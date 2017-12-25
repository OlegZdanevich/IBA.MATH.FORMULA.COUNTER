package com.iba.project.tools.formula.parser;

import com.iba.project.data.Formula;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VariableCounter {
    private int i;
    private int j;

    private static volatile VariableCounter instance;

    public static VariableCounter getInstance() {
        VariableCounter localInstance = instance;
        if (localInstance == null) {
            synchronized (VariableCounter.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new VariableCounter();
                }
            }
        }
        return localInstance;
    }

    public void replace(Formula formula) {
        StringBuilder formulaData = formula.getFormula();

        this.i = change(formulaData, i,"i");
        this.j = change(formulaData, j,"j");

    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }

    private VariableCounter() {
    }

    private int change(StringBuilder formulaData, int data, String elementToFind) {
        Pattern pattern=Pattern.compile(elementToFind);

        Matcher matcher=pattern.matcher(formulaData);

        int counter = data;

        while (matcher.find()) {
            int start = matcher.start();

            char left = start == 0 ? '0' : formulaData.charAt(start - 1);
            char right = start == formulaData.length()-1 ? '0' : formulaData.charAt(start + 1);

            if (left == '-' || left == '+') {

                if (left == '-') {
                    counter--;
                } else {
                    counter++;
                }

                formulaData.replace(start - 2, start+1, String.valueOf(counter));

                matcher=pattern.matcher(formulaData);
            } else {

                formulaData.replace(start, start + 3, String.valueOf(counter));

                matcher=pattern.matcher(formulaData);

                if (right == '-') {
                    counter--;
                } else {
                    counter++;
                }
            }
        }

        return counter;


    }
}
