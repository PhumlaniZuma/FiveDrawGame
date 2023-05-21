public class Main
{
  public static void main(String[] args)
  {
    Game game = new Game(2,5);
    game.deal();
    game.displayHand();
    game.deal();
    game.displayHand();
  }
}
