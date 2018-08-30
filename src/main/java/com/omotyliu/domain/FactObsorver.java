package com.omotyliu.domain;

import java.util.ArrayList;
import java.util.List;

public class FactObsorver
{
    private static List<Fact> knownFacts = new ArrayList<>();


    public static void reqFact(Fact fact)
    {
        knownFacts.add(fact);
    }

}
