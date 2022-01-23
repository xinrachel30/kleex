import java.io.*;
import java.util.*;

public class Deck {

  protected static ArrayList<Card> deck = new ArrayList<Card>();
  protected String[] suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
  protected String suit;
  protected int number;
  protected int suitrank;

  public Deck() {
    for (String s : suits) {
      for (int i = 1; i < 14; i++) {
        deck.add(new Card(s, i));
      }
    }
  }

  public static Card get(int input) {
    return deck.get(input);
  }

  public static void remove(int input) {
    deck.remove(input);
  }

  // public static void main(String[] args) {
  //   Deck deck0 = new Deck();
  //   System.out.println(deck0.deck.get(51));
  // }

}
