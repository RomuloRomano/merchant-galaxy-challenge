package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class DefaultGalaxyRuleRepeatedSymbolTest {

    private   GalaxyChainBusinessRule  galaxyChainBusinessRule;

    private  static final String XXXIV = "XXXXIV";




    @Test
    public void executeRuleRepeatedSymbolsTest() {
        Assert.assertEquals(-1, getGalaxyChainBusinessRule().apply(XXXIV).intValue());

    }


    /**
     * Inject the Chain Business Rules
     * @return
     */
    public GalaxyChainBusinessRule getGalaxyChainBusinessRule() {
        if(galaxyChainBusinessRule == null){
            galaxyChainBusinessRule = new DefaultGalaxyRuleRepeateSymbol();
        }
        return galaxyChainBusinessRule;
    }
}




