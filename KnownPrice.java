
public final class KnownPrice implements Price{
    private final long cents;   // price per share, in cents

    public KnownPrice(long cents){
        if(cents <= 0){
            throw new IllegalArgumentException("Price must be positive");
        }
        this.cents = cents;
    }

    @Override
    @NotNull
    public FinancialValue calculate(@NotNull final Quantity quantity){
        return new KnownFinancialValue(cents * quantity.toLong());
    }
}
