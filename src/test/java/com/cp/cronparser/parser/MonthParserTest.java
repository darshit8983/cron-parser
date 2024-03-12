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
public class MonthParserTest {

    @Autowired
    private MonthParser monthParser;

    @Test
    public void parseRecognizedRangeShouldReturnValidSet() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(1,2,3));
        String input = "Jan,Feb,Mar";
        Set<Integer> output =  monthParser.parse(input);
        Assertions.assertEquals(inputSet, output);
    }

    @Test
    public void parseRecognizedInvalidExceptionShouldBeThrown() {
        String input = "**";
        Assertions.assertThrows(ParserException.class, () -> monthParser.parse(input));
    }
}
