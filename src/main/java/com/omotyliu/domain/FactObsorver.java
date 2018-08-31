package com.omotyliu.domain;

import java.util.HashSet;
import java.util.Set;

public class FactObsorver
{
    public static Set<Fact> knownFacts = new HashSet<>();

    private static Set<Fact> queries = new HashSet<>();

    public static Set<Rule> rules = new HashSet<>();


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


    public static Fact getFact(String name) {
        return knownFacts.stream().filter(fact -> fact.getName().equals(name)).findFirst().orElse(null);
    }
}
