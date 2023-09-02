
public class Test2 {

    public static void main(String[] args) {
        long ll = 1;

        int[] nums = new int[]{2, 4, 5, 1, 32, 443, 43, 22, 13, 3, 13};
        sort(nums, 0, nums.length - 1);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
    private static void sort(int[] nums, int start, int end){
        if(start >= end)
            return;
        int left = start;
        int right = end;
        int keyVal = nums[left];
        while(left < right){
            while(left < right && nums[right] >= keyVal){
                right--;
            }
            swap(nums, left, right);
            while(left < right && nums[left] <= keyVal){
                left++;
            }
            swap(nums, left, right);
        }
        sort(nums, start, left - 1);
        sort(nums, right + 1, end);
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
