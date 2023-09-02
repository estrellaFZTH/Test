public class DanLi {

    private static volatile DanLi danli = null;

    public DanLi getDanLi() {
        if (danli == null) {
            synchronized (DanLi.class) {
                if (danli == null) {
                    danli = new DanLi();
                }
            }
        }
        return danli;
    }

}
