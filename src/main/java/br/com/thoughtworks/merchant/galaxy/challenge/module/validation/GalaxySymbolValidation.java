package br.com.thoughtworks.merchant.galaxy.challenge.module.validation;


/**
 *
 * This class  represent the validation galaxy symbol numeral
 */
public interface GalaxySymbolValidation {

    /**
     * <p>This method validates a given galaxy input number<br>
     *
     * @param inputGalaxySymbol
     *
     * @return 0|1
     */
     int validation(String inputGalaxySymbol);

}
