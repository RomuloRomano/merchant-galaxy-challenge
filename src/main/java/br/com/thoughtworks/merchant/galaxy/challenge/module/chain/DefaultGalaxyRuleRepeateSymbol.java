package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import br.com.thoughtworks.merchant.galaxy.challenge.module.constants.MerchantGalaxyContants;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxySymbol;

import java.util.Map;
import java.util.Set;

/**
 * This class will processing the business rule  to check  the quantity of some characters are repeats
 *
 */
public class DefaultGalaxyRuleRepeateSymbol extends  GalaxyAbstractRuleBusiness implements   GalaxyChainBusinessRule{


    /**
     * This method   will processing the follow  business rule:
     *
     *     Rule 03 -  Repeat   symbols ("I", "X", "C") three times
     *     Rule 04 - Repeat symbols ("I","X","C") four time when  the third and fourth are separated by smaller number
     *
     * @param inputSymbolNumeral
     *
     * @return Value
     */
    public Integer apply(String inputSymbolNumeral){

        //load repeated symbols
        Set<Character>  repeatedCharactersThreeTimes =  getGalaxyLoadSymbolService().loadRepeatedCharactersThreeTimes();

        //load all the galaxy symbol
        Map<String, Integer> mapGalaxySymbols = getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();

        char[]  charSymbolsNumeralArray = inputSymbolNumeral.toCharArray();
        char  beforeChar = ' ';


        int characterRepeatCount = 1;
        int total = 0;
        int previousCharacterOrdinal = Integer.MAX_VALUE;
        int currentCharacterOrdinal;


        for(int i = 0; i < charSymbolsNumeralArray.length; i++){
            char currentCharacter= charSymbolsNumeralArray[i];

            int  currentGalaxyNumeralValue = mapGalaxySymbols.get(String.valueOf(currentCharacter)).intValue();

            if(beforeChar  != ' '){
                previousCharacterOrdinal = GalaxySymbol.valueOf(String.valueOf(beforeChar)).ordinal();

            }
            currentCharacterOrdinal  = GalaxySymbol.valueOf(String.valueOf(currentCharacter)).ordinal();

            if(currentCharacter == beforeChar && ++characterRepeatCount < MerchantGalaxyContants.MAX_VALUE_REPEATED_FOURTH_TIMES
                    && repeatedCharactersThreeTimes.contains(currentCharacter) ){
                total += currentGalaxyNumeralValue;
            }else if( characterRepeatCount > MerchantGalaxyContants.MAX_VALUE_REPEATED_THREE_TIMES){
                total = -1;

            }else if(currentCharacter == beforeChar && !repeatedCharactersThreeTimes.contains(currentCharacter)){
                total = -1;
            }else{
                characterRepeatCount =1;
                total += currentGalaxyNumeralValue;
            }

            beforeChar = currentCharacter;

            if(total == -1){
                break;
            }
        }

        return total;

    }





}
