
public interface FinancialValue
{

    @NotNull FinancialValue add(@NotNull FinancialValue other);

 
    @NotNull FinancialValue addCents(long cents);

    @NotNull String display();

    boolean isKnown();
}
