package homework14.Ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Elena Chinarina
 *
 **/

public class FileProcessor {
    public List<String> readDocuments(String filePath) {
        List<String> documents = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty())
                    documents.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return documents;
    }

    public void writeValidDocuments(String filePath, List<DocumentValidator.ValidationResult> validResults,
                                    List<String> originalDocuments) {
        Path path = Paths.get(filePath);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("=== ВАЛИДНЫЕ ДОКУМЕНТЫ: ===\n\n");

            for (int i = 0; i < validResults.size(); i++) {
                bufferedWriter.write(originalDocuments.get(i) + "\n");
                bufferedWriter.write(validResults.get(i).getMessage() + "\n");
                bufferedWriter.write("------------------------------\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeInvalidDocuments(String filePath, List<DocumentValidator.ValidationResult> invalidResults,
                                      List<String> originalDocuments) {
        Path path = Paths.get(filePath);

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            bufferedWriter.write("=== НЕВАЛИДНЫЕ ДОКУМЕНТЫ: ===\n\n");

            for (int i = 0; i < invalidResults.size(); i++) {
                bufferedWriter.write(originalDocuments.get(i) + "\n");
                bufferedWriter.write("Причина: " + invalidResults.get(i).getMessage() + "\n");
                bufferedWriter.write("------------------------------\n\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ensureDirectoryExists(String filePath) {
        Path path = Paths.get(filePath);
        Path parent = path.getParent();

        if (parent != null && !Files.exists(parent)) {
            try {
                Files.createDirectories(parent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
