package br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl;


import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxySymbol;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 *
 */
public class DefaultGalaxyLoadSymbolService  implements GalaxyLoadSymbolService {


    public Map<String, Integer>  loadMerchantGalaxySymbols(){
        return  createMerchantGalaxySymbols();
    }


    /**
     *
     * Map the Merchant Galaxy symbols from Galaxy Symbols Object
     * @return
     */
    public Map<String, Integer> createMerchantGalaxySymbols(){
        Map<String, Integer> mapMerchantGalaxySymbol = new HashMap<String, Integer>();
        for(GalaxySymbol galaxySymbol : GalaxySymbol.values()){
            mapMerchantGalaxySymbol.put(galaxySymbol.getName() , galaxySymbol.getValue());
        }
        return mapMerchantGalaxySymbol;
    }


    /**
     * Return List of  characters that we can repeat three times
     *
     * @return List
      */
    public  Set<Character> loadRepeatedCharactersThreeTimes(){
        Set<Character>  repeatedCharactersThreeTimes = new HashSet<Character>();
        repeatedCharactersThreeTimes.add(GalaxySymbol.I.getName().charAt(0));
        repeatedCharactersThreeTimes.add(GalaxySymbol.X.getName().charAt(0));
        repeatedCharactersThreeTimes.add(GalaxySymbol.C.getName().charAt(0));
        return   repeatedCharactersThreeTimes;
    }


    /**
     * Return List of  characters that can never  repeated
     *
     * @return List
     */
    public  Set<Character> loadSymbolsCanNeverRepeated(){
        Set<Character>  symbolsCanNeverRepeated = new HashSet<Character>();
        symbolsCanNeverRepeated.add(GalaxySymbol.D.getName().charAt(0));
        symbolsCanNeverRepeated.add(GalaxySymbol.L.getName().charAt(0));
        symbolsCanNeverRepeated.add(GalaxySymbol.V.getName().charAt(0));
        return   symbolsCanNeverRepeated;
    }

    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    public  Set<Character> loadSymbolsCanBeSubtractedFromXV(){
        Set<Character>  symbolsCanBeSubtracted = new HashSet<Character>();
        symbolsCanBeSubtracted.add(GalaxySymbol.I.getName().charAt(0));
        return   symbolsCanBeSubtracted;
    }

    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    public  Set<Character> loadSymbolICanBeSubtractedFromXV(){
        Set<Character>  symbolsCanBeSubtracted = new HashSet<Character>();
        symbolsCanBeSubtracted.add(GalaxySymbol.I.getName().charAt(0));
        return   symbolsCanBeSubtracted;
    }

    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    public  Set<Character> loadSymbolXVFromSubtracted(){
        Set<Character>  symbolsCanBeSubtracted = new HashSet<Character>();
        symbolsCanBeSubtracted.add(GalaxySymbol.V.getName().charAt(0));
        symbolsCanBeSubtracted.add(GalaxySymbol.X.getName().charAt(0));

        return   symbolsCanBeSubtracted;
    }



    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    public  Set<Character> loadSymbolsCanBeSubtractedFromLC(){
        Set<Character>  symbolsCanBeSubtracted = new HashSet<Character>();
        symbolsCanBeSubtracted.add(GalaxySymbol.X.getName().charAt(0));
        return   symbolsCanBeSubtracted;
    }


    /**
     * Return List of  characters that can be subtracted   from another symbols
     *
     * @return List
     */
    public  Set<Character> loadSymbolsCanBeSubtractedFromDM(){
        Set<Character>  symbolsCanBeSubtracted = new HashSet<Character>();
        symbolsCanBeSubtracted.add(GalaxySymbol.C.getName().charAt(0));
        return   symbolsCanBeSubtracted;
    }




    /**
     * Return List of  characters that can never  repeated
     *
     * @return List
     */
    public  Set<Character> loadSymbolsCanNeverBeSubtracted(){
        Set<Character>  symbolsCanNeverBeSubtracted = new HashSet<Character>();
        symbolsCanNeverBeSubtracted.add(GalaxySymbol.V.getName().charAt(0));
        symbolsCanNeverBeSubtracted.add(GalaxySymbol.L.getName().charAt(0));
        symbolsCanNeverBeSubtracted.add(GalaxySymbol.D.getName().charAt(0));
        return   symbolsCanNeverBeSubtracted;
    }







}
