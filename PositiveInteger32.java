public final class PositiveInteger32{
    private final int value;

    public PositiveInteger32(final int value){
        if (value <= 0){
            throw new IllegalArgumentException("Value must be positive.");
        }
        this.value = value;
    }

    public int value(){
        return value;
    }
}
