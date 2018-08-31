package com.omotyliu.domain;

import java.util.ArrayList;
import java.util.List;

public class FactObsorver
{
    private static List<Fact> knownFacts = new ArrayList<>();

    private static List<Fact> queries = new ArrayList<>();

    private static List<Rule> rules = new ArrayList<>();


    public static void reqFact(Fact fact)
    {
        knownFacts.add(fact);
    }
    public static void reqQuerie(Fact fact)
    {
        queries.add(fact);
    }

    public static void reqRule(Rule rule)
    {
        rules.add(rule);
    }

}
