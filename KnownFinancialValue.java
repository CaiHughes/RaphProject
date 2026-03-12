
public final class KnownFinancialValue implements FinancialValue
{
    private final UnsignedInteger63 cents;

    public KnownFinancialValue(final long cents)
    {
        this.cents = new UnsignedInteger63(cents);
    }

    /**
     * Delegates to {@link FinancialValue#addCents} so that no cast is needed and
     * no assumption is made about the runtime type of {@code other}.
     * <ul>
     *   <li>Known + Known  → Known (summed cents)</li>
     *   <li>Known + Unknown → Unknown (propagated by the other implementation)</li>
     * </ul>
     */
    @Override
    @NotNull
    public FinancialValue add(@NotNull final FinancialValue other)
    {
        return other.addCents(this.cents.toLong());
    }

    /**
     * Called back by another {@link KnownFinancialValue#add}.
     * Because we are known we can honour the addition.
     */
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
