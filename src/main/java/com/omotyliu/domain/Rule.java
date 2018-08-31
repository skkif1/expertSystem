package com.omotyliu.domain;

import java.util.ArrayList;
import java.util.List;

public class Rule
{

    private String rowRule;

    private List<Fact> facts = new ArrayList<>();


    public Rule() {
        FactObsorver.reqRule(this);
    }

    public Rule(String rowRule)
    {
        this.rowRule = rowRule;
    }


}
