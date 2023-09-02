import com.google.common.hash.Funnels;


public class BloomFilter {

    /**
     * 预计要插入的数据
     */
    private static int size = 1000000;
    private static double fpp = 0.001;
    private static com.google.common.hash.BloomFilter<Integer> bloomFilter = com.google.common.hash.BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    private static int total = 1000000;
    public static void main(String[] args) {
        for(int i = 0; i < total; i++){
            bloomFilter.put(i);
        }
        int count = 0;

        for(int i = total; i < total + 100000; i++){
            if(bloomFilter.mightContain(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}
