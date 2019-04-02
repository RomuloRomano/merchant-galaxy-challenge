package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;


import org.junit.Assert;
import org.junit.Test;

public class DefaultGalaxyRuleCanNeverSubtractedTest {



    private   GalaxyChainBusinessRule  galaxyChainBusinessRule;
    private  static final String INPUT_SYMBOL_NUMERAL = "VLD";


    @Test
    public void executeRuleRepeatedSymbolsTest() {
        Assert.assertEquals(-1, getGalaxyChainBusinessRule().apply(INPUT_SYMBOL_NUMERAL).intValue());
    }

    /**
     * Inject the Chain Business Rules
     * @return
     */
    public GalaxyChainBusinessRule getGalaxyChainBusinessRule() {
        if(galaxyChainBusinessRule == null){
            galaxyChainBusinessRule = new DefaultGalaxyRuleCanNeverSubtracted();
        }
        return galaxyChainBusinessRule;
    }
}
