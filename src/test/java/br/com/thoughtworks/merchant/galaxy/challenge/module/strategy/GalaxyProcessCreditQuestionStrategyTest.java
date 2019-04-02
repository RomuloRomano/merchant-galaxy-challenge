package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;


import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.GalaxyProcessQuestionStrategyBuilder;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;
import org.junit.Test;

/**
 * Class base to test Question Strategy
 *
 */
public class GalaxyProcessCreditQuestionStrategyTest {



    @Test
    public void processCreditsLineTest(){
        GalaxyProcessQuestionStrategyBuilder.builderProcessCreditQuestionStrategy().processQuestion(GalaxyProcessQuestionStrategyBuilder.LINE_INPUT_CREDIT);
        System.out.println("Execute test for Credit Strategy : " + GalaxyProcessQuestionHelper.getComputedLiterals());

    }

}
