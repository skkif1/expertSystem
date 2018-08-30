package com.omotyliu;

import com.omotyliu.domain.Fact;
import com.omotyliu.domain.FactObsorver;
import com.omotyliu.domain.FactState;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args)
    {

        if (args.length == 1)
        {
            InputParser parser = new InputParser(args[0]);
            parser.parseFile();

            parser.getFacts().stream().map(s -> new Fact(s, FactState.TRUE)).collect(Collectors.toList());
            FactObsorver
        }

    }
}
