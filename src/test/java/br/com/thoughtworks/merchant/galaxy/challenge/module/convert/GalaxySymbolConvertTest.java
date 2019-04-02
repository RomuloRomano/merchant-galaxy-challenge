package br.com.thoughtworks.merchant.galaxy.challenge.module.convert;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to create some tests  to convert symbol galaxy
 *
 */
public class GalaxySymbolConvertTest {

    private  GalaxySymbolConvert galaxySymbolConvert;

    private static final String NUMBER_TO_ARABIC = "MMC";

    private static String RESULT_NUMBER_EXPECTED = "2100";


    @Test
    public void convertGalaxySymbolNumberToArabicTest(){
        Assert.assertEquals(RESULT_NUMBER_EXPECTED, getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(NUMBER_TO_ARABIC));
    }

    public GalaxySymbolConvert getGalaxySymbolConvert() {
        if(galaxySymbolConvert == null){
            galaxySymbolConvert = new DefaultGalaxySymbolConvert();
        }
        return galaxySymbolConvert;
    }
}
