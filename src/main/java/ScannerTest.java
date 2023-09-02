import java.io.*;
import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) throws IOException{
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
    }

    private static void test5() throws IOException{
        // 3 4 3
        // 1 2 3 4
        // 3 2 1 0
        // 1 5 7 8

        // 1 1 2 2
        // 1 1 3 3
        // 1 2 3 4
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int index = 0;
        int n = Integer.parseInt(s[index++]);
        int[][] nums = new int[n][];
        for(int i = 0; i < n; i++){
            String[] ss = reader.readLine().split(" ");
            index = 0;
            int[] num = new int[ss.length];
            for(int j = 0; j < num.length; j++){
                num[j] = Integer.parseInt(ss[index++]);
            }
            nums[i] = num;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void test4() throws IOException {
        //3 4 3 1 2 3 4 3 2 1 0 1 5 7 8 1 1 2 2 1 1 3 3 1 2 3 4
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int index = 0;
        int n = Integer.parseInt(s[index++]);
        int m = Integer.parseInt(s[index++]);
        int q = Integer.parseInt(s[index++]);

        long[][] nums = new long[n][m];
        for(int i = 0; i < n; i++){
            String[] ss = reader.readLine().split(" ");
            index = 0;
            for(int j = 0; j < m; j++){
                nums[i][j] = Integer.parseInt(ss[index++]);
            }
        }
        int[][] select = new int[q][4];
        for(int i = 0; i < q; i++){
            String[] ss =reader.readLine().split(" ");
            index = 0;
            for(int j = 0; j < 4; j++){
                select[i][j] = Integer.parseInt(ss[index++]);
            }
        }
        long[][] preSum = new long[n + 1][m + 1];
        preSum[1][1] = nums[0][0];
        for(int i = 1; i < m; i++){
            preSum[1][i + 1] = preSum[1][i] + nums[0][i];
        }
        for(int j = 1; j < n; j++){
            preSum[j + 1][1] = preSum[j][1] + nums[j][0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                preSum[i + 1][j + 1] = nums[i][j] + preSum[i][j + 1] +
                        preSum[i + 1][j] - preSum[i][j];
            }
        }
        for(int[] sel : select){
            int x1 = sel[0];
            int y1 = sel[1];
            int x2 = sel[2];
            int y2 = sel[3];
            System.out.println(preSum[x2][y2] - preSum[x1-1][y2] -
                    preSum[x2][y1-1] + preSum[x1 - 1][y1 - 1]);
        }
    }

    private static void test3(){
        Scanner sc = new Scanner(System.in);
        // 第一行包含三个整数n,m,q.
        // 接下来n行，每行m个整数，代表矩阵的元素
        // 接下来q行，每行4个整数x1, y1, x2, y2，分别代表这次查询的参数
        // 输入
        // 3 4 3
        // 1 2 3 4
        // 3 2 1 0
        // 1 5 7 8
        // 1 1 2 2
        // 1 1 3 3
        // 1 2 3 4
        // 3 4 3 1 2 3 4 3 2 1 0 1 5 7 8 1 1 2 2 1 1 3 3 1 2 3 4
        // 输出
        // 8
        // 25
        // 32
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            long[][] nums = new long[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    nums[i][j] = sc.nextInt();
                }
            }
            int[][] select = new int[q][4];
            for(int i = 0; i < q; i++){
                for(int j = 0; j < 4; j++){
                    select[i][j] = sc.nextInt();
                }
            }
            System.out.println(n + " " + m + " " + q);
            System.out.println("------------------------------");
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            for(int i = 0; i < q; i++){
                for(int j = 0; j < 4; j++){
                    System.out.print(select[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            long[][] preSum = new long[n + 1][m + 1];
            preSum[1][1] = nums[0][0];
            for(int i = 1; i < m; i++){
                preSum[1][i + 1] = preSum[1][i] + nums[0][i];
            }
            for(int j = 1; j < n; j++){
                preSum[j + 1][1] = preSum[j][1] + nums[j][0];
            }
            for(int i = 1; i < n; i++){
                for(int j = 1; j < m; j++){
                    preSum[i + 1][j + 1] = nums[i][j] + preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j];
                }
            }
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(preSum[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("------------------------------");
            for(int[] sel : select){
                int x1 = sel[0];
                int y1 = sel[1];
                int x2 = sel[2];
                int y2 = sel[3];
                System.out.println((x1) + "," + (y1) + "," + (x2) + "," + (y2));
                System.out.println(preSum[x2][y2] - preSum[x1-1][y2] - preSum[x2][y1-1] + preSum[x1 - 1][y1 - 1]);
            }
        }
    }


    private static void test2(){
        Scanner sc = new Scanner(System.in);
        // 第一行包含两个整数n和q.
        // 第二行包含n个整数, 表示a1,a2,....an.
        // 接下来q行,每行包含两个整数 l和r.
        // 输入：
        // 3 2
        // 1 2 4
        // 1 2
        // 2 3
        // 输出：
        // 3
        // 6
        while (sc.hasNext()){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int[][] sel = new int[q][2];
            for(int i = 0; i < q; i++){
                sel[i][0] = sc.nextInt();
                sel[i][1] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < q; i++){
                for(int j = 0; j < 2; j++){
                    System.out.print(sel[i][j] + " ");
                }
                System.out.println();
            }
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            preSum[1] = nums[0];
            for(int i = 1; i < n; i++){
                preSum[i + 1] = preSum[i] + nums[i];
                //  2 = 1 +
            }
            for(int i : preSum){
                System.out.println(i);
            }
            for(int i = 0; i < q; i++){
                System.out.println(preSum[sel[i][1]] - preSum[sel[i][0] - 1]);
            }
        }
    }


    private static void test1(){
        Scanner sc = new Scanner(System.in);
        // 2 2
        // 10 2
        // 11 4
        while(sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for(int j = 0; j < m; j++){
                    nums[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(nums[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
