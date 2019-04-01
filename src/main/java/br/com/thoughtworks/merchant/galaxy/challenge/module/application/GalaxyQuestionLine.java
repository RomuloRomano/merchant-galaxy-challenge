package br.com.thoughtworks.merchant.galaxy.challenge.module.application;

import br.com.thoughtworks.merchant.galaxy.challenge.module.enums.GalaxyQuestionType;

/**
 * This class  check the line question
 */
public class GalaxyQuestionLine {

    private GalaxyQuestionType galaxyQuestionType;
    private  String pattern;


    public GalaxyQuestionLine(GalaxyQuestionType galaxyQuestionType, String pattern) {
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
