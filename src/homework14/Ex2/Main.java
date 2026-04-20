package homework14.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    private static final String VALID_FILE = "src\\homework14\\Ex2\\valid_documents.txt";
    private static final String INVALID_FILE = "src\\homework14\\Ex2\\invalid_documents.txt";

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

//        String inputFilePath = "src\\homework14\\Ex2\\input.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу с номерами документов: ");
        String inputFilePath = scanner.nextLine().trim();
        scanner.close();

        List<String> documents = fileProcessor.readDocuments(inputFilePath);

        if (documents.isEmpty()) {
            System.out.println("Файл не содержит номеров документов или пуст");
            return;
        }

        List<String> validDocuments = new ArrayList<>();
        List<String> invalidDocuments = new ArrayList<>();
        List<DocumentValidator.ValidationResult> validResults = new ArrayList<>();
        List<DocumentValidator.ValidationResult> invalidResults = new ArrayList<>();

        for (String doc : documents) {
            DocumentValidator.ValidationResult result = DocumentValidator.validate(doc);
            if (result.isValid()) {
                validDocuments.add(doc);
                validResults.add(result);
            } else {
                invalidDocuments.add(doc);
                invalidResults.add(result);
            }
        }

        fileProcessor.ensureDirectoryExists(VALID_FILE);
        fileProcessor.ensureDirectoryExists(INVALID_FILE);

        fileProcessor.writeValidDocuments(VALID_FILE, validResults, validDocuments);
        fileProcessor.writeInvalidDocuments(INVALID_FILE, invalidResults, invalidDocuments);

        System.out.println("\n=== РЕЗУЛЬТАТЫ ОБРАБОТКИ ===");
        System.out.println("Всего документов: " + documents.size());
        System.out.println("Валидных: " + validDocuments.size());
        System.out.println("Невалидных: " + invalidDocuments.size());

        if (!invalidDocuments.isEmpty()) {
            System.out.println("\nДетали невалидных документов:");
            for (int i = 0; i < invalidDocuments.size(); i++) {
                System.out.println(invalidDocuments.get(i) + " -> " + invalidResults.get(i).getMessage());
            }
        }
    }
}
