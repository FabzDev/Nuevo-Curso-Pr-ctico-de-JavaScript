package edu.fabzdev.exercism.logsExcercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLineV2 {
    Pattern pattern = Pattern.compile("\\[([A-Z]{3})]:\s(.*)$");
    Matcher matcher;
    LogLevelV2 logLevelV2;
    String message;

    public LogLineV2(String logLine) {
        matcher = pattern.matcher(logLine);
        matcher.matches();
        logLevelV2 = LogLevelV2.getLogLevelFrom(matcher.group(1));
        message = matcher.group(2);
    }

    public LogLevelV2 getLogLevel() {
        return logLevelV2;
    }

    public String getOutputForShortLog() {
        return String.format("%d:%s", logLevelV2.getCode(), message);
    }

    public static void main(String[] args) {
        LogLineV2 ll = new LogLineV2("[ERR]: Stack Overflow");
        System.out.println(ll.getLogLevel());
        System.out.println(ll.getOutputForShortLog());
    }
}
