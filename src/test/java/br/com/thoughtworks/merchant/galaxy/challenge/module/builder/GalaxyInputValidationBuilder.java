package br.com.thoughtworks.merchant.galaxy.challenge.module.builder;

import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxyInputValiation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxyInputValiation;

public class GalaxyInputValidationBuilder {


    public static GalaxyInputValiation builderGalaxyInputValidation(){
        return new DefaultGalaxyInputValiation();
    }

}
