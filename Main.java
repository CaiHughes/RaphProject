// Main.java  (fixed logic)
import java.util.ArrayList;
import java.util.List;

public final class Main {

    public static void main(String[] args) {

        List<PortfolioValuable> holdings = new ArrayList<>();

        // Normal stocks with known price
        holdings.add(new Stock(322, 31_630_000));      // Google
        holdings.add(new Stock(401, 32_290_000));      // Microsoft

        // Positions without current price  → we want THREE of them
        holdings.add(new NullPriceStock(48_800_000));  // Apple-like

        long totalKnownValue = 0;
        int missingPriceCount = 0;

        for (PortfolioValuable h : holdings) {
            if (h.hasReliablePrice()) {
                totalKnownValue += h.totalValue();
            } else {
                missingPriceCount++;
            }
        }

        String portfolioDisplay;
        if (missingPriceCount > 0) {
            portfolioDisplay = "Missing price for " + missingPriceCount +
                               " holding(s). Known portfolio value at minimum: $" + totalKnownValue;
        } else {
            portfolioDisplay = "Portfolio size: $" + totalKnownValue;
        }

        System.out.println(portfolioDisplay);
    }
}