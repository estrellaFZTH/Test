import org.apache.commons.collections4.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

public class Test {


    private static int n ;
    private static int[] a;

    private static double ZERO = 0.0;
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        String str = "string";
        Integer inttt = 130;
        Integer integer = 130;
//        System.out.println(inttt == integer);
        System.out.println(inttt.equals(integer));
        String str2 = "double";
        Double dou = 2.0;
        map.put(str, inttt);
        map.put(str2, dou);
        System.out.println(map.get(str).getClass());
        System.out.println(map.get(str2).getClass());

//        Integer[] num = new Integer[]{1,4,2,4,6,8,3,9};
//        Arrays.sort(num, (num1, num2) -> {
//            return num2 - num1;
//        });
//        for(int i = 0; i < num.length; i++){
//            System.out.println(num[i]);
//        }
//        String[] str = new String[]{"a","b"};
//        Arrays.sort(str);
//        Arrays.sort(str,
//                    (a ,b) -> {
//                        return a.compareTo(b);
//                    }
//        );
//        PriorityQueue<Integer> que = new PriorityQueue<>( (a, b) -> {
//            return  b - a;
//        });
//        que.add(5);
//        que.add(2);
//        que.add(4);
//        while (!que.isEmpty()) {
//            System.out.println(que.poll());
//        }

        int[] nums = new int[]{1,2,3};
//        System.out.println(preSum(nums, 3));
    }

    private static int preSum(int[] nums, int k){
        if(nums.length == 0){
            return 0;
        }
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            preSum[i] = preSum[i - 1] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(preSum[i] - k)){
                res += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return  res;

    }

    // 1 1 2 2 3
    // 0 1 2 3 4
    private static int helper(int[] nums, int left, int right){
        if (nums.length % 2 == 0) {
            return -1;
        }
        if(right - left == 2){
            if(nums[left] == nums[left + 1]){
                return nums[right];
            }else if(nums[left + 1] == nums[left + 2]){
                return nums[left];
            }else{
                return nums[left + 1];
            }
        }
        int mid = (left + right) / 2;
        if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
            return nums[mid];
        }else if(nums[mid] == nums[mid + 1]){
            return helper(nums, mid, right);
        }else{
            return helper(nums, left, mid);
        }

    }















    private static int check(int l,int r){
        // 6 1 1 2 2 4 4 5 5
        // 0 1 2 3 4 5 6 7 8
        //     2   4
        int mid = (l + r) / 2;
        if(r - l == 2){
            if (a[l] != a[l+1] && a[l] != a[l+2]) {
                return l;
            }
            else if (a[r] != a[l] && a[r] != a[l+1]) {
                return r;
            }
            else {
                return l + 1;
            }
        }
        if (a[mid] != a[mid-1 ] && a[mid] != a[mid+1]) {
            return mid;
        } else if (a[mid] == a[mid-1]) {
            return check(l, mid);
        } else {
            return check(mid, r);
        }
    }


    private static int help(int[] nums) {

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
//                cout<<a[mid]<<endl;
                System.out.println(nums[mid]);
                return nums[mid];
            } else if (mid == left || mid == right) {
//                cout<<a[mid]<<endl;
                System.out.println(nums[mid]);
                return nums[mid];
            } else if (nums[mid] == nums[mid - 1]) {
                right = mid - 2;
            } else if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            }
        }
        return  -1;
    }


//        int left = 0, right = nums.length - 1;
//        int res = -1;
//        // 1 1 2 2 6 6 5 5
//        // 0 1 2 3 4 5 6 7 8
//        while(left <= right){
//            int mid = (left + right) / 2;
//            System.out.println("mid:" + mid);
//            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
//                res = nums[mid];
//                return nums[res];
//            }else if(nums[mid] == nums[mid - 1]){
//                left = mid - 2;
//            }else if(nums[mid] == nums[mid + 1]){
//                right = mid + 2;
//            }
//        }
//        return -1;
//    }


}
