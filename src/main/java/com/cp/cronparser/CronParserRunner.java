package com.cp.cronparser;

import com.cp.cronparser.dto.ParserType;
import com.cp.cronparser.parser.AbstractParser;
import com.cp.cronparser.parser.ParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible to parse the Cron job provided as the application arguments.
 */
@Component
@Profile("!test")
public class CronParserRunner implements CommandLineRunner {

    @Autowired
    ParserFactory factory;

    List<ParserType> parserTypeList = Arrays.asList(
            ParserType.MINUTE,
            ParserType.HOUR,
            ParserType.DAY_OF_MONTH,
            ParserType.MONTH,
            ParserType.DAY_OF_WEEK
    );

    /**
     * Overridden method which get triggered once the application comes up.
     * @param args The args passed to the main class as arguments.
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

        if(args.length > 1 || args.length == 0) {
            throw new IllegalArgumentException(String.format("only 1 argument expected but got %s. " +
                    "Correct arg ex - '* * * * * /var/cv/run.sh'", args.length));
        }
        String cron = args[0];
        String[] cronComponent = cron.split(" ");

        if(cronComponent.length != 6) {
            throw new IllegalArgumentException(String.format("expected 6 argument in cron but got %s. " +
                    "Correct arg ex - '* * * * * /var/cv/run.sh'", cronComponent.length));
        }

        String out = processCron(cronComponent);
        out += String.format("%-14s%s\n", "command", cronComponent[5]);
        System.out.println(out);

    }

    private String processCron(String[] cron) {
        StringBuilder b = new StringBuilder();
        AbstractParser parser;
        for(int i =0 ; i< 5; i++) {
            parser = factory.getParser(parserTypeList.get(i));
            parser.validate(cron[i]);
            b.append(ParserUtil.printer(parserTypeList.get(i) ,parser.parse(cron[i])));
        }
        return b.toString();
    }
}
