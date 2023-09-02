package interfaceAndClass;

import java.io.Serializable;

public class a implements jieKou, Serializable {
    @Override
    public String str() {
        return null;
    }

    @Override
    public String str1() {
        return null;
    }

    @Override
    public String str(int i) {
        return jieKou.super.str(i);
    }
}
