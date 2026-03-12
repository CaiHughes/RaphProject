import java.util.ArrayList;
import java.util.List;

public final class Main
{
    public static void main(final String[] args)
    {
        final List<PortfolioValuable> holdings = new ArrayList<>();

        holdings.add(new Stock(322_00L, 31_630_000));
        holdings.add(new Stock(401_00L, 32_290_000));
        holdings.add(new UnknownPriceHolding(48_800_000, "Apple"));

        final String message = new Portfolio(holdings).valuationSummary();

        System.out.println(message);
    }
}
