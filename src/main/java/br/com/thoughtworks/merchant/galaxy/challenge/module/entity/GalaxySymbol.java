package br.com.thoughtworks.merchant.galaxy.challenge.module.entity;

/**
 * Class represent the Symbol Numeral for application
 */
public enum GalaxySymbol {

    I("I", 1),
    V("V", 5),
    X("X", 10),
    L("L",50),
    C("C",100),
    D("D", 500),
    M("M", 1000);

    GalaxySymbol(String name, int value){
        this.name = name;
        this.value = value;
    }

    private String name;
    private int value;


    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
