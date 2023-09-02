import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class m2 {
    // 给一个长度为n的数组，允许翻转一次部分数组元素，求最大子段和
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        // 6
        // -1,-5,3,2,-1,3
        for(int i = 0; i < n; i ++){
            int num = sc.nextInt();
            nums[i] = num;
        }
//        int[] nums = new int[]{-1,-5,3,2,-1,3};
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(sum <= 0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
    //m3
    // 给一个长宽高为n的豆腐，切m刀
    // 2 3
    // x y z
    // 1 1 1
    // 求切完后最大的豆腐块

}
