public enum Face
{
  ONE("A", 1),
  TWO("2", 2),
  THREE("3",3),
  FOUR("4", 4),
  FIVE("5", 5),
  SIX("6",6),
  SEVEN("7",7),
  EIGHT("8",8),
  NINE("9",9),
  TEN("10",10),
  JACK("J",11),
  QUEEN("Q",12),
  KING("K", 13);


  private final String name;
  private final int rank;

  Face(String name, int rank)
  {
    this.name = name;
    this.rank = rank;
  }

  public static final Face[] ALL_FACE_TYPES = {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING};

  public boolean is(String name)
  {
    return this.name.equals(name);
  }

  public String getName()
  {
    return name;
  }

  public int getRank()
  {
    return rank;
  }
}
