package br.com.thoughtworks.merchant.galaxy.challenge.module.convert;

import br.com.thoughtworks.merchant.galaxy.challenge.module.application.GalaxyTranslateMessage;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyLoadSymbolService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxySymbolValidation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxySymbolValidation;

import java.util.Map;

public class DefaultGalaxySymbolConvert implements GalaxySymbolConvert {

    /**
     * Galaxy Load Symbol Service
     */
    private GalaxyLoadSymbolService galaxyLoadSymbolService;


    private GalaxyQuestionReturnCode  galaxyQuestionReturnCode;

    private GalaxySymbolValidation galaxySymbolValidation;

    private GalaxyTranslateMessage  galaxyTranslateMessage;




    public Integer convertSymbol(String symbol) {

        Map<String, Integer>  mapGalaxySymbols = getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();
        if(symbol == null || "".equals(symbol)){
            return Integer.valueOf(0);
        }
        return mapGalaxySymbols.get(symbol);
    }


    /**
     * Converts the valid galaxy number to arabic number
     * @param symbol
     * @return String
     */
    public   String convert(String symbol)
    {
        int decimal = 0;
        int lastNumber = 0;

        for(int i=symbol.length()-1;i>=0;i--)
        {
            char character = symbol.charAt(i);
            decimal = checkGalaxySymbol(convertSymbol(String.valueOf(character)), lastNumber, decimal);
            lastNumber = convertSymbol(String.valueOf(character));
        }

        return decimal+"";

    }

    private  int checkGalaxySymbol(int TotalDecimal, int LastGalaxySymbolLetter, int LastDecimal){

        if (LastGalaxySymbolLetter > TotalDecimal) {
            return LastDecimal - TotalDecimal;
        } else {
            return LastDecimal + TotalDecimal;
        }

    }


    /**
     * Convert galaxy symbol number to arabic number
     *
     * @param galaxySymbolNumer
     *
     * @return
     */
    public  String convertGalaxySymbolNumberToArabic(String galaxySymbolNumer)
    {
        String result="";


        switch( getGalaxySymbolValidation().validation(galaxySymbolNumer))
        {
            case 1 :  result = this.convert(galaxySymbolNumer);
                break;

            default : result = getGalaxyTranslateMessage().getMessage(GalaxyQuestionReturnCode.INVALID_GALAXY_STRING);
        }

        return result;
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

    public GalaxySymbolValidation getGalaxySymbolValidation() {
        if(galaxySymbolValidation == null){
            galaxySymbolValidation = new DefaultGalaxySymbolValidation();
        }
        return galaxySymbolValidation;
    }


    public GalaxyTranslateMessage getGalaxyTranslateMessage() {
        if(galaxyLoadSymbolService == null){
            galaxyTranslateMessage = new GalaxyTranslateMessage();
        }
        return galaxyTranslateMessage;
    }
}
