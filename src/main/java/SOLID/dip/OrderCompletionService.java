/**
 * <h2>Dependency Inversion Principle (DIP)</h2>
 *
 * <p><strong>Example Type:</strong> Good Example</p>
 *
 * <p>The Dependency Inversion Principle means high-level code should depend on abstractions,
 * not directly on concrete low-level classes.</p>
 *
 * <p><strong>How this file follows DIP:</strong> {@code OrderCompletionService} depends on the
 * {@code MessageService} interface.</p>
 *
 * <p><strong>Why this fixes the problem:</strong> the notification method can change without
 * changing the business logic.</p>
 */
package SOLID.dip;

import java.util.Objects;

/**
 * Good example: the business class depends on an abstraction.
 */
public final class OrderCompletionService {

    private final MessageService messageService;

    public OrderCompletionService(MessageService messageService) {
        this.messageService = Objects.requireNonNull(messageService, "messageService must not be null");
    }

    public void completeOrder(String customerEmail) {
        Objects.requireNonNull(customerEmail, "customerEmail must not be null");
        messageService.send(customerEmail, "Your order is complete.");
    }

    public interface MessageService {
        void send(String customerEmail, String message);
    }

    public static final class EmailService implements MessageService {

        @Override
        public void send(String customerEmail, String message) {
            System.out.printf("Email to %s: %s%n", customerEmail, message);
        }
    }
}
