package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.GalaxyProcessQuestionStrategyBuilder;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;
import org.junit.Test;

/**
 * Class base to processing the strategy how many
 */

public class GalaxyHowManyQuestionStrategyTest {

    @Test
    public  void processAssignmentTest(){

        GalaxyProcessQuestionStrategyBuilder.builderHowManyQuestionStrategy().processQuestion(GalaxyProcessQuestionStrategyBuilder.LINE_INPUT_HOW_MANY);
        System.out.println("Execute test for How many  Strategy : " + GalaxyProcessQuestionHelper.getConstantAssignments());

    }

}
