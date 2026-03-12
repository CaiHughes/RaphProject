import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A collection of {@link PortfolioValuable} holdings.
 * <p>
 * Valuation logic that previously lived in {@code main()} has been pushed here
 * so that it can be reasoned about (and tested) independently of I/O concerns.
 * </p>
 */
public final class Portfolio
{
    private final List<PortfolioValuable> holdings;

    public Portfolio(@NotNull final List<PortfolioValuable> holdings)
    {
        this.holdings = Collections.unmodifiableList(new ArrayList<>(holdings));
    }

    /**
     * Returns a human-readable valuation summary.
     * <ul>
     *   <li>If every holding has a known price the total is reported exactly.</li>
     *   <li>If any price is unknown the summary lists the affected holdings and
     *       reports the minimum (known) value. Unknown holdings contribute their
     *       share count × 100 cents ($1.00/share floor) to the minimum total.</li>
     * </ul>
     */
    @NotNull
    public String valuationSummary()
    {
        FinancialValue knownTotal = new KnownFinancialValue(0);
        final List<String> missingIds = new ArrayList<>();

        for (final PortfolioValuable holding : holdings)
        {
            final FinancialValue value = holding.getFinancialValue();

            if (value.isKnown())
            {
                knownTotal = knownTotal.add(value);
            }
            else
            {
                final UnknownFinancialValue unknown = (UnknownFinancialValue) value;
                missingIds.addAll(unknown.missingPriceFor());
                // Include a $1.00/share floor for the unknown holding's quantity
                // so the minimum known total accounts for all shares in the portfolio.
                final long floorCents = unknown.quantity().toLong() * 100L;
                knownTotal = knownTotal.add(new KnownFinancialValue(floorCents));
            }
        }

        if (missingIds.isEmpty())
        {
            return "Portfolio value: " + knownTotal.display();
        }

        return "Missing price for: " + missingIds + "\n"
                + "Minimum known portfolio value: " + knownTotal.display();
    }
}
