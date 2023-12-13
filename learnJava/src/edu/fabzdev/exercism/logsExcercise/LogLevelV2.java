package edu.fabzdev.exercism.logsExcercise;

public enum LogLevelV2 {
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42),
    UNKNOWN(0);

    private final int code;

    LogLevelV2(int code){
        this.code = code;
    }

    public static LogLevelV2 getLogLevelFrom(String msg){
        return switch (msg) {
            case "TRC" -> LogLevelV2.TRACE;
            case "DBG" -> LogLevelV2.DEBUG;
            case "INF" -> LogLevelV2.INFO;
            case "WRN" -> LogLevelV2.WARNING;
            case "ERR" -> LogLevelV2.ERROR;
            case "FTL" -> LogLevelV2.FATAL;
            default -> LogLevelV2.UNKNOWN;
        };
    }

    public int getCode() {
        return code;
    }
}
