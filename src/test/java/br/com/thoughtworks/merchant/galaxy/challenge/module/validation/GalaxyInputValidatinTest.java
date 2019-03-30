package br.com.thoughtworks.merchant.galaxy.challenge.module.validation;

import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.GalaxyInputValidationBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Class  to test the input value
 */
public class GalaxyInputValidatinTest {


    @Test
    public void validationTest(){

        String[]  input = new String[1];
        input[0] = "glob is I";
        Assert.assertTrue(GalaxyInputValidationBuilder.builderGalaxyInputValidation().validation(input));
    }

}
