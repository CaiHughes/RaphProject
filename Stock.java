public final class Stock{

    private final PositiveInteger32 price;
    private final PositiveInteger32 quantity;

    public Stock(final PositiveInteger32 price, final PositiveInteger32 quantity){

        this.price = price;
        this.quantity = quantity;
    }

    public int totalValue(){
        return price.value() * quantity.value();
    }
}