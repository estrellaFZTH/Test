package builder;

import lombok.Data;

/**
 * @Author: shiguang
 * @Create: 2023/9/2 5:37 下午
 * @Version: v1.0
 **/
@Data
public class People {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        People people = new People();
        people.setName("xiao");
        people.setAge(18);
    }
}
