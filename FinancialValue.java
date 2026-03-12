
public interface FinancialValue
{
    /**
     * Adds another {@link FinancialValue} to this one.
     * If either operand is unknown the result is unknown.
     */
    @NotNull FinancialValue add(@NotNull FinancialValue other);

    /**
     * Callback used by {@link KnownFinancialValue#add} to avoid an unsafe cast.
     * Implementations that hold a concrete cent value should return a new instance
     * with {@code cents} added; implementations that represent an unknown value
     * should return {@code this} (the known addend cannot resolve the unknown).
     */
    @NotNull FinancialValue addCents(long cents);

    @NotNull String display();

    boolean isKnown();
}
