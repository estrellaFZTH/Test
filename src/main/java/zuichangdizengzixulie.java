import java.util.Arrays;

public class zuichangdizengzixulie {

    public static void main(String[] args) {
        String[] str = "16 103 132 23 211 75 155 82 32 48 79 183 13 91 51 172 109 102 189 121 12 120 116 133 79 120 116 208 47 110 65 187 69 143 140 173 203 35 184 49 245 50 179 63 204 34 218 11 205 100 90 19 145 203 203 215 72 108 58 198 95 116 125 235 156 133 220 236 125 29 235 170 130 165 155 54 127 128 204 62 59 226 233 245 46 3 14 108 37 94 52 97 159 190 143 67 24 204 39 222 245 233 11 80 166 39 224 12 38 13 85 21 47 25 180 219 140 201 11 42 110 209 77 136".split(" ");
        int[] nums = new int[str.length];
        System.out.println(nums.length);
        System.out.println();
        for(int i = 0; i < str.length; i++){
            nums[i] = Integer.valueOf(str[i]);
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            for(int index = 0; index < nums.length; index++){
                System.out.print(dp[index] + " ");
            }
            System.out.println();
            res = Math.max(res, dp[i]);
        }
        System.out.println();
        int[] rp = new int[nums.length];
        Arrays.fill(rp, 1);
        for(int i = nums.length - 2; i >= 0; i--){
            for(int j = nums.length - 1; j >=0; j--){
                if(nums[j] < nums[i]){
                    rp[i] = Math.max(rp[i], rp[j] + 1);
                }
            }
            for(int index = 0; index < nums.length; index++){
                System.out.print(rp[index] + " ");
            }
            System.out.println();
        }

        for(int i =0 ; i < nums.length; i++){
            res = Math.max(res, dp[i] + rp[i] - 1);
        }
        return res;
    }

}


