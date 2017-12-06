package com.iba.project.data.file;

import org.apache.log4j.Logger;

import java.io.*;

public class Loader {
    private static final Logger log = Logger.getLogger(Loader.class);

    public static StringBuilder loadData(String filename) {
        File file = null;

        file = new File("data/" + filename);

        StringBuilder result = new StringBuilder("");
        try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {

            String line = reader.readLine();

            while (line != null) {
                result.append(line + "\n");

                line = reader.readLine();
            }

        } catch (FileNotFoundException exception) {
            log.trace("There is no file in this directory", exception);
        } catch (IOException exception)

        {
            log.trace("Failed to read file", exception);
        }
        return result;

    }
}

