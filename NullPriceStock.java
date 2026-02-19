// NullPriceStock.java
public final class NullPriceStock implements PortfolioValuable {
    private final long quantity;
    public static int count = 0;

    public NullPriceStock(long quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        count++;
        this.quantity = quantity;
    }

    @Override
    public long totalValue() {
        return 0;           // or throw exception — but 0 is safer here
    }

    @Override
    public boolean hasReliablePrice() {
        return false;
    }
}
  