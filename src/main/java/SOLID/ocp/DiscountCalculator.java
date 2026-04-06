/**
 * <h2>Open/Closed Principle (OCP)</h2>
 *
 * <p><strong>Example Type:</strong> Bad Example</p>
 *
 * <p>The Open/Closed Principle means code should be open for extension but closed for
 * modification.</p>
 *
 * <p><strong>Why this file violates OCP:</strong> {@code DiscountCalculator} uses
 * {@code if-else} rules for customer types. Adding a new discount means editing this class.</p>
 *
 * <p><strong>Problems caused:</strong> the class keeps growing and becomes harder to maintain.</p>
 */
package SOLID.ocp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Bad example: the calculator changes whenever a new discount rule is needed.
 */
public final class DiscountCalculator {

    public BigDecimal applyDiscount(String customerType, BigDecimal price) {
        Objects.requireNonNull(customerType, "customerType must not be null");
        Objects.requireNonNull(price, "price must not be null");

        if ("PREMIUM".equalsIgnoreCase(customerType)) {
            return price.multiply(new BigDecimal("0.90")).setScale(2, RoundingMode.HALF_UP);
        }

        return price.setScale(2, RoundingMode.HALF_UP);
    }
}
