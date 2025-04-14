import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Compare {

    public static void main(String[] args) {
        String file1 = "input.txt";
        String file2 = "output.txt";

        
        List<String> wordsInFile1 = readWordsFromFile(file1);
        List<String> wordsInFile2 = readWordsFromFile(file2);

        
        System.out.println("Words in " + file1 + ": " + wordsInFile1);
        System.out.println("Words in " + file2 + ": " + wordsInFile2);

        
        List<String> uniqueWords = compareFiles(wordsInFile1, wordsInFile2);

        
        System.out.println("Words in " + file1 + " but not in " + file2 + ":");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                   
                    String[] tokens = line.split("\\s+");
                    for (String token : tokens) {
                        String trimmedWord = token.trim();
                        if (!trimmedWord.isEmpty()) {
                            words.add(trimmedWord);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("File does not exist: " + filename);
            return null;
        }
        return words;
    }

    
    public static List<String> compareFiles(List<String> words1, List<String> words2) {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : words1) {
            if (!words2.contains(word)) { 
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }
}
