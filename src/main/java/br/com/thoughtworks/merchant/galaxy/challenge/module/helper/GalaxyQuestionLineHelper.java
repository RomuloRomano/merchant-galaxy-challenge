package br.com.thoughtworks.merchant.galaxy.challenge.module.helper;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionType;

/**
 * This class  check the line question
 */
public class GalaxyQuestionLineHelper {

    private GalaxyQuestionType galaxyQuestionType;
    private  String pattern;


    public GalaxyQuestionLineHelper(GalaxyQuestionType galaxyQuestionType, String pattern) {
        this.galaxyQuestionType = galaxyQuestionType;
        this.pattern = pattern;
    }


    public GalaxyQuestionType getGalaxyQuestionType() {
        return galaxyQuestionType;
    }

    public String getPattern() {
        return pattern;
    }
}
