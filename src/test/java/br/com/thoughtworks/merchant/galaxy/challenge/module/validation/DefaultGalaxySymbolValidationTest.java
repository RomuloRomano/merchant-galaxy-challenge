package br.com.thoughtworks.merchant.galaxy.challenge.module.validation;


import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxySymbolValidation;
import org.junit.Assert;
import org.junit.Test;

/**
 * Class base to test galaxy symbol validation
 */
public class DefaultGalaxySymbolValidationTest {


    private GalaxySymbolValidation galaxySymbolValidation  = new DefaultGalaxySymbolValidation();

    private static final String  GALAXY_NUMBER = "MMC";


    @Test
    public void validationTest(){

        Assert.assertEquals(1,galaxySymbolValidation.validation(GALAXY_NUMBER));
    }
}
