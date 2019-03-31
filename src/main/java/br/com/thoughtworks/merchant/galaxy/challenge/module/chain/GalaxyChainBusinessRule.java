package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

/**
 * Class to represent and  process the chain of business rules
 *
 */
public interface GalaxyChainBusinessRule {

    /**
     * This method will be implement for  all concretes class that need to  processing one business rules
     * @param inputSymbol
     * @return  value
     */
    Integer apply(String inputSymbol);

}
