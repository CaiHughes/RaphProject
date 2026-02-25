public final class Quantity{
    private final long value;

    public Quantity(long value){
        if(value <= 0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.value = value;
    }

    public long toLong(){
        return value;
    }
}