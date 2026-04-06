/**
 * <h2>Interface Segregation Principle (ISP)</h2>
 *
 * <p><strong>Example Type:</strong> Bad Example</p>
 *
 * <p>The Interface Segregation Principle means a class should not be forced to use methods it
 * does not need.</p>
 *
 * <p><strong>Why this file violates ISP:</strong> {@code Worker} forces every worker to support
 * both {@code work()} and {@code eat()}. A robot can work, but eating does not make sense.</p>
 *
 * <p><strong>Problems caused:</strong> some implementations are forced to throw exceptions for
 * methods they do not really support.</p>
 */
package SOLID.isp;

import java.util.Objects;

/**
 * Bad example: one interface is too large for all implementations.
 */
public final class WorkstationOperator {

    public void startWork(Worker worker) {
        Objects.requireNonNull(worker, "worker must not be null");
        worker.work();
    }

    public interface Worker {
        void work();

        void eat();
    }

    public static final class HumanWorker implements Worker {

        @Override
        public void work() {
            System.out.println("Human is working");
        }

        @Override
        public void eat() {
            System.out.println("Human is eating");
        }
    }

    public static final class RobotWorker implements Worker {

        @Override
        public void work() {
            System.out.println("Robot is working");
        }

        @Override
        public void eat() {
            throw new UnsupportedOperationException("Robot does not eat");
        }
    }
}
