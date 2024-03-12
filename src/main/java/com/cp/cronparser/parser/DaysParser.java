package com.cp.cronparser.parser;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DaysParser extends AbstractParser {

    private static final Set<Character> allowedChar = new HashSet<>(Arrays.asList(',', '-', '*', '/'));
    private static final List<Integer> range = Arrays.asList(0, 6);

    private static final Map<String, Integer> daysMap = new HashMap<String, Integer>() {{
        put("SUN", 0);
        put("MON", 1);
        put("TUE", 2);
        put("WED", 3);
        put("THU", 4);
        put("FRI", 5);
        put("SAT", 6);
    }};


    /**
     * Validator for all days cron component.
     * @param val input values of days component.
     */
    @Override
    public void validate(String val) {
        super.baseValidate(val, allowedChar);
        super.baseValidateRange(val,range);
    }

    /**
     * parser used to parse days component.
     * @param val
     * @return set {@link Set} return the value for which the cron will run.
     */
    @Override
    public Set<Integer> parse(String val) {
        for(String key : daysMap.keySet()) {
            val = val.replaceAll("((?i)" + key + ")", daysMap.get(key).toString());
        }
        return super.baseParser(val, allowedChar, range);
    }


}
