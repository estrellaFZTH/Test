import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class StringUtilsTest {

    private static class Node{
        private String name1;
        private String name2;
        private String name3;

        public Node(String name1, String name2, String name3){
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name1='" + name1 + '\'' +
                    ", name2='" + name2 + '\'' +
                    ", name3='" + name3 + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[5];
        nodes[0] = new Node("yila", "one", "A");
        nodes[1] = new Node("China", "two", "C");
        nodes[2] = new Node("China", "two", "A");
        nodes[3] = new Node("China", "two", "B");
        nodes[4] = new Node("China","two1", "B");
        String flag1 = "";
        String flag2 = "";
        System.out.println(flag2);
        String flag3 = "";
        List<Node> list = new ArrayList<>();
        for(Node node : nodes){
            System.out.println(node);
            if(flag1 != "" && !node.name1.equals(flag1)){
                continue;
            }
            if(flag2 != "" && !node.name2.equals(flag2)){
                continue;
            }
            if(flag3 != "" && !node.name3.equals(flag3)){
                continue;
            }
            list.add(node);
        }
        System.out.println("-------------");
        for(Node node : list){
            System.out.println(node.toString());
        }
    }

}
