import java.util.ArrayList;
import java.util.List;

public class Hand
{
  private final List<Card> hands;
  private final int handSize;

  public Hand(int handSize)
  {
    this.handSize = handSize;
    this.hands = new ArrayList<>(handSize);
    for(int j = 0; j < handSize; j++)
    {
      hands.add(new Card());
    }
  }

  public void setCard(int index, Card newCard)
  {
    if (index < this.handSize)
    {
      Card card = hands.get(index);
      if (card == null)
      {
        hands.add(index, newCard);
      }
      else
      {
        this.hands.set(index, newCard);
      }
    }
    else
    {
      System.out.println("the hand you want to replace does not exist");
    }
  }

  //TODO make sure to check the rules on the strength of the hand that you have
  public void getHandValue()
  {
    for (Card card : hands)
    {
      System.out.print(card.getFace().getName() + "" + card.getSuit().getValue() + " ");
    }
    System.out.println("");
  }
}
