package cardgame;
import interfaces.*;
import java.util.*;

public class HighCardCheck implements Checkable{

  public boolean check(ArrayList<Card> hand){
    return true;
  }

  public int getValue(ArrayList<Card> hand){
    int[] refs = new int[3];
    refs[0] = hand.get(0).getRef();
    refs[1] = hand.get(1).getRef();
    refs[2] = hand.get(2).getRef();
    Arrays.sort(refs);
    return refs[2];
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
