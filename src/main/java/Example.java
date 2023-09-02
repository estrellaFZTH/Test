import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Example {
    String str = new String("good");
    char[] ch = {'a','b','c'};
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str +"and");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]){
        str= "test ok";
        ch[0]= 'g';
    }
}
