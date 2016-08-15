import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import interfaces.*;
import java.util.*;


public class DealerTest{
  Ruleset ruleset;
  Deckable deck;
  Dealer dealer;
  ArrayList<Player> players;
  Player player;
  Player player2;


  @Before
  public void before(){
    this.ruleset = new Ruleset("Snap");
    this.deck  = new Deck(ruleset);
    this.dealer = new Dealer(deck);
    this.player = new Player("Renwick");
    this.player2 = new Player("Chris");
    this.players = new ArrayList<Player>();
    this.players.add(player);
    this.players.add(player2);
  }

  @Test
  public void dealerCanDealHand(){
    dealer.dealHandToOne(player);
    assertEquals(3, player.cardCount());
  }

    @Test
    public void dealerCanDealHandToAllPlayers(){
      dealer.dealHandToAll(players);
      assertEquals(3, player.cardCount());
      assertEquals(3, player2.cardCount());
    }
  
}