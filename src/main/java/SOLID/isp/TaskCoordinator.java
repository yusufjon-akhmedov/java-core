/**
 * <h2>Interface Segregation Principle (ISP)</h2>
 *
 * <p><strong>Example Type:</strong> Good Example</p>
 *
 * <p>The Interface Segregation Principle means interfaces should be small and focused.</p>
 *
 * <p><strong>How this file follows ISP:</strong> working and eating are separated into
 * {@code Workable} and {@code Eatable}. A robot implements only what it really needs.</p>
 *
 * <p><strong>Why this fixes the problem:</strong> no class is forced to implement behavior that
 * does not belong to it.</p>
 */
package SOLID.isp;

import java.util.Objects;

/**
 * Good example: small interfaces match real capabilities.
 */
public final class TaskCoordinator {

    public void startWork(Workable workable) {
        Objects.requireNonNull(workable, "workable must not be null");
        workable.work();
    }

    public void startLunch(Eatable eatable) {
        Objects.requireNonNull(eatable, "eatable must not be null");
        eatable.eat();
    }

    public interface Workable {
        void work();
    }

    public interface Eatable {
        void eat();
    }

    public static final class HumanWorker implements Workable, Eatable {

        @Override
        public void work() {
            System.out.println("Human is working");
        }

        @Override
        public void eat() {
            System.out.println("Human is eating");
        }
    }

    public static final class RobotWorker implements Workable {

        @Override
        public void work() {
            System.out.println("Robot is working");
        }
    }
}
