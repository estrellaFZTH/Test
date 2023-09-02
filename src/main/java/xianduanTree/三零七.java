//package xianduanTree;
//
//public class 三零七 {
//    class NumArray {
//        private class Node{
//            private int l;
//            private int r;
//            private int sum;
//            private Node left;
//            private Node right;
//            public Node(){}
//            public Node(int l, int r, int sum){
//                this.l = l;
//                this.r = r;
//                this.sum = sum;
//            }
//        }
//        private Node root;
//        public NumArray(int[] nums) {
//            this.root = buildTree(0, nums.length - 1, nums);
//        }
//
//        private Node buildTree(int l, int r, int[] nums){
//            Node root = new Node(l, r, 0);
//            if(l == r){
//                root.sum = nums[l];
//                return root;
//            }
//            int mid = (l + r) / 2;
//            root.left = buildTree(l, mid, nums);
//            root.right = buildTree(mid + 1, r, nums);
//            root.sum = root.left.sum + root.right.sum;
//            return root;
//        }
//
//        public void update(int index, int val) {
//            updateHelper(root, index, val);
//        }
//
//        private void updateHelper(Node root, int x, int val){
//            if(root.l == root.r){
//                root.sum = val;
//                return;
//            }
//            int mid = (root.l + root.r) / 2;
//            if(x <= mid){
//                updateHelper(root.left, x, val);
//            }else{
//                updateHelper(root.right, x, val);
//            }
//            root.sum = root.left.sum + root.right.sum;
//        }
//
//        public int sumRange(int left, int right) {
//            return this.query(root, left, right);
//        }
//
//        private int query(Node root, int l, int r) {
//            if(root.l == root.r){
//                if(root.l >= l && root.r <= r) {
//                    return root.sum;
//                }
//            }
//            int mid = (root.l + root.r) >> 1;
//            int ret = 0;
//            if(l <= mid) {
//                ret += query(root.left, l, r);
//            }
//            if(r > mid) {
//                ret += query(root.right, l, r);
//            }
//            return ret;
//        }
//    }
//}
