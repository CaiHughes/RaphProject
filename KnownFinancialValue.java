
public final class KnownFinancialValue implements FinancialValue
{
    private final UnsignedInteger63 cents;

    public KnownFinancialValue(final long cents)
    {
        this.cents = new UnsignedInteger63(cents);
    }

   
    @Override
    @NotNull
    public FinancialValue add(@NotNull final FinancialValue other)
    {
        return other.addCents(this.cents.toLong());
    }

   
    @Override
    @NotNull
    public FinancialValue addCents(final long cents)
    {
        return new KnownFinancialValue(this.cents.toLong() + cents);
    }

    @Override
    @NotNull
    public String display()
    {
        long dollars = cents.toLong() / 100;
        long fraction = cents.toLong() % 100;
        return String.format("$%,d.%02d", dollars, fraction);
    }

    @Override
    public boolean isKnown()
    {
        return true;
    }

    public long getCents()
    {
        return cents.toLong();
    }
}
