package com.omotyliu;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {


    private final String filePath;

    private final String INITIAL_FACTS = "=";

    private final String QUERIES = "?";

    private final String COMMENT = "#";

    private List<String> facts = new ArrayList<>();

    private List<String> rules = new ArrayList<>();

    private List<String> queries = new ArrayList<>();

    private List<String> rowLines = new ArrayList<>();

    private List<String> rowLinesCopy = new ArrayList<>();

    public InputParser(String filePath) {
        this.filePath = filePath;
    }

    public void parseFile() {
        try {
            readFile();
            rowLinesCopy = new ArrayList<>(rowLines);
            removeComments();
            fetchFacts(INITIAL_FACTS, facts);
            fetchFacts(QUERIES, queries);
            fetchRules();

        } catch (IOException e) {
            throw new RuntimeException("Bad file (cant find or read file)\n");
        }
    }

    private void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        while ((line = reader.readLine()) != null) {
            rowLines.add(line);
        }
    }

    private void fetchFacts(String sign, List<String> list)
    {
        list.addAll(rowLines.stream().filter(s -> StringUtils.startsWith(s, sign)).flatMap(s -> s.chars().mapToObj(ch -> String.valueOf((char) ch))).collect(Collectors.toList()));
        list.removeIf(s -> StringUtils.isBlank(s) || s.equals(sign));

    }

    private void fetchRules()
    {
        rules = rowLines.stream().filter(s -> !StringUtils.startsWith(s, QUERIES) && !StringUtils.startsWith(s, INITIAL_FACTS) && StringUtils.isNotBlank(s)).map(String::trim).collect(Collectors.toList());
    }

    private void removeComments() {
        rowLines = rowLines.stream().map(s -> StringUtils.substringBefore(s, COMMENT)).filter(StringUtils::isNotEmpty).collect(Collectors.toList());
    }

}
