import java.io.*;
import java.util.*;

public class baidu02 {
    // 2
    // 4 2
    // 1 2 1 2
    // 4 3
    // 1 2 1 2
    // --> 2 5 || 1 1
    //     -1
    static class Number {
        int num;
        int count;

        public Number(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(bf.readLine());
        for (int i = 0; i < N; i++) {
            String[] str = bf.readLine().split(" ");
            int len = Integer.valueOf(str[0]);
            int k = Integer.valueOf(str[1]);
            String[] arr = bf.readLine().split(" ");
            List<Number> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                int n = Integer.valueOf(arr[j]);
                if (map.containsKey(n)) {
                    map.put(n, map.get(n) + 1);
                } else {
                    map.put(n, 1);
                }
            }
            for (int key : map.keySet()) {
                Number number = new Number(key, map.get(key));
                list.add(number);
            }
            list.sort(
                    new Comparator<Number>() {
                        @Override
                        public int compare(Number o1, Number o2) {
                            return o1.count - o2.count;
                        }
                    });
            int sum = 0;
            int l = 0, r = 0;
            boolean flag = false;
            for (int m = 0; m < list.size(); m++) {
                for (int n = m; n < list.size(); n++) {
                    sum += list.get(n).count;
                    //发现符合条件的区间
                    if (sum == k) {
                        l = list.get(m).num;
                        r = list.get(n).num;
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println(l + " " + r);
            } else {
                System.out.println(-1);
            }
        }

    }



}
