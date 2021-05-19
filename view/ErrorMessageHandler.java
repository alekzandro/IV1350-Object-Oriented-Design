package se.kth.iv1350.PointOfSale.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Class <code>ErrorMessageUserHandler</code>, shows error messages to the user.
 */
class ErrorMessageUserHandler {
    
    /**
     * Displays the specified error message.
     * 
     * @param message The error message.
     */
    void showErrorMessage(String message) {
        StringBuilder errorMessageBuilder = new StringBuilder();
        errorMessageBuilder.append(createTime());
        errorMessageBuilder.append(", ERROR: ");
        errorMessageBuilder.append(message);
        System.out.println(errorMessageBuilder);
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }
}