package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;


import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyLoadSymbolService;

import java.util.Map;

/**
 * This class implement the defaul chain business rules
 * First Rule is adding value  and depends  on the position of number  the second rule is subtract
 */
public class DefaultGalaxyAddingSubtractSymbol  implements GalaxyChainBusinessRule {



    /**
     * Galaxy Load Symbol Service
     */
    private GalaxyLoadSymbolService galaxyLoadSymbolService;


    /**
     * This method   will processing the follow  business rule:
     *
     *     Rule 01 - Adding Numerals generally in order of values
     *     Rule 02 - Subtracted Numerals when smaller values precede large values
     *     Rule 10 - Only one-smaller symbol may be subtracted from any large-value
     *
     * @param inputSymbol
     *
     * @return Value
     */
    public Integer apply(String inputSymbol) {

        //load all the galaxy symbol
        Map<String, Integer> mapGalaxySymbols = getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();

        int accumulator = 0;
        int lastNeighborOfLeft = 0;

        for(int i  = inputSymbol.length() - 1;  i >= 0; i--){
            //get the integer value reference the current value
            int current = mapGalaxySymbols.get(String.valueOf(inputSymbol.charAt(i)));

            //if the  right value is smaller we will multiply for -1 to became the number negative
            int multiply = 1;
            if(current < lastNeighborOfLeft) multiply = -1;

            //update the accumator
            accumulator += mapGalaxySymbols.get(String.valueOf(inputSymbol.charAt(i))) * multiply;

            //update the neighbor with current value
            lastNeighborOfLeft = current;
        }
        return Integer.valueOf(accumulator);
    }



    /**
     * Inject the Galaxy Load Symbols. In the future we can  user a better spring sulution
     * in order to inject and manage all of the beans service in the application
     * @return
     */

    public GalaxyLoadSymbolService getGalaxyLoadSymbolService() {
        if(galaxyLoadSymbolService == null){
            galaxyLoadSymbolService = new DefaultGalaxyLoadSymbolService();
        }
        return galaxyLoadSymbolService;
    }
}


