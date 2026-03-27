public final class Stock implements PortfolioValuable
{
    private final KnownPrice price;
    private final Quantity quantity;

    public Stock(final long priceCents, final long quantity)
    {
        this.price = new KnownPrice(priceCents);
        this.quantity = new Quantity(quantity);
    }

    @Override
    public FinancialValue getFinancialValue()
    {
        return price.calculate(quantity);
    }
}
