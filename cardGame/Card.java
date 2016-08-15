package cardgame;
import interfaces.*;
import java.util.*;

public class Card{
  private String suit;
  private String value;
  private int ref;

  public Card(String suit, String value){
    this.suit = suit;
    this.value= value;
    setRef();
  }

  public String number(){
    return this.value;
  }

  public String suit(){
    return this.suit;
  }

  public String getCard(){
    return this.value + " of " + this.suit;
  }

  public int getRef(){
    return this.ref;
  }

  // gives the face value a numerical value, to allow for easy hand comparison
  private void setRef(){
    switch(this.value){
      case "2": ref = 1;
      break;
      case "3": ref = 2;
      break;
      case "4": ref = 3;
      break;
      case "5": ref = 4;
      break;
      case "6": ref = 5;
      break;
      case "7": ref = 6;
      break;
      case "8": ref = 7;
      break;
      case "9": ref = 8;
      break;
      case "10": ref = 9;
      break;
      case "Jack": ref = 10;
      break;
      case "Queen": ref = 11;
      break;
      case "King": ref = 12;
      break;
      case "Ace": ref = 13;
      break;
      
    }
  }
}