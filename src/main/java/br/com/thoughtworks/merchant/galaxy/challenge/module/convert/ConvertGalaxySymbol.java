package br.com.thoughtworks.merchant.galaxy.challenge.module.convert;

/**
 * This class will  provide mechanism to convert a galaxy symbol to value
 *
 */
public interface ConvertGalaxySymbol {


    /**
     * Convert a symbol to corresponding value
     * @param symbol
     * @return value
     */
     Integer convertSymbol(String symbol);

}
