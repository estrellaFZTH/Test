import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TTT {

    private static double distance (int x1, int y1, int x2, int y2) {
        double x = (x1 - x2) * (x1 - x2);
        double y = (y1 - y2) * (y1 - y2);
        return x + y;
    }

    private static boolean isEqual (double[] tri1, double[] tri2) {
        double tri1_a = tri1[0];
        double tri1_b = tri1[1];
        double tri1_c = tri1[2];

        for(int i = 0; i < tri2.length; i++) {
            if(tri1_a == tri2[i % tri2.length] && tri1_b == tri2[(i + 1) % tri2.length] && tri1_c == tri2[(i + 2) % tri2.length]) {
                return true;
            }
        }

        return false;
    }

    private static boolean isSim(double[] tri1, double[] tri2) {
        double tri1_a = tri1[0];
        double tri1_b = tri1[1];
        double tri1_c = tri1[2];

        for(int i = 0; i < tri2.length; i++) {
            double pro = tri1_a / tri2[i % tri2.length];
            if(pro == tri1_b / tri2[(i + 1) % tri2.length] && pro == tri1_c / tri2[(i + 2) % tri2.length]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String[] nums1 = s1.split(" ");
        String s2 = reader.readLine();
        String[] nums2 = s2.split(" ");
        double[] tri1 = new double[3];
        double[] tri2 = new double[3];
        tri1[0] = distance(Integer.parseInt(nums1[0]), Integer.parseInt(nums1[1]), Integer.parseInt(nums1[2]),Integer.parseInt(nums1[3]));
        tri1[1] = distance(Integer.parseInt(nums1[0]), Integer.parseInt(nums1[1]), Integer.parseInt(nums1[4]),Integer.parseInt(nums1[5]));
        tri1[2] = distance(Integer.parseInt(nums1[2]), Integer.parseInt(nums1[3]), Integer.parseInt(nums1[4]),Integer.parseInt(nums1[5]));

        tri2[0] = distance(Integer.parseInt(nums2[0]), Integer.parseInt(nums2[1]), Integer.parseInt(nums2[2]),Integer.parseInt(nums2[3]));
        tri2[1] = distance(Integer.parseInt(nums2[0]), Integer.parseInt(nums2[1]), Integer.parseInt(nums2[4]),Integer.parseInt(nums2[5]));
        tri2[2] = distance(Integer.parseInt(nums2[2]), Integer.parseInt(nums2[3]), Integer.parseInt(nums2[4]),Integer.parseInt(nums2[5]));

        if (isEqual(tri1, tri2)) {
            System.out.println("EQUAL");
        } else if (isSim(tri1, tri2)) {
            System.out.println("SIMILAR");
        }
    }
//    600 - 465
}
//150 5 150 5 150, 5 150