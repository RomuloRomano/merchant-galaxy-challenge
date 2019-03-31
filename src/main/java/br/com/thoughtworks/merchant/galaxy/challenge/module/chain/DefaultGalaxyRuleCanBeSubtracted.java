package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import br.com.thoughtworks.merchant.galaxy.challenge.module.entity.GalaxySymbol;

import java.util.Map;
import java.util.Set;

/**
 * This class will processing the business rule   what symbols can be subtracted
 *
 */
public class DefaultGalaxyRuleCanBeSubtracted extends  GalaxyAbstractRuleBusiness implements  GalaxyChainBusinessRule {



    /**
     * This method   will processing the follow  business rule:
     *
     *      Rule 06 - Symbol "I" can be subtracted from ("V", "X")
     *      Rule 07 - Symbol "X" can be subtracted from ("L", "C") only
     *      Rule 08 - Symbol "C" can be subtracted from ("D", "M")
     *
     * @param inputSymbolNumeral
     *
     * @return Value
     */
    public Integer apply(String inputSymbolNumeral) {

        //load symbols can be subtracted  from anothers
        Set<Character> symbolsCanBeSubtractedFromXV  =  getGalaxyLoadSymbolService().loadSymbolsCanBeSubtractedFromXV();
        Set<Character> symbolsCanBeSubtractedFromLC  =  getGalaxyLoadSymbolService().loadSymbolsCanBeSubtractedFromLC();
        Set<Character> symbolsCanBeSubtractedFromDm  =  getGalaxyLoadSymbolService().loadSymbolsCanBeSubtractedFromDM();

        Set<Character> loadSymbolICanBeSubtractedFromXV = getGalaxyLoadSymbolService().loadSymbolICanBeSubtractedFromXV();
        Set<Character> loadSymbolXVFromSubtracted    = getGalaxyLoadSymbolService().loadSymbolXVFromSubtracted();



        //load all the galaxy symbol
        Map<String, Integer> mapGalaxySymbols = getGalaxyLoadSymbolService().loadMerchantGalaxySymbols();

        //convert inputSymbols numeral to character array

        int characterRepeatCount = 1;
        int result = 0;
        int previousCharacterOrdinal = Integer.MAX_VALUE;
        int currentCharacterOrdinal;
        int previousGalaxyNumeralValue = 0;






        char[]  charSymbolsNumeralArray = inputSymbolNumeral.toCharArray();
        char previousCharacter = ' ';


        for(int i = 0; i < charSymbolsNumeralArray.length; i++){
            char currentCharacter= charSymbolsNumeralArray[i];
            int  currentGalaxyNumeralValue = mapGalaxySymbols.get(String.valueOf(currentCharacter)).intValue();
            char nextCharacter = charSymbolsNumeralArray[i+1];


            if( previousCharacter != ' '){
                previousCharacterOrdinal = GalaxySymbol.valueOf(String.valueOf(previousCharacter)).ordinal();
                previousGalaxyNumeralValue  = mapGalaxySymbols.get(String.valueOf(previousCharacter));


            }
            currentCharacterOrdinal  = GalaxySymbol.valueOf(String.valueOf(currentCharacter)).ordinal();

            if(loadSymbolXVFromSubtracted.contains(previousCharacter) && loadSymbolICanBeSubtractedFromXV.contains(currentCharacter)){

                if( currentGalaxyNumeralValue < previousGalaxyNumeralValue ){
                   result +=  (currentGalaxyNumeralValue - previousGalaxyNumeralValue);
                }else {
                 result += currentGalaxyNumeralValue;
                }

            }else if(previousCharacterOrdinal  < currentCharacterOrdinal && !loadSymbolXVFromSubtracted.contains(previousCharacter)){
                    result = -1;
            }else  if(loadSymbolICanBeSubtractedFromXV.contains(previousCharacter)  || loadSymbolXVFromSubtracted.contains(currentCharacter) ){
                continue;
            }else{
                result += currentGalaxyNumeralValue;
            }



            previousCharacter = currentCharacter;

            if(result == -1){
                break;
            }
        }

        return Integer.valueOf(result);
    }
}
