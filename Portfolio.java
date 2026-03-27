import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class Portfolio
{
    private final List<PortfolioValuable> holdings;

    public Portfolio(@NotNull final List<PortfolioValuable> holdings)
    {
        this.holdings = Collections.unmodifiableList(new ArrayList<>(holdings));
    }

  
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
