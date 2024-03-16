# Cron Parser

### Background
Cron parser is responsible to parse and show the times at which it will run. 
Cron parser is written in java with spring boot 3.2.3. Spring boot 3.2.3 requires minimum of java 17 
and maven 3.6.3 version

### Building the script
Cron parser requires minimum of java 17 & maven 3.6.3 to build.

From the project root, do `mvn clean install` :
```bash
$ mvn clean install
..
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
..
```

### Running the script
Checkout the project:
`git clone {proj url}`
Build the project following above stated steps:
`mvn clean install`
move to  target folder
`cd ./target/`
Run the application
`java -jar deliveroo-cron-parser.jar "${minute} ${hour} ${day of month} ${month} ${day of week} ${command}"`
- ${minute} - minute config of cron
- ${hour} - hour config of cron
- ${day of month} - day of month config of cron
- ${month} - month config of cron
- ${day of week} - day of week config of cron
- ${command} - command to be executed at per scheduled cron

```bash
$ java -jar cron-parser-0.0.1-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
  minute        0, 15, 30, 45
  hour          0
  day of month  1, 15
  month         1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
  day of week   1, 2, 3, 4, 5
  command       /usr/bin/find

```
