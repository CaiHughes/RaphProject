
public final class UnknownFinancialValue implements FinancialValue{
    private final Quantity quantity;

    public UnknownFinancialValue(@NotNull final Quantity quantity){
        this.quantity = quantity;
    }

    @Override
    @NotNull
    public FinancialValue add(@NotNull final FinancialValue other){
        if (other instanceof UnknownFinancialValue){
            final UnknownFinancialValue otherUnknown = (UnknownFinancialValue) other;
            return new UnknownFinancialValue(
                    new Quantity(this.quantity.toLong() + otherUnknown.quantity.toLong())
            );
        }
        // Unknown + Known → remain Unknown; the known portion cannot redeem the gap
        return this;
    }

    @Override
    @NotNull
    public String display(){
        return "Unknown value (" + quantity.toLong() + " shares, price unavailable)";
    }

    @Override
    public boolean isKnown(){
        return false;
    }

    public Quantity quantity(){
        return quantity;
    }
}
