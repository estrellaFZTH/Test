package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * С�����Aͽ����B�����̳���ҪM�죬·����Ϊ��ȷ����ȫ,С��ÿ����Ҫ����1��ʳ�
 * ����㼰·�̵��У����Ƿֲ���N���ӽoվ,���Բ���ʳ���ͬ�Ӹ�վ��ʳ��۸���ܲ�ͬ��
 * ����С����Ҫ��ȫ���ͽ����������Ҫ���Ѷ���Ǯ��?
 * ��������: ��һ��Ϊ����������M��N,������·��:�죬����վ����w ������N�У�
 * ÿ���������Ǹ�����A. B����-һ������վ����ʾ��A�쾭���ò���վ��ÿ��ʳ��ļ۸�ΪBԪ��
 * A�Ǵ�0��ʼ�ϸ�����ģ������һ���в���վ������վ�ǰ�λ��˳������ģ���ͬһ��λ�������һ������վ��
 * �������: ���һ����������ʾ���ٻ��ѵĽ��
 * ���� 5 4
 *     0 2
 *     1 3
 *     2 1
 *     3 2
 * ��� 7 ˵�� �ڵ�0����2��ʳ�ﻨ��4Ԫ���ڵ�2����3��ʳ�ﻨ��3Ԫ��������7Ԫ
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

        /* �������� */
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

        /* ̰�� */
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
