package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.GalaxyProcessQuestionStrategyBuilder;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;
import org.junit.Test;


/**
 * Class base to test the processing the strategy how much
 */
public class GalaxyProcessHowMuchQuestionStrategyTest {

    @Test
    public  void processAssignmentTest(){

        GalaxyProcessQuestionStrategyBuilder.builderHowMuchQuestionStrategy().processQuestion(GalaxyProcessQuestionStrategyBuilder.LINE_INPUT_HOW_MUCH);
        System.out.println("Execute test for How much  Strategy : " + GalaxyProcessQuestionHelper.getConstantAssignments());

    }

}
