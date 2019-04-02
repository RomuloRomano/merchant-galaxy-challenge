package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

/**
 * The class represent the base strategy to processing the question  in the helper
 *
 */
public interface GalaxyProcessQuestionStrategy {

    /**
     * This method process the question line in the helper
     *
     * @param inputLine
     */
    void processQuestion(String inputLine);
}
