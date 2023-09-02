import java.util.ArrayList;
import java.util.List;

public class Tree {
    // root = 1 2 3 4 null null 5  输出 9
    //输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    //输出：15
    //
    //输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    //输出：19
    public static void main(String[] args) {
        List<Integer> res = new ArrayList<>();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int maxLevel = maxLevel(root);
        System.out.println(maxLevel);
        dfs(root, 1, res, maxLevel);
        int sum = 0;
        for(int i = 0; i < res.size(); i++) {
            sum += res.get(i);
        }
        System.out.println(sum);
    }

    public static void dfs(TreeNode root, int level, List<Integer> list, int maxLevel) {
        if(root == null) {
            return;
        }
        if(level == maxLevel) {
            list.add(root.val);
        }
        dfs(root.left, level + 1, list, maxLevel);
        dfs(root.right, level + 1, list, maxLevel);
    }

    public static int maxLevel(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftLevel = maxLevel(root.left);
        int rightLevel = maxLevel(root.right);
        return Math.max(leftLevel, rightLevel) + 1;
    }

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
