package Appenders;
import GUI.*;
import Layouts.*;

public class FileAppender implements IAppender{
    private String name;
    private ILayout layout;
    private String threshold;
    private LogFile logFile;
    private int logCount;
    
    public FileAppender(ILayout layout) {
        this.name = "FileAppender";
        this.layout = layout;
        this.threshold = ReportLevel.Info;
        this.logFile = null;
        this.logCount = 0;
    }
    public void append(String reportLevel, String date, String message) {
        if(ReportLevel.isAboveThreshold(threshold, reportLevel))
        {
            String formattedLog = layout.format(reportLevel, date, message);
            logFile.write(formattedLog);
            logFile.saveToFile("logs.txt");
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
