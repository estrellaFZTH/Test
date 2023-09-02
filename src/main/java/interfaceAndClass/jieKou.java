package interfaceAndClass;

public interface jieKou {

    public String str();

    public String str1 = null;

    public int num = 0;

    public abstract String str1();

    public default String str(int i){
        return null;
    };

}
