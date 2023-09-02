package Lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockAndLock {

    private static ReentrantLock reentrantLock1 = new ReentrantLock();
    private static ReentrantLock reentrantLock2 = new ReentrantLock();

    private static volatile int num1 = 0;
    private static volatile int num2 = 0;

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newFixedThreadPool(10);
        ExecutorService executorService2 = Executors.newFixedThreadPool(10);
        System.out.println("==========================start=========================");
        /** ≤‚ ‘TryLock() */
        for(int i = 0; i < 10; i++){
            executorService1.submit(new Task(reentrantLock1));
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========================================================");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /** ≤‚ ‘Lock() */
        for(int i = 0; i < 10; i++){
            executorService2.submit(new Task2(reentrantLock2));
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("============================end=========================");
    }

    private static class Task implements Runnable {
        private ReentrantLock lock;

        public Task(ReentrantLock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            if (lock.tryLock()) {
                System.out.println(++num1);
            }
        }
    }

    private static class Task2 implements Runnable{
        private ReentrantLock lock;
        public Task2(ReentrantLock lock){
            this.lock = lock;
        }
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(++num2);
            } finally {
                lock.unlock();
            }
        }
    }
}
