public final class Stock implements PortfolioValuable{
    private final long price;
    private final long quantity;

    public Stock(long price, long quantity){
        if (price <= 0 || quantity <= 0){
            throw new IllegalArgumentException("Price and quantity must be positive");
        }
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public long totalValue(){
        return price * quantity;
    }

    @Override
    public boolean hasReliablePrice(){
        return true;
    }
}