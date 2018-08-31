package com.omotyliu.domain;

import com.omotyliu.operators.Operator;

import java.util.ArrayList;
import java.util.List;

public class Fact implements RuleToken
{
    private String name;

    private FactState value = FactState.FALSE;

    private List<Rule> rules = new ArrayList<>();

    public void setValue(FactState value) {
        this.value = value;
    }

    public static Fact getFact(String name) {
        Fact fact = FactObsorver.getFact(name);

        if (fact == null) {
            return new Fact(name);
        } else {
            return fact;
        }
    }

    public static Fact getFact(String name, FactState state) {
        Fact fact = getFact(name);
        fact.value = state;
        return fact;
    }

    public FactState getValue() {

        return value;
    }

    public String getName() {
        return name;
    }


    private Fact(String name)
    {
        this.name = name;
        FactObsorver.reqFact(this);
    }

    private Fact(String name, FactState state)
    {
        this.name = name;
        this.value = state;
        FactObsorver.reqFact(this);
    }


    public Fact operator(Operator op)
    {
        return op.apply(this);
    }

    public Fact operator(Operator op, Fact fact)
    {
        return op.apply(this, fact);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fact fact = (Fact) o;

        return name.equals(fact.name) && value == fact.value;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
