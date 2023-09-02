import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 三十六进制 {

    public static void main(String[] args) {

//        String num1 = "12";
//        String num2 = "23";
//        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
//        Deque<Integer> que = new LinkedList<>();
//        int flag = 0;
//        while (idx1 >= 0 || idx2 >= 0){
//            int n1 = idx1 >= 0 ? Integer.valueOf(num1.charAt(idx1)) : 0;
//            int n2 = idx2 >= 0 ? Integer.valueOf(num2.charAt(idx2)) : 0;
//            int sum = n1 + n2 + flag;
//            flag = sum / 36;
//            que.push(sum % 36);
//            idx1--;
//            idx2--;
//        }
//        if(flag != 0){
//            que.push(flag);
//        }
//        Map<Integer, String> map = new HashMap<>();
        System.out.println(getInt('b'));
        System.out.println(getChar(10));
        int n = 1;
        System.out.println((n & 1) == 0);


    }

    private static char getChar(int n){
        if(n <= 9){
            return (char) (n + '0');
        }else{
            return (char) (n - 10 + 'a');
        }
    }
    private static int getInt(char ch){
        if ('0' <= ch && ch <= '9')
            return ch - '0';
        else
            return ch - 'a' + 10;
    }
}
