package br.com.thoughtworks.merchant.galaxy.challenge.module.builder;


import br.com.thoughtworks.merchant.galaxy.challenge.module.strategy.*;

/**
 * Class to builder the concrete strategy
 *
 */
public class GalaxyProcessQuestionStrategyBuilder {


    /**
     * Constant will be used to validation strategy test
     */


    public static final String LINE_INPUT_ASSINGMENT = "glob is I";
    public static final String LINE_INPUT_CREDIT= "glob glob Silver is 34 Credits";
    public static final String LINE_INPUT_HOW_MUCH= "how much is pish tegj glob glob ?";
    public static final String LINE_INPUT_HOW_MANY = "how many Credits is glob prok Gold ?";



    /**
     * Return  the strategy
     *
     * @return DefaultGalaxyProcessAssignmentQuestionStrategy
     */
    public static GalaxyProcessQuestionStrategy builderProcessingAssignmentStrategy() {
        return new DefaultGalaxyProcessAssignmentQuestionStrategy();
    }

    /**
     * Return  the  strategy
     *
     * @return DefaultGalaxyProcessCreditQuestionStrategy
     */
    public static GalaxyProcessQuestionStrategy builderProcessCreditQuestionStrategy() {
        return new DefaultGalaxyProcessCreditQuestionStrategy();
    }

    /**
     * Return  the  strategy
     *
     * @return DefaultGalaxyHowManyQuestionStrategy
     */
    public static GalaxyProcessQuestionStrategy builderHowManyQuestionStrategy() {
        return new DefaultGalaxyHowManyQuestionStrategy();
    }

    /**
     * Return  the  strategy
     *
     * @return DefaultGalaxyHowManyQuestionStrategy
     */
    public static GalaxyProcessQuestionStrategy builderHowMuchQuestionStrategy() {
        return new DafaultGalaxyProcessHowMuchQuestionStrategy();
    }





}
