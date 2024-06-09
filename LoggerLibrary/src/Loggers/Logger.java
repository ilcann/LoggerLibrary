package Loggers;
import java.util.List;

import Appenders.*;

public class Logger implements ILogger{
    private List<IAppender> appenders;
    
    public Logger(List<IAppender> appenders) {
        this.appenders = appenders;
    }

    public void log (String reportLevel, String date, String message) {
        for (IAppender appender : appenders) {
            appender.append(reportLevel, date, message);
        }
    }
    public void Info(String date, String message) {
        log("INFO", date, message);
    }

    public void Warn(String date, String message) {
        log("WARNING", date, message);
    }

    public void Error(String date, String message) {
        log("ERROR", date, message);
    }

    public void Critical(String date, String message) {
        log("CRITICAL", date, message);
    }

    public void Fatal(String date, String message) {
        log("FATAL", date, message);
    }
}
