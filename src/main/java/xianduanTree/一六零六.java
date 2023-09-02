package xianduanTree;

import java.util.ArrayList;
import java.util.List;

public class “ª¡˘¡„¡˘ {


    public static void main(String[] args) {
        int[] arrival = new int[]{1,2,3,4,5};
        int[] load = new int[]{5,2,3,3,3};
        int k = 3;
        // sout : 1
        System.out.println(busiestServers(k, arrival, load));

    }


    public static List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        List<Integer> res = new ArrayList<>();
        if(k <= 0){
            return res;
        }
        Node root = buildTree(0, k - 1);
        System.out.println(root.l + ":" + root.r);
        int[] count = new int[k];
        int maxCount = 0;
        for(int i = 0; i < arrival.length; i++){
            if(root.end > arrival[i]){
                continue;
            }
            int position = i % k;
            int start = arrival[i];
            int end = start + load[i];
            int x = query(root, position, k - 1, start);
            if(x == -1){
                x = query(root, 0, position - 1, start);
            }
            count[x]++;
            maxCount = Math.max(count[x], maxCount);
            update(root, x, end);
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] == maxCount){
                res.add(i);
            }
        }
        return res;
    }

    private static void update(Node root, int x, int end){
        if(root.l == root.r){
            root.end = end;
            return;
        }
        int mid = (root.l + root.r) / 2;
        if(x <= mid){
            update(root.left, x, end);
        }else{
            update(root.right, x, end);
        }
        root.end = Math.min(root.left.end, root.right.end);
    }

    private static int query(Node root, int l, int r, int start){
        if(root.l == root.r){
            if(root.l >= l && root.r <= r){
                return root.l;
            }
            return -1;
        }
        int val = -1;
        int mid = (root.l + root.r) / 2;
        if(l <= mid && start >= root.left.end){
            val = query(root.left, l, r, start);
        }
        if(val != -1){
            return val;
        }
        if(r > mid && start >= root.right.end){
            val = query(root.right, l, r, start);
        }
        return val;
    }

    private static Node buildTree(int l, int r){
        Node root = new Node(l, r, -1);
        if(l == r){
            return root;
        }
        int mid = (l + r) / 2;
        root.left = buildTree(l, mid);
        root.right = buildTree(mid + 1, r);
        return root;
    }

    private static class Node{
        private int l;
        private int r;
        private int end;
        private Node left;
        private Node right;

        public Node(){}
        public Node(int l, int r, int end){
            this.l = l;
            this.r = r;
            this.end = end;
        }
    }


}
