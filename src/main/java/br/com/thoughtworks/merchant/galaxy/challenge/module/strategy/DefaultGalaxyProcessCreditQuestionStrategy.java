package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;


import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.DefaultGalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.GalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;

/**
 * This concrete class will be used to processing credit question in the helper
 */
public class DefaultGalaxyProcessCreditQuestionStrategy extends AbstractGalaxyProcessQuestionStrategy implements  GalaxyProcessQuestionStrategy{


    /**
     * Convert Galaxy Symbol
     */
    private GalaxySymbolConvert galaxySymbolConvert;



    public void processQuestion(String inputLine) {

        try
        {
            //Remove the unwanted words like "is" and "credits"
            String formatted = inputLine.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();

            //Split the remaining based on space
            String[] keys = formatted.split("\\s");

            //concatenate all keys to form roman number except the second last and last one. because the second last one is to be computed.
            // The last one is the value itself
            // get the value for that roman number

            String toBeComputed = keys[keys.length-2];
            float value = Float.parseFloat(keys[keys.length-1]);

            //concatenate remaining initial strings


            String galaxySymbol="";

            for(int i=0;i<keys.length-2;i++)
            {
                galaxySymbol += GalaxyProcessQuestionHelper.getConstantAssignments().get(keys[i]);
            }

            int galaxyNumer = Integer.parseInt(getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(galaxySymbol));
            float credit = (float)(value/galaxyNumer);


            GalaxyProcessQuestionHelper.getComputedLiterals().put(toBeComputed, credit+"");
        }
        catch(Exception e)
        {

            this.getGalaxyTranslateMessageHelper().displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());

        }

    }

    @Override
    public GalaxySymbolConvert getGalaxySymbolConvert() {
        if(galaxySymbolConvert == null){
            galaxySymbolConvert = new DefaultGalaxySymbolConvert();
        }
        return galaxySymbolConvert;
    }
}
