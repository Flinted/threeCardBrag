package cardgame;
import interfaces.*;
import java.util.*;

public class Deck implements Deckable{
  private int size;
  private ArrayList<Card> deck;
  private ArrayList<String> suits;
  private ArrayList<String> values;
  private Ruleset rules;

  public Deck(Ruleset ruleset){
    this.rules = ruleset;
    this.suits = ruleset.getSuits();
    this.values= ruleset.getValues();
  }

  public void prepareDeck(){
    createDeck();
    shuffle();
  }

  public ArrayList<Card> getDeck(){
    return this.deck;
  }

  // creates a deck, wiping the previous one if neccesary to avoid doubling cards
  public void createDeck(){
    if(this.deck != null){
      this.deck.clear();
    }

    for(String suit : suits){
      for(String value : values){
        Card card = new Card(suit, value);
        addCard(card);
      }
    }
  }

  public int numberCards(){
    return this.deck.size();
  }

  // adds a new card to the deck, creating the deck if needed
  public void addCard(Card card){
    if(this.deck == null){
      this.deck = new ArrayList<Card>();
    }
    deck.add(card);
  }

  // deals a single card from end of array
  public Card deal(){
    return this.deck.remove(this.deck.size()-1);
  }

  public Ruleset getRules(){
    return this.rules;
  }

  // overly complicated shuffle function (grabs each card in turn and swaps it with a random card in the deck)
  public void shuffle(){
    for ( int i = numberCards()-1; i > 0; i-- ) {
                int rand = (int)(Math.random()*(i+1));
                Card temp = deck.get(i);
                deck.set(i, deck.get(rand));
                deck.set(rand,temp);
            }
  }
}