package Appenders;

import GUI.LogFile;
import Layouts.ILayout;

public interface IAppender {
	public void append(String reportLevel, String date, String message);
	public String getThreshold();
	public void setThreshold(String threshold);
	public LogFile getLogFile();
    public void setLogFile(LogFile logFile);
	public int getLogCount();
	public int getLogFileSize();
	public String toString();
	public String getName();
	public ILayout getLayout();
}
