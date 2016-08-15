package cardgame;
import interfaces.*;
import java.util.*;

public class PairCheck implements Checkable{

  public boolean check(ArrayList<Card> hand){
    if(hand.get(0).number() == hand.get(1).number() || hand.get(0).number() == hand.get(2).number() || hand.get(1).number() == hand.get(2).number()){
      return true;
    }

    return false;
  }

  public int getValue(ArrayList<Card> hand){
    if(hand.get(0).number() == hand.get(1).number()){
      return hand.get(0).getRef();
    } else {
      return hand.get(2).getRef();
    }
  }

    public Player compare(Player current, Player challenge){
      ArrayList<Card> currentHand = current.reveal();
      ArrayList<Card> challengeHand = challenge.reveal();

      if(getValue(currentHand) > getValue(challengeHand)){
        return current;
      }else
      {
        return challenge;
      }
    }
  
}