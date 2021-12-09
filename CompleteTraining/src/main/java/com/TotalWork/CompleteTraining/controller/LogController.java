package com.TotalWork.CompleteTraining.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController

public class LogController {

    @Autowired
    private MessageSource messageSource;

    Logger logger= LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/")
    public String index(){
        logger.trace("A TRACE Message");
        logger.error("error happend");
        logger.debug("debug happend");
        logger.warn("warn  happend");
        logger.info("info happend");
    return "Howdy! Check out the Logs to see the output...";
    }

    @GetMapping(path ="/hello-world")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) String localeString) {
        try {
            Locale locale = new Locale(localeString);
            System.out.println("##3  local: " + locale);
            return messageSource.getMessage("good.morning.message", null, locale);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
