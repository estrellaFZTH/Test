import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class xianLiu {


    public static void main(String[] args) {


    }
}


//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>(1);
////        System.out.println(list.size());
//        list.add(1);
////        System.out.println(list.size());
//        list.add(2);
//        System.out.println(list.size());
//        StringBuilder sb = new StringBuilder();
//        sb.insert(0, 1);
//        list.add(5);
//        PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> {
//            return b - a;
//        });
//        que.add(1);
//        que.add(2);
//        que.add(3);
//        que.add(4);
//        System.out.println(que.poll());
////        for(int i = 0; i < 50; i++){
////            Thread t = new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    while (true) {
////                        System.out.println(grant());
////                    }
////                }
////            });
////            t.run();
////        }
//    }
//
//
//    private int ab(){
//        return 1;
//    }
//    private static long curTime = getNowTime();
//    private static final int count = 100; // 流量窗口
//    private static final int time = 1000; // 时间窗口 ms
//    private static volatile int req = 0;
//
//    public static boolean grant(){
//        if(getNowTime() < curTime + time){
//            if(req > count)
//                return false;
//            req++;
//        }else{
//            curTime = getNowTime();
//            req = 1;
//        }
//        return true;
//    }
//
//    private static long getNowTime(){
//        return System.currentTimeMillis();
//    }
//
//}
