package builder;

import lombok.Data;

import java.util.*;

/**
 * @Author: shiguang
 * @Create: 2023/9/2 5:54 下午
 * @Version: v1.0
 **/
@Data
public class PeopleBuilder {

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

    // 为了演示方便，加几个聚合方法
    public void addHobby(String hobby) {
        this.hobby = Optional.ofNullable(this.hobby).orElse(new ArrayList<>());
        this.hobby.add(hobby);
    }

    public void addGift(String day, String gift) {
        this.gift = Optional.ofNullable(this.gift).orElse(new HashMap<>());
        this.gift.put(day, gift);
    }

    public void setVitalStatistics(Integer bust, Integer waist, Integer hips) {
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
    }

    public static void main(String[] args) {

//        peopleNew.setName("迪丽热巴");
//        peopleNew.setAge(18);
//        peopleNew.setBust(33);
//        peopleNew.setWaist(23);
//        peopleNew.setHips(33);
//        peopleNew.setBirthday("2001-10-26");
//        peopleNew.setAddress("China");
//        peopleNew.setMobile("1811111");
//        peopleNew.setEmail("pro@email");
//        peopleNew.setHairColor("浅棕色");
//        List<String> hobby = new ArrayList<>();
//        hobby.add("逛街");
//        hobby.add("购物");
//        hobby.add("运动");
//        peopleNew.setHobby(hobby);
//        Map<String, String> gift = new HashMap<>();
//        gift.put("汽车", "海豹");
//        gift.put("工作", "银行");
//        peopleNew.setGift(gift);
        PeopleBuilder peopleBuilder = Builder.of(PeopleBuilder::new)
                        .with(PeopleBuilder::setName, "迪丽热巴")
                        .with(PeopleBuilder::setAge, 18)
                        .with(PeopleBuilder::setVitalStatistics, 33, 23, 33)
                        .with(PeopleBuilder::setBirthday, "2001-10-26")
                        .with(PeopleBuilder::setAddress, "China")
                        .with(PeopleBuilder::setMobile, "1811111")
                        .with(PeopleBuilder::setEmail, "pro@Email")
                        .with(PeopleBuilder::setHairColor, "浅棕色")
                        .with(PeopleBuilder::addHobby, "逛街")
                        .with(PeopleBuilder::addHobby, "购物")
                        .with(PeopleBuilder::addHobby, "运动")
                        .with(PeopleBuilder::addGift, "汽车", "海豹")
                        .with(PeopleBuilder::addGift, "工作", "银行")
                        // 等等..
                        .build();
        System.out.println(peopleBuilder);
    }
}
