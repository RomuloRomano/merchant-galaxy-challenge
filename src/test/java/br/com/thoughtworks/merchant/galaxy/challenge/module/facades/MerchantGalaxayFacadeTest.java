package br.com.thoughtworks.merchant.galaxy.challenge.module.facades;

import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.MerchantGalaxyFacadeBuilder;
import org.junit.Test;

import java.util.Map;

public class MerchantGalaxayFacadeTest {


    /**
     * Test load galaxy symbols
     */
    @Test
    public void loadGalaxySymbolFacadeTest(){
         Map<String, Integer > mapGalaxySymbol = MerchantGalaxyFacadeBuilder.builderMerchantGalaxyFacade().getLoadMerchantGalaxySymbols();
        for(String  key: mapGalaxySymbol.keySet()){
            System.out.println( "Load Symbol : (" + key  + "," + mapGalaxySymbol.get(key) + ")");
        }
    }
}
