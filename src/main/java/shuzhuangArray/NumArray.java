package shuzhuangArray;

class NumArray {

    class BIT {
        int[] nums;
        BIT(int n) {
            nums = new int[n + 1];
        }
        //更新x的的值
        void update(int x, int val) {
            while (x < nums.length) {
                nums[x] += val;
                x += (x & -x);
            }
        }

        //计算nums[0,i]和
        int sum(int index) {
            int ans = 0;
            while (index > 0) {
                ans += nums[index];
                index -= (index & -index);
            }
            return ans;
        }
    }

    BIT bit;
    public NumArray(int[] nums) {
        bit = new BIT(nums.length);
        for (int i = 1; i <= nums.length; i++) {
            bit.update(i, nums[i - 1]);
        }
    }

    public void update(int index, int val) {
        bit.update(index + 1, val - (bit.sum(index + 1) - bit.sum(index)));
    }

    public int sumRange(int left, int right) {
        return bit.sum(right + 1) - bit.sum(left);
    }
}



//    public int searchTree(int left, int right, int node, int start, int end){
//        if(start == left && end == right) return tree[node];
//        else{
//            int leftNode = node * 2 + 1;
//            int rightNode = node * 2 + 2;
//            int mid = (start + end) / 2;
//            if(right <= mid) return searchTree(left, right, leftNode, start, mid);
//            else if(left > mid){
//                return searchTree(left, right, rightNode, mid + 1, end);
//            }
//            else{
//                return searchTree(left, mid, leftNode, start, mid) + searchTree(mid + 1, right, rightNode, mid + 1, end);
//            }
//        }
//    }
//
//    public int sumRange(int left, int right) {
//        return searchTree(left, right, 0, 0, arrEnd);
//    }



