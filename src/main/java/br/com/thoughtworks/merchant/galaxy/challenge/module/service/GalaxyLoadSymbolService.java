package br.com.thoughtworks.merchant.galaxy.challenge.module.service;

import java.util.Map;

/**
 * Interface to load the Merchant Galaxy Symbols convention. In the future we can load this from another repository
 *
 */
public interface GalaxyLoadSymbolService {

    /**
     * Load the Merchant Galaxy Symbols
     * @return Map
     */
    Map<String, Integer> loadMerchantGalaxySymbols();
}
