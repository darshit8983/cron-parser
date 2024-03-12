package com.cp.cronparser.parser;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DomParser extends AbstractParser {

    private static final Set<Character> allowedChar = new HashSet<>(Arrays.asList(',', '-', '*', '/'));
    private static final List<Integer> range = Arrays.asList(0, 31);

    /**
     * Validator for all day of month cron component.
     * @param val input values of day of month component.
     */
    @Override
    public void validate(String val) {
        super.baseValidate(val, allowedChar);
        super.baseValidateRange(val,range);
    }

    /**
     * parser used to parse day of month component.
     * @param val
     * @return set {@link Set} return the value for which the cron will run.
     */
    @Override
    public Set<Integer> parse(String val) {
        return super.baseParser(val, allowedChar, range);
    }
}
