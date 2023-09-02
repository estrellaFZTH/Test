package dp;

public class TriangleArray {

    public static void main(String[] args) {
        int[][] arr = new int[5][];
        arr[0] = new int[]{2};
        arr[1] = new int[]{3,4};
        arr[2] = new int[]{6,5,7};
        arr[3] = new int[]{4,1,8,3};
        arr[4] = new int[]{5,9,8,4,5};
        System.out.println(minLength(arr));
    }

    private static int minLength(int[][] nums){
        int[][] dp = new int[nums.length][nums[nums.length - 1].length];
        for(int i = 0; i < nums[nums.length - 1].length; i++){
            dp[nums.length - 1][i] = nums[nums.length - 1][i];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = 0; j < nums[i].length; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + nums[i][j];
            }
        }
        return dp[0][0];
    }
}
