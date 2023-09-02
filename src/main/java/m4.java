import java.util.Scanner;


public class m4 {

    public static void main(String[] args) {
        /**
         * 允许调整初始数组顺序，求最大和（每次查询后得到的和相加）
         * n m   // 数组元素为n, 进行m次操作
         * 5 5
         * 3 4 2 1 5  // 这一行为数组元素
         * 1 1 3      // 1 l r 查询
         * 2 3 4 2    // 2 l r k 给数组元素加k
         * 1 2 4
         * 2 2 3 2
         * 1 3 5
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            nums[i] = num;
        }
        int[][] op = new int[m][];
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if(num == 1){
                for(int j = 0; j < 3; j++){
                    op[i][j] = num;
                    num = sc.nextInt();
                }
            }else {
                for(int j = 0; j < 4; j++){
                    op[i][j] = num;
                    num = sc.nextInt();
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < op.length; i++){
            for(int j = 0; j < op[i].length; j++){
                System.out.print(op[i][j] + " ");
            }
            System.out.println();
        }

    }
}
