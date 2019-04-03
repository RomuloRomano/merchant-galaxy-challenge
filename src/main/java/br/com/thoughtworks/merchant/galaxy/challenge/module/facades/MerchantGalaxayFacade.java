package br.com.thoughtworks.merchant.galaxy.challenge.module.facades;


import java.util.ArrayList;
import java.util.Map;

/**
 * Interface base to serve with facade for helper
 *
 */
public interface MerchantGalaxayFacade {



     void  translateSymbolValue(String[] input);

    /**
     * Return Map with Mechant Galaxy Symbols
     * @return
     */
    Map<String, Integer> getLoadMerchantGalaxySymbols();


    /**
     * Mehtod processing all the question that will ber anserwer
     * @return
     */
    ArrayList<String> fulfillmentProcessGalaxyQuestion();


}
