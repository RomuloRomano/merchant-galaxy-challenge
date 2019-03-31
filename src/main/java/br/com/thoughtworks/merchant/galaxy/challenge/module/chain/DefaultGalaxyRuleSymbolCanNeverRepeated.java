package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import java.util.Set;

/**
 * This class will processing the business rule  to check  some symbol that can never repeated.
 *
 */
public class DefaultGalaxyRuleSymbolCanNeverRepeated  extends   GalaxyAbstractRuleBusiness implements  GalaxyChainBusinessRule {



    /**
     * This method   will processing the follow  business rule:
     *
     *          Rule 05 - Symbols ("D", "L", "V") can never repeated
     *
     * @param inputSymbolNumeral
     *
     * @return Value
     */
    public Integer apply(String inputSymbolNumeral) {

        //load repeated symbols
        Set<Character> symbolsCanNeverRepeated =  getGalaxyLoadSymbolService().loadSymbolsCanNeverRepeated();

        return null;
    }
}
