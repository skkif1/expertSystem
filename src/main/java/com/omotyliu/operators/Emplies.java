package com.omotyliu.operators;


public class Emplies extends Operator {

    public Emplies(String value) {
        super(value);

        super.binaryOperator = (fact, fact2) ->
        {
            fact2.setValue(fact.getValue());
            return fact2;
        };
    }

}
