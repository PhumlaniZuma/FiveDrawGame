public enum Rank
{
  STRAIGHT_FLUSH("Straight Flush", 9),
  FOUR_OF_A_KIND("Four of a kind", 8),
  FULL_HOUSE("Full house", 7),
  FLUSH("Flush", 6),
  STRAIGHT("Straight", 5),
  THREE_OF_A_KIND("Three of a kind", 4),
  TWO_PAIR("Two Pair", 3),
  ONE_PAIR("One Pair", 2),
  HIGH_CARDS("High Cards", 1);

  private final String value;
  private final int rank;

  Rank(String value, int rank)
  {
    this.value = value;
    this.rank = rank;
  }

  public static final Rank[] ALL_RANK_TYPES = {STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE,FLUSH,STRAIGHT,THREE_OF_A_KIND,TWO_PAIR,ONE_PAIR,HIGH_CARDS};


  public boolean is(String value)
  {
    return this.value.equals(value);
  }

  public String getValue()
  {
    return value;
  }

  public int getRank()
  {
    return rank;
  }
}