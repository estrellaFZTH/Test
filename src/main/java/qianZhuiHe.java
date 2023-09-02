import java.util.HashMap;
import java.util.Map;

public class qianZhuiHe {

    public static void main(String[] args) {
        int sum = 0;
        int[] n = new int[]{3,3,2,4,2,3,3};
        for(int i = 0; i < n.length; i++){
            sum += n[i];
        }
        System.out.println(sum);
        Map<String, String> map1 = new HashMap<>();
        map1.put(null, null);
        map1.put("1", null);
        map1.put("2", null);
        System.out.println(map1.get(null));
        System.out.println(map1.get("1"));
        System.out.println(map1.get("2"));
        map1.put(null, "1");
        System.out.println(map1.get(null));
        int[] nums = new int[]{1,1,0,0,1,0,1,0};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                preSum += -1;
            }else{
                preSum += nums[i];
            }
            if(map.containsKey(preSum - 0)){
                res += map.get(preSum - 0);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        System.out.println(res);
    }
}
