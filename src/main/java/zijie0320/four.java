package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 小红拿列了一个长度为n的、仅由大小写字母组成的字符串， 小红有q次操作，每次操作可以选择一个区间, 将该区间的字母大小写翻转。
 * 请你输出最终的字符串。  输入描述: 第一行输入两个正整数n和q,用空格隔开。代表字符事长度和操 作次数。
 * 第二行输入一个长度为n的、仅由大小写字母组成的字符申。 接下来的q行，每行输入两个正整数l和r，代表小红操作的区 间。
 * 输出描述: 输出最终的字符串。
 * 输入 5 3
 *     aCbqE
 *     1 3
 *     2 5
 *     5 5
 * 输出 ACbQE
 * 说明 第一次操作[1,3]区间，字符串变成AcBqE 第二次操作[2,5] 区间，字符申变成ACbQe 第三次操作[5,5]区间，字符串变成ACbQE
 */
public class four {

    public static void main(String[] args) throws IOException {
//        System.out.println((int)'a'); // 97
//        System.out.println((int)'A'); // 65
//        char[] ch = new char[2];
//        ch[0] = 'a';
//        ch[1] = 'B';
//        if(ch[0] >= 97){
//            System.out.println(ch[0]);
//            ch[0] = (char)(ch[0] - 32);
//            System.out.println(ch[0]);
//        }
//        if(ch[1] < 65 + 26){
//            System.out.println(ch[1]);
//            ch[1] = (char)(ch[1] + 32);
//            System.out.println(ch[1]);
//        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int q = Integer.valueOf(s[1]);
        int[][] oper = new int[q][2];
        char[] str = reader.readLine().toCharArray();
        for(int i = 0; i < q; i++){
            String[] ss = reader.readLine().split(" ");
            oper[i][0] = Integer.parseInt(ss[0]);
            oper[i][1] = Integer.parseInt(ss[1]);
        }
        for(int i = 0; i < q; i++){
            int l = oper[i][0] - 1;
            int r = oper[i][1] - 1;
            for(int j = l; j <= r; j++){
                if(str[j] >= 97){
//                    System.out.println(str[j]);
                    str[j] = (char)(str[j] - 32);
//                    System.out.println(str[j]);
                }else if(str[j] < 65 + 26){
                    str[j] = (char) (str[j] + 32);
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(str[i]);
        }
        System.out.println(sb.toString());
    }
}
