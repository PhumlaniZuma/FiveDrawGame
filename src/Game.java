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
    addDeckInitially();
  }

  private void addDeckInitially()
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

  private void swapDeck(int r, int j)
  {
    Card card = deck[r];
    deck[r] = deck[j];
    deck[j] = card;
  }

  public void displayHand()
  {
    for (Hand hand : players)
    {
      hand.sortHand();
      hand.getHandValue();
    }
  }

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

  public List<Hand> getPlayers()
  {
    return players;
  }


}
