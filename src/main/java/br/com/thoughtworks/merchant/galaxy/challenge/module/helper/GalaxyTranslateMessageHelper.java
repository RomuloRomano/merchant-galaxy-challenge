package br.com.thoughtworks.merchant.galaxy.challenge.module.helper;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionReturnCode;

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
}
