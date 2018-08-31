package com.omotyliu.domain;

import com.omotyliu.Util;
import com.omotyliu.operators.Operator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Rule
{

    private String rowRule;

    private Map<String, RuleToken> tokenObj = new HashMap<>();

    private LinkedList<RuleToken> rule = new LinkedList<>();


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
                Fact temp = Fact.getFact(s);
                rule.add(temp);
                tokenObj.put(s, temp);
            }
            else if (Util.isOperator(s))
            {
                Operator op = Operator.getOperator(s);
                rule.add(op);
                tokenObj.put(s, op);
            }


        }
    }


    public Fact execute() {
        Fact temp = null;

        Operator op = null;

        for (RuleToken token : rule) {
            if (token instanceof Fact) {
                if (temp == null) {
                    temp = (Fact) token;
                } else {
                    temp.operator(op, (Fact) token);
                }
            } else {
                op = (Operator) token;
            }
        }

        return temp;
    }
}
