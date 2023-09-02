import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class newBag {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int N = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
//        System.out.println(N + ":" + m);
        int[][] nums = new int[m][3];
        List<List<Integer>> weight = new ArrayList<>();
        List<List<Integer>> val = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String[] ss = reader.readLine().split(" ");
//            System.out.println(ss.length);
            for(int j = 0; j < 3; j++){
                nums[i][j] = Integer.valueOf(ss[j]);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------------");
        for(int i = 0; i < m; i++){
            weight.add(new ArrayList<>());
            val.add(new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i][2] == 0){
                weight.get(i).add(nums[i][0]);
                val.get(i).add(nums[i][1] * nums[i][0]);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i][2] != 0){
                int length = weight.get(nums[i][2] - 1).size();
                for(int j = 0; j < length; j++){
                    weight.get(nums[i][2] - 1).add(weight.get(nums[i][2] - 1).get(j) + nums[i][0]);
                    val.get(nums[i][2] - 1).add(val.get(nums[i][2] - 1).get(j) + nums[i][1] * nums[i][0]);
                }
            }
        }
        System.out.println(1);
        int[] dp = new int[N + 1];
        for(int i = 0; i < weight.size(); i++){
            if(weight.get(i).size() != 0){
//                for(int j = 0; j < weight.get(i).size(); j++){
//                    for(int k = N; k >= weight.get(i).get(j); k--){
//                        dp[k] = Math.max(dp[k], dp[k - weight.get(i).get(j)] + val.get(i).get(j));
//                    }
//                }
                 for(int j = N; j >= 0; j++){

                     for(int k = 0; k < weight.get(i).size(); k++){

                         if(j >= val.get(i).get(k))
                             dp[j] = Math.max(dp[j], dp[j - weight.get(i).get(k)] + val.get(i).get(k));
                     }

                 }
            }
        }
        System.out.println(dp[N]);

    }

}
