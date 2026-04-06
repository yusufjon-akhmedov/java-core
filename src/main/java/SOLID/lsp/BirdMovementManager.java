/**
 * <h2>Liskov Substitution Principle (LSP)</h2>
 *
 * <p><strong>Example Type:</strong> Good Example</p>
 *
 * <p>The Liskov Substitution Principle means a type should promise only behavior that every
 * implementation can really provide.</p>
 *
 * <p><strong>How this file follows LSP:</strong> only birds that can really fly implement
 * {@code FlyingBird}. A {@code Penguin} implements only {@code Bird}.</p>
 *
 * <p><strong>Why this fixes the problem:</strong> each type is used in a safe and honest way.</p>
 */
package SOLID.lsp;

import java.util.Objects;

/**
 * Good example: shared behavior and flying behavior are separated.
 */
public final class BirdMovementManager {

    public void makeBirdMove(Bird bird) {
        Objects.requireNonNull(bird, "bird must not be null");
        bird.move();
    }

    public void makeBirdFly(FlyingBird bird) {
        Objects.requireNonNull(bird, "bird must not be null");
        bird.fly();
    }

    public interface Bird {
        void move();
    }

    public interface FlyingBird extends Bird {
        void fly();
    }

    public static final class Sparrow implements FlyingBird {

        @Override
        public void move() {
            System.out.println("Sparrow is hopping");
        }

        @Override
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    public static final class Penguin implements Bird {

        @Override
        public void move() {
            System.out.println("Penguin is walking");
        }
    }
}
