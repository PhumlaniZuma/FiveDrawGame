import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game
{
  private static final int SUIT_SIZE = 4;
  private static final int FACE_SIZE = 13;
  private static final int DECK_SIZE = SUIT_SIZE * FACE_SIZE;
  private static final int MIN_DECK_SIZE = 0;
  private static final int NUMBER_OFF_TIMES_TO_SHUFFLE = DECK_SIZE * 10;
  private final List<Hand> players;
  private final int handSize;
  private final Card[] deck = new Card[DECK_SIZE];

  public Game(int no_players, int handSize)
  {
    this.handSize = handSize;
    this.players = new ArrayList<>(no_players);
    for (int j = 0; j < no_players; j++)
    {
      players.add(new Hand(handSize));
    }
    addDeckInitialValues();
  }

  /**
   * this is to add the initial values of the deck, this will be in order off they input.
   */
  private void addDeckInitialValues()
  {
    int i = 0;
    for (Suit suit : Suit.ALL_SUIT_TYPES)
    {
      for (Face face : Face.ALL_FACE_TYPES)
      {
        deck[i] = new Card(suit, face);
        i++;
      }
    }
  }

  /**
   * this is to shuffle the deck as it is add in order it will be predictable off which will come first
   * by shuffling the deck we will make it so that there is not order in the deck and can not be predictable.
   */
  public void Shuffle()
  {
    int i = 0;
    while (i != NUMBER_OFF_TIMES_TO_SHUFFLE)
    {
      Random random = new Random();
      swapDeck(random.nextInt(DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE, random.nextInt(DECK_SIZE - MIN_DECK_SIZE) + MIN_DECK_SIZE);
      i++;
    }
  }

  /**
   * swapping cards in the deck
   *
   * @param r the index that will be swapped with J
   * @param j the index that will be swapped with r
   */
  private void swapDeck(int r, int j)
  {
    Card card = deck[r];
    deck[r] = deck[j];
    deck[j] = card;
  }

  /**
   * this is to print out the value off each hand that is in the game.
   */
  public void displayHand()
  {
    for (Hand hand : players)
    {
      hand.printHand();
    }
  }

  /**
   * this is to set each hand in play, it will add one card from the to each player till all players have all cards
   */
  public void deal()
  {
    Shuffle();
    int deck_count = 0;
    for (int i = 0; i < handSize; i++)
    {
      for (Hand hand : players)
      {
        hand.setCard(i, deck[deck_count]);
        deck_count++;
      }
    }
  }

  /**
   * @return get the list off Hands, which are players
   */
  public List<Hand> getPlayers()
  {
    return players;
  }

  /**
   * @return this is the cards that will be played with and server each player.
   */
  public Card[] getDeck()
  {
    return deck;
  }
}
