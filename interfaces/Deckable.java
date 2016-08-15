package interfaces;
import cardgame.*;

import java.util.*;

public interface Deckable{
  public void shuffle();
  public int numberCards();
  public void createDeck();
  public Card deal();
}
