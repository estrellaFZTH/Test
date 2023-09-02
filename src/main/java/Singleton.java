

public class Singleton {

    public synchronized void test1(){}
    public static synchronized void test2(){}


    private volatile static Singleton singletonInstance = null;

    /**
     * 单例模式保证java应用程序中，一个类Class只有一个实例在，使用单例模式好处在于可以节省内存，
     * 节约资源，对于一般频繁创建和销毁对象的可以使用单例模式。
     *
     * 就是不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，
     * 单例就会引起数据的错误，不能保存彼此的状态。
     *
     */
    private Singleton(){
    }

    // 双重检查加锁
    public static Singleton singletonInstance() {
        //双重校验锁第一次进行判空原因：当程序顺序执行的时候，如果不进行判空，
        // 每一个线程都会先去获得当前类的类锁，而其他线程都进入阻塞状态。
        // 单例模式中初始化单例的程序只会执行一次，大部分情况下会直接到return语句返回，如果都阻塞在获取锁的位置，会大大降低程序的运行速度
        if(singletonInstance == null){
            //双重校验锁第二次进行判空原因：假设有两个线程A和B，都进行完第一次判空了，A和B都阻塞在本注释的位置
            //这个时候A线程获取了类锁，然后B线程被阻塞，A线程新建了一个实例后释放了锁，B线程获取锁，又新建了一个实例，这破坏了单例设计模式的初衷。
            synchronized (Singleton.class) {
                if (singletonInstance == null) {
                    singletonInstance = new Singleton();
                }
            }
        }
        return singletonInstance;
    }
}
