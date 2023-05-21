public class Main
{
  public static void main(String[] args)
  {
    Game game = new Game(2, -1);
    game.deal();
    game.displayHand();
    game.deal();
    game.displayHand();
  }
}
