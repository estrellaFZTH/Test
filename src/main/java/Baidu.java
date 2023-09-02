
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baidu {

    private class LR{
        private int left;
        private int right;
        public LR(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] nums = new int[s.length()];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i] +",");
        }
        System.out.println("------------------");
        int[][] dp1 = new int[nums.length][nums.length];
        int[][] dp0 = new int[nums.length][nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 1){
                    count++;
                }
                dp1[i][j] = count;
                dp0[i][j] = j - i + 1 - count;
            }
        }
//        int maxLen = 0;
//        int[][] res = new int[2][2];
//        for(int i = 0; i < nums.length; i++){
//            for (int j = i; j < nums.length; j++){
//                if(maxLen < dp[i][j]){
//
//                }
//            }
//        }



        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                System.out.print(dp1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------------");
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                System.out.print(dp0[i][j] + " ");
            }
            System.out.println();
        }




//        int[] preSum = new int[s.length() + 1];
//        preSum[0] = 0;
//        preSum[1] = nums[0];
//        for(int i = 1; i < nums.length; i++){
//            if(nums[i] == 1){
//                preSum[i + 1] = 1 + preSum[i];
//            }else{
//                preSum[i + 1] = -1 + preSum[i];
//            }
//        }
//        for(int i = 0; i < preSum.length; i++){
//            System.out.println(i + ":"+preSum[i]);
//        }
        //   1 2 3 4 5
        //   1 1 0 1 1
        // 0 1 2 2 3 4
//        Map<Integer, LR> map = new HashMap<>();
//        for(int i = 0; i < preSum.length; i++){
//            for(int j = 0; j < preSum.length; j++){
//                if(map.containsKey(preSum[]))
//            }
//        }

    }
//    //2 2
//    //0 1
//    //1 0
//
//    //3 3
//    //1 0 1
//    //0 0 0
//    //1 0 1
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = reader.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int K = Integer.parseInt(s[1]);
//        int[] map = new int[N * N];
//        int mapIdx = 0;
//        for(int i = 0; i < N; i++){
//            String[] ss = reader.readLine().split(" ");
//            int index = 0;
//            for(int j = 0; j < N; j++){
//                map[mapIdx++] = Integer.parseInt(ss[index++]);
//            }
//        }
//        int[][] res = new int[N*K][N*K];
//        for(int i = 0; i < N*K; i++){
//            for (int j = 0; j < N*K; j++){
//                int arr = (i/K)*N + (j/K);
////                System.out.println(arr);
//                res[i][j] = map[arr];
//            }
//        }
//        //1 1 1 0 0 0 1 1 1
//        //1 1 1 0 0 0 1 1 1
//        //1 1 1 0 0 0 1 1 1
//        //0 0 0 0 0 0 0 0 0
//        //0 0 0 0 0 0 0 0 0
//        //0 0 0 0 0 0 0 0 0
//        //1 1 1 0 0 0 1 1 1
//        //1 1 1 0 0 0 1 1 1
//        //1 1 1 0 0 0 1 1 1
//
//        for(int i = 0; i < N*K; i++){
//            for(int j = 0; j < N*K; j++){
//                System.out.print(res[i][j] + " ");
//            }
//            System.out.println();
//        }
////        for(int i = 0; i < map.length; i++){
////            System.out.print(map[i] + " ");
////        }
//
//    }
}
