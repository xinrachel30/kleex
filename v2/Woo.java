/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

import java.io.*;
import java.util.*;

public class Woo {

  protected static Character player;

  public static void printStats(Character a) {
    System.out.println("Current Stats: -------------------\n" +
    "Money: " + a.currency +
    "\nKnowledge: "+ a.knowledge +
    "\nHealth: "+ a.hp +
    "\nStrength: "+ a.strength +
    "\nEnergy: "+ a.energy +
    "-------------------\n");
  }

  public static void playGame() {
    String choice = "";

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n" +
    "Welcome, player.\n" +
    "You've been hired by Kenna and Jimmy Ecclestone to investigate the disappearance of their daughter, Marisa Ecclestone.\n" +
    "You have 5 days to solve the case.\n" +
    "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");

    Scanner in = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = in.nextLine();

    System.out.println("Best of luck to you, PI " + name + ".");
    player = new PrivateInvestigator(name);

    dayOne();

  }

  public static boolean dayOne() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n"
    + "\nDay 1");
    printStats(player);

    System.out.println("KENNA ECCLESTONE: This is just horrible..." +
    "JIMMY ECCLESTONE: You're the one that insisted on going to those RIDICULOUS wine tastings. You could have spent more time with her..." +
    "KENNA ECCLESTONE: You act as if you don't golf with your friends every weekend!");

    Scanner in = new Scanner(System.in);
    System.out.println("Kenna and Jimmy glare at each other. You feel the tension in the room. What do you do, " + player + "?");
    System.out.println("1 - Talk to Kenna (-1 energy)");
    System.out.println("2 - Talk to Jimmy (-1 energy)");
    String choice = in.nextLine();
    if (choice == "1") {
      System.out.println("KENNA ECCLESTONE: It's difficult caring for a 16 year old girl, let alone having to do it by myself!");
      PrivateInvestigator.updateEnergy();
      goodKnowledge();
    }
    else if (choice == "2") {
      System.out.println("JIMMY ECCLESTONE: You don't understand how much that woman aggravates me. I spend enough time with my daughter. My wife just has a flair for dramatics.");
    }
    else {
      System.out.println("You stand there in silence. (-2 energy)");
    }

    System.out.println("YOU: Let's cut to the chase. When was the last time you saw your daughter?" +
    "You notice that the couple has stopped their bickering and genuinely look deep in thought." +
    "YOU: ...?" +
    "KENNA ECCLESTONE: Well, to what I can recall, I last saw her with her friends." +
    "Jimmy nods his head in agreement." +
    "JIMMY ECCLESTONE: I never did like them scallywags. They always played around with my cards");
  }

  public static void dayTwo() {

  }

  public static void dayThree() {

  }

  public static void dayFour() {

  }

  public static void dayFive() {

  }

  public static void playCardGame() {
    System.out.println("");
  }

  public static void main(String[] args) {
    playGame();
  }


}
