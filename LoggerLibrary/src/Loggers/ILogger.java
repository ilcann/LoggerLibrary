package Loggers;

public interface ILogger {
    public void log(String reportLevel, String date, String message);
    public void Info(String date, String message);
    public void Warn(String date, String message);
    public void Error(String date, String message);
    public void Critical(String date, String message);
    public void Fatal(String date, String message);
}
