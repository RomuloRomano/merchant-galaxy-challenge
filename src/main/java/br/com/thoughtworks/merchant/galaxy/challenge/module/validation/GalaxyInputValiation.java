package br.com.thoughtworks.merchant.galaxy.challenge.module.validation;

/**
 * Interface base to validation
 */
public interface GalaxyInputValiation {

    /**
     * This method will  validation the input instruction for  program
     *
     * @param input
     * @return TRUE|FALSE
     */
    boolean validation(String input);
}
