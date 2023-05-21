public enum Rank
{
  STRAIGHT_FLUSH("Straight Flush"),
  FOUR_OF_A_KIND("Four of a kind"),
  FULL_HOUSE("Full house"),
  FLUSH("Flush"),
  STRAIGHT("Straight"),
  THREE_OF_A_KIND("Three of a kind"),
  TWO_PAIR("Two Pair"),
  ONE_PAIR("One Pair"),
  HIGH_CARDS("High Cards");

  private final String value;

  Rank(String value)
  {
    this.value = value;
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
}