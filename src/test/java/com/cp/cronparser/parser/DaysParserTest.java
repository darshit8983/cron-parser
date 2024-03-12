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
public class DaysParserTest {

    @Autowired
    private DaysParser daysParser;

    @Test
    public void parseRecognizedRangeShouldReturnValidSet() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(1,2));
        String input = "Mon,tUe";
        Set<Integer> output =  daysParser.parse(input);
        Assertions.assertEquals(inputSet, output);
    }

    @Test
    public void parseRecognizedInvalidExceptionShouldBeThrown() {
        String input = "9/2";
        Assertions.assertThrows(ParserException.class, () -> daysParser.validate(input));
    }
}
