package br.com.thoughtworks.merchant.galaxy.challenge.module.convert;

/**
 * This class will  provide mechanism to convert a galaxy symbol to value
 *
 */
public interface GalaxySymbolConvert {


    /**
     * Convert a symbol to corresponding value
     * @param symbol
     * @return value
     */
     Integer convertSymbol(String symbol);

    /**
     *
     * Converts the valid galaxy number to arabic number
     *
     * @param symbol
     *
     * @return value
     */
    String convert(String symbol);


    /**
     * Convert galaxy symbol number to arabic number
     *
     * @param galaxySymbolNumer
     *
     * @return value
     */
    String convertGalaxySymbolNumberToArabic(String galaxySymbolNumer);

}
