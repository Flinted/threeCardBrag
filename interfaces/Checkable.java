package interfaces;
import cardgame.*;

import java.util.*;

public interface Checkable{
  public boolean check(ArrayList<Card> hand);
  public int getValue(ArrayList<Card> hand);
  public Player compare(Player current, Player challenge);
}