import java.io.*;
import java.util.*;

public class FileProcessor {
    public static void main(String[] args) {
        
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        
        
        List<String> words = readWordsFromFile(inputFile);
        
        
        if (words != null) {
            System.out.println("Nombre de mots dans le fichier : " + words.size());
            Collections.sort(words);
            writeWordsToFile(outputFile, words);
            System.out.println("Les mots triés ont été enregistrés dans " + outputFile);
        } else {
            System.out.println("Erreur de lecture du fichier.");
        }
    }

    public static List<String> readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
       
        File file = new File(filename);
        if (file.exists() && file.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    words.addAll(Arrays.asList(line.split("\\s+")));
                }
            } catch (IOException e) {
                
                return null;
            }
        }
        return words;
    }

    public static void writeWordsToFile(String filename, List<String> words) {
        // Vérification rudimentaire de l'existence du fichier pour éviter un crash
        File file = new File(filename);
        try {
            // createNewFile() peut générer une IOException
            if (file.exists() || file.createNewFile()) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                    for (String word : words) {
                        bw.write(word);
                        bw.newLine();
                    }
                } catch (IOException e) {
                    System.out.println("Erreur lors de l'écriture du fichier: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la création du fichier: " + e.getMessage());
        }
    }
}



