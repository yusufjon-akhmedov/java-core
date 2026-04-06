/**
 * <h2>Single Responsibility Principle (SRP)</h2>
 *
 * <p><strong>Example Type:</strong> Bad Example</p>
 *
 * <p>The Single Responsibility Principle means one class should have one clear job.</p>
 *
 * <p><strong>Why this file violates SRP:</strong> {@code UserManager} saves the user and also
 * sends a welcome email. These are two different responsibilities.</p>
 *
 * <p><strong>Problems caused:</strong> if saving changes or email sending changes, the same
 * class must be changed.</p>
 */
package SOLID.srp;

import java.util.Objects;

/**
 * Bad example: one class handles too many responsibilities.
 */
public final class UserManager {

    public void register(User user) {
        Objects.requireNonNull(user, "user must not be null");
        saveUser(user);
        sendWelcomeEmail(user);
    }

    private void saveUser(User user) {
        System.out.println("Saving user: " + user.email());
    }

    private void sendWelcomeEmail(User user) {
        System.out.println("Sending email to: " + user.email());
    }

    public record User(String email) {

        public User {
            Objects.requireNonNull(email, "email must not be null");
        }
    }
}
