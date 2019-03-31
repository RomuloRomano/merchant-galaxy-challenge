package br.com.thoughtworks.merchant.galaxy.challenge.module.convert;

import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyLoadSymbolService;

import java.util.Map;

public class DefaultConvertGalaxySymbol  implements  ConvertGalaxySymbol{

    /**
     * Galaxy Load Symbol Service
     */
    private GalaxyLoadSymbolService galaxyLoadSymbolService;


    public Integer convertSymbol(String symbol) {

        Map<String, Integer>  mapGalaxySymbols = getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();
        if(symbol == null || "".equals(symbol)){
            return Integer.valueOf(0);
        }
        return mapGalaxySymbols.get(symbol);
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
