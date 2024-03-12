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
public class HourParserTest {

    @Autowired
    private HourParser hourParser;

    @Test
    public void parseRecognizedRangeShouldReturnValidSet() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(3,9,15,21));
        String input = "3/6";
        Set<Integer> output =  hourParser.parse(input);
        Assertions.assertEquals(inputSet, output);
    }

    @Test
    public void parseRecognizedInvalidExceptionShouldBeThrown() {
        String input = "*/";
        Assertions.assertThrows(ParserException.class, () -> hourParser.parse(input));
    }
}
