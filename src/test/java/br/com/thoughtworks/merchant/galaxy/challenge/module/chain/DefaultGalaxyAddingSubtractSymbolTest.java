package br.com.thoughtworks.merchant.galaxy.challenge.module.chain;

import org.junit.Assert;
import org.junit.Test;

public class DefaultGalaxyAddingSubtractSymbolTest {

    private   GalaxyChainBusinessRule  galaxyChainBusinessRule;

    private  static final String XXXIV = "XXIV";
    private static final String IX = "IX";

    @Test
    public void convertComplexSymbolsTest(){
        Assert.assertEquals(24, getGalaxyChainBusinessRule().apply(XXXIV).intValue());
        Assert.assertEquals(9, getGalaxyChainBusinessRule().apply(IX).intValue());

    }


    /**
     * Inject the Chain Business Rules
     * @return
     */
    public GalaxyChainBusinessRule getGalaxyChainBusinessRule() {
        if(galaxyChainBusinessRule == null){
            galaxyChainBusinessRule = new DefaultGalaxyAddingSubtractSymbol();
        }
        return galaxyChainBusinessRule;
    }
}
