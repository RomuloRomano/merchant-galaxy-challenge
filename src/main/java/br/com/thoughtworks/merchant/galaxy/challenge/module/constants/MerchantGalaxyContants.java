package br.com.thoughtworks.merchant.galaxy.challenge.module.constants;

public class MerchantGalaxyContants {

    public static String ERROR = "I have no idea what you are talking about";
    public static String REGEX_ASSINGGNMENT  = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
    public static String REGEX_CREDITS  = "((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) ([A-Z]\\w+)$";
    public static String REGEX_HOW_MANY = "^how many ([a-zA-Z]\\w+) is ((?:\\w+ )+)([A-Z]\\w+) \\?$";
    public static String REGEX_HOW_MUCH = "^how much is ((?:\\w+[^0-9] )+)\\?$";

    public static final int MAX_VALUE_REPEATED_THREE_TIMES = 3;
    public static final int MAX_VALUE_REPEATED_FOURTH_TIMES = 4;


}
