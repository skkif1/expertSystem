package com.omotyliu.domain;

import com.omotyliu.Util;
import com.omotyliu.operators.Operator;
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
        Fact first = null;

        for (String s : arr)
        {
            if (Util.isFact(s))
            {
                Fact temp = new Fact(s);
                facts.add(temp);
                if (first == null) {
                    first = temp;
                } else {

                }
            }
            else if (Util.isOperator(s))
            {
                operators.add(Operator.getOperator(s));
            }
        }


    }

}
