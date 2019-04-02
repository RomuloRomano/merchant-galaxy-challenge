package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;

import java.util.Stack;

public class DefaultGalaxyHowManyQuestionStrategy extends AbstractGalaxyProcessQuestionStrategy implements GalaxyProcessQuestionStrategy{



    /**
     * This method  will processing the line start with hom many.
     * @param inputLine
     */
    public void processQuestion(String inputLine) {


        try
        {
            //Remove the unwanted words like "is" and "?"
            String formatted = inputLine.split("(\\sis\\s)")[1];

            formatted = formatted.replace("?","").trim();

            // search for all numerals for their values to compute the result
            String[] keys = formatted.split("\\s");

            boolean found = false;
            String galaxySymbol = "";
            String outputResult = null;
            Stack<Float> cvalues = new Stack<Float>();

            for(String key : keys)
            {
                found = false;

                String galaxySymbolValue = GalaxyProcessQuestionHelper.getConstantAssignments().get(key);
                if(galaxySymbolValue!=null)
                {
                    galaxySymbol += galaxySymbolValue;
                    found = true;
                }

                String computedValue = GalaxyProcessQuestionHelper.getComputedLiterals().get(key);
                if(!found && computedValue!=null)
                {
                    cvalues.push(Float.parseFloat(computedValue));
                    found = true;
                }

                if(!found)
                {
                    outputResult = this.getGalaxyTranslateMessageHelper().getMessage(GalaxyQuestionReturnCode.NO_IDEA);
                    break;
                }
            }

            if(found)
            {
                float res=1;
                for(int i =0;i<cvalues.size();i++)
                    res *= cvalues.get(i);

                int finalres= (int) res;
                if(galaxySymbol.length()>0)
                    finalres = (int)(Integer.parseInt(getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(galaxySymbol))*res);
                outputResult = formatted +" is "+ finalres +" Credits";
            }

            GalaxyProcessQuestionHelper.getOutput().add(outputResult);

        }
        catch(Exception e)
        {
            this.getGalaxyTranslateMessageHelper().displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());
        }

    }
}
