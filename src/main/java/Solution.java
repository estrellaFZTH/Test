// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {


    private static Map<Integer, Integer> map = new HashMap<Integer, Integer>(){
        {
            put(1,1);
            put(2,2);
        }
    };

    private static class Help{
        private int leftIndex;
        private int leftVal;
        private int rightIndex;
        private int rightVal;
        private int distance;

        public Help(int leftIndex, int leftVal, int rightIndex,  int rightVal, int distance){
            this.leftIndex = leftIndex;
            this.leftVal = leftVal;
            this.rightIndex = rightIndex;
            this.rightVal = rightVal;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        int[] A = new int[]{-3, -2, 1, 0, 8, 7, 1};
        int M = 3;
        System.out.println(solution(A, M));
        System.out.println("--------------------------------------");
        int[] B = new int[]{7, 1, 11, 8, 4, 10};
        int N = 8;
        System.out.println(solution(B, N));
    }
    public static int solution(int[] A, int M) {
        // write your code in Java SE 8
        if(A.length == 0)
            return 0;
        List<Help> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] % M == 0){
                System.out.println(A[i]);
                res.add(A[i]);
            }
            for(int j = i + 1; j < A.length; j++){
                list.add(new Help(i, A[i], j, A[j], Math.abs(A[i] - A[j])));
            }
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println("[" + list.get(i).leftVal + ", " + list.get(i).rightVal +"]   " + list.get(i).distance);
        }
        Set<Integer> indexSet = new HashSet<>();
        for(int i = 0; i < list.size(); i++){
            Help cur = list.get(i);
            if(cur.distance % M == 0){
                System.out.println("Current :   {" +  cur.leftIndex + ", " + cur.rightIndex + "}" );
                if(!indexSet.contains(cur.leftIndex)){
                    indexSet.add(cur.leftIndex);
                    res.add(cur.leftVal);
                }
                if(!indexSet.contains(cur.rightIndex)){
                    indexSet.add(cur.rightIndex);
                    res.add(cur.rightVal);
                }
            }
        }

        System.out.println("--------set----------");
        for(Integer in : indexSet){
            System.out.println(in);
        }
        System.out.println("--------set----------");
        return res.size();
    }

}