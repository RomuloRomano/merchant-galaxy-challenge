package br.com.thoughtworks.merchant.galaxy.challenge.module.constants;

public class MerchantGalaxyContants {

    public static String ERROR = "I have no idea what you are talking about";
    public static String REGEX_ASSINGGNMENT  = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
    public static String REGEX_CREDITS  = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
    public static String REGEX_HOW_MANY = "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
    public static String REGEX_HOW_MUCH = "^how much is ((?:\\w+[^0-9] )+)\\?$";


    public static String REGEX_PATTERN_ASSINGGNMENT = "^([A-Za-z]+) is ([I|V|X|L|C|D|M])$";
    public static String REGEX_PATTERN_CREDITS = "^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$";
    public static String REGEX_PETTERN_HOW_MUCH = "^how much is (([A-Za-z\\s])+)\\?$";
    public static String REGEX_PATTERN_HOW_MANY= "^how many [c|C]redits is (([A-Za-z\\s])+)\\?$";

    /**
     * This regex string will validate whether roman number entered is valid or not
     */
    public static String GALAXY_SYMBOL_NUMBER_VALIDATOR = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";



    public static final int MAX_VALUE_REPEATED_THREE_TIMES = 3;
    public static final int MAX_VALUE_REPEATED_FOURTH_TIMES = 4;
    public static final int MAX_VALUE_QUESTION_  = 4;


}
