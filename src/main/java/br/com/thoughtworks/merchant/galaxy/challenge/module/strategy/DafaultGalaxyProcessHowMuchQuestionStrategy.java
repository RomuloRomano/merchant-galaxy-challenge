package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;

/**
 *
 * This class implement the strategy to processing the question  start  with How much
 */

public class DafaultGalaxyProcessHowMuchQuestionStrategy extends AbstractGalaxyProcessQuestionStrategy implements   GalaxyProcessQuestionStrategy{



    /**
     * Method process the question in the helper
     *
     *
     * @param inputLine
     */
    public void processQuestion(String inputLine) {

        try
        {
            //Break the how much question line based on "is" keyword
            // the second part will contain the identifiers whooose values are to determined

            String formatted = inputLine.split("\\sis\\s")[1].trim();

            //Remove the uestion mark from the string
            formatted = formatted.replace("?","").trim();

            //Now since the string will contain only identifiers,break them into words by splitting through space
            String keys[] = formatted.split("\\s+");


            String galaxySymbolResult="";
            String completeResult = null;
            boolean errorOccured = false;

            for(String key : keys)
            {
                //For each identifier gets its value
                String galaxySymbolValue = GalaxyProcessQuestionHelper.getConstantAssignments().get(key);
                if(galaxySymbolValue==null)
                {
                    // This means that user has entered something thats not in the hash map
                    completeResult = this.getGalaxyTranslateMessageHelper().getMessage(GalaxyQuestionReturnCode.NO_IDEA);
                    errorOccured = true;
                    break;
                }
                galaxySymbolResult += galaxySymbolValue;
            }

            if(!errorOccured)
            {

                galaxySymbolResult = getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(galaxySymbolResult);
                completeResult = formatted+" is "+galaxySymbolResult;
            }

            GalaxyProcessQuestionHelper.getOutput().add(completeResult);

        }
        catch(Exception e)
        {
            this.getGalaxyTranslateMessageHelper().displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());

        }

    }
}
