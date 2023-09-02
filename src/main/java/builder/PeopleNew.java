package builder;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shiguang
 * @Create: 2023/9/2 5:39 下午
 * @Version: v1.0
 **/
@Data
public class PeopleNew {

    private String name;
    private Integer age;
    private Integer bust;
    private Integer waist;
    private Integer hips;
    private List<String> hobby;
    private String birthday;
    private String address;
    private String mobile;
    private String email;
    private String hairColor;
    private Map<String, String> gift;
    // 等等

    public static void main(String[] args) {
        PeopleNew peopleNew = new PeopleNew();
        peopleNew.setName("迪丽热巴");
        peopleNew.setAge(18);
        peopleNew.setBust(33);
        peopleNew.setWaist(23);
        peopleNew.setHips(33);
        peopleNew.setBirthday("2001-10-26");
        peopleNew.setAddress("China");
        peopleNew.setMobile("1811111");
        peopleNew.setEmail("pro@email");
        peopleNew.setHairColor("浅棕色");
        List<String> hobby = new ArrayList<>();
        hobby.add("逛街");
        hobby.add("购物");
        hobby.add("运动");
        peopleNew.setHobby(hobby);
        Map<String, String> gift = new HashMap<>();
        gift.put("汽车", "海豹");
        gift.put("工作", "银行");
        peopleNew.setGift(gift);
        // 等等
        System.out.println(peopleNew);
    }
}
