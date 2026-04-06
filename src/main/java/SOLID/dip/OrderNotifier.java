/**
 * <h2>Dependency Inversion Principle (DIP)</h2>
 *
 * <p><strong>Example Type:</strong> Bad Example</p>
 *
 * <p>The Dependency Inversion Principle means high-level code should depend on abstractions,
 * not directly on low-level classes.</p>
 *
 * <p><strong>Why this file violates DIP:</strong> {@code OrderNotifier} directly creates
 * {@code EmailService}.</p>
 *
 * <p><strong>Problems caused:</strong> the business logic is tightly coupled to one concrete
 * notification class.</p>
 */
package SOLID.dip;

import java.util.Objects;

/**
 * Bad example: the business class directly uses a concrete email service.
 */
public final class OrderNotifier {

    public void completeOrder(String customerEmail) {
        Objects.requireNonNull(customerEmail, "customerEmail must not be null");

        EmailService emailService = new EmailService();
        emailService.send(customerEmail, "Your order is complete.");
    }

    public static final class EmailService {

        public void send(String customerEmail, String message) {
            System.out.printf("Email to %s: %s%n", customerEmail, message);
        }
    }
}
