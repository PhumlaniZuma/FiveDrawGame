import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hand
{
  private final List<Card> hands;
  private final int handSize;
  private boolean sameSuit = true;
  private boolean inOrder = true;
  private boolean threeOffAKind = false;
  private boolean twoOffAKind = false;
  private boolean doubleTwoOffAKind = false;
  private boolean fourOffAKind = false;

  private Rank handRank;

  public Hand(int handSize)
  {
    this.handSize = handSize;
    this.hands = new ArrayList<>(handSize);
    for (int j = 0; j < handSize; j++)
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

  public void getHandValue()
  {
    evaluateHand();
    setHandRank();
    for (Card card : hands)
    {
      System.out.print(card.getFace().getName() + "" + card.getSuit().getValue() + " ");
    }
    System.out.print(handRank.getValue());
    System.out.println("");
  }

  public void sortHand()
  {
    boolean swapped;
    do
    {
      swapped = false;
      Card previousCard = hands.get(0);
      for (int i = 1; i < handSize; i++)
      {
        if (previousCard.getFace().getRank() > hands.get(i).getFace().getRank())
        {
          hands.set(i - 1, hands.get(i));
          hands.set(i, previousCard);
          swapped = true;
        }
        previousCard = hands.get(i);
      }
    }
    while (swapped);
  }

  private void checkKindTypes(int sameKind)
  {
    if (sameKind > 0)
    {
      if (sameKind == 2)
      {
        threeOffAKind = true;
      }
      else if (sameKind == 1)
      {
        if (twoOffAKind)
        {
          doubleTwoOffAKind = true;
        }
        twoOffAKind = true;
      }
      else if (sameKind == 3)
      {
        fourOffAKind = true;
      }
    }
  }

  private void setHandRank()
  {
    if (inOrder && sameSuit)
    {
      handRank = Rank.STRAIGHT_FLUSH;
    }
    else if (fourOffAKind)
    {
      handRank = Rank.FOUR_OF_A_KIND;
    }
    else if (threeOffAKind && twoOffAKind)
    {
      handRank = Rank.FULL_HOUSE;
    }
    else if (sameSuit)
    {
      handRank = Rank.FLUSH;
    }
    else if (inOrder)
    {
      handRank = Rank.STRAIGHT;
    }
    else if (threeOffAKind)
    {
      handRank = Rank.THREE_OF_A_KIND;
    }
    else if (twoOffAKind && doubleTwoOffAKind)
    {
      handRank = Rank.TWO_PAIR;
    }
    else if (twoOffAKind)
    {
      handRank = Rank.ONE_PAIR;
    }
    else
    {
      handRank = Rank.HIGH_CARDS;
    }
  }

  public void evaluateHand()
  {
    threeOffAKind = false;
    twoOffAKind = false;
    fourOffAKind = false;

    Suit previousSuit = null;
    int cardDif = 0;
    int sameKind = 0;
    Face previousFace = null;
    for (Card card : hands)
    {
      if (previousSuit == null || (previousSuit == card.getSuit() && sameSuit))
      {
        previousSuit = card.getSuit();
      }
      else
      {
        sameSuit = false;
      }
      if ((cardDif == 0) || (card.getFace().getRank() - cardDif == 1))
      {
        cardDif = card.getFace().getRank();
      }
      else
      {
        inOrder = false;
      }
      if (previousFace != null && previousFace.getRank() == card.getFace().getRank())
      {
        sameKind++;
      }
      else
      {
        if (sameKind > 0)
        {
          checkKindTypes(sameKind);
        }
        sameKind = 0;
      }
      previousFace = card.getFace();
    }
    if (sameKind > 0)
    {
      checkKindTypes(sameKind);
    }
  }
}
