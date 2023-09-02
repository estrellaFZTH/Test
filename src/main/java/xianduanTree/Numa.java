package xianduanTree;


public class Numa {

    public static void main(String[] args) {

    }
    private class Node{
        private int l;
        private int r;
        private int sum;
        private Node left;
        private Node right;
        public Node(){}
        public Node(int l, int r, int sum){
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }
    private Node root;
    public Numa(int[] nums) {
        this.root = buildTree(0, nums.length - 1, nums);
    }

    private Node buildTree(int l, int r, int[] nums){
        Node root = new Node();
        if(l == r){
            root.l = l;
            root.r = r;
            root.sum = nums[l];
            return root;
        }
        int mid = (l + r) / 2;
        root.left = buildTree(l, mid, nums);
        root.right = buildTree(mid + 1, r, nums);
        return root;
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }

    private void updateHelper(Node root, int x, int val){
        if(root.l == root.r){
            root.sum = val;
            return;
        }
        int mid = (root.l + root.r) / 2;
        if(x <= mid){
            updateHelper(root.left, x, val);
        }else{
            updateHelper(root.right, x, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int left, int right) {
        return this.query(root, left, right);
    }

    private int query(Node root, int l, int r){
        if(root.l == l && root.r == r){
            return root.sum;
        }else{
            int mid = (l + r) / 2;
            if(r <= mid){
                return query(root.left, l, mid);
            }else if(l > mid){
                return query(root.right, mid + 1, r);
            }else{
                return query(root.left, l, mid) + query(root.right, mid + 1, r);
            }
        }

    }

}