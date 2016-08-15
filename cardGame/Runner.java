package cardgame;
import interfaces.*;
import java.util.*;

public class Runner{
  public static void main(String[] args){
    System.out.println("Started");

    Ruleset ruleset = new Ruleset("Snap");
    Deckable deck = new Deck(ruleset);
    Dealer dealer = new Dealer(deck);
    Table table = new Table(dealer, ruleset);
    table.setup(4);
    table.runTurn();
    table.runTurn();

  }
}