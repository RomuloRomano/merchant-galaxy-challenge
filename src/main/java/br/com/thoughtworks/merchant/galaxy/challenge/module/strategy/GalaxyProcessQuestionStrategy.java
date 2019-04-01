package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

/**
 * The class represent the base strategy to processing the question  in the application
 *
 */
public interface GalaxyProcessQuestionStrategy {

    /**
     * This method process the quetion in the application
     *
     * @param inputLine
     */
    void processQuestion(String inputLine);
}
