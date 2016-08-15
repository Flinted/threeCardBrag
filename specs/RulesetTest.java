import static org.junit.Assert.*;
import org.junit.*;
import cardgame.*;
import interfaces.*;

public class RulesetTest{
  Ruleset ruleset;

  @Before
  public void before(){
    this.ruleset = new Ruleset("snap");
  }

  @Test
  public void rulesetCreates(){
    assertEquals("snap",ruleset.getGameName());
  }

  @Test
  public void rulesetReturnsCorrectPlayerCards(){
    assertEquals(3, (int)ruleset.playerCardsToDeal());
  }
}
