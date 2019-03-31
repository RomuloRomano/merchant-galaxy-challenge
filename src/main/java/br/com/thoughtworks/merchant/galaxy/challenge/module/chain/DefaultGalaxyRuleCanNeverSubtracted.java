package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import br.com.thoughtworks.merchant.galaxy.challenge.module.constants.MerchantGalaxyContants;
import br.com.thoughtworks.merchant.galaxy.challenge.module.entity.GalaxySymbol;

import java.util.Map;
import java.util.Set;

public class DefaultGalaxyRuleCanNeverSubtracted extends GalaxyAbstractRuleBusiness implements  GalaxyChainBusinessRule {



    /**
     * This method   will processing the follow  business rule:
     *
     *     Rule 09 - Symbols ("V", "L", "D") can never be subtracted
     *
     *
     * @param inputSymbolNumeral
     *
     * @return Value
     */
    public Integer apply(String inputSymbolNumeral) {

        //load symbols can never subtracted
        Set<Character> symbolsCanNeverSubtracted  =  getGalaxyLoadSymbolService().loadSymbolsCanNeverBeSubtracted();

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

            if(previousCharacterOrdinal  < currentCharacterOrdinal && !symbolsCanNeverSubtracted.contains(beforeChar)){

                int beforeGalaxySymbolNumralValue = mapGalaxySymbols.get(String.valueOf(beforeChar)).intValue();

                if(previousCharacterOrdinal + 2 >= currentCharacterOrdinal){

                    total += currentGalaxyNumeralValue  - ( 2 * beforeGalaxySymbolNumralValue );
                    characterRepeatCount = 1;
                }else {
                    total = -1;
                }

            }else if(previousCharacterOrdinal  < currentCharacterOrdinal && symbolsCanNeverSubtracted.contains(beforeChar)){

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

        return Integer.valueOf(total);
    }
}
