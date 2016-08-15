import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import interfaces.*;

public class PlayerTest{

  Ruleset ruleset;
  Deckable deck;
  Dealer dealer;
  Player player;


  @Before
  public void before(){
    this.ruleset = new Ruleset("Snap");
    this.deck  = new Deck(ruleset);
    this.dealer = new Dealer(deck);
    this.player = new Player("Renwick");
  }

  @Test
  public void playerHasName(){
    assertEquals("Renwick", player.getName());
  }

  @Test
  public void playerHasNoCardsAtStart(){
    assertEquals(0, player.cardCount());
  }

  @Test
  public void playerCanGetCards(){
    Deck deck = (Deck)this.deck;
    deck.createDeck();
    dealer.dealToOne(player);
    assertEquals(1, player.cardCount());
  }

  

}
