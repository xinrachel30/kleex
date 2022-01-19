/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

import java.io.*;
import java.util.*;

public class Woo {

  protected static PrivateInvestigator player;

  public static void printStats(Character a) {
    System.out.println("Current Stats: -------------------" +
    "\nMoney: " + a.currency +
    "\nKnowledge: "+ a.knowledge +
    "\nHealth: "+ a.hp +
    "\nStrength: "+ a.strength +
    "\nEnergy: "+ a.energy +
    "-------------------\n");
  }

  public static void playGame() {
    String choice = "";

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" +
    "\nWelcome, player." +
    "\nYou've been hired by Kenna and Jimmy Ecclestone to investigate the disappearance of their daughter, Marisa Ecclestone." +
    "\nYou have 5 days to solve the case." +
    "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

    Scanner in = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = in.nextLine();

    System.out.println("Best of luck to you, PI " + name + ".");
    player = new PrivateInvestigator(name);

    dayOne();

  }

  public static void dayOne() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 1");
    printStats(player);

    System.out.println("KENNA ECCLESTONE: This is just horrible..." +
    "\nJIMMY ECCLESTONE: You're the one that insisted on going to those RIDICULOUS wine tastings. You could have spent more time with her..." +
    "\nKENNA ECCLESTONE: You act as if you don't golf with your friends every weekend!");

    Scanner in = new Scanner(System.in);
    System.out.println("Kenna and Jimmy glare at each other. You feel the tension in the room. What do you do, " + player.name + "?");
    System.out.println("1 - Talk to Kenna (-1 energy)");
    System.out.println("2 - Talk to Jimmy (-1 energy)");
    String choice = in.nextLine();
    if (choice.equals("1")) {
      System.out.println("KENNA ECCLESTONE: It's difficult caring for a 16 year old girl, let alone having to do it by myself!");
      player.Kenna();
      player.regularEnergy();
      player.goodKnowledge();
    }
    else if (choice.equals("2")) {
      System.out.println("JIMMY ECCLESTONE: You don't understand how much that woman aggravates me. I spend enough time with my daughter. My wife just has a flair for dramatics.");
      player.Jimmy();
      player.regularEnergy();
      player.goodKnowledge();
    }
    else {
      System.out.println("You stand there in silence. (-2 energy)");
      player.lotEnergy();
      player.badKnowledge();
    }

    System.out.println("YOU: Let's cut to the chase. When was the last time you saw your daughter?" +
    "\nYou notice that the couple has stopped their bickering and genuinely look deep in thought." +
    "\nYOU: ...?" +
    "\nKENNA ECCLESTONE: Well, to what I can recall, I last saw her with her friends." +
    "\nJimmy nods his head in agreement." +
    "\nJIMMY ECCLESTONE: I never did like them scallywags. They always played around with my cards even though I explicity told them not to." +
    "\nKENNA ECCLESTONE: Jimmy, who cares about your damn cards? We're talking about our daughter." +
    "\nJimmy sighs and turns to you." +
    "\nJIMMY ECCLESTONE: How about you talk to them friends then, huh?" +
    "\nJimmy then faces Kenna." +
    "\nJIMMY ECCLESTONE: Give 'em the contact information. I've got things to do.");

    Scanner in2 = new Scanner(System.in);
    System.out.println("1 - Stop Jimmy (-1 energy)");
    System.out.println("2 - Don't stop Jimmy (-1 energy)");
    choice = in2.nextLine();
    if (choice.equals("1")) {
      player.Jimmy();
      player.regularEnergy();
      player.goodKnowledge();
      System.out.println("JIMMY ECCLESTONE: What? I've already made plans with a couple of lads. I'm trying to make a gain in BlackJack... Are you judging me for it?");
      Scanner in3 = new Scanner(System.in);
      System.out.println("1 - No. (-1 energy)");
      System.out.println("2 - Yes. (-1 energy)");
      choice = in3.nextLine();
      if (choice.equals("1")) {
        player.Jimmy();
        player.regularEnergy();
        System.out.println("JIMMY ECCLESTONE: Well, then... Good luck with my wife and with finding my daughter.");
      }
      else if (choice.equals("2")) {
        player.regularEnergy();
        System.out.println("JIMMY ECCLESTONE: Well, instead of meddling in my business, how about you do your job and find my daughter?");
      }
      else {
        System.out.println("JIMMY ECCLESTONE: Okay, don't say anything then." +
        "(-2 energy)\n");
        player.lotEnergy();
        }
      }
    else if (choice.equals("2")) {
      player.regularEnergy();
    }
    else {
      System.out.println("(-2 energy)");
      player.lotEnergy();
        }

    System.out.println("Jimmy leaves the room, leaving Kenna and you alone." +
    "\nKenna looks at the door Jimmy left through." +
    "\nKENNA ECCLESTONE: Nevermind him. I would rather get started on finding my daughter." +
    "\nYou nod your head." +
    "\nKENNA ECCLESTONE: I'll have my daughter's friends' numbers emailed to you. In the meantime, we should -" +
    "\nYour conversation is disrupted by the ringing of Kenna's phone." +
    "\nKenna grabs her phone and answers it, listening for a few seconds before looking at you." +
    "\nKENNA ECCLESTONE: All right, hold for a minute. (She mutes herself on the phone) I'm sorry to say, but it seems as if there is a meeting I have to attend. You will recieve the email with the contact information. You can leave now -- but you may use our bathroom if you need to before so.");

    Scanner in4 = new Scanner(System.in);
    System.out.println("1 - I'll take you up on your offer. (-1 energy)");
    System.out.println("2 - I'll just go home. (-1 energy)");
    choice = in4.nextLine();
    if (choice.equals("1")) {

    }
    else if (choice.equals("2")) {

    }
    else {

    }

      }

  public static void dayTwo() {

  }

  public static void dayThree() {

  }

  public static void dayFour() {

  }

  public static void dayFive() {

  }

  public static void playCardGame(PrivateInvestigator player) {
    System.out.println("You paid BOBO 10 dollars.");
    player.payForGame();

    System.out.println("BOBO: So you think you can beat me? I am the most skilled card picker!" +
    "\nPick a card, any card!");
    Card playerCard = new Card();
    System.out.println("BOBO: Let's see... your card is a " + playerCard + "!");
    Card boboCard = new Card(7);
    System.out.println("BOBO: Woah! I got a " + boboCard + "!");

    if (playerCard.compareTo(boboCard) == 1) {
      System.out.println("BOBO: ..." +
      "\nBOBO: I... I lost?" +
      "\nBOBO: How did this happen?");

      player.winGame();
      System.out.println("You received 50 dollars!");
    }
    else if (playerCard.compareTo(boboCard) == -1) {
      System.out.println("BOBO: As predicted! Ahahaha!!");
    }
    else {
      System.out.println("BOBO: Huh. How did we get the same card? Weird." +
      "\nBOBO: Well, I'm feeling nice today. Here's 30 dollars!");

      player.draw();
      System.out.println("You received 30 dollars!");
    }
  }

  public static void main(String[] args) {
    playGame();
  }


}
