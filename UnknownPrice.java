public final class UnknownPrice implements Price
{
    private final String holdingId;

    public UnknownPrice(@NotNull final String holdingId)
    {
        this.holdingId = holdingId;
    }

    @Override
    @NotNull
    public FinancialValue calculate(@NotNull final Quantity quantity)
    {
        return new UnknownFinancialValue(quantity, holdingId);
    }
}
