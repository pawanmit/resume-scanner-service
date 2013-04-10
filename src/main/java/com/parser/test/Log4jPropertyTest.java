package com.parser.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jPropertyTest {
    private static Logger logger = Logger.getLogger
               (Log4jPropertyTest.class);
    public static void main (String args[]){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("Test Log");
    }
}
