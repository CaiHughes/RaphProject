
public final class KnownPrice implements Price
{
    private final NonZeroUnsignedInteger63 cents;

    public KnownPrice(final long cents)
    {
        this.cents = new NonZeroUnsignedInteger63(cents);
    }

    @Override
    @NotNull
    public FinancialValue calculate(@NotNull final Quantity quantity)
    {
        return new KnownFinancialValue(cents.toLong() * quantity.toLong());
    }
}

