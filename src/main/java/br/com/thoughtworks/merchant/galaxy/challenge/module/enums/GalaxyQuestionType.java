package br.com.thoughtworks.merchant.galaxy.challenge.module.enums;

/**
 * This class represent  the line that can be processing by some action
 *
 */
public enum GalaxyQuestionType {

    /**
     * This represents that line is of Assignment type. Ex: glob is V
     */
    ASSIGNED,

    /**
     * This represents that line is of Credits type. Ex : glob glob Silver is 34 Credits
     */
    CREDITS,

    /**
     * This represents that line is question asking how much. Ex : how much is pish tegj glob glob ?
     */
    QUESTION_HOW_MUCH,

    /**
     * This represents that line is question asking how many. Ex: how many Credits is glob prok Iron ?
     */
    QUESTION_HOW_MANY,

    /**
     * This represents that line does not matched any of the line type mentioned above
     */
    NOMATCH
}
