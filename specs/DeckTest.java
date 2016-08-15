import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import interfaces.*;

public class DeckTest{
  Deckable deck;

  @Before
  public void before(){
    Ruleset ruleset = new Ruleset("Snap");
    this.deck = new Deck(ruleset);
    this.deck.createDeck();
  }

  @Test
  public void deckCreation(){
    assertEquals(52, deck.numberCards());
  }

  @Test 
  public void checkFirstCardNoShuffle(){
    assertEquals("Ace of Clubs", this.deck.deal().getCard());
  }

  @Test 
  public void checkFirstCardShuffled(){
    this.deck.shuffle();
    // Deck deck = (Deck) this.deck;
    // for(Card card: deck.getDeck()){
    //   System.out.println(card.getCard());
    // }
    assertNotEquals("Ace of Clubs", this.deck.deal().getCard());
  }
}
