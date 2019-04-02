package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;


/**
 * This is a concrete class to processing the question line  Assignment
 * .
 * We can change this implementation for another in the future
 *
 */
public class DefaultGalaxyProcessAssignmentQuestionStrategy extends AbstractGalaxyProcessQuestionStrategy implements GalaxyProcessQuestionStrategy {



    /**
     * This method processing the input line assignment
     *
     * @param inputLine
     */
    public void processQuestion(String inputLine) {

        //Since the assignment line is like "glob is I"
        //we have to break the line based on space
        //The first part i.e splited[0] is identifier and second part is i.e splited[2] is the value
        String[] splited = inputLine.trim().split("\\s+");

        //Since it is assignment line the first String will be constantIdentifier
        // and the last will be its roman value;
        try
        {
            //Add identifier and its value to the map
            GalaxyProcessQuestionHelper.getConstantAssignments().put(splited[0], splited[2]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            this.getGalaxyTranslateMessageHelper().displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());
        }

    }
}
