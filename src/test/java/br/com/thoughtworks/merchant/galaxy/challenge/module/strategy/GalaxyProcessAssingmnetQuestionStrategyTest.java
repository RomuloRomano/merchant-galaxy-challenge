package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;


import br.com.thoughtworks.merchant.galaxy.challenge.module.builder.GalaxyProcessQuestionStrategyBuilder;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyProcessQuestionHelper;
import org.junit.Test;

/**
 * Class base to test Processing assignment question
 *
 */
public class GalaxyProcessAssingmnetQuestionStrategyTest {



    @Test
    public  void processAssignmentTest(){

        GalaxyProcessQuestionStrategyBuilder.builderProcessingAssignmentStrategy().processQuestion(GalaxyProcessQuestionStrategyBuilder.LINE_INPUT_ASSINGMENT);
        System.out.println("Execute test for Assignment Strategy : " +GalaxyProcessQuestionHelper.getConstantAssignments());

    }

}
