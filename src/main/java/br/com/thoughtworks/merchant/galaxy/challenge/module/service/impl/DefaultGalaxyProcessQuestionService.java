package br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl;


import br.com.thoughtworks.merchant.galaxy.challenge.module.application.GalaxyQuestionConversation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.application.GalaxyTranslateMessage;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.DefaultGalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.GalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionType;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyProcessQuestionService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxySymbolValidation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxySymbolValidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class represent the service that wil be used to process all the quistion in the application
 *
 */
public class DefaultGalaxyProcessQuestionService implements GalaxyProcessQuestionService {

    private Scanner scanner;
    private GalaxyQuestionConversation  galaxyQuestionConversation;
    private GalaxyQuestionReturnCode questionReturnCode;
    private GalaxySymbolValidation galaxySymbolValidation;
    private GalaxySymbolConvert galaxySymbolConvert;
    private GalaxyTranslateMessage galaxyTranslateMessage;



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
        this.galaxyQuestionConversation = new GalaxyQuestionConversation();
        this.constantAssignments = new HashMap<String, String>();
        this.computedLiterals = new  HashMap<String, String>();
        this.output = new ArrayList<String>();
        this.galaxyTranslateMessage = new GalaxyTranslateMessage();

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
                case NO_IDEA :  this.output.add(this.galaxyTranslateMessage.getMessage(error));break;

                default : this.galaxyTranslateMessage.displayMessage(error);
            }

            count++;
        }

        switch(count)
        {
            case 0: error = GalaxyQuestionReturnCode.NO_INPUT;
                this.galaxyTranslateMessage.displayMessage(error);
                break;

            default :
        }

        return this.output;

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

        GalaxyQuestionType lineType = this.galaxyQuestionConversation.getQuestionType(line);

        switch(lineType)
        {
            case ASSIGNED : 		 processAssignmentLine(line);
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
     * <p>This method process the assignment line<br>
     * It extracts the constant roman literal from input string and adds it constantAssignments hash map
     * <p>
     * @param line
     * @throws ArrayIndexOutOfBoundsException
     */
    private void processAssignmentLine(String line)
    {
        //Since the assignment line is like "glob is I"
        //we have to break the line based on space
        //The first part i.e splited[0] is identifier and second part is i.e splited[2] is the value
        String[] splited = line.trim().split("\\s+");

        //Since it is assignment line the first String will be constantIdentifier
        // and the last will be its roman value;
        try
        {
            //Add identifier and its value to the map
            System.out.println(splited[0] + " " + splited[2] );
            constantAssignments.put(splited[0], splited[2]);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            this.galaxyTranslateMessage.displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
             System.out.println(e.getMessage());
        }
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
        try
        {
            //Break the how much question line based on "is" keyword
            // the second part will contain the identifiers whooose values are to determined

            String formatted = line.split("\\sis\\s")[1].trim();

            //Remove the uestion mark from the string
            formatted = formatted.replace("?","").trim();

            //Now since the string will contain only identifiers,break them into words by splitting through space
            String keys[] = formatted.split("\\s+");


            String romanResult="";
            String completeResult = null;
            boolean errorOccured = false;

            for(String key : keys)
            {
                //For each identifier gets its value
                String romanValue = constantAssignments.get(key);
                if(romanValue==null)
                {
                    // This means that user has entered something thats not in the hash map
                    completeResult = this.galaxyTranslateMessage.getMessage(GalaxyQuestionReturnCode.NO_IDEA);
                    errorOccured = true;
                    break;
                }
                romanResult += romanValue;
            }

            if(!errorOccured)
            {
                //Utility.println(romanResult.length()+"");
                romanResult = getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(romanResult);
                completeResult = formatted+" is "+romanResult;
            }

            output.add(completeResult);

        }
        catch(Exception e)
        {
            this.galaxyTranslateMessage.displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());

        }
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
        try
        {
            //Remove the unwanted words like "is" and "credits"
            String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)","").trim();

            //Split the remaining based on space
            String[] keys = formatted.split("\\s");

            //concatenate all keys to form roman number except the second last and last one. because the second last one is to be computed.
            // The last one is the value itself
            // get the value for that roman number

            String toBeComputed = keys[keys.length-2];
            float value = Float.parseFloat(keys[keys.length-1]);

            //concatenate remaining initial strings


            String roman="";

            for(int i=0;i<keys.length-2;i++)
            {
                roman += constantAssignments.get(keys[i]);
            }

            int romanNumber = Integer.parseInt(galaxySymbolConvert.convertGalaxySymbolNumberToArabic(roman));
            float credit = (float)(value/romanNumber);


            computedLiterals.put(toBeComputed, credit+"");
        }
        catch(Exception e)
        {

            this.galaxyTranslateMessage.displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());

        }
    }





    /**
     * This will calculate the answer for how many credits question.
     * @param line
     */
    private void processHowManyCreditsQuestion(String line) {

        try
        {
            //Remove the unwanted words like "is" and "?"
            String formatted = line.split("(\\sis\\s)")[1];

            formatted = formatted.replace("?","").trim();

            // search for all numerals for their values to compute the result
            String[] keys = formatted.split("\\s");

            boolean found = false;
            String roman = "";
            String outputResult = null;
            Stack<Float> cvalues = new Stack<Float>();

            for(String key : keys)
            {
                found = false;

                String romanValue = constantAssignments.get(key);
                if(romanValue!=null)
                {
                    roman += romanValue;
                    found = true;
                }

                String computedValue = computedLiterals.get(key);
                if(!found && computedValue!=null)
                {
                    cvalues.push(Float.parseFloat(computedValue));
                    found = true;
                }

                if(!found)
                {
                    outputResult = this.galaxyTranslateMessage.getMessage(GalaxyQuestionReturnCode.NO_IDEA);
                    break;
                }
            }

            if(found)
            {
                float res=1;
                for(int i =0;i<cvalues.size();i++)
                    res *= cvalues.get(i);

                int finalres= (int) res;
                if(roman.length()>0)
                    finalres = (int)(Integer.parseInt(getGalaxySymbolConvert().convertGalaxySymbolNumberToArabic(roman))*res);
                outputResult = formatted +" is "+ finalres +" Credits";
            }

            this.output.add(outputResult);

        }
        catch(Exception e)
        {
            this.galaxyTranslateMessage.displayMessage(GalaxyQuestionReturnCode.INCORRECT_QUESTION_LINE_TYPE);
            System.out.println(e.getMessage());
        }

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
