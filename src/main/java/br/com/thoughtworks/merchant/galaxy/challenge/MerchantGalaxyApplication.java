package br.com.thoughtworks.merchant.galaxy.challenge;

import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.MerchantGalaxayFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.impl.DefaultMerchantGalaxyFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxyInputValiation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxyInputValiation;

public class MerchantGalaxyApplication {






    public static void main( String[] args )
    {
        System.out.println( "*******************Welcome to the Merchant's Guide Galaxy*******************");
        System.out.println();
        System.out.println( "*******************Please enter with the instruction for application*******************");

        GalaxyInputValiation  galaxyInputValiation = new DefaultGalaxyInputValiation();

        if(!galaxyInputValiation.validation(args)){
            System.out.println("Please provide  a instruction for application");
            System.exit(0);
        }

        MerchantGalaxayFacade merchantGalaxayFacade  = new DefaultMerchantGalaxyFacade();
        merchantGalaxayFacade.getLoadMerchantGalaxySymbols();


    }
}

