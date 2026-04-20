package homework14.Ex2;

import java.util.regex.Pattern;

/**
 * @author Elena Chinarina
 *
 **/

public class DocumentValidator {
    private static final int REQUIRED_LENGTH = 15;
    private static final Pattern VALID_PREFIX_PATTERN = Pattern.compile("^(docnum|contract).*$");
    private static final Pattern VALID_CHARS_PATTERN = Pattern.compile("^[a-zA-Z0-9]+$");

    public static ValidationResult validate(String documentNumber) {
        if (documentNumber == null || documentNumber.trim().isEmpty())
            return new ValidationResult(false, "Пустая строка");

        String trimmed = documentNumber.trim();

        if (trimmed.length() != REQUIRED_LENGTH)
            return new ValidationResult(false, "Неверная длина: " + trimmed.length());

        if (!VALID_CHARS_PATTERN.matcher(trimmed).matches())
            return new ValidationResult(false, "Содержит недопустимые символы");

        if (!VALID_PREFIX_PATTERN.matcher(trimmed).matches())
            return new ValidationResult(false, "Должен начинаться с \"docnum\" или \"contract\"");

        return new ValidationResult(true, "Валидный документ");
    }

    public static class ValidationResult {
        private final boolean isValid;
        private final String message;

        public ValidationResult(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }
    }
}
