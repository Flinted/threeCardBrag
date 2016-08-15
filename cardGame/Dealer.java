package cardgame;
import interfaces.*;
import java.util.*;


public class Dealer{

  private Deckable deck;

  public Dealer(Deckable deck){
    this.deck = deck;
    Deck prepdeck = (Deck)this.deck;
    prepdeck.prepareDeck();
  }

  public void shuffle(){
    this.deck.shuffle();
  }

  // deals the number of cards specified for hand to one given player
  public void dealHandToOne(Player player){
    Deck deck  = (Deck)this.deck;
    int cardsToDeal = deck.getRules().playerCardsToDeal();
    
    for(int i = 0; i < cardsToDeal; i++){
      dealToOne(player);
    }  
  }

  // deals the number of cards specified for table
  public ArrayList<Card> dealHandToTable(ArrayList<Card> table){
    Deck deck  = (Deck)this.deck;
    int cardsToDeal = deck.getRules().tableCardsToDeal();

    for(int i = 0; i < cardsToDeal; i++){
      Card card = deck.deal();
      table.add(card);
    }  

    return table;
  }


  // deals the number of cards specified for hand to ALL players
  public void dealHandToAll(ArrayList<Player> players){
    Deck deck  = (Deck)this.deck;
    int cardsToDeal = deck.getRules().playerCardsToDeal();
    for(Player player: players){
      for(int i = 0; i < cardsToDeal; i++){
        dealToOne(player);
      }  
    }
  }

  // gives a single card to each player
  public void dealToAll(ArrayList<Player> players){
    for(Player player : players){
      dealToOne(player);
    }
  }

  // gives a single card to a single given playerß
  public void dealToOne(Player player){
    Deck deck =  (Deck)this.deck;
    Card card = deck.deal();
    player.getCard(card); 
  }
}