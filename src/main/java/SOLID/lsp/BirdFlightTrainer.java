/**
 * <h2>Liskov Substitution Principle (LSP)</h2>
 *
 * <p><strong>Example Type:</strong> Bad Example</p>
 *
 * <p>The Liskov Substitution Principle means a child class should be usable anywhere the
 * parent class is expected.</p>
 *
 * <p><strong>Why this file violates LSP:</strong> {@code Penguin} extends {@code Bird}, but
 * it cannot safely do what the parent type promises: fly.</p>
 *
 * <p><strong>Problems caused:</strong> the code compiles, but fails at runtime when a penguin
 * is used where a flying bird is expected.</p>
 */
package SOLID.lsp;

import java.util.Objects;

/**
 * Bad example: a subtype breaks the parent contract.
 */
public final class BirdFlightTrainer {

    public void makeBirdFly(Bird bird) {
        Objects.requireNonNull(bird, "bird must not be null");
        bird.fly();
    }

    public static class Bird {

        public void fly() {
            System.out.println("Bird is flying");
        }
    }

    public static final class Sparrow extends Bird {
    }

    public static final class Penguin extends Bird {

        @Override
        public void fly() {
            throw new UnsupportedOperationException("Penguin cannot fly");
        }
    }
}
