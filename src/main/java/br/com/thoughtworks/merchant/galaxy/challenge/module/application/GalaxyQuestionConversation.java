package br.com.thoughtworks.merchant.galaxy.challenge.module.application;

import br.com.thoughtworks.merchant.galaxy.challenge.module.constants.MerchantGalaxyContants;
import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionType;

/**
 *
 * This represent the  question conversation
 */
public class GalaxyQuestionConversation {

    private GalaxyQuestionLine[] galaxyQuestionLine;

    public GalaxyQuestionConversation() {
        this.initializeQuestionLine();
    }


    /**
     *
     * Load all the Type question in the application
     */

    private void initializeQuestionLine(){
        this.galaxyQuestionLine = new GalaxyQuestionLine[MerchantGalaxyContants.MAX_VALUE_QUESTION_];
        this.galaxyQuestionLine[0] = new GalaxyQuestionLine(GalaxyQuestionType.ASSIGNED, MerchantGalaxyContants.REGEX_PATTERN_ASSINGGNMENT);
        this.galaxyQuestionLine[1] = new GalaxyQuestionLine(GalaxyQuestionType.CREDITS, MerchantGalaxyContants.REGEX_PATTERN_CREDITS);
        this.galaxyQuestionLine[2] = new GalaxyQuestionLine(GalaxyQuestionType.QUESTION_HOW_MUCH, MerchantGalaxyContants.REGEX_PETTERN_HOW_MUCH);
        this.galaxyQuestionLine[3] = new GalaxyQuestionLine(GalaxyQuestionType.QUESTION_HOW_MANY, MerchantGalaxyContants.REGEX_PATTERN_HOW_MANY);
    }

    /**
     * This method returns the question type in the line
     *
     * @param line
     *
     * @return GalaxyQuestionType
     */
    public GalaxyQuestionType getQuestionType(String line)
    {
        line = line.trim();
        GalaxyQuestionType result = GalaxyQuestionType.NOMATCH;

        boolean matched = false;

        for(int i =0;i<galaxyQuestionLine.length && !matched ;i++)
        {
            if( line.matches(galaxyQuestionLine[i].getPattern()) )
            {
                matched = true;
                result = galaxyQuestionLine[i].getGalaxyQuestionType();
            }

        }

        return result;

    }
}
