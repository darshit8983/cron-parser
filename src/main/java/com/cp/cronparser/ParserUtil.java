package com.cp.cronparser;

import com.cp.cronparser.dto.ParserType;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ParserUtil {

    public static String printer(ParserType parser, Set<Integer> values) {
        StringBuffer b = new StringBuffer();
        values = values.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        b.append(String.format("%-14s%s\n", parser.toString().replaceAll("_", " ").toLowerCase(),
                values.toString().substring(1, values.toString().length() - 1)));
        return b.toString();
    }
}
