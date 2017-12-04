package com.iba.project.loggin.results;


import org.apache.log4j.Logger;

public class LoggerForInfo
{
    private static final Logger log = Logger.getLogger(LoggerForInfo.class);

    public static void writeInfo(String information)
    {

        log.info(information);
    }
}
