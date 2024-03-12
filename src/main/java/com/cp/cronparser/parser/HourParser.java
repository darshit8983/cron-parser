package com.cp.cronparser.parser;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class HourParser extends AbstractParser {

    private static final Set<Character> allowedChar = new HashSet<>(Arrays.asList(',', '-', '*', '/'));
    private static final List<Integer> range = Arrays.asList(0, 23);

    @Override
    public void validate(String val) {
        super.baseValidate(val, allowedChar);
        super.baseValidateRange(val,range);
    }

    @Override
    public Set<Integer> parse(String val) {
        return super.baseParser(val, allowedChar, range);
    }
}
