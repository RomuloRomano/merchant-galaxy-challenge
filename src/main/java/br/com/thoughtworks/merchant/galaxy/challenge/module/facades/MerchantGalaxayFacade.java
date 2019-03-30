package br.com.thoughtworks.merchant.galaxy.challenge.module.facades;


import java.util.Map;

/**
 * Interface base to serve with facade for application
 *
 */
public interface MerchantGalaxayFacade {



     void  translateSymbolValue(String[] input);

    /**
     * Return Map with Mechant Galaxy Symbols
     * @return
     */
    Map<String, Integer> getLoadMerchantGalaxySymbols();


}
