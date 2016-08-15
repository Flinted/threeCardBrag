import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import interfaces.*;
import cardgame.*;

public class CheckTest{
  ArrayList<Checkable> checks;
  ArrayList<Card> hand;
  ArrayList<Card> hand1;
  ArrayList<Card> hand2;
  ArrayList<Card> hand3;
  ArrayList<Card> hand4;
  ArrayList<Card> hand5;
  
  @Before
  public void before(){
    this.checks = new ArrayList<Checkable>();
    checks.add(new PrialCheck());
    checks.add(new StraightCheck());
    checks.add(new FlushCheck());
    checks.add(new PairCheck());
    this.hand = new ArrayList<Card>();
    hand.add(new Card("Clubs", "7"));
    hand.add(new Card("Clubs", "8"));
    hand.add(new Card("Clubs", "9"));
    this.hand1 = new ArrayList<Card>();
    hand1.add(new Card("Clubs", "5"));
    hand1.add(new Card("Hearts", "5"));
    hand1.add(new Card("Spades", "5"));
    this.hand2 = new ArrayList<Card>();
    hand2.add(new Card("Clubs", "5"));
    hand2.add(new Card("Hearts", "5"));
    hand2.add(new Card("Spades", "7"));
    this.hand3 = new ArrayList<Card>();
    hand3.add(new Card("Clubs", "6"));
    hand3.add(new Card("Hearts", "6"));
    hand3.add(new Card("Spades", "7"));
    this.hand4 = new ArrayList<Card>();
    hand4.add(new Card("Clubs", "3"));
    hand4.add(new Card("Hearts", "3"));
    hand4.add(new Card("Spades", "3"));
    this.hand5 = new ArrayList<Card>();
    hand5.add(new Card("Clubs", "9"));
    hand5.add(new Card("Clubs", "10"));
    hand5.add(new Card("Clubs", "Jack"));
  }

  @Test
  public void testCheckforPrialTrue(){
    assertEquals(true,checks.get(0).check(hand1));
  }

  @Test
  public void testCheckforPrialFalse(){
    assertEquals(false,checks.get(0).check(hand2));
  }

  @Test
  public void testCheckforStraightTrue(){
    assertEquals(true,checks.get(1).check(hand));
  }

  @Test
  public void testCheckforStraightFalse(){
    assertEquals(false,checks.get(1).check(hand1));
  }

  @Test
  public void testCheckforFlushTrue(){
    assertEquals(true,checks.get(2).check(hand));
  }

  @Test
  public void testCheckforFlushFalse(){
    assertEquals(false,checks.get(2).check(hand1));
  }

  @Test
  public void testCheckforPairTrue(){
    assertEquals(true,checks.get(3).check(hand2));
  }

  @Test
  public void testCheckforPairFalse(){
    assertEquals(false,checks.get(3).check(hand));
  }
}