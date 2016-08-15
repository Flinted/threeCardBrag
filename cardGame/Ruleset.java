package cardgame;
import interfaces.*;
import java.util.*;

public class Ruleset{
  private String gameName;
  private ArrayList<String> suits;
  private ArrayList<String> values;
  private ArrayList<Integer> playerCardsPerTurn;
  private ArrayList<Integer> tableCardsPerTurn;
  private ArrayList<Checkable> rules;
  private int turn;

  public Ruleset(String name){
    this.gameName = name;
    this.suits =  new ArrayList<String>();
    suits.add("Diamonds");
    suits.add("Hearts");
    suits.add("Spades");
    suits.add("Clubs");
    this.values = new ArrayList<String>();
    values.add("2");
    values.add("3");
    values.add("4");
    values.add("5");
    values.add("6");
    values.add("7");
    values.add("8");
    values.add("9");
    values.add("10");
    values.add("Jack");
    values.add("Queen");
    values.add("King");
    values.add("Ace");
    this.turn = 0;
    this.playerCardsPerTurn = new ArrayList<Integer>();
    playerCardsPerTurn.add(3);
    this.tableCardsPerTurn = new ArrayList<Integer>();
    tableCardsPerTurn.add(0);
    this.rules = new ArrayList<Checkable>();
    this.rules.add(new PrialCheck());
    this.rules.add(new StraightCheck());
    this.rules.add(new FlushCheck());
    this.rules.add(new PairCheck());

  }

  public String getGameName(){
    return this.gameName;
  }

  public ArrayList<String> getSuits(){
    return this.suits;
  }

  public ArrayList<String> getValues(){
    return this.values;
  }

  public int getTurn(){
    return this.turn;
  }

  public int playerCardsToDeal(){
    return playerCardsPerTurn.get(this.turn);
  }

  public int tableCardsToDeal(){
    return tableCardsPerTurn.get(this.turn);
  }

  public boolean check(){
    return this.turn >= playerCardsPerTurn.size();
  }

  // calls compare for each player in turn to end with best hand and returns that player
  public Player endGame(ArrayList<Player> players){
    System.out.println("Game Ended");
    Player current; 
    current = players.get(0);

    for(Player player : players){
      if(current == player){
        continue;
      }else{
        current = compare(current, player);
      }
    }
    System.out.println("Winner is " + current.getName());
    return current;
  }

  public void incTurn(){
    this.turn ++;
  }

  // compares the given two players hands and returns the player with the better hand
  public Player compare(Player currentLead, Player challenger){
    ArrayList<Card> currentHand = currentLead.reveal();
    ArrayList<Card> challengeHand = challenger.reveal();
   
    for(Checkable rule : this.rules){
      boolean current = rule.check(currentHand);
      boolean challenge = rule.check(challengeHand);

      if(current && challenge){
        return rule.compare(currentLead,challenger);
      }else if(!current && !challenge){
        continue;
      }
      else if (current != challenge){
        if(current){
          return currentLead;
        }else{
          return challenger;
        }
      }
    }
    return challenger;
  }



}