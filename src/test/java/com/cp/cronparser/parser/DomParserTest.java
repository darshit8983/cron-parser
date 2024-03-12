package com.cp.cronparser.parser;

import com.cp.cronparser.exception.ParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class DomParserTest {

    @Autowired
    private DomParser domParser;

    @Test
    public void parseRecognizedRangeShouldReturnValidSet() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(0,15,30));
        String input = "*/15";
        Set<Integer> output =  domParser.parse(input);
        Assertions.assertEquals(inputSet, output);
    }

    @Test
    public void validateInvalidDateOfMonthRaiseException() {
        String input = "32";
        Assertions.assertThrows(ParserException.class, () -> domParser.validate(input));
    }
}
