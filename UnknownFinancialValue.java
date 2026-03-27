import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class UnknownFinancialValue implements FinancialValue
{
    private final Quantity quantity;

    private final Set<String> missingPriceFor;

    public UnknownFinancialValue(@NotNull final Quantity quantity, @NotNull final String holdingId)
    {
        this.quantity = quantity;
        this.missingPriceFor = new LinkedHashSet<>();
        this.missingPriceFor.add(holdingId);
    }

    private UnknownFinancialValue(@NotNull final Quantity quantity, @NotNull final Set<String> missingPriceFor)
    {
        this.quantity = quantity;
        this.missingPriceFor = new LinkedHashSet<>(missingPriceFor);
    }


    @Override
    @NotNull
    public FinancialValue add(@NotNull final FinancialValue other)
    {
        if (other instanceof UnknownFinancialValue)
        {
            return mergeWith((UnknownFinancialValue) other);
        }
        return this;
    }


    @Override
    @NotNull
    public FinancialValue addCents(final long cents)
    {
        return this;
    }

    @Override
    @NotNull
    public String display()
    {
        return "Unknown value ("
                + quantity.toLong()
                + " shares, price unavailable for: "
                + missingPriceFor
                + ")";
    }

    @Override
    public boolean isKnown()
    {
        return false;
    }

    public Quantity quantity()
    {
        return quantity;
    }

    public Set<String> missingPriceFor()
    {
        return Collections.unmodifiableSet(missingPriceFor);
    }

    private UnknownFinancialValue mergeWith(@NotNull final UnknownFinancialValue other)
    {
        final Set<String> merged = new LinkedHashSet<>(this.missingPriceFor);
        merged.addAll(other.missingPriceFor);
        return new UnknownFinancialValue(
                new Quantity(this.quantity.toLong() + other.quantity.toLong()),
                merged
        );
    }
}
