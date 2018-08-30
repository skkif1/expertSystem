package com.omotyliu.domain;

import java.util.ArrayList;
import java.util.List;

public class Fact
{

    private String name;

    private FactState value = FactState.FALSE;

    private List<Rule> rules = new ArrayList<>();


    private Fact()
    {
        FactObsorver.reqFact(this);
    }

    public Fact(String name, FactState state)
    {
        this();
        this.name = name;
        this.value = state;
    }
}
