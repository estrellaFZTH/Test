package zijie0320;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 经过500年的大战，X星球的人们在魔法天神的带领下终于消灭了外来物种Y,然而，长时间的战争使得X军球秋序遭到破坏，
 * 人员管理混乱，为了尽快恢复秩序，建设美好生活乐园，土地如何划分、人员如何管理成为当前必须要解决的问题。
 * x星球由多个魔法部落组成，每个魔法部落由多个魔法师组成，每个魔法师有一个单线联系的来自同一部落的师父。
 * 为了公平，X星球上的魔法师之问达成共识，按照每个部满的魔法师人数比例多少划分土地。 现在，星球上由于长时间大战，
 * 魔法师分散星球各地，请你协助魔法天神 按照各部落魔法使人数划分土地。
 * 注意: 1. x星球土地面积共有579万平方干米
 *      2.魔法天神需要把星球的土地全部划分到各个部落中
 *      3.一个部落中的师徒关系有可能出现环，即A是B的师傅，B是C的师傅, C又是的A师傅
 * 输入描述: 第一行星球总人数n (从1、n代表星球上的所有人，1<n<=200 )师徒关系数m(0<=m<=200)其他行m组师徒关系数据 徒弟 师傅
 * 输出描述: 第一行 星球总部落数 第二行由多到少每个部落 分得的土地面积(单位为万平力平米，保留整敫(向下取整>即可)
 * 输入 8 6
 *     1 3
 *     5 3
 *     7 5
 *     6 2
 *     4 8
 *     8 2
 * 输出 2
 *     289 289
 * 说明 8个人，有6个师徒关系，根据师徒关系可以得出 1, 3, 5，7属于一个部落
 * 2，4, 6, 8属于一个部落 所以这个星球共有2个部落，
 * 由于两个部落人数一致，所以平分579万平方千米的土地，即分别 分得289万平方千米
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
