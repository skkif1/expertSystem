package com.omotyliu;

public class Main {

    public static void main(String[] args)
    {

        if (args.length == 1)
        {
            InputParser parser = new InputParser(args[0]);
            parser.parseFile();
            System.out.println();
        }

    }
}
