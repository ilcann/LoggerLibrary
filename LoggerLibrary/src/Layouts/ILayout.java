package Layouts;

public interface ILayout {
    public String format(String reportLevel, String date, String message);
    public String getName();
}
