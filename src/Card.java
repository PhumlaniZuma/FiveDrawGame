public class Card
{

  private Suit suit;
  private Face face;

  public Card(Suit suit, Face face)
  {
    this.suit = suit;
    this.face = face;
  }

  public Card()
  {
  }

  public Suit getSuit()
  {
    return suit;
  }

  public Face getFace()
  {
    return face;
  }
}
