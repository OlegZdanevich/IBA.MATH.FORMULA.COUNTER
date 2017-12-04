package com.iba.project.data.file;

import com.iba.project.loggin.exceptions.LoggerForExceptions;

import java.io.*;

public class Loader {
    public static StringBuilder loadData(String filename)
    {
        File file=null;
        FileReader fileReader = null;

        StringBuilder result=new StringBuilder("");
        try {
            file = new File("data/" + filename);

            fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();


            while (line != null) {
                result.append(line+"\n");

                line = reader.readLine();
            }

        } catch (FileNotFoundException exception)

        {
            LoggerForExceptions.fileNotFoundException(exception);
        } catch (IOException exception)

        {
            LoggerForExceptions.ReadFileException(exception);
        }
        finally {
            try{

                if(fileReader!=null)
                    fileReader.close();
            }
            catch(IOException exception){

                LoggerForExceptions.ReadFileException(exception);
            }

        }

        return result;

    }
}
