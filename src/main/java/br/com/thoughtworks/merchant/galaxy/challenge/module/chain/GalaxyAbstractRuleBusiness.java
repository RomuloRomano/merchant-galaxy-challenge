package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyLoadSymbolService;

/**
 *
 * Class base for Galaxy Business Rule
 */
public class GalaxyAbstractRuleBusiness {


    /**
     * Galaxy Load Symbol Service
     */
    private GalaxyLoadSymbolService galaxyLoadSymbolService;



    public GalaxyAbstractRuleBusiness() {

    }

    /**
     * Inject the Galaxy Load Symbols. In the future we can  user an better  like a spring solution
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
