package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ����Լ��"ģ��������ĸ��"�Ķ�������: ����һһ������Ӣ����ĸ���ַ��ꡣ
 * ����������¹���: 1)����ʱ����ĸ�����ִ�Сд; 2)����ĸ�ַ�������ͬһ�ַ���̾: ���������Ҷ��ʹ����������һ����, ��ô�ͳ�֮Ϊģ��������ĸ����
 * ���磬"a#&A". "a+b-a". "abA". "ab(%BA'������ģ��������ĸ���� �ָ���һһ��������ĸ���ַ���s�����д�����ж��ַ���s�������޴ε��ַ�λ��
 * �������ܷ���һ��ģ��������ĸ������������true,�� �����򷵻�false. �������� a#&A ��� true �������� -A+(AAa)bB ��� true
 */
public class one {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        System.out.println((int)'a'); // 97
        System.out.println((int)'A'); // 65
        int[] nums = new int[256];
        System.out.println("-------------");
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            System.out.println(ch - 0);
            if(ch >= 97){
                nums[ch - 32] ++;
            }else{
                nums[ch] ++;
            }
        }
        System.out.println("-------------");
        int count = 0;
        for(int i = 65; i < 65 + 26; i++){
            if((nums[i] & 1) != 0) {
                count++;
            }
        }
        if (count > 1)
            System.out.println(false);
        else
            System.out.println(true);
    }

}
