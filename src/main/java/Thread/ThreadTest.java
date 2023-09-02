package Thread;

public class ThreadTest {

    public static void main(String[] args) {
        MyThread thread = new MyThread(100);
//        thread.setA(10);
        thread.start();
        int a = 10;
        ThreadLocal local = new ThreadLocal();
        System.out.println(local.get());
        local.set(a);
        local.set("123");

        System.out.println(local.get());


//        System.out.println("----------------------------------------------");
        final int b = 0;
        RunnableTask task = new RunnableTask(000);
        new Thread(task).start();
    }

    static class MyThread extends Thread {
        private int a;

        public MyThread(int a) {
            this.a = a;
        }

        @Override
        public void run() {
            System.out.println("I am child " + a);
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }
    }


    static class RunnableTask implements Runnable{

        int a;
        public RunnableTask(int a) {
            this.a = a;
        }

        Object o = new Object();

        @Override
        public void run() {
            System.out.println("I am child " + a);
            synchronized (o){
                try {
                    Thread.sleep(1000);
                    o.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}


