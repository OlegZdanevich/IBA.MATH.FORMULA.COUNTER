package com.iba.project.tools.formula.parser;


public class Preparear {

    public static void prepare(StringBuilder data) {
        change(data, "+");
        change(data, "-");
        change(data, "*");
        change(data, "/");
        change(data, "^");
    }

    private static void change(StringBuilder data, String operator) {
        int start=0;
        while (true) {

            start =data.indexOf(operator,start);

            if(start==-1) break;

            data.replace(start, start + 1, operator + " ");

            start++;
        }
    }
}
