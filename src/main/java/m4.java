import java.util.Scanner;


public class m4 {

    public static void main(String[] args) {
        /**
         * ���������ʼ����˳�������ͣ�ÿ�β�ѯ��õ��ĺ���ӣ�
         * n m   // ����Ԫ��Ϊn, ����m�β���
         * 5 5
         * 3 4 2 1 5  // ��һ��Ϊ����Ԫ��
         * 1 1 3      // 1 l r ��ѯ
         * 2 3 4 2    // 2 l r k ������Ԫ�ؼ�k
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
