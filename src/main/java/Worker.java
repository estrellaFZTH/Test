import java.util.Hashtable;

/**
 * @author shiguang
 */
public class Worker extends Thread{
    private int x = 2;

    public static void main(String[] args) throws Exception {
        new Worker().makeItSo();
    }
    public Worker() {
        x = 5;
        start();
    }

    public void makeItSo() throws Exception{
        join();
        x = x - 1;
        System.out.println(x);
    }

    @Override
    public void run() {
        x *= 2;
    }

}


