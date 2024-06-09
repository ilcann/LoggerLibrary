package GUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogFile {
    private StringBuilder logMessages;

    public LogFile() {
        this.logMessages = new StringBuilder();
    }
    public int getSize() {
        int size = 0;
        for (char c : logMessages.toString().toCharArray()) {
            if (Character.isLetter(c)) {
                size += (int) c;
            }
        }
        return size;
    }
    public void write(String log) {
        logMessages.append(log + "\n");
    }
    public void saveToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(logMessages.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
