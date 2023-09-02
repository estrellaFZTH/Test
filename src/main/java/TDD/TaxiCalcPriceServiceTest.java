package TDD;
import org.junit.Assert;
import org.junit.Test;


/**
 * 例子：
 * 需求：计程车计价：
 * 费用包含：起步价、超出起步价范围的每公里单位价、下半夜对于单位价价收20%
 * 规则：
 * 起步价：13
 * 起步范围：3km
 * 每公里单位价：2.3
 * 下半夜： 23:00 - 05:00 单位价格增收20%
 * 最终价格： 向下取整
 */
public class TaxiCalcPriceServiceTest {


    /**
     * 起步价：13
     */
    @Test
    public void it_should_charge_13_when_the_instance_le_3km(){

        // Given
        final TaxiCalcPriceService taxiCalcPriceService = new TaxiCalcPriceService();
//        final CalcPriceDto calPriceDto = new CalcPriceDto();
        final double instance = 2;
        final CalcPriceDto calcPriceDto = buildCalcPriceDto(instance);

        // When
        double price = taxiCalcPriceService.calcPrice1(calcPriceDto);

        // Then
        Assert.assertEquals(13, price, 0);


    }

    /**
     * 起步范围：3km
     * 每公里单位价：2.3
     */
    @Test
    public void it_should_charge_15_dot_3_when_the_instance_is_4km(){
        // Given
        final TaxiCalcPriceService taxiCalcPriceService = new TaxiCalcPriceService();
//        final CalcPriceDto calPriceDto = new CalcPriceDto();
        final double instance = 4;
        final CalcPriceDto calcPriceDto = buildCalcPriceDto(instance);

        // When
        double price = taxiCalcPriceService.calcPrice(calcPriceDto);

        // Then
        Assert.assertEquals(15.3, price, 0);
    }

    /**
     * 下半夜： 23:00 - 05:00 单位价格增收20%
     */
    @Test
    public void it_should_charge_additional_20_percent_of_unit_price_when_in_dark_night() {
        // Given
        final TaxiCalcPriceService taxiCalcPriceService = new TaxiCalcPriceService();
//        final CalcPriceDto calPriceDto = new CalcPriceDto();
        final double instance = 5;
        final double instanceInNight = 1;
        final CalcPriceDto calcPriceDto = buildCalcPriceDto1(instance, instanceInNight);

        // When
        double price = taxiCalcPriceService.calcPrice2(calcPriceDto);

        // Then
        Assert.assertEquals(15.3 + (1 + 20.0 / 100.0) * 2.3, price, 0);
    }

    private CalcPriceDto buildCalcPriceDto1(double instance, double instanceInNight) {
        CalcPriceDto calcPriceDto = new CalcPriceDto();
        calcPriceDto.setInstance(instance);
        calcPriceDto.setInstanceInNight(instanceInNight);
        return calcPriceDto;
    }

    private CalcPriceDto buildCalcPriceDto(double instance) {
        CalcPriceDto calcPriceDto = new CalcPriceDto();
        calcPriceDto.setInstance(instance);
        return calcPriceDto;
    }





}
