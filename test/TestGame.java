import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestGame
{
  @Test
  public void testSameCards()
  {
    boolean sameCards = false;
    int noPlayers = 2;
    int handSize = 5;
    Game game = new Game(noPlayers, handSize);
    game.deal();

    for (int j = 0; j < noPlayers; j++)
    {
      Card card1 = game.getPlayers().get(j).getHands().get(0);
      Card card2 = game.getPlayers().get(j).getHands().get(1);
      Card card3 = game.getPlayers().get(j).getHands().get(2);
      Card card4 = game.getPlayers().get(j).getHands().get(3);
      Card card5 = game.getPlayers().get(j).getHands().get(4);

      for (int i = 1; i < noPlayers; i++)
      {
        if (i != j)
        {
          for (Card card : game.getPlayers().get(i).getHands())
          {
            if (isSameCard(card1, card))
            {
              sameCards = true;
            }
            else if (isSameCard(card2, card))
            {
              sameCards = true;
            }
            else if (isSameCard(card3, card))
            {
              sameCards = true;
            }
            else if (isSameCard(card4, card))
            {
              sameCards = true;
            }
            else if (isSameCard(card5, card))
            {
              sameCards = true;
            }
          }
        }
      }
    }
    Assertions.assertFalse(sameCards);
  }

  private boolean isSameCard(Card card1, Card card)
  {
    return card.getFace() == card1.getFace() && card.getSuit() == card1.getSuit();
  }

  @Test
  public void testHandSize()
  {
    int handSize = 5;
    Game game = new Game(2, handSize);
    game.deal();
    for (Hand hand : game.getPlayers())
    {
      Assertions.assertEquals(handSize, hand.getHands().size());
    }
  }

  @Test
  public void testShuffled()
  {
    int noOffShuffled = 0;
    Game game = new Game(2, 5);
    Card[] initialDeck = new Card[game.getDeck().length];
    for (int i = 0; i < game.getDeck().length; i++)
    {
      initialDeck[i] = game.getDeck()[i];
    }
    game.Shuffle();
    Card[] newDeck = game.getDeck();

    for (int i = 0; i < newDeck.length; i++)
    {
      if (isSameCard(newDeck[i], initialDeck[i]))
      {
        noOffShuffled++;
      }
    }
    System.out.println(noOffShuffled);
    Assertions.assertTrue(noOffShuffled < 5);
    Assertions.assertNotEquals(initialDeck,newDeck);
  }
}
