package br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl;

import br.com.thoughtworks.merchant.galaxy.challenge.module.constants.MerchantGalaxyContants;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxySymbolValidation;

/**
 *
 * This class  represent the validation galaxy symbol numeral
 */
public class DefaultGalaxySymbolValidation implements GalaxySymbolValidation {


    /**
     * <p>This method validates a given galaxy input number<br>
     *
     * @param inputGalaxySymbol
     *
     * @return TRUE|FALSE
     */
    public  int validation(String inputGalaxySymbol)
    {
        int result = 0;

        if(inputGalaxySymbol.matches(MerchantGalaxyContants.GALAXY_SYMBOL_NUMBER_VALIDATOR))
        {
            result = 1;
        }
        return result;
    }
}
