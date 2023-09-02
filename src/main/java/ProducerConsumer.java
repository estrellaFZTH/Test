import java.util.Random;
import java.util.concurrent.*;


public class ProducerConsumer {

    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        ExecutorService service =  Executors.newFixedThreadPool(15);
        for(int i = 0; i < 5; i++){
            service.submit(new Producer(queue));
        }
        for(int i = 0; i < 10; i++){
            service.submit(new Consumer(queue));
        }
    }

    private static class Producer implements Runnable{

        private BlockingQueue<Integer> queue;

        public Producer(BlockingQueue queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                Random random = new Random();
                int i = random.nextInt();
                System.out.println("生产者 " + Thread.currentThread().getName() + " 生产数据 " + i);
                queue.put(i);
                Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable{

        private BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue){
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    Integer i = queue.take();
                    System.out.println("消费者 " + Thread.currentThread().getName() + " 消费数据 " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
