import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import interfaces.*;
import java.util.*;


public class TableTest{
  Table table;
  Ruleset ruleset;
  Deckable deck;
  Dealer dealer;


  @Before
  public void before(){
    this.ruleset = new Ruleset("Snap");
    this.deck  = new Deck(ruleset);
    this.dealer = new Dealer(deck);
    this.table = new Table(dealer, ruleset);
    table.setup(2);
  }

  @Test
  public void testSetup(){
    assertEquals(2, table.countPlayers());
  }

  @Test
  public void testHandRuns(){
    table.runTurn();
    assertEquals(1, this.ruleset.getTurn());
  }

  @Test
  public void testStraightBeatsFlush(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "5"));
    players.get(0).getCard(new Card("Spades", "6"));
    players.get(0).getCard(new Card("Spades", "9"));
    players.get(1).getCard(new Card("Spades", "9"));
    players.get(1).getCard(new Card("Hearts", "10"));
    players.get(1).getCard(new Card("Spades", "Jack"));
    assertEquals("Player2", ruleset.endGame(players).getName());
  }

  @Test
  public void testPrial3sBeatAces(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "3"));
    players.get(0).getCard(new Card("Hearts", "3"));
    players.get(0).getCard(new Card("Clubs", "3"));
    players.get(1).getCard(new Card("Spades", "Ace"));
    players.get(1).getCard(new Card("Hearts", "Ace"));
    players.get(1).getCard(new Card("Clubs", "Ace"));
    assertEquals("Player1", ruleset.endGame(players).getName());
  }


  @Test
  public void testPairBeatsHighCard(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "3"));
    players.get(0).getCard(new Card("Hearts", "3"));
    players.get(0).getCard(new Card("Clubs", "6"));
    players.get(1).getCard(new Card("Spades", "Ace"));
    players.get(1).getCard(new Card("Hearts", "6"));
    players.get(1).getCard(new Card("Clubs", "10"));
    assertEquals("Player1", ruleset.endGame(players).getName());
  }

  @Test
  public void testHighCardWins(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "3"));
    players.get(0).getCard(new Card("Hearts", "4"));
    players.get(0).getCard(new Card("Clubs", "6"));
    players.get(1).getCard(new Card("Spades", "Ace"));
    players.get(1).getCard(new Card("Hearts", "6"));
    players.get(1).getCard(new Card("Clubs", "10"));
    assertEquals("Player2", ruleset.endGame(players).getName());
  }

  @Test
  public void test3HighStraightWins(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "Ace"));
    players.get(0).getCard(new Card("Hearts", "2"));
    players.get(0).getCard(new Card("Clubs", "3"));
    players.get(1).getCard(new Card("Spades", "10"));
    players.get(1).getCard(new Card("Hearts", "Jack"));
    players.get(1).getCard(new Card("Clubs", "Queen"));
    assertEquals("Player1", ruleset.endGame(players).getName());
  }

  @Test
  public void testStraightFlushBeatsStraight(){
    ArrayList<Player> players = table.getPlayers();
    players.get(0).getCard(new Card("Spades", "3"));
    players.get(0).getCard(new Card("Spades", "4"));
    players.get(0).getCard(new Card("Spades", "5"));
    players.get(1).getCard(new Card("Spades", "10"));
    players.get(1).getCard(new Card("Hearts", "Jack"));
    players.get(1).getCard(new Card("Clubs", "Queen"));
    assertEquals("Player1", ruleset.endGame(players).getName());
  }
}