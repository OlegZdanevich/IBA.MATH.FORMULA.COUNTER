package com.iba.project.data;

import com.iba.project.tools.formula.parser.Parser;
import com.iba.project.tools.formula.parser.VariableCounter;

public class Formula implements Node {
    private StringBuilder formula;


    public Formula(String formula) {
        this.formula = new StringBuilder(formula);
    }

    @Override
    public StringBuilder count() {
        VariableCounter counter = VariableCounter.getInstance();

        counter.replace(this);

        Parser.parseExpression(formula);

        StringBuilder result = new StringBuilder("");//Count
        //ToDO

        return result;
    }

    public StringBuilder getFormula() {
        return formula;
    }

    public void setFormula(StringBuilder formula) {
        this.formula = formula;
    }
}
