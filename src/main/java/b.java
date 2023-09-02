import java.util.*;

public class b {

    public static void main(String[] args){
        //69564669 12

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] res = new int[100000];
        int minLength = Integer.MAX_VALUE;
        int left = 0, right = -1, sum = 0;
        while(left < n1){
            if(sum == n1 && (right - left + 1) >= n2){
                if(minLength > right - left + 1){
                    minLength = right - left + 1;
                    int index = 0;
                    for(int i = left; i <= right; i++){
                        res[index++] = i;
                    }
                }
            }
            if(sum < n1 && right + 1 < n1){
                sum += (++right);
            }else{
                sum -= (left++);
            }
        }
        if(minLength == Integer.MAX_VALUE || minLength > 100){
            System.out.println("NO");
        }else {
            for (int i = 0; i < minLength; i++) {
                System.out.print(res[i] + " ");
            }
        }
        int[] nums2 = new int[]{1617762, 1617763, 1617764, 1617765, 1617766, 1617767, 1617768,
                1617769, 1617770, 1617771, 1617772, 1617773, 1617774, 1617775, 1617776, 1617777,
                1617778, 1617779, 1617780, 1617781, 1617782, 1617783, 1617784, 1617785, 1617786,
                1617787, 1617788, 1617789, 1617790, 1617791, 1617792, 1617793, 1617794, 1617795,
                1617796, 1617797, 1617798, 1617799, 1617800, 1617801, 1617802, 1617803, 1617804};
        System.out.println();
        for(int i = 0; i < minLength; i++){
            if(nums2[i] != res[i]){
                System.out.println("f");
                return;
            }
        }
        System.out.println("t");

        //1617762 1617763 1617764 1617765 1617766 1617767 1617768 1617769 1617770 1617771 1617772 1617773 1617774 1617775 1617776 1617777 1617778 1617779 1617780 1617781 1617782 1617783 1617784 1617785 1617786 1617787 1617788 1617789 1617790 1617791 1617792 1617793 1617794 1617795 1617796 1617797 1617798 1617799 1617800 1617801 1617802 1617803 1617804
    }
}
