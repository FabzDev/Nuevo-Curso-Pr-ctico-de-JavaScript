package edu.fabzdev.exercism.logsExcercise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLine {
    private String logLine;
    Pattern pattern = Pattern.compile("\\[([A-Z]{3})]:\s(.*)$");
    Matcher matcher;

    public LogLine(String logLine) {
        this.logLine = logLine;
        matcher = pattern.matcher(logLine);
    }

    public LogLevel getLogLevel() {
        if (matcher.matches()) {
            String mat = matcher.group(1);
            return switch (mat) {
                case "TRC" -> LogLevel.TRACE;
                case "DBG" -> LogLevel.DEBUG;
                case "INF" -> LogLevel.INFO;
                case "WRN" -> LogLevel.WARNING;
                case "ERR" -> LogLevel.ERROR;
                case "FTL" -> LogLevel.FATAL;
                default -> LogLevel.UNKNOWN;
            };
        } else {
            return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        if (matcher.matches()) {
            String g1 = matcher.group(1);
            String g2 = matcher.group(2);
            return switch (g1) {
                case "TRC" -> "1:" + g2;
                case "DBG" -> "2:" + g2;
                case "INF" -> "4:" + g2;
                case "WRN" -> "5:" + g2;
                case "ERR" -> "6:" + g2;
                case "FTL" -> "42:" + g2;
                default -> "0:" + g2;
            };
        } else {
            return "Log not valid";
        }
    }

    public static void main(String[] args) {
        LogLine ll = new LogLine("[DBG]: File deleted");
        System.out.println(ll.getLogLevel());
        System.out.println(ll.getOutputForShortLog());
    }
}
