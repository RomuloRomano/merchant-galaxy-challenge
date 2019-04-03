package br.com.thoughtworks.merchant.galaxy.challenge;

import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.MerchantGalaxayFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.facades.impl.DefaultMerchantGalaxyFacade;
import br.com.thoughtworks.merchant.galaxy.challenge.module.helper.GalaxyTranslateMessageHelper;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.GalaxyProcessQuestionService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.service.impl.DefaultGalaxyProcessQuestionService;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.GalaxyInputValiation;
import br.com.thoughtworks.merchant.galaxy.challenge.module.validation.impl.DefaultGalaxyInputValiation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MerchantGalaxyApplication {




    public static void main(String[] args)

        {

            GalaxyTranslateMessageHelper.printMessage();
            MerchantGalaxayFacade merchantGalaxayFacade  = new DefaultMerchantGalaxyFacade();
            merchantGalaxayFacade.getLoadMerchantGalaxySymbols();
            GalaxyTranslateMessageHelper.printResult(merchantGalaxayFacade.fulfillmentProcessGalaxyQuestion());


    }





}

