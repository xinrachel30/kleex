public class Card {

  protected String[] suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
  protected String suit = "";
  protected int number;
  protected int suitrank;

  protected String[] riggedsuits = new String[] {"Hearts", "Spades"};

//Regular Card
  public Card() {
      number = (int)(Math.random() * 13 + 1);
      suitrank = (int)(Math.random() * 4);
      suit = suits[suitrank];
  }

//Rigged Card 
  public Card(int degree) {
    number = (int)(Math.random() * (14 - degree) + degree); //rigs the program so that the card number will always be above or equal to a certain degree.
    suitrank = (int)(Math.random() * 2 + 2);
    suit = riggedsuits[suitrank - 2];
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

  //Set Card
  public Card(String chosenSuit, int chosenNumber) {
    if (chosenNumber < 1 || chosenNumber > 13) {
      System.out.println("Invalid input for card number. Setting number to 1...");
      number = 1;
    }
    else {
      number = chosenNumber;
    }
    for (int i = 0; i < suits.length; i ++) {
      if (chosenSuit.equals(suits[i])) {
        suit = chosenSuit;
        suitrank = i;
      }
    }
    if (suit.equals("")) {
      System.out.println("Invalid input for card suit. Setting suit to Clubs...");
      suit = "Clubs";
      suitrank = 0;
    }
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

  public int blackJackValue() {
    if (number <= 10) {
      return number;
    }
    else {
      return 10;
    }
  }

  public static void main(String[] args) {
    Card player = new Card();
    // System.out.println(player);
    // Card computer = new Card(7);
    // System.out.println(computer);
    // System.out.println(player.compareTo(computer));
    // Card chosen = new Card("Spades", 8);
    // System.out.println(chosen);
    // Card invalid = new Card("Jonathon", 251);
    // System.out.println(invalid);
    System.out.println(player.blackJackValue());
  }
}
