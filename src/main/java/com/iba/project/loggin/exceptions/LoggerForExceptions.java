package com.iba.project.loggin.exceptions;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class LoggerForExceptions {
    private static final Logger log = Logger.getLogger(LoggerForExceptions.class);

    public static void fileNotFoundException(FileNotFoundException exception) {
        log.trace("There is no file in this directory",exception);
    }

    public static void ReadFileException(IOException exception) {

        log.trace("Failed to read file",exception);
    }


    public static void notNumberException(NumberFormatException exception) {
        log.trace("You should enter integer number",exception);
    }

    public static void notCorrectNumbersException(IllegalArgumentException exception) {
        log.trace(exception.getMessage(),exception);

    }


}
