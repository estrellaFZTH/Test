import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int count = 1;
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(count <= n){
            lock.lock();
            try {
                if(count % 3 == 0 && count % 5 != 0){
                    printFizz.run();
                    count++;
                    condition.signalAll();
                }else{
                    condition.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(count <= n){
            lock.lock();
            try {
                if(count % 3 != 0 && count % 5 == 0){
                    printBuzz.run();
                    count++;
                    condition.signalAll();
                }else{
                    condition.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count <= n){
            lock.lock();
            try {
                if(count % 3 == 0 && count % 5 == 0){
                    printFizzBuzz.run();
                    count++;
                    condition.signalAll();
                }else{
                    condition.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(count <= n){
            lock.lock();
            try {
                if(count % 3 != 0 && count % 5 != 0){
                    printNumber.accept(count);
                    count++;
                    condition.signalAll();
                }else{
                    condition.await();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}