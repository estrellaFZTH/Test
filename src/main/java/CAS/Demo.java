package CAS;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Demo {
    // 总访问量
    static int count = 0;

    // 模拟访问方法
    public static void request() throws InterruptedException {
        // 模拟耗时5ms
        TimeUnit.MILLISECONDS.sleep(5);
        /**
         *  Q：分析一下问题出在哪？
         *  A：count++实际上是由三步来完成！（jvm引擎）
         *     1。获取count的值，记做：A： A=count
         *     2。将A值+1，得到B：B=A+1
         *     3。将B赋值给count
         *
         *     如果有A，B两个线程同时执行count++，他们通知执行上面步骤到第一步，得到的count是一样的，
         *     三步操作结束后，count只加1，导致count的结果不正确。
         *  Q：怎么解决结果不正确的问题？
         *  A：对count++操作对时候，我们让多个线程排队，多个线程同时到达request()方法的时候，只能允许
         *  一个线程可以进去操作，其它线程在外面等着，等里面的线程处理完毕出来之后，外面等着的再进去一个，
         *  这样的操作count++就是排队进行的，结果是一定正确的。
         *
         *  Q：怎么实现排队效果？
         *  A：java中synchronized关键字和ReentrantLock都可以实现对资源加锁，保证并发正确性，多线程的情况下可以保证
         *  被锁住的资源"串行"访问。
         *
         */
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        // 开始时间
        long startTime = System.currentTimeMillis();
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        for (int i = 0; i < threadSize; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    // 模拟用户行为： 每个用户访问10次网站
                    try {
                        for(int j = 0; j < 10; j++){
                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            });

            thread.run();
        }
        // 怎么保证100个线程结束之后在执行后续代码
        countDownLatch.wait();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        System.out.println("count: " + count);

    }
}
