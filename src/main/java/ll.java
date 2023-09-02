public class ll {
    // 升序
    // 1,2,3,4,5,6,7
    // 3,4,5,6,7,1,2,2
    // 10111
    // 01234
    //10111 和 11101 这种。此种情况下 nums[start] == nums[mid]，
    // 分不清到底是前面有序还是后面有序，此时 start++ 即可。相当于去掉一个重复的干扰项。

    //当搜索有重复元素的排序数组时，我们会遇到一个问题：如果 nums[left] nums[mid] nums[right]
    // 时怎么办？比如 [2,1,2,2,2] 和 [2,2,2,1,2]，最开始时，left 指向 第 0 位置，right
    // 指向第 4 位置，mid 指向中间的 2 位置；此时三者相等都为 2。如果我们想找 1，而这个 1 可
    // 以在 mid 的左边也可以在 mid 的右边。
    // 所以就不知道该在哪个区间继续搜索。
    //一个解决本题的办法是，我们遇到 nums[left] == nums[right] 的情况时，直接向右移动 left，
    // 直至 nums[left] != nums[right]。那这样的话，上面的例子中就变成了在 [1,2,2,2]和
    // [2,2,2,1]
    // 上搜索，1 所在的区间就可以根据 mid 和 right 的大小关系而获得了。
    //代码如下，是在上面的代码的基础上增加了 nums[left] 和 nums[right]相等的时候的判断代码。

    // 返回下表 int定义函数
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] == nums[mid]){
                left++;
                continue;
            }
            if(nums[mid] >= nums[left]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[right] >= target && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
