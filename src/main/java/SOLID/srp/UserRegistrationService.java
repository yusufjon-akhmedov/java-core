/**
 * <h2>Single Responsibility Principle (SRP)</h2>
 *
 * <p><strong>Example Type:</strong> Good Example</p>
 *
 * <p>The Single Responsibility Principle means one class should have one clear job.</p>
 *
 * <p><strong>How this file follows SRP:</strong> {@code UserRegistrationService} only manages
 * the registration flow. Saving is done by {@code UserRepository}, and email sending is done
 * by {@code EmailService}.</p>
 *
 * <p><strong>Why this fixes the problem:</strong> each class has only one responsibility, so
 * changes stay small and clear.</p>
 */
package SOLID.srp;

import java.util.Objects;

/**
 * Good example: responsibilities are split into separate collaborators.
 */
public final class UserRegistrationService {

    private final UserRepository userRepository;
    private final EmailService emailService;

    public UserRegistrationService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = Objects.requireNonNull(userRepository, "userRepository must not be null");
        this.emailService = Objects.requireNonNull(emailService, "emailService must not be null");
    }

    public void register(User user) {
        Objects.requireNonNull(user, "user must not be null");
        userRepository.save(user);
        emailService.sendWelcomeEmail(user);
    }

    public interface UserRepository {
        void save(User user);
    }

    public interface EmailService {
        void sendWelcomeEmail(User user);
    }

    public static final class ConsoleUserRepository implements UserRepository {

        @Override
        public void save(User user) {
            System.out.println("Saving user: " + user.email());
        }
    }

    public static final class ConsoleEmailService implements EmailService {

        @Override
        public void sendWelcomeEmail(User user) {
            System.out.println("Sending email to: " + user.email());
        }
    }

    public record User(String email) {

        public User {
            Objects.requireNonNull(email, "email must not be null");
        }
    }
}
