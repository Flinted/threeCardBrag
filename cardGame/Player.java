package cardgame;
import java.util.*;

public class Player{

  private String name;
  private ArrayList<Card> hand;

  public Player(String name){
    this.name = name;
    this.hand = new ArrayList<Card>();
  }

  public String getName(){
    return this.name;
  }

  public int cardCount(){
    if(hand == null){ 
      return 0;
    }else{
      return hand.size();
    }
  }

  public void getCard(Card card){
    hand.add(card);
  }

  public ArrayList<Card> reveal(){
    return this.hand;
  }
}