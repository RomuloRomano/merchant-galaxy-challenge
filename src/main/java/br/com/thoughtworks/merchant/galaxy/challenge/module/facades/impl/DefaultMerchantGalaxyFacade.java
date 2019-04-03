package br.com.thoughtworks.merchant.galaxy.challenge.module.facades.impl;

import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.MerchantGalaxayFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyProcessQuestionService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyProcessQuestionService;

import java.util.ArrayList;
import java.util.Map;

/**
 * Default Merchant Galaxy Facade to be use for helper.
 * The goals to use this pattern is that we  never can programing for concrete implementation just for one interface.
 *
 */
public class DefaultMerchantGalaxyFacade implements MerchantGalaxayFacade {


    /**
     * Galaxy Load Symbol Service
     */
    private GalaxyLoadSymbolService  galaxyLoadSymbolService;

    /**
     * Process Question service
     */
    private GalaxyProcessQuestionService galaxyProcessQuestionService;


    /**
     *
     * @param input
     */
    public void  translateSymbolValue(String[] input){

   }


    public ArrayList<String> fulfillmentProcessGalaxyQuestion() {
        return getGalaxyProcessQuestionService().fulfillmentProcessGalaxyQuestion();
    }

    /**
     * Load  Merchant Galaxy Symbols
     * @return Map
     */

   public Map<String, Integer> getLoadMerchantGalaxySymbols(){
        return  getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();
   }


    /**
     * Inject the Galaxy Load Symbols. In the future we can  user a better spring sulution
     * in order to inject and manage all of the beans service in the helper
     * @return
     */

    public GalaxyLoadSymbolService getGalaxyLoadSymbolService() {
        if(galaxyLoadSymbolService == null){
            galaxyLoadSymbolService = new DefaultGalaxyLoadSymbolService();
        }
        return galaxyLoadSymbolService;
    }

    public GalaxyProcessQuestionService getGalaxyProcessQuestionService() {
        if(galaxyProcessQuestionService == null){
            galaxyProcessQuestionService = new DefaultGalaxyProcessQuestionService();
        }
        return galaxyProcessQuestionService;
    }
}
