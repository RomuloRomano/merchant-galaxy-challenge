package br.com.thoughtworks.merchant.galaxy.challenge.module.service;

import java.util.Map;
import java.util.Set;

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


    /**
     * Load List of  characters that we can repeat three times
     *
     * @return List
     */
    Set<Character> loadRepeatedCharactersThreeTimes();

    /**
     * Load List of  characters that can never  repeated
     *
     * @return List
     */
     Set<Character> loadSymbolsCanNeverRepeated();

    /**
     * Load List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
     Set<Character> loadSymbolsCanBeSubtractedFromXV();

    /**
     * Load List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    Set<Character> loadSymbolsCanBeSubtractedFromLC();

    /**
     * Load List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
     Set<Character> loadSymbolsCanBeSubtractedFromDM();


    /**
     * Load List of  characters that can never  repeated
     *
     * @return List
     */
    Set<Character> loadSymbolsCanNeverBeSubtracted();


    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    Set<Character> loadSymbolICanBeSubtractedFromXV();


    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    Set<Character> loadSymbolXVFromSubtracted();

}

