import java.util.*;

public class NetEase {


    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,3,4,5,5};
        int[] nums = new int[]{1,5,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == 2) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] <= nums[j]) {
                        continue;
                    }
                    for(int k = j + 1; k < nums.length; k++) {
                        if(nums[i] == nums[k]) {
                            count++;
                            break;
                        }
                    }
                }
            } else {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[i] <= nums[j]) {
                        continue;
                    }
                    for(int k = j + 1; k < nums.length; k++) {
                        if(nums[i] == nums[k]) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }





}
