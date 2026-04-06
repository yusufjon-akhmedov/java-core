/**
 * <h2>Open/Closed Principle (OCP)</h2>
 *
 * <p><strong>Example Type:</strong> Good Example</p>
 *
 * <p>The Open/Closed Principle means code should be extended by adding new classes instead of
 * changing existing logic again and again.</p>
 *
 * <p><strong>How this file follows OCP:</strong> {@code FlexibleDiscountCalculator} works with
 * the {@code DiscountPolicy} interface. New discount types are added as new policy classes.</p>
 *
 * <p><strong>Why this fixes the problem:</strong> the calculator stays unchanged when a new
 * discount rule is added.</p>
 */
package SOLID.ocp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

/**
 * Good example: the calculator is extended through small policy classes.
 */
public final class FlexibleDiscountCalculator {

    private final List<DiscountPolicy> discountPolicies;

    public FlexibleDiscountCalculator(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = List.copyOf(Objects.requireNonNull(
                discountPolicies,
                "discountPolicies must not be null"));
    }

    public BigDecimal applyDiscount(String customerType, BigDecimal price) {
        Objects.requireNonNull(customerType, "customerType must not be null");
        Objects.requireNonNull(price, "price must not be null");

        for (DiscountPolicy policy : discountPolicies) {
            if (policy.supports(customerType)) {
                return policy.apply(price).setScale(2, RoundingMode.HALF_UP);
            }
        }

        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public interface DiscountPolicy {
        boolean supports(String customerType);

        BigDecimal apply(BigDecimal price);
    }

    public static final class PremiumDiscountPolicy implements DiscountPolicy {

        @Override
        public boolean supports(String customerType) {
            return "PREMIUM".equalsIgnoreCase(customerType);
        }

        @Override
        public BigDecimal apply(BigDecimal price) {
            return price.multiply(new BigDecimal("0.90"));
        }
    }
}
