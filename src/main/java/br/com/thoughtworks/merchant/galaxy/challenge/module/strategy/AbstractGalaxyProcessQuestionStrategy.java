package br.com.thoughtworks.merchant.galaxy.challenge.module.strategy;

import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyTranslateMessageHelper;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.DefaultGalaxySymbolConvert;
import br.com.thoughtworks.merchant.galaxy.challenge.module.convert.GalaxySymbolConvert;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class abstract to process question line in the helper
 *
 */
public class AbstractGalaxyProcessQuestionStrategy {

    /**
     * This is the hash map that will contain the value for each identifier
     */
    private HashMap<String, String> constantAssignments;


    /**
     * Translate the message in the output
     */
    private GalaxyTranslateMessageHelper galaxyTranslateMessageHelper;


    /**
     * Galaxy Symbol Convert
     */
    private GalaxySymbolConvert galaxySymbolConvert;


    /**
     * List output to be post in the console helper
     */
    private ArrayList<String> output;


    /**
     *
     *
     */
    private  HashMap<String, String> computedLiterals;



    public void setConstantAssignments(HashMap<String, String> constantAssignments) {
        this.constantAssignments = constantAssignments;
    }

    public HashMap<String, String> getConstantAssignments() {
        return constantAssignments;
    }

    public void setGalaxyTranslateMessageHelper(GalaxyTranslateMessageHelper galaxyTranslateMessageHelper) {
        this.galaxyTranslateMessageHelper = galaxyTranslateMessageHelper;
    }

    public GalaxyTranslateMessageHelper getGalaxyTranslateMessageHelper() {
        if(galaxyTranslateMessageHelper == null){
            galaxyTranslateMessageHelper = new GalaxyTranslateMessageHelper();
        }
        return galaxyTranslateMessageHelper;
    }

    public GalaxySymbolConvert getGalaxySymbolConvert() {
        if(galaxySymbolConvert == null){
            galaxySymbolConvert = new DefaultGalaxySymbolConvert();
        }

        return galaxySymbolConvert;
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }

    public ArrayList<String> getOutput() {
        if(output ==null){
            output = new ArrayList<String>();
        }
        return output;
    }

    public void setComputedLiterals(HashMap<String, String> computedLiterals) {
        this.computedLiterals = computedLiterals;
    }

    public HashMap<String, String> getComputedLiterals() {
        if(computedLiterals == null){
            computedLiterals = new HashMap<String, String>();
        }
        return computedLiterals;
    }
}

