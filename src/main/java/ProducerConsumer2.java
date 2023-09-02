import sun.awt.windows.ThemeReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer2 {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition full = reentrantLock.newCondition();
    private static Condition empty = reentrantLock.newCondition();

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        ExecutorService service = Executors.newFixedThreadPool(15);
        service.submit(new Producer(list, 10, reentrantLock));
        service.submit(new Consumer(list, reentrantLock));
//        for(int i = 0; i < 5; i++){
//            service.submit(new Producer(list, 10, reentrantLock));
//        }
//        for(int i = 0; i < 10; i++){
//            service.submit(new Consumer(list, reentrantLock));
//        }
    }

    static class Producer implements Runnable{

        private List<Integer> list;
        private int maxLength;
        private Lock lock;

        public Producer(List<Integer> list, int maxLength, Lock lock){
            this.list = list;
            this.maxLength = maxLength;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == maxLength){
                        System.out.println("list已满：" + Thread.currentThread().getName() + "进入wait");
                        full.await();
                        System.out.println(Thread.currentThread().getName() + "退出wait");
                    }
                    int i = new Random().nextInt();
                    list.add(i);
                    System.out.println(Thread.currentThread().getName() + "生产数据" + i);
                    empty.signalAll();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable{

        private List<Integer> list;
        private Lock lock;

        public Consumer(List<Integer> list, Lock lock){
            this.list = list;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.size() == 0){
                        System.out.println("list已空：" + Thread.currentThread().getName() + "进入wait");
                        empty.await();
                        System.out.println(Thread.currentThread().getName() + "退出wait");
                    }
                    int i = list.remove(0);
                    System.out.println(Thread.currentThread().getName() + "消费数据" + i);
                    full.signalAll();
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }


//    private static ReentrantLock lock = new ReentrantLock();
//    private static Condition full = lock.newCondition();
//    private static Condition empty = lock.newCondition();
//
//    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        ExecutorService service = Executors.newFixedThreadPool(15);
//        for(int i = 0; i < 5; i++){
//            service.submit(new Producer(list, 10, lock));
//        }
//        for(int i = 0; i < 10; i++){
//            service.submit(new Consumer(list, lock));
//        }
//
//
//    }
//
//    private static class Producer implements Runnable{
//
//        private List<Integer> list;
//        private int maxLength;
//        private Lock lock;
//
//        public Producer(List<Integer> list, int maxLength, Lock lock){
//            this.list = list;
//            this.maxLength = maxLength;
//            this.lock = lock;
//        }
//
//        @Override
//        public void run() {
//            while(true){
//                lock.lock();
//                try {
//                    while(list.size() == maxLength){
//                        System.out.println("生产者 " + Thread.currentThread().getName() + " list达到最大容量，进行wait");
//                        full.await();
//                        System.out.println("生产者"  + Thread.currentThread().getName() + " 退出wait");
//                    }
//                    Random random = new Random();
//                    int i = random.nextInt();
//                    System.out.println("生产者 " + Thread.currentThread().getName() + " 生产数据 " + i);
//                    list.add(i);
//                    empty.signalAll();
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }
//
//
//    private static class Consumer implements Runnable{
//
//        private List<Integer> list;
//        private Lock lock;
//
//        public Consumer(List<Integer> list, Lock lock){
//            this.list = list;
//            this.lock = lock;
//        }
//        @Override
//        public void run() {
//            while (true){
//                lock.lock();
//                try {
//                    while(list.isEmpty()){
//                        System.out.println("消费者 " + Thread.currentThread().getName() + " list为空，进行wait");
//                        empty.await();
//                        System.out.println("消费者 " + Thread.currentThread().getName() + " 退出wait");
//                    }
//                    int i = list.remove(0);
//                    System.out.println("消费者 " + Thread.currentThread().getName() + " 消费数据 " + i);
//                    full.signalAll();
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }
//    }
}
