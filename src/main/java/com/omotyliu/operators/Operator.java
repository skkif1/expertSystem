package com.omotyliu.operators;

import com.omotyliu.domain.Fact;
import com.omotyliu.domain.RuleToken;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public abstract class Operator implements RuleToken {
    public static final List<String> knownOperators = Arrays.asList("=>");

    protected BinaryOperator<Fact> binaryOperator;

    protected UnaryOperator<Fact> unaryOperator;

    public static Operator getOperator(String rowOp) {
        switch (rowOp) {
            case "=>":
                return new Emplies("=>");

        }
        return null;
    }

    private final String value;

    protected Operator(String value) {
        this.value = value;
    }

    public Fact apply(Fact... facts) {
        if (binaryOperator != null) {
            return binaryOperator.apply(facts[0], facts[1]);
        } else {
            return unaryOperator.apply(facts[0]);
        }
    }

}
