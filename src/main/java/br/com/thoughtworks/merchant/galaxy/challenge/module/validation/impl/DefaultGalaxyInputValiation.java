package br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl;

import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxyInputValiation;

/**
 * Default Galaxy Input Validation
 *
 */

public class DefaultGalaxyInputValiation implements GalaxyInputValiation {



    public boolean validation(String[] input) {
        if(input == null || input.length == 0){
            return false;
        }
        return true;
    }
}
