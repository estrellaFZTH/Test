package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * С��������һ������Ϊn�ġ����ɴ�Сд��ĸ��ɵ��ַ����� С����q�β�����ÿ�β�������ѡ��һ������, �����������ĸ��Сд��ת��
 * ����������յ��ַ�����  ��������: ��һ����������������n��q,�ÿո�����������ַ��³��ȺͲ� ��������
 * �ڶ�������һ������Ϊn�ġ����ɴ�Сд��ĸ��ɵ��ַ��ꡣ ��������q�У�ÿ����������������l��r������С��������� �䡣
 * �������: ������յ��ַ�����
 * ���� 5 3
 *     aCbqE
 *     1 3
 *     2 5
 *     5 5
 * ��� ACbQE
 * ˵�� ��һ�β���[1,3]���䣬�ַ������AcBqE �ڶ��β���[2,5] ���䣬�ַ�����ACbQe �����β���[5,5]���䣬�ַ������ACbQE
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
