import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String filename = "input.txt";
        int wordCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (line.trim().isEmpty()) {
                    continue;
                }
                wordCount += words.length;
            }
            System.out.println("Total word count: " + wordCount);
        } catch (IOException e) {
            System.out.println("Error: Unable to read file '" + filename + "'");
            System.out.println("Reason: " + e.getMessage());
        }

        
    }
}
