import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class m2 {
    // ��һ������Ϊn�����飬����תһ�β�������Ԫ�أ�������Ӷκ�
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
    // ��һ�������Ϊn�Ķ�������m��
    // 2 3
    // x y z
    // 1 1 1
    // ����������Ķ�����

}
