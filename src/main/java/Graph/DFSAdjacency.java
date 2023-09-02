package Graph;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * 数组索引代表顶点的值 */
public class DFSAdjacency {
    private int V; //顶点数量
    private int E; //边数量
    private Deque[] adj;
    //邻接表
    public DFSAdjacency(int vertical) {
        this.V = vertical;
        this.adj = new Deque[vertical];
        for (int i = 0; i < vertical; i++) {
            adj[i] = new LinkedList<>();
        }
    }
    public int getV() {
        return V;
    }
    public int getE() {
        return E;
    }
    /**
     * 向图中某一顶点加一条边
     * 无向图是没有方向的，需要让w出现在v的邻接表中，还需要让v出现在w的邻接表中
     * @param w
     * @param v
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }
    /**
     * 获取和某一顶点关联的所有顶点
     * @param v
     * @return Queue
     */
    public Queue adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) {
        String[][] str = new String[2][];
        System.out.println(str[0]);
        str[0] = new String[]{"1"};
        System.out.println(str[0][0]);
        System.out.println(str[0][1]);
    }


    public boolean isBipartite(int[][] graph) {
        boolean[] isMarked = new boolean[graph.length];
        boolean[] isRed = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {    // 使用遍历因为给定图不一定是连通图
            if (!isMarked[i]) {
                isMarked[i] = true;
                isRed[i] = true;
                Deque<Integer> queue = new LinkedList<>();
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor: graph[node]) {
                        if (!isMarked[neighbor]) {  // 如果邻居节点没有被标记过
                            isMarked[neighbor] = true;
                            isRed[neighbor] = !isRed[node];
                            queue.offer(neighbor);
                        } else {                    // 如果邻居节点被标记过
                            if (isRed[neighbor] == isRed[node]) {
                                return false;
                            }
                        }
                    }
                }

            }
        }

        return true;
    }


}





