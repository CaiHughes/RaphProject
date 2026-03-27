public final class Quantity
{
    private final NonZeroUnsignedInteger63 value;

    public Quantity(final long value)
    {
        this.value = new NonZeroUnsignedInteger63(value);
    }

    public long toLong()
    {
        return value.toLong();
    }
}