
public interface FinancialValue{


    @NotNull FinancialValue add(@NotNull FinancialValue other);


    @NotNull String display();


    boolean isKnown();
}
