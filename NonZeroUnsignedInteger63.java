public final class NonZeroUnsignedInteger63
{
    private final long value;

    public NonZeroUnsignedInteger63(final long value)
    {
        if (value <= 0)
        {
            throw new IllegalArgumentException("Value must be positive, got: " + value);
        }
        this.value = value;
    }

    public long toLong()
    {
        return value;
    }
}
