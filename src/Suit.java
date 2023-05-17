public enum Suit
{
  CLUBS("\u2663"),
  DIAMONDS("\u2666"),
  HEARTS("\u2764"),
  SPADES("\u2660");

  public static final Suit[] ALL_SUIT_TYPES = {CLUBS, DIAMONDS, HEARTS,SPADES};

  private final String value;

  Suit(String value)
  {
    this.value = value;
  }

  public boolean is(String value)
  {
    return this.value.equals(value);
  }

  public String getValue()
  {
    return value;
  }
}
