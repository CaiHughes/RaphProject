public final class UnknownPriceHolding implements PortfolioValuable
{
    private final Quantity quantity;
    private final String holdingId;

    public UnknownPriceHolding(final long quantity, @NotNull final String holdingId)
    {
        this.quantity = new Quantity(quantity);
        this.holdingId = holdingId;
    }

    @Override
    public FinancialValue getFinancialValue()
    {
        return new UnknownPrice(holdingId).calculate(quantity);
    }
}
