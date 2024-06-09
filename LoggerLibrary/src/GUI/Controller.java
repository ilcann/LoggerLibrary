package GUI;

import Appenders.*;
import Layouts.*;
import Loggers.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //N - Number of Appenders
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character
        //List of Appenders
        List<IAppender> appenders = new ArrayList<IAppender>();
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            String appenderType = tokens[0];
            String layoutType = tokens[1];
            String reportLevel = ReportLevel.Info;

            if (tokens.length == 3) {
                reportLevel = tokens[2];
            }

            ILayout layout = createLayout(layoutType);
            IAppender appender = createAppender(appenderType, layout);
            appender.setThreshold(reportLevel);

            appenders.add(appender);
        }
        // Create a logger with the given appenders list
        ILogger logger = new Logger(appenders);
        String Query = scanner.nextLine();
        while (!Query.equals("END")) {
            String[] tokens = Query.split("\\|"); // Use double backslash to escape the pipe character
            String reportLevel = tokens[0];
            String date = tokens[1];
            String message = tokens[2];
            switch (reportLevel) {
                case ReportLevel.Fatal:
                    logger.Fatal(date, message);
                    break;
                case ReportLevel.Critical:
                    logger.Critical(date, message);
                    break;
                case ReportLevel.Error:
                    logger.Error(date, message);
                    break;
                case ReportLevel.Warn:
                    logger.Warn(date, message);
                    break;
                case ReportLevel.Info:
                    logger.Info(date, message);
                    break;
                default:
                    System.out.println("Unknown report level: " + reportLevel);
                    break;
            }
            Query = scanner.nextLine();
        }
        System.out.println("Logger Info:");
        for (IAppender appender : appenders) {
            System.out.print("Appender type: " + appender.getName() + ", " +
                             "Layout type: " + appender.getLayout().getName() + ", " +
                             "Report level: " + appender.getThreshold() + ", " +
                             "Messages appended: " + appender.getLogCount());
            if (appender.getLogFile() != null)
                System.out.print(", File size: " + appender.getLogFileSize());
            System.out.println();
        }

        scanner.close();
    }

    private static ILayout createLayout(String layoutType) {
        switch (layoutType) {
            case "SimpleLayout":
                return new SimpleLayout();
            // Add more layout types if needed
            default:
                throw new IllegalArgumentException("Unknown layout type: " + layoutType);
        }
    }

    private static IAppender createAppender(String appenderType, ILayout layout) {
        switch (appenderType) {
            case "ConsoleAppender":
                return new ConsoleAppender(layout);
            case "FileAppender":
                FileAppender fileAppender = new FileAppender(layout);
                LogFile logFile = new LogFile();
                fileAppender.setLogFile(logFile);
                return fileAppender;
            // Add more appender types if needed
            default:
                throw new IllegalArgumentException("Unknown appender type: " + appenderType);
        }
    }
}
