package cardgame;
import interfaces.*;
import java.util.*;

public class StraightCheck implements Checkable{

  public boolean check(ArrayList<Card> hand){
    int[] refs = new int[3];
    refs[0] = hand.get(0).getRef();
    refs[1] = hand.get(1).getRef();
    refs[2] = hand.get(2).getRef();
    Arrays.sort(refs);
    if(refs[0] == refs[1]-1 && refs[1] == refs[2]-1){
      return true;
    }else if(refs[2] != 13){
      return false;
    }else if(refs[0] == 1 && refs[1] == 2){
      return true;
    }   
    return false;
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
    Checkable flushcheck = new FlushCheck();
    if(flushcheck.check(currentHand)){return current;}
    if(flushcheck.check(challengeHand)){return challenge;}

    if(getValue(currentHand) > getValue(challengeHand) && getValue(challengeHand) != 0 && getValue(challengeHand)!= 2){
      return current;
    }else if(getValue(currentHand) == 2){
      return current;
    }else
    {
      return challenge;
    }
  }
}