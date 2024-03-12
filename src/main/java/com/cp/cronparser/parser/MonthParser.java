package com.cp.cronparser.parser;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MonthParser extends AbstractParser {

    private static final Set<Character> allowedChar = new HashSet<>(Arrays.asList(',', '-', '*', '/'));
    private static final List<Integer> range = Arrays.asList(1, 12);

    private static final Map<String, Integer> monthMap = new HashMap<String, Integer>() {{
        put("JAN", 1);
        put("FEB", 2);
        put("MAR", 3);
        put("APR", 4);
        put("MAY", 5);
        put("JUN", 6);
        put("JUL", 7);
        put("AUG", 8);
        put("SEP", 9);
        put("OCT", 10);
        put("NOV", 11);
        put("DEC", 12);
    }};

    @Override
    public void validate(String val) {
        super.baseValidate(val, allowedChar);
        super.baseValidateRange(val,range);
    }

    @Override
    public Set<Integer> parse(String val) {
        for(String key : monthMap.keySet()) {
            val = val.replaceAll("((?i)" + key + ")", monthMap.get(key).toString());
        }
        return super.baseParser(val, allowedChar, range);
    }
}
