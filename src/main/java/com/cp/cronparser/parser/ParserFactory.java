package com.cp.cronparser.parser;

import com.cp.cronparser.dto.ParserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.cp.cronparser.dto.ParserType.*;

/**
 * Factory class for parsers.
 */
@Component
public class ParserFactory {

    DaysParser daysParser;
    DomParser domParser;
    HourParser hourParser;
    MinutesParser minutesParser;
    MonthParser monthParser;

    @Autowired
    public ParserFactory(DaysParser daysParser, DomParser domParser, HourParser hourParser,
                         MinutesParser minutesParser, MonthParser monthParser) {
        this.daysParser = daysParser;
        this.domParser = domParser;
        this.hourParser = hourParser;
        this.minutesParser = minutesParser;
        this.monthParser = monthParser;
    }

    /**
     * Provides the parser object based on the input provided.
     * @param type class of {@link ParserType}
     * @return implementation of {@link  AbstractParser} based on {@link ParserType} provided.
     */
    public AbstractParser getParser(ParserType type) {
        switch (type) {
            case MINUTE:
                return this.minutesParser;
            case HOUR:
                return this.hourParser;
            case DAY_OF_MONTH:
                return this.domParser;
            case MONTH:
                return this.monthParser;
            case DAY_OF_WEEK:
                return this.daysParser;
            default:
                return null;
        }
    }
}
