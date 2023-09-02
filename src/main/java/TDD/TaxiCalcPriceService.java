package TDD;

public class TaxiCalcPriceService {

    private static final int BASE_INSTANCE = 3;
    private static final int INT_PRICE = 13;
    private static final double UNIT_PRICE = 2.3;
    private static final double NIGHT_ADDITIONAL_TAX_RATIO = 20.0 / 100.0;

    /**
     * 起步价：13
     */
//    初始情况，未写入业务代码的时候，进行单元测试会不通过报红
//    public double calcPrice(CalcPriceDto calPriceDto) {
//    return 0;
//    }

    public double calcPrice(CalcPriceDto calPriceDto) {

        if (calPriceDto.getInstance() < BASE_INSTANCE) {
            return INT_PRICE;
        }

        return 0;
    }

    /**
     * 起步范围：3km
     * 每公里单位价：2.3
     */
//    初始情况，未写入业务代码的时候，进行单元测试会不通过报红
//    public double calcPrice1(CalcPriceDto calPriceDto) {
//
//        if (calPriceDto.getInstance() < BASE_INSTANCE) {
//            return INT_PRICE;
//        }
//
//        return 0;
//    }

    public double calcPrice1(CalcPriceDto calPriceDto) {

        if (calPriceDto.getInstance() < BASE_INSTANCE) {
            return INT_PRICE;
        }

        return INT_PRICE + (calPriceDto.getInstance() - BASE_INSTANCE) * UNIT_PRICE;
    }


    /**
     * 下半夜： 23:00 - 05:00 单位价格增收20%
     */
    // 初始情况：
            // Expected :18.060000000000002
            // Actual   :17.6
//    public double calcPrice2(CalcPriceDto calPriceDto) {
//
//        if (calPriceDto.getInstance() < BASE_INSTANCE) {
//            return INT_PRICE;
//        }
//
//        return INT_PRICE + (calPriceDto.getInstance() - BASE_INSTANCE) * UNIT_PRICE;
//    }

    public double calcPrice2(CalcPriceDto calPriceDto) {

        if (calPriceDto.getInstance() < BASE_INSTANCE) {
            return INT_PRICE;
        }

        return INT_PRICE + (calPriceDto.getInstance() - BASE_INSTANCE - calPriceDto.getInstanceInNight()) * UNIT_PRICE
                + calPriceDto.getInstanceInNight() * (1 + NIGHT_ADDITIONAL_TAX_RATIO) * UNIT_PRICE;
    }

}
