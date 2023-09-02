import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MS {



    public static void main(String[] args) {
        System.out.println((int)3*0.1==0.3);
        System.out.println((int)3*0.1);
    }

    // 用户上传文本
    // 送杜少府之任蜀川
    // 【唐】王勃
    //城阙辅三秦，风烟望五津。
    //与君离别意，同是宦游人。

    //  前端传来的文本
    //  方案1： 以诗句为单位并加标点符号， 其实这个方案我在后端也会拆成单个字处理
    // List<String>["送杜少府之任蜀川"，"【唐】王勃"，"城阙辅三秦，"，"风烟望五津。"，"与君离别意，"，"同是宦游人。"]
    //  方案2： 以单个字为符号，标点也占一个单位
    // List<String>["送杜少府之任蜀川"，"【唐】王勃"，"城"，"阙"，"辅"，"三"，"秦"，"，"，"风"，"烟"，"望"，"五"，"津"，"。"，
    //              "与"，"君"，"离"，"别"，"意"，"，"，"同"，"是"，"宦"，"游"，"人"，"。"]

    // 针对方案一设计：
    private class Text {
        private String text;
        private int type; // 0:不上色；1：平；2：仄；3：声韵
        // 当然还可以加读音字段
        // 不知mentor说的让用户自己选多音字的发音是怎么选的

    }

    public class Request{
        private List<String> list;
    }

    public class Response {
        private String title;
        private String author;
        private List<List<Text>> content;  // 外层List 对应哪句诗，内层List对应该句诗的某个字
    }

    // 前端拿到我的Response，只需遍历 content，然后拿到某字的type。并判断对其上什么色


}
