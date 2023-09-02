package Graph;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ͼ
 * ���������������ֵ */
public class DFSAdjacency {
    private int V; //��������
    private int E; //������
    private Deque[] adj;
    //�ڽӱ�
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
     * ��ͼ��ĳһ�����һ����
     * ����ͼ��û�з���ģ���Ҫ��w������v���ڽӱ��У�����Ҫ��v������w���ڽӱ���
     * @param w
     * @param v
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        this.E++;
    }
    /**
     * ��ȡ��ĳһ������������ж���
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

        for (int i = 0; i < graph.length; i++) {    // ʹ�ñ�����Ϊ����ͼ��һ������ͨͼ
            if (!isMarked[i]) {
                isMarked[i] = true;
                isRed[i] = true;
                Deque<Integer> queue = new LinkedList<>();
                queue.offer(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor: graph[node]) {
                        if (!isMarked[neighbor]) {  // ����ھӽڵ�û�б���ǹ�
                            isMarked[neighbor] = true;
                            isRed[neighbor] = !isRed[node];
                            queue.offer(neighbor);
                        } else {                    // ����ھӽڵ㱻��ǹ�
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





