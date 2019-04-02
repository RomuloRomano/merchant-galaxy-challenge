package br.com.thoughtworks.merchant.galaxy.challenge.module.enums;

/**
 * This enum class represent the question error in the helper
 *
 */
public enum GalaxyQuestionReturnCode {

    /**
     * Success OK
     */
    SUCCESS_OK,
    /**
     * No input value
     */
    NO_INPUT,
    /**
     * Invalid input
     */
    INVALID,
    /**
     * Invalid Galaxy Symbol
     */
    INVALID_GALAXY_CHARACTER,
    /**
     * Invalid Galaxy string
     */
    INVALID_GALAXY_STRING,
    /**
     * Incorrect question line type
     */
    INCORRECT_QUESTION_LINE_TYPE,
    /**
     * Not identify the question
     */
    NO_IDEA;
}
