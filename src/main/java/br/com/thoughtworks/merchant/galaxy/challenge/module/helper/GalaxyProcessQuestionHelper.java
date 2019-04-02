package br.com.thoughtworks.merchant.galaxy.challenge.module.helper;


import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * Class  to helper processing the question its will be used in the strategy
 * to concentrate all the information  computed in the  application
 */
public class GalaxyProcessQuestionHelper {


    /**
     * This is the hash map that will contain the value for each identifier
     */
    private static HashMap<String, String> constantAssignments = new HashMap<String, String>();

    /**
     * List output to be post in the console helper
     */
    private static  ArrayList<String> output = new ArrayList<String>();



    /**
     *
     *
     */
    private  static HashMap<String, String> computedLiterals = new HashMap<String, String>();


    public GalaxyProcessQuestionHelper() {
    }

    public static HashMap<String, String> getComputedLiterals() {
        return computedLiterals;
    }



    public static HashMap<String, String> getConstantAssignments() {
        return constantAssignments;
    }

    public static ArrayList<String> getOutput() {
        return output;
    }
}
