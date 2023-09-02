package zijie0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 我们约定"模糊回文字母串"的定义如下: 对于一一个含有英文字母的字符申。
 * 如果满足如下规则: 1)读的时候字母不区分大小写; 2)非字母字符均当作同一字符读叹: 若从左往右读和从右往左读是一样的, 那么就称之为模糊回文字母串。
 * 例如，"a#&A". "a+b-a". "abA". "ab(%BA'均属于模朝回文字母串。 现给定一一个含有字母的字符串s，请编写函数判断字符丰s经过有限次的字符位置
 * 调整后能否变成一个模糊回文字母串，若可以则返true,不 可以则返回false. 输入用例 a#&A 输出 true 输入用例 -A+(AAa)bB 输出 true
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
