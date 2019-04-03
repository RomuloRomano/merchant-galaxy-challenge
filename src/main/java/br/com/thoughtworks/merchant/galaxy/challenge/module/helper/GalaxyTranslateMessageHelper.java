package br.com.thoughtworks.merchant.galaxy.challenge.module.helper;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;

import java.util.ArrayList;

/**
 * This class  represent the translate message in the helper
 *
 */
public class GalaxyTranslateMessageHelper {


    public  void displayMessage(GalaxyQuestionReturnCode  messageCode){
        String message = getMessage(messageCode);
        if(message != null) System.out.println(message);
    }

    /**
     * This method returns the  message error
     *
     * @param error
     * @return
     */
    public String getMessage(GalaxyQuestionReturnCode error)
    {
        String message= null;

        switch(error)
        {
            case NO_INPUT : message = "No input was specified ! Program exited";
                break;
            case INVALID : message = "Input format is wrong ! input discarded";
                break;
            case INVALID_GALAXY_CHARACTER:_CHARACTER : message = "Illegal character specified in galaxy number ! input discarded";
                break;
            case INVALID_GALAXY_STRING:_STRING : message =  "wrong Galaxy number, voilated roman number format";
                break;
            case INCORRECT_QUESTION_LINE_TYPE:_TYPE : message =  "Exception caused during processing due to incorrect line type supplied";
                break;
            case NO_IDEA : message = "I have no idea what you are talking about";
                break;
            default : break;
        }
        return message;
    }


    public static  void printMessage(){
        System.out.println( "Welcome to GalaxyMerchant ! please provide input below and a blank new line to finish input");
        System.out.println();
        System.out.println("Please input something like as below:");
        System.out.println();
        System.out.println("glob is I");
        System.out.println("prok is V");
        System.out.println("pish is X");
        System.out.println("tegj is L");
        System.out.println("glob glob Silver is 34 Credits");
        System.out.println("glob prok Gold is 57800 Credits");
        System.out.println("pish pish Iron is 3910 Credits");
        System.out.println("how much is pish tegj glob glob ?");
        System.out.println();
        System.out.println("After enter with some information, Please press enter to continue.");

    }

    public static void printResult(ArrayList<String> output ){

        if(output != null && output.size() > 0){
            for(int i=0;i<output.size();i++)
            {
                System.out.println(output.get(i));
            }

        }

    }
}
