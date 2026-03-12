
public interface Price{
    @NotNull FinancialValue calculate(@NotNull final Quantity quantity);
}
