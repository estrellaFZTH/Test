public class Bag01 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        System.out.println(isBag(nums));
    }

    private static boolean isBag(int[] nums){
        int[] dp = new int[200 * 50 + 1];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
//        if(sum % 2 == 1)
//            return false;
        int target = sum / 2;
        dp[0] = 0;
        for(int i = 0; i < nums.length; i++){
            System.out.println("-------------" + i + "---------------");
            for(int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                System.out.print(dp[j] + ", ");
            }
            System.out.println();
        }
        System.out.println("------------------------target------------------------");
        for(int i = 0; i < target; i++)
            System.out.println(dp[i]);
        return dp[target] == target;
    }
}
