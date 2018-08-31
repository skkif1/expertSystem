package com.omotyliu.domain;

import java.util.Arrays;
import java.util.List;

public class Operator
{
    public static final List<String> knownOperators = Arrays.asList("=>");


    private final String value;

    public Operator(String value)
    {
        this.value = value;
    }
}
