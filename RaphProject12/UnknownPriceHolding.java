public final class UnknownPriceHolding implements PortfolioValuable{
    private final Quantity quantity;

    public UnknownPriceHolding(long quantity){
        this.quantity = new Quantity(quantity);
    }

    @Override
    public FinancialValue getFinancialValue(){
        return new KnownFinancialValue(this.quantity.toLong() * 100);
    }
}
