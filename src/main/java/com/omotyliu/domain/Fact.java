package com.omotyliu.domain;

import java.util.ArrayList;
import java.util.List;

public class Fact
{
    private String name;

    private FactState value = FactState.FALSE;

    private List<Rule> rules = new ArrayList<>();


    public Fact(String name)
    {
        FactObsorver.reqFact(this);
        this.name = name;
    }

    public Fact(String name, FactState state)
    {
        this(name);
        this.value = state;
    }


    public Fact operator(Operator op)
    {
        return null;
    }

    public Fact operator(Operator op, Fact fact)
    {
        return null;
    }

}
