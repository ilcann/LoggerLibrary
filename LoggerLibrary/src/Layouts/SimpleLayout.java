package Layouts;

public class SimpleLayout implements ILayout{
    private String name = "SimpleLayout";
    public String format(String reportLevel, String date, String message) {
        return date + " - " + reportLevel + " - " + message;
    }
    public String getName() {
        return name;
    }
}