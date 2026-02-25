
public final class UnknownPrice implements Price{

    @Override
    @NotNull
    public FinancialValue calculate(@NotNull final Quantity quantity){
        return new UnknownFinancialValue(quantity);
    }
}
