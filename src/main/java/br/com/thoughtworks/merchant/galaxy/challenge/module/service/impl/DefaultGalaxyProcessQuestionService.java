package br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl;


import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyQuestionConversationHelper;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyTranslateMessageHelper;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.DefaultGalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.GalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionType;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyProcessQuestionService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.strategy.*;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxySymbolValidation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxySymbolValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class represent the service that wil be used to process all the quistion in the helper
 *
 */
public class DefaultGalaxyProcessQuestionService implements GalaxyProcessQuestionService {

    private Scanner scanner;
    private GalaxyQuestionConversationHelper galaxyQuestionConversationHelper;
    private GalaxyQuestionReturnCode questionReturnCode;
    private GalaxySymbolValidation galaxySymbolValidation;
    private GalaxySymbolConvert galaxySymbolConvert;
    private GalaxyTranslateMessageHelper galaxyTranslateMessageHelper;


    private static  GalaxyProcessQuestionHelper helper = new GalaxyProcessQuestionHelper();

    /**
     * Strategy class to processing all question
     */

    private GalaxyProcessQuestionStrategy galaxyProcessQuestionStrategy;



    /**
     * This is the hash map that will contain the value for each identifier
     */
    private HashMap<String, String> constantAssignments;

    /**
     * This is the hash map for storing the value of the calculated literal
     */
    private HashMap<String, String> computedLiterals;

    /**
     * <p>This variable of ArrayList type that will contain the answers for the questions asked in input from console.<br>
     * Read() method will return this object which in turn can be used to display the results</p>
     */
    private ArrayList<String> output;


    public DefaultGalaxyProcessQuestionService() {

        this.scanner = new Scanner(System.in);
        this.galaxyQuestionConversationHelper = new GalaxyQuestionConversationHelper();
        this.constantAssignments = new HashMap<String, String>();
        this.computedLiterals = new  HashMap<String, String>();
        this.output = new ArrayList<String>();
        this.galaxyTranslateMessageHelper = new GalaxyTranslateMessageHelper();

    }


    /**
     * <p>This method reads the paragraph from the input console.<br>
     * The input sequence can be terminated by a blank new line.<br>
     * Each input entered will be processed same time and if it contains any formatting error message will be shown immediately<br>
     * <b>Ex:</b> saket is 78 , error message : <i>Input format is wrong ! input discarded</i>
     * </p>
     * @return output ArrayList<String>
     * <p>Use this returned ArrayList<String> object to print the results for the question asked in the input.
     */
    public ArrayList<String> fulfillmentProcessGalaxyQuestion()
    {
        String line;
        int count=0;
        GalaxyQuestionReturnCode error = null;


        while(this.scanner.hasNextLine() && (line = this.scanner.nextLine()).length()>0 )
        {
            error = validate(line);

            switch(error)
            {
                case NO_IDEA :
                    GalaxyProcessQuestionHelper.getOutput().add(this.galaxyTranslateMessageHelper.getMessage(error));break;

                default :
                        this.galaxyTranslateMessageHelper.displayMessage(error);
            }

            count++;
        }

        switch(count)
        {
            case 0: error = GalaxyQuestionReturnCode.NO_INPUT;
                this.galaxyTranslateMessageHelper.displayMessage(error);
                break;

            default :
        }

        return GalaxyProcessQuestionHelper.getOutput();

    }

    /**
     * <p>This method first determines the type of line<br>
     * Based on the type of line it process each input line
     * </p>
     * @param line
     * @return error Errorcodes

     */

    private GalaxyQuestionReturnCode validate(String line)
    {

        GalaxyQuestionReturnCode error = GalaxyQuestionReturnCode.SUCCESS_OK;
        GalaxyQuestionType lineType = this.galaxyQuestionConversationHelper.getQuestionType(line);

        switch(lineType)
        {
            case ASSIGNED : 		 processAssignment(line);
                break;

            case CREDITS :			 processCreditsLine(line);
                break;

            case QUESTION_HOW_MUCH : processHowMuchQuestion(line);
                break;

            case QUESTION_HOW_MANY : processHowManyCreditsQuestion(line);
                break;

            default : error = GalaxyQuestionReturnCode.NO_IDEA; break;
        }

        return error;
    }





    /**
     * This method process the assignment line
     * It extracts the constant roman literal from input string and adds it constantAssignments hash map
     *
     * @param line
     * @throws ArrayIndexOutOfBoundsException
     */
    private void processAssignment(String line)
    {
        galaxyProcessQuestionStrategy = new DefaultGalaxyProcessAssignmentQuestionStrategy();
        galaxyProcessQuestionStrategy.processQuestion(line);


    }
    /**
     * <p>This method process the line for type how_much question<br>
     * It extracts all the constant identifiers from line and calculates the value from the constantAssignments hashMap<br>
     * It will generate an error
     * @param line
     * @throws Exception
     */
    private void processHowMuchQuestion(String line)
    {
        galaxyProcessQuestionStrategy = new DafaultGalaxyProcessHowMuchQuestionStrategy();
        galaxyProcessQuestionStrategy.processQuestion(line);

    }


    /**
     * <p>This method process the line for credit computation for line type CREDITS defined in ConversationLine.type<br>
     * It extracts the constant identifier from line and compute the variable identifier<br>
     * The variable identifier is assumed to be closest to 'is' keyword in the line
     * </p>
     * @param line String
     */

    private void processCreditsLine(String line)
    {
        galaxyProcessQuestionStrategy = new DefaultGalaxyProcessCreditQuestionStrategy();
        galaxyProcessQuestionStrategy.processQuestion(line);
    }
    /**
     * This will calculate the answer for how many credits question.
     * @param line
     */
    private void processHowManyCreditsQuestion(String line) {
        galaxyProcessQuestionStrategy = new DefaultGalaxyHowManyQuestionStrategy();
        galaxyProcessQuestionStrategy.processQuestion(line);

    }

    public GalaxySymbolValidation getGalaxySymbolValidation() {
        if(galaxySymbolValidation == null){
            galaxySymbolValidation = new DefaultGalaxySymbolValidation();
        }
        return galaxySymbolValidation;
    }

    public GalaxySymbolConvert getGalaxySymbolConvert() {
        if(galaxySymbolConvert == null){
            galaxySymbolConvert = new DefaultGalaxySymbolConvert();
        }

        return galaxySymbolConvert;
    }
}
