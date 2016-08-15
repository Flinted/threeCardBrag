package cardgame;
import interfaces.*;
import java.util.*;

public class PrialCheck implements Checkable{

  public boolean check(ArrayList<Card> hand){
    if(hand.get(0).number() == hand.get(1).number() && hand.get(1).number() == hand.get(2).number()){
      return true;
    }
    else{
      return false;
    }
  }

  public int getValue(ArrayList<Card> hand){
    return hand.get(0).getRef();
  }

  public Player compare(Player current, Player challenge){
    ArrayList<Card> currentHand = current.reveal();
    ArrayList<Card> challengeHand = challenge.reveal();

    if(getValue(currentHand) > getValue(challengeHand) && getValue(challengeHand) != 2 ){
      return current;
    }else if(getValue(currentHand) == 2){
      return current;
    } else
    {
      return challenge;
    }
  }
}