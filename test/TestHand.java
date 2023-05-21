import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHand
{
  @Test
  public void testStraightFlush()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.TWO));
    hand.setCard(1,new Card(Suit.CLUBS,Face.THREE));
    hand.setCard(2,new Card(Suit.CLUBS,Face.FOUR));
    hand.setCard(3,new Card(Suit.CLUBS,Face.FIVE));
    hand.setCard(4,new Card(Suit.CLUBS,Face.SIX));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.STRAIGHT_FLUSH);
  }

  @Test
  public void testFourOfAKind()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.TWO));
    hand.setCard(1,new Card(Suit.DIAMONDS,Face.TWO));
    hand.setCard(2,new Card(Suit.HEARTS,Face.TWO));
    hand.setCard(3,new Card(Suit.SPADES,Face.TWO));
    hand.setCard(4,new Card(Suit.CLUBS,Face.SIX));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.FOUR_OF_A_KIND);
  }

  @Test
  public void testFullHouse()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.TWO));
    hand.setCard(1,new Card(Suit.DIAMONDS,Face.TWO));
    hand.setCard(2,new Card(Suit.HEARTS,Face.THREE));
    hand.setCard(3,new Card(Suit.SPADES,Face.THREE));
    hand.setCard(4,new Card(Suit.CLUBS,Face.THREE));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.FULL_HOUSE);
  }

  @Test
  public void testFlush()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.TWO));
    hand.setCard(1,new Card(Suit.CLUBS,Face.TEN));
    hand.setCard(2,new Card(Suit.CLUBS,Face.THREE));
    hand.setCard(3,new Card(Suit.CLUBS,Face.KING));
    hand.setCard(4,new Card(Suit.CLUBS,Face.JACK));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.FLUSH);
  }

  @Test
  public void testStraight()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.NINE));
    hand.setCard(1,new Card(Suit.SPADES,Face.TEN));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.JACK));
    hand.setCard(3,new Card(Suit.CLUBS,Face.QUEEN));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.KING));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.STRAIGHT);
  }

  @Test
  public void TestSort()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.TWO));
    hand.setCard(1,new Card(Suit.SPADES,Face.FIVE));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.THREE));
    hand.setCard(3,new Card(Suit.CLUBS,Face.FOUR));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.SIX));
    hand.sortHand();

    Assertions.assertEquals(hand.getHands().get(0).getFace(),Face.TWO);
    Assertions.assertEquals(hand.getHands().get(1).getFace(),Face.THREE);
    Assertions.assertEquals(hand.getHands().get(2).getFace(),Face.FOUR);
    Assertions.assertEquals(hand.getHands().get(3).getFace(),Face.FIVE);
    Assertions.assertEquals(hand.getHands().get(4).getFace(),Face.SIX);
  }

  @Test
  public void testThreeOfAKind()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.NINE));
    hand.setCard(1,new Card(Suit.SPADES,Face.KING));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.SIX));
    hand.setCard(3,new Card(Suit.CLUBS,Face.KING));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.KING));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.THREE_OF_A_KIND);
  }

  @Test
  public void testTwoPair()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.NINE));
    hand.setCard(1,new Card(Suit.SPADES,Face.KING));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.NINE));
    hand.setCard(3,new Card(Suit.CLUBS,Face.QUEEN));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.KING));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.TWO_PAIR);
  }

  @Test
  public void testPair()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.NINE));
    hand.setCard(1,new Card(Suit.SPADES,Face.EIGHT));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.NINE));
    hand.setCard(3,new Card(Suit.CLUBS,Face.QUEEN));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.KING));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.ONE_PAIR);
  }

  @Test
  public void testHighCard()
  {
    Hand hand = new Hand(5);
    hand.setCard(0,new Card(Suit.CLUBS,Face.NINE));
    hand.setCard(1,new Card(Suit.SPADES,Face.EIGHT));
    hand.setCard(2,new Card(Suit.DIAMONDS,Face.FOUR));
    hand.setCard(3,new Card(Suit.CLUBS,Face.QUEEN));
    hand.setCard(4,new Card(Suit.DIAMONDS,Face.KING));
    hand.evaluateHand();
    Assertions.assertEquals(hand.getHandRank(),Rank.HIGH_CARDS);
  }
}
