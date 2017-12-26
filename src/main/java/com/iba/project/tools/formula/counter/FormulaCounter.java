package com.iba.project.tools.formula.counter;

import java.util.Stack;

public class FormulaCounter {
    public static double doParse(String input) {
        Stack<Double> numberStack = new Stack<>();

        StringBuilder numberKeeper = new StringBuilder("");

        char currentCharecter;
        for (int j = 0; j < input.length(); j++) {
            currentCharecter = input.charAt(j);
            if (currentCharecter >= '0' && currentCharecter <= '9') {
                numberKeeper.append(currentCharecter);
            }
            if (currentCharecter == ' ' & numberKeeper.length()!=0) {
                    numberStack.push(Double.parseDouble(numberKeeper.toString()));
                    numberKeeper.delete(0,numberKeeper.length());
            }

            if (isOperator(currentCharecter)) {

                double secondNumber=numberStack.pop();

                double firstNumber = numberStack.pop();

                double currentAnswer;
                switch (currentCharecter) {
                    case '+':
                        currentAnswer = firstNumber + secondNumber;
                        break;
                    case '-':
                        currentAnswer = firstNumber - secondNumber;
                        break;
                    case '*':
                        currentAnswer = firstNumber * secondNumber;
                        break;
                    case '/':
                        currentAnswer = firstNumber / secondNumber;
                        break;
                    case '^':
                        currentAnswer=Math.pow(firstNumber,secondNumber);
                        break;

                    default:
                        currentAnswer = 0;
                }
                numberStack.push(currentAnswer);
            }
        }

        double currentAnswer = numberStack.pop();
        return currentAnswer;
    }


    private static boolean isOperator(char currentCharecter) {
        switch (currentCharecter) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;

            default:
                return false;
        }
    }
}
