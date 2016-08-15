import static org.junit.Assert.*;
import org.junit.*;
import interfaces.*;
import cardgame.*;

public class CardTest{
  Card card;

  @Before
  public void before(){
    this.card = new Card("Spades", "Ace");
  }

  @Test
  public void cardCreatesProperly(){
    assertEquals("Ace of Spades", card.getCard());
  }

}