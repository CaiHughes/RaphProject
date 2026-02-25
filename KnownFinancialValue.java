
public final class KnownFinancialValue implements FinancialValue{
    private final long cents;

    public KnownFinancialValue(long cents){
        if(cents < 0){
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.cents = cents;
    }

    /**
     * Known + Known  → Known (summed cents)
     * Known + Unknown → Unknown (we cannot assert a total if any part is missing)
     */
    @Override
    @NotNull
    public FinancialValue add(@NotNull final FinancialValue other){
        if(!other.isKnown()) {
            return other;                       // propagate the unknown outward
        }
        // Safe: isKnown() guarantees the other side is a KnownFinancialValue
        return new KnownFinancialValue(this.cents + ((KnownFinancialValue) other).cents);
    }

    @Override
    @NotNull
    public String display(){
        long dollars = cents / 100;
        long fraction = cents % 100;
        return String.format("$%,d.%02d", dollars, fraction);
    }

    @Override
    public boolean isKnown(){
        return true;
    }

    public long getCents(){
        return cents;
    }
}
