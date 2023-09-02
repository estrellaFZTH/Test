package CollectionStream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



public class ListStream {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("一");
        list.add("两个");
        list.add("三");
        Stream<String> stream = list.stream();


    }


}
