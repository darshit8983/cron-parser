package com.cp.cronparser.parser;

import com.cp.cronparser.CronParserApplication;
import com.cp.cronparser.exception.ParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class MinutesParserTest{

    @Autowired
    private MinutesParser minutesParser;

    @Test
    public void validateValidInputShouldNotThrowException() {
        String validInput = "*/15";
        Assertions.assertDoesNotThrow(() -> minutesParser.validate(validInput));
    }

    @Test
    public void validateUnrecognizedCharacterShouldThrowException() {
        String invalidInput = "*()15";
        Assertions.assertThrows(ParserException.class, () -> minutesParser.validate(invalidInput));
    }

    @Test
    public void parseRecognizedRangeShouldReturnValidSet() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(2,3,4,5,6));
        String input = "2-6";
        Set<Integer> output =  minutesParser.parse(input);
        Assertions.assertEquals(output, inputSet);
    }

    @Test
    public void parseRecognizedInvalidExceptionShouldBeThrown() {
        String input = "59-";
        Assertions.assertThrows(ParserException.class, () -> minutesParser.parse(input));
    }
}
