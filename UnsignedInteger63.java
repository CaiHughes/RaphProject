public final class UnsignedInteger63
{
    private final long value;

    public UnsignedInteger63(final long value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("Value cannot be negative, got: " + value);
        }
        this.value = value;
    }

    public long toLong()
    {
        return value;
    }
}
