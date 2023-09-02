import CAS.Inn;
import sun.misc.Unsafe;

import java.util.*;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class a {




    public static void main(String[] args) throws InterruptedException {
        Inn n1 = new Inn(130);
        Inn n2 = new Inn(130);
        System.out.println(n1.equals(n2));
        System.out.println(Integer.MAX_VALUE);
        int[] nums = new int[]{1,1,1,1,1};
//        int[] nums = new int[]{1, 1, 0, 0, 1, 0};
        int count = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num : nums){
            if(num == 0)
                preSum += -1;
            else
                preSum += 1;
            if(map.containsKey(preSum - 0)){
                count += map.get(preSum - 0);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(count);

//        new ThreadA().start();
//        new ThreadB().start();
//        new ThreadC().start();


        
//        PriorityQueue<Integer> queue ;
//        Deque<Character> stack = new LinkedList<>();
//        String str = "edababccd";
//        for(int i = 0; i < str.length(); i++){
//            if(str.charAt(i) == 'c'){
//                char ch1 = !stack.isEmpty() ? stack.pop() : '#';
//                char ch2 = !stack.isEmpty() ? stack.pop() : '#';
//                if(ch2 == '#' && ch1 != '#')
//                    stack.push(ch1);
//                if(ch1 != '#' && ch2 != '#'){
//                    if(ch1 == 'b' && ch2 == 'a'){
//                        continue;
//                    }else{
//                        stack.push(ch2);
//                        stack.push(ch1);
//                    }
//                }
//            }
//            stack.push(str.charAt(i));
//        }
//        while(!stack.isEmpty()){
//            System.out.print(stack.pop());
//        }

    }

    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();

    private static int count = 1;


    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    if (count % 3 != 1)//注意这里是不等于0，也就是说在count % 3为0之前，当前线程一直阻塞状态
                        A.await(); // A释放lock锁
                    System.out.print("1");
                    count++;
                    B.signal(); // A执行完唤醒B线程

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true){
                try {
                    lock.lock();
                    if (count % 3 != 2)
                        B.await();// B释放lock锁，当前面A线程执行后会通过B.signal()唤醒该线程
                    System.out.print("2");
                    count++;
                    C.signal();// B执行完唤醒C线程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (count % 3 != 0)
                        C.await();// C释放lock锁
                    System.out.print("3");
                    count++;
                    A.signal();// C执行完唤醒A线程

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
