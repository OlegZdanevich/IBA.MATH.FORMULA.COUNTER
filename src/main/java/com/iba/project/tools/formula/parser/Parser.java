package com.iba.project.tools.formula.parser;


import java.util.Stack;

public class Parser {

    public static String parseExpression(StringBuilder data) {

        StringBuilder result = new StringBuilder("");

        Stack<Character> operatorsStack = new Stack<>();

        char previousChar = ' ';
        for (int j = 0; j < data.length(); j++) {
            char ch = data.charAt(j);
            switch (ch) {

                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    operatorParse(operatorsStack, result, ch);
                    break;

                case '(':
                    operatorsStack.push(ch);
                    break;
                case ')':
                    leftParenthesis(operatorsStack, result);
                    break;
                default:
                    if (previousChar >= '0' && previousChar <= '9') {
                        result.append(ch);
                    } else {
                        result.append(" " + ch);
                    }

                    break;
            }
            previousChar = ch;
        }

        while (!operatorsStack.isEmpty()) {
            result.append(" " + operatorsStack.pop());
        }

        result.deleteCharAt(0);
        return result.toString();
    }

    private static void operatorParse(Stack<Character> operatorsStack, StringBuilder result, char opThis) {

        int priorityOfCurrentElement = getPriority(opThis);

        while (!operatorsStack.isEmpty()) {
            char opTop = operatorsStack.pop();
            if (opTop == '(') {
                operatorsStack.push(opTop);
                break;
            } else {
                int priorityOfElementFromStack = getPriority(opTop);

                if (priorityOfElementFromStack < priorityOfCurrentElement) {
                    operatorsStack.push(opTop);
                    break;
                } else
                    result.append(" " + opTop);
            }
        }
        operatorsStack.push(opThis);
    }

    private static void leftParenthesis(Stack<Character> operatorsStack, StringBuilder result) {
        while (!operatorsStack.isEmpty()) {
            char chx = operatorsStack.pop();
            if (chx == '(')
                break;

            else result.append(" " + chx);
        }
    }

    private static int getPriority(char ch) {
        int priority = 0;
        switch (ch) {
            case '+':
            case '-':
                priority = 1;
                break;

            case '*':
            case '/':
                priority = 2;
                break;

            case '^':
                priority = 3;

        }

        return priority;
    }
}