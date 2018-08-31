package com.omotyliu;

import com.omotyliu.domain.Fact;
import com.omotyliu.domain.FactObsorver;
import com.omotyliu.domain.FactState;
import com.omotyliu.domain.Rule;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {

        if (args.length == 1)
        {
            InputParser parser = new InputParser(args[0]);
            parser.parseFile();
            parser.getFacts().forEach(s -> new Fact(s, FactState.TRUE));
            parser.getQueries().forEach(s -> new Fact(s));
            parser.getRules().forEach(s -> new Rule(s));
            System.out.println();
        }


    }
}
