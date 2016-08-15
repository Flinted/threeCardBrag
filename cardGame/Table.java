package cardgame;
import interfaces.*;
import java.util.*;

public class Table{
  private ArrayList<Player> players;
  private Dealer dealer;
  private ArrayList<Card> tableCards;
  private ArrayList<Card> burnCards;
  private Ruleset rules;

  public Table(Dealer dealer, Ruleset ruleset){
      this.dealer = dealer;
      this.rules = ruleset;
      this.tableCards = new ArrayList<Card>();
  }

  // adds number of given players with playeri numbering and shuffles deck
  public void setup(int noPlayers){
    for(int i = 0; i < noPlayers; i++)
    {
      addPlayer("Player" + (i+1));
    }
    dealer.shuffle();
  }

  // adds player with given name
  public void addPlayer(String name){
    Player player = new Player(name);

    if(this.players == null){
      this.players = new ArrayList<Player>();
    }

    this.players.add(player);
  }


  public int countPlayers(){
    return this.players.size();
  }

  public ArrayList<Player> getPlayers(){
    return this.players;
  }

  // checks if more turns to be taken if so calls dealer to deal, if not calls endGame.
  public String runTurn(){
    if(rules.check() == true){ 
       rules.endGame(this.players);
       return "Game Ended";
    }else{
    dealer.dealHandToAll(this.players);
    this.tableCards = dealer.dealHandToTable(this.tableCards);
    rules.incTurn();
    return "Turn processed";
  }
  }



}