import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.RandomAccess;

public class Cat {

    public static void main(String[] args) {

        numJewelsInStones("aA", "aAAbbbb");
    }

    public  static int numJewelsInStones(String jewels, String stones) {
        int[] jew = new int[256];
        for(int i = 0; i < jewels.length(); i++){
            jew[jewels.charAt(i)]++;
        }
        int res = 0;
        for(int i = 0; i < stones.length(); i++){
            if(jew[stones.charAt(i) - '0'] != 0)
                res++;
        }
        return res;
    }
    private Integer id;
    private String name;

    public Cat(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id.equals(cat.id) && name.equals(cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
