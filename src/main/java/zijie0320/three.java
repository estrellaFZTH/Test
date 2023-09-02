package zijie0320;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ����500��Ĵ�ս��X�����������ħ������Ĵ�����������������������Y,Ȼ������ʱ���ս��ʹ��X���������⵽�ƻ���
 * ��Ա������ң�Ϊ�˾���ָ����򣬽�������������԰��������λ��֡���Ա��ι����Ϊ��ǰ����Ҫ��������⡣
 * x�����ɶ��ħ��������ɣ�ÿ��ħ�������ɶ��ħ��ʦ��ɣ�ÿ��ħ��ʦ��һ��������ϵ������ͬһ�����ʦ����
 * Ϊ�˹�ƽ��X�����ϵ�ħ��ʦ֮�ʴ�ɹ�ʶ������ÿ��������ħ��ʦ�����������ٻ������ء� ���ڣ����������ڳ�ʱ���ս��
 * ħ��ʦ��ɢ������أ�����Э��ħ������ ���ո�����ħ��ʹ�����������ء�
 * ע��: 1. x���������������579��ƽ������
 *      2.ħ��������Ҫ�����������ȫ�����ֵ�����������
 *      3.һ�������е�ʦͽ��ϵ�п��ܳ��ֻ�����A��B��ʦ����B��C��ʦ��, C���ǵ�Aʦ��
 * ��������: ��һ������������n (��1��n���������ϵ������ˣ�1<n<=200 )ʦͽ��ϵ��m(0<=m<=200)������m��ʦͽ��ϵ���� ͽ�� ʦ��
 * �������: ��һ�� �����ܲ����� �ڶ����ɶൽ��ÿ������ �ֵõ��������(��λΪ��ƽ��ƽ�ף��������(����ȡ��>����)
 * ���� 8 6
 *     1 3
 *     5 3
 *     7 5
 *     6 2
 *     4 8
 *     8 2
 * ��� 2
 *     289 289
 * ˵�� 8���ˣ���6��ʦͽ��ϵ������ʦͽ��ϵ���Եó� 1, 3, 5��7����һ������
 * 2��4, 6, 8����һ������ �������������2�����䣬
 * ����������������һ�£�����ƽ��579��ƽ��ǧ�׵����أ����ֱ� �ֵ�289��ƽ��ǧ��
 */
public class three {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] nums = new int[m][2];
        for(int i = 0; i < nums.length; i++){
            String[] ss = reader.readLine().split(" ");
            nums[i][0] = Integer.parseInt(ss[0]) - 1;
            nums[i][1] = Integer.parseInt(ss[1]) - 1;
        }
        int[][] isConnected = new int[n][n];
        for(int i = 0; i < nums.length; i++){
            isConnected[nums[i][0]][nums[i][1]] = 1;
            isConnected[nums[i][1]][nums[i][0]] = 1;
        }
        for(int i = 0; i < n; i++){
            isConnected[i][i] = 1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(isConnected[i][j] + " ");
            }
            System.out.println();
        }
        boolean[] visited = new boolean[n];
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                res.add(new ArrayList<>());
                dfs(isConnected, visited, i, res, index);
                index++;
            }
        }
        System.out.println(res.size() + ",  " + index);
        for(List<Integer> list : res){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i, List<List<Integer>> res, int index){
        visited[i] = true;
        res.get(index).add(i);
        for(int j = 0; j < isConnected[i].length; j++){
            if(isConnected[i][j] == 1 && !visited[j]){
                dfs(isConnected, visited, j, res, index);
            }
        }
    }
}
