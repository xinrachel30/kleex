public class Card {

  protected String[] suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
  protected String suit;
  protected int number;
  protected int suitrank;

  public Card() {
      number = (int)(Math.random() * 13 + 1);
      suitrank = (int)(Math.random() * 4);
      suit = suits[suitrank];
  }

  public int compareTo(Card a) {
    if (this.number > a.number) {
      return 1;
    }
    else if (a.number > this.number) {
      return -1;
    }

    if (this.suitrank > a.suitrank) {
      return 1;
    }
    return -1;
  }

  public String toString() {
    String value;
    if (number == 1) {
      value = "Ace";
    }
    else if (number == 11) {
      value = "Jack";
    }
    else if (number == 12) {
      value = "Queen";
    }
    else if (number == 13) {
      value = "King";
    }
    else {
      value = "" + number;
    }
    return value + " of " + suit;
  }

  // public static void main(String[] args) {
  //   Card player = new Card();
  //   System.out.println(player);
  //   Card computer = new Card();
  //   System.out.println(computer);
  //   System.out.println(player.compareTo(computer));
  // }
}
