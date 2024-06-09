package Appenders;
import GUI.*;
import Layouts.*;

public class ConsoleAppender implements IAppender{
    private String name;
    private ILayout layout;
    private String threshold;
    private LogFile logFile;
    private int logCount;

    public ConsoleAppender(ILayout layout) {
        this.name = "ConsoleAppender";
        this.layout = layout;
        this.threshold = ReportLevel.Info;
        this.logFile = null;
        this.logCount = 0;
    }

    public void append(String reportLevel, String date, String message) {
        if (ReportLevel.isAboveThreshold(this.threshold, reportLevel)) {
            String formattedLog = layout.format(reportLevel, date, message);
            System.out.println(formattedLog);
            logCount++;
        }
    }
    public String getThreshold() {
        return this.threshold;
    }
    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }
    public LogFile getLogFile() {
        return this.logFile;
    }
    public void setLogFile(LogFile logFile) {
        this.logFile = logFile;
    }
    public int getLogCount() {
        return this.logCount;
    }
    public int getLogFileSize() {
        return this.logFile.getSize();
    }
    public String getName() {
        return name;
    }
    public ILayout getLayout() {
        return layout;
    }
}
