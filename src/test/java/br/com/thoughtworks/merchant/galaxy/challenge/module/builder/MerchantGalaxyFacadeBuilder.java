package br.com.thoughtworks.merchant.galaxy.challenge.module.builder;

import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.MerchantGalaxayFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.impl.DefaultMerchantGalaxyFacade;

/**
 * Builder Mechant Galaxy Facade  to make a simple test.
 */
public class MerchantGalaxyFacadeBuilder {


    /**
     * Create instance Merchant Galaxy  Facade
     * @return
     */
    public static MerchantGalaxayFacade  builderMerchantGalaxyFacade(){
        return   new DefaultMerchantGalaxyFacade();
    }


}
