public class Hua {

    //
    public static void main(String[] args) {
//        String source = "abc";
//        String target = "abcbc";
//        String source = "abc";
//        String target = "acdbc";
        String source = "xyz";
        String target = "xzyxz";
        int res = 0;
        boolean flag = false;
        for(int i = 0; i < target.length();) {
            int len = isMatch(source, target, i);
            if(len != 0) {
                res++;
                i += len;
            } else {
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }

    public static int isMatch(String source, String target, int index) {
        String newTarget = target.substring(index, target.length());
        int newTargetIdx = 0;
        for(int j = 0; j < source.length(); j++) {
            if(newTarget.charAt(newTargetIdx) == source.charAt(j)) {
                newTargetIdx++;
            }
        }
        return newTargetIdx;
    }
}
