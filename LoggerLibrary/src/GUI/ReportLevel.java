package GUI;

public class ReportLevel {
	public static final String Info = "INFO";
	public static final String Warn = "WARNING";
	public static final String Error = "ERROR";
	public static final String Critical = "CRITICAL";
	public static final String Fatal = "FATAL";
    public static int getValue(String reportLevel) {
        switch (reportLevel.toUpperCase()) {
            case "FATAL":
                return 4;
            case "CRITICAL":
                return 3;
            case "ERROR":
                return 2;
            case "WARNING":
                return 1;
            case "INFO":
                return 0;
            default:
                return -1;
        }
    }
    public static boolean isAboveThreshold(String threshold, String reportLevel) { 
        return ReportLevel.getValue(reportLevel) >= ReportLevel.getValue(threshold);
    }
}
