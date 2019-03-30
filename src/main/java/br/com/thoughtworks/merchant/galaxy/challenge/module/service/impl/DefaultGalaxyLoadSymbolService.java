package br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl;


import br.com.thoughtworks.merchant.galaxy.challenge.module.entity.GalaxySymbol;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;

import java.util.HashMap;
import java.util.Map;

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


}
