package br.com.thoughtworks.merchant.galaxy.challenge.module.validation;

/**
 * Interface base to validation
 *
 * @author  Rafael.Almeida
 */
public interface GalaxyInputValiation {

    /**
     * This method will  validation the input instruction for  application
     *
     * @param input
     * @return TRUE|FALSE
     */
    boolean validation(String[] input);
}
