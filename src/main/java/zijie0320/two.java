package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 小明想从A徒步到B，总跆程需要M天，路程中为了确保安全,小明每天需要消耗1份食物。
 * 在起点及路程当中，零星分布着N个朴給站,可以补充食物，不同朴给站的食物价格可能不同。
 * 请问小明若要安全完成徒步，最少需要花费多少钱呢?
 * 输入描述: 第一行为两个正整教M、N,代表总路程:天，补给站个数w 接下来N行，
 * 每行有两个非负整数A. B代表-一个补输站，表示第A天经过该补给站，每份食物的价格为B元，
 * A是从0开始严格递增的，即起点一定有补给站，补给站是按位置顺序给出的，且同一个位置最多有一个补给站。
 * 输出描述: 输出一个整数，表示最少花费的金额
 * 输入 5 4
 *     0 2
 *     1 3
 *     2 1
 *     3 2
 * 输出 7 说明 在第0天买2份食物花费4元，在第2天买3份食物花费3元，共花费7元
 */
public class two {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int M = Integer.parseInt(s[0]);
        int N = Integer.parseInt(s[1]);
        int[][] nums = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] ss = reader.readLine().split(" ");
            nums[i][0] = Integer.parseInt(ss[0]);
            nums[i][1] = Integer.parseInt(ss[1]);
        }

        /* 单调队列 */
        Deque<Integer> que = new LinkedList<>();
        int index = 0;
        int res = 0;
        for(int i = 0; i < M; i++){
            if(index < nums.length && nums[index][0] == i){
                while (!que.isEmpty() && nums[index][1] < que.peekLast()){
                    que.pollLast();
                }
                que.addLast(nums[index][1]);
                index++;
            }
            res += que.peekFirst();
        }
        System.out.println(res);

        /* 贪心 */
//        int minPrice = Integer.MAX_VALUE;
//        int index = 0;
//        int res = 0;
//        for(int i = 0; i < M; i++){
//            if(index < nums.length && nums[index][0] == i){
//                minPrice = Math.min(minPrice, nums[index][1]);
//                index++;
//            }
//            res += minPrice;
//        }
//        System.out.println(res);

    }
}
