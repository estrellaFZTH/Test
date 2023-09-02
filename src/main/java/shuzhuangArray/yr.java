package shuzhuangArray;

public class yr {

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
    public yr(int[] nums) {
//        Node node = buildTree(0, nums.length - 1, nums);
//        System.out.println(node.l + "," + node.r + "," + node.sum);
        this.root = buildTree(0, nums.length - 1, nums);
//        System.out.println(this.root.l + ":" + this.root.r);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,9,5,7,3};
        yr y = new yr(nums);
        y.query(y.root, 4,4);
        int res = y.sumRange(0,2);
        System.out.println(res);
//        System.out.println(y.root.l + ":" + y.root.r);
        y.update(1,2);
        System.out.println();
        System.out.println(y.sumRange(0,2));
    }

    private Node buildTree(int l, int r, int[] nums){
        Node root = new Node(l, r, 0);
        if(l == r){
            root.sum = nums[l];
            return root;
        }
        int mid = (l + r) / 2;
        root.left = buildTree(l, mid, nums);
        root.right = buildTree(mid + 1, r, nums);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(Node root, int x, int val){
        if(root.l == root.r){
            if(root.l == x){
                root.sum = val;
                return;
            }
        }
        int mid = (root.l + root.r) / 2;
        if(x <= mid){
            update(root.left, x, val);
        }else{
            update(root.right, x, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int sumRange(int left, int right) {
        return query(root, left, right);
    }

    private int query(Node root, int l, int r ){
        if(root.l == l && root.r == r){
            return root.sum;
        }else{
            int mid = (root.l + root.r) / 2;
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
