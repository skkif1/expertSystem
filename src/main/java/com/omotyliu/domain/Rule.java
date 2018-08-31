package com.omotyliu.domain;

import com.omotyliu.Util;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Rule
{

    private String rowRule;

    private List<Fact> facts = new ArrayList<>();

    private List<Operator> operators = new ArrayList<>();

    public Rule() {
        FactObsorver.reqRule(this);
    }

    public Rule(String rowRule)
    {
        this();
        this.rowRule = rowRule;
        parseRule();
    }

    private void parseRule()
    {
        String[] arr = StringUtils.split(rowRule, " \t");
        for (String s : arr)
        {
            if (Util.isFact(s))
            {
                facts.add(new Fact(s));
            }
            else if (Util.isOperator(s))
            {
                operators.add(new Operator(s));
            }
        }
    }

}
