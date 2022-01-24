/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-24
*/

import java.io.*;
import java.util.*;

public class Woo {

  protected static PrivateInvestigator player;
  protected static ArrayList<String> friends = new ArrayList<>();
  protected static Civilian friend1 = new Civilian();
  protected static Civilian friend2 = new Civilian();
  protected static Civilian friend3 = new Civilian();

//Game Methods ---------------------------------------------------------------//

  public static void printStats(PrivateInvestigator a) {
    System.out.println("Current Stats: -------------------" +
    "\nMoney: " + a.currency +
    "\nKnowledge: "+ a.knowledge +
    "\nEnergy: "+ a.energy +
    "-------------------\n");
  }

  public static void playGame() {
    String choice = "";

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" +
    "\nWelcome, player." +
    "\nYou've been hired by Kenna and Jimmy Ecclestone to investigate the disappearance of their daughter, Marisa Ecclestone." +
    "\nYou have 5 days to solve the case." +
    "\n" +
    "\nHave in mind that failure to choose a valid option will result in a GAME OVER." +
    "\n______________" +
    "\n|_    __  _____|                         O                               O            " +
    "\n /    _(_|" +
    "\n/____/" +
    "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

    Scanner in = new Scanner(System.in);
    System.out.println("What is your name?");
    String name = in.nextLine();

    System.out.println("Best of luck to you, PI " + name + ".");
    player = new PrivateInvestigator(name);

    dayOne();

    dayTwo();

    dayThree();

    dayFour();

    dayFive();
  }

  public static void wrongChoice() {
    System.out.println("Your inability to choose a valid option baffles me." +
    "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    System.exit(0);
  }

//Casino Methods -------------------------------------------------------------//

  public static void gotoCasino() {

    player.regularEnergy();
    System.out.println("You walk into the Moonlit 251 Casino. You walk past lines and lines of slot machines and tables of calculating players.");

    int timesPlayed = 0;
    while (timesPlayed < 3) {
      System.out.println("\nWhat do you want to play now, " + player.name + "?");
      Scanner casino = new Scanner(System.in);
      System.out.println("1 - Play against Bobo, a master at picking high value cards from a standard deck of cards (-1 energy)\n");
      System.out.println("2 - Play against Jojo, a dealer of a classic card game: BlackJack (-1 energy)\n");
      System.out.println("3 - Return home (-0 energy)\n");

      String choice = casino.nextLine();
      if ((!choice.equals("3")) && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy! A bouncer kicks you out.");
        return;
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        timesPlayed ++;
        playAgainstBobo();
      }
      else if (choice.equals("2")) {
        player.regularEnergy();
        timesPlayed ++;
        playAgainstJojo();
      }
      else if (choice.equals("3")) {
        break;
      }
      else {
        wrongChoice();
      }
    } //end repeating games
    System.out.println("\nYou return home via Uber and the day ends.");
  }

  public static void playAgainstBobo() {
    Character BOBO = new Civilian("BOBO");
    System.out.println("You paid BOBO 10 dollars.");
    player.payForGame();

    System.out.println("BOBO: So you think you can beat me? I am the most skilled card picker!");

    System.out.println("_________________" +
    "\n  |                |" +
    "\n  |       C        |" +
    "\n  |                |" +
    "\n  |       A        |" +
    "\n  |                |" +
    "\n  |       R        |" +
    "\n  |                |" +
    "\n  |       D        |" +
    "\n  |                |" +
    "\n  |________________|" +
    "\nPick a card, any card! (3 words)");

    while (true) {
      Scanner pick = new Scanner(System.in);
      String choice = pick.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("pick a card")) {
        break;
      }
      else {
        System.out.println("No...");
      }
    }

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

      System.out.println("_____________________________________________" +
      "\n|             _______________               |" +
      "\n|             |             |               |" +
      "\n|             |    MOOLA    |               |" +
      "\n|             |      $      |               |" +
      "\n|             |_____________|               |" +
      "\n|___________________________________________|");

    }
    else if (playerCard.compareTo(boboCard) == -1) {
      System.out.println("BOBO: As predicted! Ahahaha!!");
    }
    else {
      System.out.println("BOBO: Huh. How did we get the same card? Weird." +
      "\nBOBO: Well, I'm feeling nice today. Here's 30 dollars!");

      System.out.println("_____________________________________________" +
      "\n|             _______________               |" +
      "\n|             |             |               |" +
      "\n|             |    MOOLA    |               |" +
      "\n|             |      $      |               |" +
      "\n|             |_____________|               |" +
      "\n|___________________________________________|");

      player.draw();
    }
  }

  public static void playAgainstJojo() {
    Character JOJO = new Civilian("JOJO");
    System.out.println("You paid JOJO 10 dollars.");
    player.payForGame();
    player.blackJackValue = 0;
    JOJO.blackJackValue = 0;

    System.out.println("JOJO: Heya! This is BlackJack. Rules goes: Aces are 1s and jokers/queens/kings are 10s." +
    "\nJOJO: The goal is to get as close to 21 as possible without going over. Of course, you're up against me.");

    System.out.println("_________________" +
    "\n  |                |" +
    "\n  |       C        |" +
    "\n  |                |" +
    "\n  |       A        |" +
    "\n  |                |" +
    "\n  |       R        |" +
    "\n  |                |" +
    "\n  |       D        |" +
    "\n  |                |" +
    "\n  |________________|");

    Deck BlackJack = new Deck();

    Card firstCard = BlackJack.dealCard();
    System.out.println("You receive a... " + firstCard);
    player.updtBlackJack(firstCard);

    Card firstCardJojo = BlackJack.dealCard();
    System.out.println("Jojo receives a... " + firstCardJojo);
    JOJO.updtBlackJack(firstCardJojo);

    Card secondCard = BlackJack.dealCard();
    System.out.println("You receive a... " + secondCard);
    player.updtBlackJack(secondCard);

    Card secondCardJojo = BlackJack.dealCard();
    System.out.println("Jojo puts her card face down on the table.");
    JOJO.updtBlackJack(secondCardJojo);

    System.out.println("\nRight now, your total is... " + player.getBlackJack());
    System.out.println("Do you want to get another card?");
    System.out.println("1 - Yes");
    System.out.println("2 - No");

    boolean contin;

    Scanner wantCard = new Scanner(System.in);
    String choice = wantCard.nextLine();

    if (choice.equals("1")) {
      contin = true;
      System.out.println("_________________" +
      "\n  |                |" +
      "\n  |       C        |" +
      "\n  |                |" +
      "\n  |       A        |" +
      "\n  |                |" +
      "\n  |       R        |" +
      "\n  |                |" +
      "\n  |       D        |" +
      "\n  |                |" +
      "\n  |________________|");
    }
    else {
      contin = false;
    }

    Card newCard;

    while (contin) {
      newCard = BlackJack.dealCard();
      System.out.println("You receive a... " + newCard);
      player.updtBlackJack(newCard);
      System.out.println("Right now, your total is... " + player.getBlackJack());
      if (player.bust()) {
        System.out.println("\nJOJO: That's greater than 21! You lost!");
        return;
      }

      System.out.println("\nDo you want to get another card?");
      System.out.println("1 - Yes");
      System.out.println("2 - No");

      Scanner wantMoreCards = new Scanner(System.in);
      choice = wantMoreCards.nextLine();

      if (choice.equals("1")) {
        contin = true;
        System.out.println("_________________" +
        "\n  |                |" +
        "\n  |       C        |" +
        "\n  |                |" +
        "\n  |       A        |" +
        "\n  |                |" +
        "\n  |       R        |" +
        "\n  |                |" +
        "\n  |       D        |" +
        "\n  |                |" +
        "\n  |________________|");
      }
      else {
        contin = false;
      }
    }

      while (JOJO.getBlackJack() < 17) {
        newCard = BlackJack.dealCard();
        System.out.println("Jojo takes another card.");
        JOJO.updtBlackJack(secondCardJojo);
      }

      if (JOJO.bust()) {
        System.out.println("JOJO: Oh no! My total is " + JOJO.getBlackJack() + ". I guess victory is your's.");
        System.out.println("You received 50 dollars!");

        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |             |               |" +
        "\n|             |    MOOLA    |               |" +
        "\n|             |      $      |               |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        player.winGame();
        return;
      }
      else if (JOJO.getBlackJack() > player.getBlackJack()) {
        System.out.println("JOJO: Woo! My total is " + JOJO.getBlackJack() + ", which is higher than your's!");
        return;
      }
      else if (player.getBlackJack() > JOJO.getBlackJack()) {
        System.out.println("JOJO: Wow. My total is " + JOJO.getBlackJack() + ", which is lower than your's.");
        System.out.println("JOJO: I guess victory is your's.");
        System.out.println("You received 50 dollars!");

        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |             |               |" +
        "\n|             |    MOOLA    |               |" +
        "\n|             |      $      |               |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        player.winGame();
        return;
      }
      else {
        System.out.println("JOJO: Huh. I guess our card totals are the same. Mine is " + JOJO.getBlackJack() + ", too.");
        System.out.println("JOJO: Well, I'm feeling nice today, so I'll give you $30.");

        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |             |               |" +
        "\n|             |    MOOLA    |               |" +
        "\n|             |      $      |               |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        player.draw();
      }

  }

//Additional Day Methods -----------------------------------------------------//

  public static void walkinDay2() {
    System.out.println("\nYou walk into the cafe, which was surprisingly bustling. You scan the premise for a person wearing a green shirt with the queen of spades." +
    "\nYou see a teenager that fits the description and walk up to them." +
    "\nYOU: Hello... are you " + friend1 + "?" +
    "\n" + friend1 + ": Yes. That's me. I assume you know my name via how you got my phone number. What's your name?" +
    "\nYOU: My name is " + player.name + "." +
    "\n" + friend1 + ": Nice to meet you." +
    "\nYOU: Right back at you. Now, let's get started. Shall we?" +
    "\n" + friend1 + " nods their head.");
  }

  public static void questionSet1() {
    Scanner in3 = new Scanner(System.in);
    System.out.println("What will you ask?");
    System.out.println("1 - When was the last time you saw Marisa? (-1 energy)");
    System.out.println("2 - Can you describe your relationship with Marisa more? (-1 energy)");
    player.amountEnergy();
    String choice = in3.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.upKnowledge();
      player.clueBeach = true;
      System.out.println(friend1 + ": Well, the last time I saw Marisa was when our friend group went to the beach. We go to the beach every weekend.");

      Scanner in4 = new Scanner(System.in);
      System.out.println("Do you ask why exactly they go to the beach every weekend?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-0 energy)");
      player.amountEnergy();
      choice = in4.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.upKnowledge();
        player.clueAbsentParents = true;
        System.out.println(friend1 + ": Well, Marisa's parents don't really spend that much time with her. They're always busy with work or arguing with each other.");
      }
      else if (choice.equals("2")) {

      }
      else {
        wrongChoice();
      }
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println(friend1 + ": Marisa and I have been friends for two years -- since freshman year of high school. We are really good friends. We hang out with each other everyday, and tell each other practically everything.");

      Scanner in5 = new Scanner(System.in);
      System.out.println("Do ask if they're the closest to Marisa in their friend group?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-0 energy)");
      player.amountEnergy();
      choice = in5.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.upKnowledge();
        System.out.println(friend1 + ": I wouldn't say so. We're a tight knit group since we met each other at around the same time.");
      }
      else if (choice.equals("2")) {

      }
      else {
        wrongChoice();
      }
    }
    else {
      wrongChoice();
    }
  }

  public static void questionSet2() {
    Scanner in6 = new Scanner(System.in);
    System.out.println("What will you ask?");
    System.out.println("1 - How would you describe Marisa -- by that, I mean her personality? (-1 energy)");
    System.out.println("2 - Does Marisa.. disappear.. often? (-1 energy)");
    player.amountEnergy();
    String choice = in6.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println(friend1 + ": Marisa is a fun person to be around. She's quite bubbly and socialable. Though, she's touchy with the subject of her parents...");

      Scanner in7 = new Scanner(System.in);
      System.out.println("Do you ask " + friend1 + " to elaborate on how Marisa reacts to the subject of her parents?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-0 energy)");
      player.amountEnergy();
      choice = in7.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.upKnowledge();
        System.out.println(friend1 + ": We try not to bring it up, of course. But whenever someone did, she would just become stonefaced and be kinda mean. But, that's just her defense mechanism.");

        System.out.println("/Let's see if you have enough knowledge points.../" +
        "\n/Is what " + friend1 + " saying make sense? You think.../" +
        "\n" + "You have " + player.getKnowledge() + " knowledge." +
        "/You need 10 knowledge./");
        if (player.getKnowledge() > 10) {
          System.out.println("It does.");
          player.upKnowledge();
        }
        else {
          System.out.println("It doesn't.");
        }
      }
      else if (choice.equals("2")) {

      }
      else {
        wrongChoice();
      }
    } //end of describing marisa's personality
    else if (choice.equals("2")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println(friend1 + ": Actually, yes. During those times, she usually just isolates herself at her mansion. We respect her privacy.");

      Scanner in8 = new Scanner(System.in);
      System.out.println("Do you ask if " + friend1 + " contacts Marisa during those times?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-0 energy)");
      player.amountEnergy();
      choice = in8.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        System.out.println(friend1 + ": No, since she doesn't really answer any texts or calls... She completely shuts everyone out.");
      }
      else if (choice.equals("2")) {

      }
      else {
        wrongChoice();
      }
    }
    else {
      wrongChoice();
    }
  }

  public static void questionSet3() {
    Scanner in9 = new Scanner(System.in);
    System.out.println("What do you ask?");
    System.out.println("1 - How long have you been aware of Marisa's disappearance? (-1 energy)");
    System.out.println("2 - Are you concerned about Marisa's absence? (-1 energy)");
    player.amountEnergy();
    String choice = in9.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println(friend1 + ": Well, Marisa usually isolates herself for a week... It's already been ten days, so I guess since three days ago.");
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      System.out.println(friend1 + ": Of course! I'm her friend... so why wouldn't I be?");
    }
    else {
      wrongChoice();
    }

    Scanner in10 = new Scanner(System.in);
    System.out.println("Do you ask if " + friend1 + " has done anything to find out about Marisa's absence?");
    System.out.println("1 - Yes. (-1 energy)");
    System.out.println("2 - No. (-0 energy)");
    choice = in10.nextLine();
    player.amountEnergy();
    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.clueMansion = true;
      System.out.println(friend1 + ": I went over to Marisa's mansion and tried talking to her parents, but the head butler dismissed me before I had the chance to.");
    }
    else if (choice.equals("2")) {

    }
    else {
      wrongChoice();
    }
  }

  public static void kennaRant() {
    System.out.println("\nKENNA ECCLESTONE: " + friend1 + " , you remember Jimmy, right?" +
    "\n" + friend1 + " nods their head." +
    "\nKENNA ECCLESTONE: Well, Jimmy has become even more insufferable.");

    Scanner in14 = new Scanner(System.in);
    System.out.println("You think...");
    System.out.println("1 - What has he done now? (-1 energy)");
    System.out.println("2 - He's done something wrong? (-1 energy)");
    System.out.println("3 - ... (-0 energy)");
    player.amountEnergy();
    String choice = in14.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.Kenna();
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      player.Jimmy();
    }
    else if (choice.equals("3")) {

    }
    else {
      wrongChoice();
    }

    System.out.println("KENNA ECCLESTONE: We have our regular arguments here and there, of course." +
    "\nEven I must admit that it can be about the simplest things -- like how he eats his food sloppily or how he comes home late after golfing with his friends." +
    "\nYou sense hesitance in her voice." +
    "\nKENNA ECCLESTONE: But, this time -- last night -- it was just too much." +
    "\nKenna looks hesitant on what she is about to say.");

    Scanner in15 = new Scanner(System.in);
    System.out.println("Do you urge her to continue?");
    System.out.println("1 - Yes. (-2 energy)");
    System.out.println("2 - No. (-0 energy)");
    player.amountEnergy();
    choice = in15.nextLine();
    if (choice.equals("1") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.lotEnergy();
      player.Kenna();
      player.clueKennaRant = true;
      System.out.println("You nod your head, urging her to continue." +
      "\nKENNA ECCLESTONE: Everything has just been so hard, especially after Marisa's disappearance.");

      if (player.clueAbsentParents == true) {
        Scanner in16 = new Scanner(System.in);
        System.out.println("You know that " + friend1 + " told you that Kenna and Jimmy haven't been present in Marisa's life. Should you bring that up?");
        System.out.println("1 - Yes.");
        System.out.println("2 - No.");
        choice = in16.nextLine();
        if (choice.equals("1")) {
          player.clueWrongKenna = true;
          System.out.println("YOU: I thought you weren't present in Marisa's life, though." +
          "\nKenna tenses up." +
          "\nKENNA ECCLESTONE: ..What are you trying to imply? I was a part of her life as much as I could have. I'm a chief executive officer... my job demands a lot out of me." +
          "\nThere is a moment of awkwardness accompanied with silence." +
          "\nKENNA ECCLESTONE: I think that I'm just going to go..." +
          "\nIt's clear that Kenna is not comfortable with continuing the conversation and leaves.");

        }
        else if (choice.equals("2")) {
          System.out.println("You nod your head." +
          "\nKENNA ECCLESTONE: Lately, Jimmy has just been so easily tempered..." +
          "\nShe notices the skeptical look in your eyes." +
          "\nKENNA ECCLESTONE: Oh, never with me. Not with me.");

          Scanner in17 = new Scanner(System.in);
          System.out.println("What do you ask?");
          System.out.println("1 - What has he done? (-1 energy)");
          System.out.println("2 - Say nothing. (-0 energy)");
          player.amountEnergy();
          choice = in17.nextLine();
          if (choice.equals("1") && player.getEnergy() < 1) {
            System.out.println("You don't have enough energy to do that!");
          }
          else if (choice.equals("1")) {
            player.regularEnergy();
            player.upKnowledge();
            player.Kenna();
            player.clueJimmyButler = true;
            System.out.println("KENNA ECCLESTONE: He's been insisting on drinking beer every night, shutting himself in the guest room. He's been quick to anger whenever something doesn't go his way. I've also noticed that he's been arguing with the butler recently." +
            "\nI brought that up with him, and he threw a fit. I have never seen him more mad." +
            "\nBut, alas, I don't want to speak of this anymore." +
            "\nWith that, Kenna gets up and leaves.");
          }
          else if (choice.equals("2")) {

          }
          else {
            wrongChoice();
          }

          System.out.println("KENNA ECCLESTONE: I don't know... The house has just emptier than usual." +
          "\nKenna puts a smile on her face." +
          "\nKENNA ECCLESTONE: Nonetheless, I must continue on. Goodbye to you both." +
          "\nKenna gets up and leaves the cafe.");
        }
        else {
          wrongChoice();
        }
      }

      System.out.println("");
    }
    else if (choice.equals("2")) {
      System.out.println("KENNA ECCLESTONE: Actually, I shouldn't say anything..." +
      "It's clear that Kenna is not comfortable with continuing the conservation and leaves.");
    }
    else {
      wrongChoice();
    }
  }

  public static void questionJimmy() {
    Scanner in5 = new Scanner(System.in);
    System.out.println("What do you ask him?");
    System.out.println("1 - Where are you heading to? (-1 energy)");
    System.out.println("2 - Where did you come from? (-1 energy)");
    System.out.println("3 - I have no questions. I don't want to talk to him anymore.");
    player.amountEnergy();
    String choice = in5.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println("JIMMY ECCLESTONE: I'm actually going to play golf with some old friends." +
      "\nYOU: Where?" +
      "\nJIMMY: In New York, actually. I'm going to spend some time there. I don't know when I'm coming back." +
      "\nYOU: As in a break?" +
      "\nJIMMY: Yeah. A lot's been happening. I need some time to clear my head");
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println("JIMMY ECCLESTONE: I actually came from the butler's room. He had something of mine..." +
      "\nJimmy's face gives way that he is extremely upset.");

      Scanner in6 = new Scanner(System.in);
      System.out.println("Do you ask him if he's upset because...");
      System.out.println("1 - The butler stole from him? (-1 energy)");
      System.out.println("2 - The butler killed his daughter? (-1 energy)");
      System.out.println("3 - Don't ask anything. (-0 energy)");
      choice = in6.nextLine();
      if (choice.equals("1") || choice.equals("2") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.upKnowledge();
        System.out.println("James didn't necessarily steal something... but he did have something of mine. I'm just annoyed since he wouldn't give it to me when I first asked for it.");
      }
      else if (choice.equals("2")) {
        player.regularEnergy();
        player.upKnowledge();
        System.out.println("Jimmy's face hardens." +
        "\nJIMMY ECCLESTONE: I'd rather not talk about James and Marisa.");
      }
      else if (choice.equals("3")) {

      }
      else {
        wrongChoice();
      }
    }
    }

//Day Methods ----------------------------------------------------------------//

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
    System.out.println("3 - Take control of the situation (-0 energy)");
    player.amountEnergy();
    String choice = in.nextLine();
    if (player.getEnergy() < 1 && (choice.equals("1") || choice.equals("2"))) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      System.out.println("KENNA ECCLESTONE: It's difficult caring for a 16 year old girl, let alone having to do it by myself!");
      player.Kenna();
      player.regularEnergy();
      player.upKnowledge();
    }
    else if (choice.equals("2")) {
      System.out.println("JIMMY ECCLESTONE: You don't understand how much that woman aggravates me. I spend enough time with my daughter. My wife just has a flair for dramatics.");
      player.Jimmy();
      player.regularEnergy();
      player.upKnowledge();
    }
    else if (choice.equals("3")) {

    }
    else {
      wrongChoice();
    }

    System.out.println("YOU: (Cough) Let's cut to the chase. When was the last time you saw your daughter?" +
    "\nYou notice that the couple has stopped their bickering and genuinely look deep in thought." +
    "\nYOU: ...?" +
    "\nKENNA ECCLESTONE: Well, to what I can recall, I last saw her with her friends." +
    "\nJimmy nods his head in agreement." +
    "\nJIMMY ECCLESTONE: I never did like them scallywags. They always played around with my cards even though I explicity told them not to." +
    "\nKENNA ECCLESTONE: Jimmy, who cares about your damn cards? We're talking about our daughter." +
    "\nJimmy sighs and turns to you." +
    "\nJIMMY ECCLESTONE: How about you talk to them friends then, huh?" +
    "\nJimmy then faces Kenna." +
    "\nJIMMY ECCLESTONE: Give " + player.name + " the contact information. I've got things to do.");

    Scanner in2 = new Scanner(System.in);
    System.out.println("1 - Stop Jimmy (-1 energy)");
    System.out.println("2 - Don't stop Jimmy (-0 energy)");
    player.amountEnergy();
    choice = in2.nextLine();
    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.Jimmy();
      player.regularEnergy();
      player.upKnowledge();
      System.out.println("JIMMY ECCLESTONE: What? I've already made plans with a couple of lads. I'm trying to make a gain in BlackJack... Are you judging me for it?");

      Scanner in3 = new Scanner(System.in);
      System.out.println("1 - No. (-1 energy)");
      System.out.println("2 - Yes. (-1 energy)");
      System.out.println("3 - Don't say anything. (-0 energy)");
      player.amountEnergy();
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
      else if (choice.equals("3")) {
        System.out.println("JIMMY ECCLESTONE: Okay, don't say anything. I will be on my way.");
      }
      else {
        wrongChoice();
        }
    } //end stop jimmy
    else if (choice.equals("2")) {

    }
    else {
      wrongChoice();
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
    System.out.println("1 - I'll take you up on your offer. (-2 energy)");
    System.out.println("2 - I'll just head to the casino. (-1 energy)");
    System.out.println("3 - I'll go home. (-0 energy)");
    player.amountEnergy();
    choice = in4.nextLine();
    if (choice.equals("1") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("2") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.lotEnergy();
      player.upKnowledge();
      System.out.println("KENNA ECCLESTONE: All right, my head butler will bring you to the bathroom." +
      "\nWith a snap of Kenna's fingers, the doors are opened by a middle aged man. You assume that he is the head butler." +
      "\nKENNA ECCLESTONE: This is Private Investigator " + player.name + ". Please escort " + player.name + " to the bathroom and then to the exit." +
      "\nThe man nods his head." +
      "\nHEAD BUTLER: Hello, PI " + player.name + ". Please, follow me." +
      "\nYou trail after the head butler after casting a look at Kenna, noticing that she seemed visibly upset while talking into the phone.");

      Scanner in5 = new Scanner(System.in);
      System.out.println("Do you pity Kenna?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-1 energy)");
      System.out.println("3 - You're neutral. (0 energy)");
      player.amountEnergy();
      choice = in5.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.Kenna();
      }
      else if (choice.equals("2")) {
        player.regularEnergy();
        player.Jimmy();
      }
      else if (choice.equals("3")) {

      }
      else {
        wrongChoice();
      }

      Scanner in6 = new Scanner(System.in);
      System.out.println("You and the head butler walk silently down the hallway. You walk for quite some time. Do you...");
      System.out.println("1 - Start up conversation (-2 energy)");
      System.out.println("2 - Continue to walk in silence (-1 energy)");
      System.out.println("3 - Stop following the head butler and try to go into another room (-1 energy)");
      player.amountEnergy();
      choice = in6.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("3") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.lotEnergy();
        player.upKnowledge();
        System.out.println("YOU: So... " +
        "\nHEAD BUTLER: ..?" +
        "\nYOU: How long have you worked here?" +
        "\nHEAD BUTLER: Well, I have been working here for the past decade." +
        "\nYOU: Do you enjoy working here?" +
        "\nHEAD BUTLER: ... I would say so. The Ecclestone's treat me well, and Marisa has always been a dear. Though, I can't speak the same of those friends of hers..." +
        "\nYOU: Speaking of Ma-" +
        "\nHEAD BUTLER: We have arrived. I trust that you will be able to leave this premise after you're done with the facilities." +
        "\nYOU: Of course, of course. But, may I have a conversation with you about Marisa later on?" +
        "\nHEAD BUTLER: Someday, for I have some things to attend to at the moment." +
        "\nYou nod your head in agreeance as the head butler leaves." +
        "\nOnce you finish your business, you decide to...");

        Scanner in7 = new Scanner(System.in);
        System.out.println("1 - Go to the casino (-1 energy)");
        System.out.println("2 - Go home (-0 energy)");
        player.amountEnergy();
        choice = in7.nextLine();
        if (choice.equals("1") && player.getEnergy() < 1) {
          System.out.println("You don't have enough energy to do that!");
        }
        else if (choice.equals("1")) {
          player.regularEnergy();
          gotoCasino();
        }
        else if (choice.equals("2")) {

        }
        else {
          wrongChoice();
        }
      }
    else if (choice.equals("2")) {
      player.lotEnergy();
      System.out.println("\nHEAD BUTLER: We have arrived. I trust that you will be able to leave this premise after you're done with the facilities." +
      "\nYOU: Of course, of course. But, may I have a conversation with you later on?" +
      "\nHEAD BUTLER: Someday, for I have some things to attend to at the moment." +
      "\nYou nod your head in agreeance as the head butler leaves." +
      "\nOnce you finish your business, you decide to...");
      Scanner in8 = new Scanner(System.in);
      System.out.println("1 - Go to the casino (-1 energy)");
      System.out.println("2 - Go home (-0 energy)");
      player.amountEnergy();
      choice = in8.nextLine();
      if (choice.equals("1")) {
        player.regularEnergy();
        gotoCasino();
      }
      else if (choice.equals("2")) {
      }
      else {
        wrongChoice();
      }
    }
    else if (choice.equals("3")) {
      player.regularEnergy();
      System.out.println("You do so, but the head butler is quick to stop you from entering any other rooms." +
      "\nHEAD BUTLER: What do you think you're doing?" +
      "\nYou are unable to form a coherent response and thusly get kicked out of the mansion. Additionally, once Kenna was notified of your behavior, you were fired from the case." +
      "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      System.exit(0);
    }
    else {
      wrongChoice();
      }
    } // End of taking up on offer !
    else if (choice.equals("2")) {
      player.regularEnergy();
      gotoCasino();
    }
    else {
      System.out.println("You go back home for more rest.");

      System.out.println("______________" +
      "\n| ___________ |" +
      "\n| |_________| |" +
      "\n|_____________|" +
      "\n|_____________|" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|_____________|");

      player.upEnergy();
    }
  }

  public static void dayTwo() {
    player.dayEnergy();
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 2");
    printStats(player);

    System.out.println("You feel refreshed. You received Kenna's email and decided to contact Marisa's friends for some clues.");

    Scanner in = new Scanner(System.in);
    System.out.println("Who do you want to contact first?");
    System.out.println("1 - Klaus");
      friends.add("Klaus");
    System.out.println("2 - Adeline");
      friends.add("Adeline");
    System.out.println("3 - Jonas");
      friends.add("Jonas");
    String choice = in.nextLine();
    if (choice.equals("1")) {
      friend1.setName("KLAUS");
      friends.remove(0);
    }
    else if (choice.equals("2")) {
      friend1.setName("ADELINE");
      friends.remove(1);
    }
    else if (choice.equals("3")) {
      friend1.setName("JONAS");
      friends.remove(2);
    }
    else {
      wrongChoice();
    }

    System.out.println("You decide to call " + friend1 + "." +
    "\nYou wait a couple of seconds before the receiver picks up." +
    "\n" + friend1 + ": ...Hello?" +
    "\nYOU: Hello, I am a Private Investigator hired by Marisa's parents to investigate her disappearance." +
    "\n" + friend1 + ": ...." +
    "\nYOU: I understand that you are a friend of hers. Do you mind meeting up so I can know more details about her?" +
    "\n" + friend1 + ": Sure, I don't mind. Where should we meet up?" +
    "\nYOU: Let's meet up at...");

    Scanner in2 = new Scanner(System.in);
    System.out.println("1 - Knox Beat Cafe");
    System.out.println("2 - Marblin Dine");
    player.amountEnergy();
    choice = in2.nextLine();
    if (choice.equals("1")) {
      System.out.println(friend1 + ": Okay then, I'll meet you there. I'll be wearing a green shirt with the design of the queen of spades." +
      "\nThe call ends, and you leave your house after grabbing the neccessary goods." +
      "\n-------------------------------------------------------------------------------" +
      "\n                                 KNOX BEAT CAFE                                " +
      "\n-------------------------------------------------------------------------------");
      walkinDay2();
      questionSet1();
      questionSet2();
      questionSet3();
      System.out.println("Your conversation with " + friend1 + "comes to a close when you see a lady by the cashier that looks familiar.");

      Scanner out = new Scanner(System.in);
      System.out.println("Who do you think it is?");
      System.out.println("1 - Marisa");
      System.out.println("2 - Kenna");
      System.out.println("3 - Head Maid");
      choice = out.nextLine();
      if (choice.equals("2")) {
        player.Kenna();
        System.out.println("Your suspicions are proven true when the lady turns around... revealing it to be Kenna.");
      }
      else if (choice.equals("1") || choice.equals("3")) {
        System.out.println("The lady turns around... revealing it to be Kenna.");
      }

      System.out.println("Kenna also notices you and makes her way over." +
      "\nKENNA ECCLESTONE: Well, if it isn't " + player.name + " and " + friend1 + ". Lovely to see you both here." +
      "\n" + friend1 + ": Hello, Mrs. Ecclestone." +
      "\nYOU: Hello, Kenna.");

      Scanner in11 = new Scanner(System.in);
      System.out.println("1 - Ask her what she is doing here. (-1 energy)");
      System.out.println("2 - Ask her what she is drinking. (-1 energy)");
      System.out.println("3 - Just stare at her. (-0 energy)");
      player.amountEnergy();
      choice = in11.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.upKnowledge();
        player.clueCafe = true;
        System.out.println("KENNA ECCLESTONE: Well, I come here every morning to get my daily caffeine." +
        "\nKenna lets out a laugh, and you notice " + friend1 + " smile awkwardly.");
      }
      else if (choice.equals("2")) {
        player.regularEnergy();
        player.upKnowledge();
        player.clueCoffee = true;
        System.out.println("KENNA ECCLESTONE: Oh, I usually have a bold roasted coffee with hazelnut syrup and half and half." +
        "\nKenna lets out a laugh, and you notice " + friend1 + " smile awkwardly.");
      }
      else if (choice.equals("3")) {
        System.out.println("KENNA ECCLESTONE: ...");
      }
      else {
        wrongChoice();
      }

      System.out.println("KENNA ECCLESTONE: So, what are ya'll doing here?");

      Scanner in12 = new Scanner(System.in);
      System.out.println("You and " + friend1 + " look at each other." +
      "You choose to...");
      System.out.println("1 - Say that you are here questioning " + friend1 + ". (-2 energy)");
      System.out.println("2 - Say that you just met " + friend1 + ". (-1 energy)");
      System.out.println("3 - Stare at Kenna. (-0 energy)");
      player.amountEnergy();
      choice = in12.nextLine();
      if (choice.equals("1") && player.getEnergy() < 2) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("2") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.lotEnergy();
        player.Kenna();
        player.upKnowledge();
        System.out.println("KENNA ECCLESTONE: That's great! Jimmy and I have just been so busy that we haven't had the chance to ask Marisa's friends whether they know her whereabouts.");
        if (player.clueMansion == true) {
          player.upKnowledge();
          System.out.println("You know that " + friend1 + " went over to the Ecclestone mansion but were denied entrance. Is Kenna aware of that? Should you ask?" +
          "/Let's see if you have enough knowledge points.");
          if (player.getKnowledge() > 20) {
            System.out.println("YOU: But I heard that " + friend1 + " went to your mansion, and your head butler denied him entrance." +
            "\nKenna had a look of surprise on her face and looked at " + friend1 + "." +
            "\nKENNA ECCLESTONE: Is that true?" +
            "\n" + friend1 + " nods their head." +
            "\nKENNA ECCLESTONE: I was not aware of that. I'll look into it.");
          }
          else {
            player.amountKnowledge();
            System.out.println("You don't have enough knowledge points.");
          }
        }
        else {
          wrongChoice();
        }
      } // END OF QUSETIONING FRIEND1
      else if (choice.equals("2")) {
        player.regularEnergy();
        System.out.println("Kenna looks skeptical." +
        "\nKENNA ECCLESTONE: Well, then. That is quite a coincidence since the person you're conversing with is actually one of my dear Marisa's friends." +
        "\nYou just smile.");
      }
      else if (choice.equals("3")) {
        System.out.println("KENNA ECCLESTONE: ...");
      }
      else {
        wrongChoice();
      }

      System.out.println("Kenna, standing where she is, then takes multiple sips of her coffee while looking distraught." +
      "\nYou find this a bit weird so do you ask her?");

      Scanner in13 = new Scanner(System.in);
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-0 energy)");
      player.amountEnergy();
      choice = in13.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        player.Kenna();
        System.out.println("YOU: Kenna, is there something wrong?" +
        "\nKenna lets out a sigh of relief as if she was glad you asked her. She sits in the seat next to you.");
        kennaRant();
      }
      else if (choice.equals("2")) {
        System.out.println(friend1 + " decides to say something." +
        "\n" + friend1 + ": Mrs. Ecclestone, is there something wrong?" +
        "\nKenna lets out a sigh of relief as if she was glad that " + friend1 + " asked her. She sits next to them.");
        kennaRant();
      }
      else {
        wrongChoice();
      }

      if (player.clueKennaRant == true) {
        System.out.println("YOU: That was unexpected..." +
        "\n" + friend2 + ": Well, for you perhaps. But, I always had an inkling that this would happen." +
        "YOU: That what would happen?" +
        "\n" + friend2 + ": Mrs. and Mr. Ecclestone bully eaach other. I was anticipating when they would be bored of bullying each other, and it seems like the time is now." +
        "YOU: Interesting...");;
      }
      else if (player.clueWrongKenna == true) {
        System.out.println("You have the feeling that you shouldn't have brought that up..." +
        "YOU: Do you have an idea of what has happened?" +
        "\n" + friend2 + ": Well, roughly. Mrs. and Mr. Ecclestone always had their disagreements. It was only a matter of time of when they would be tired of their disagreements and of each other.");
      }
      else {
        System.out.println("YOU: Do you have an idea of what has happened?" +
        "\n" + friend2 + ": Well, roughly. Mrs. and Mr. Ecclestone always had their disagreements. It was only a matter of time of when they would be tired of their disagreements and of each other.");
      }

      System.out.println("YOU: Well, I will take note of this nonetheless." +
      "\n" + friend3 + " nods their head." +
      "\nYOU: I'm also going to depart since there is something I have to do." +
      "\n" + friend3 + ": Okay, bye! Oh, and do let me know if you find any new leads. I do want to be of help..." +
      "\nYOU: I will, don't worry.");
    }
    else if (choice.equals("2")) {
      System.out.println(
      ": Okay then, I'll meet you there. I'll be wearing a green shirt with the design of the queen of spades." +
      "\nThe call ends, and you leave your house after grabbing the neccessary goods." +
      "\n-------------------------------------------------------------------------------" +
      "\n                                  MARBLIN DINE                                 " +
      "\n-------------------------------------------------------------------------------");
      walkinDay2();
      questionSet1();
      questionSet2();
      questionSet3();
      System.out.println("Your conversation ends as " + friend3 + "departs as he has other matters to attend to." +
      "\nYou are about to leave when you recognize a man amongst a group of men chattering and eating.");

      Scanner out2 = new Scanner(System.in);
      System.out.println("Who do you tink it is?");
      System.out.println("1 - Jimmy");
      System.out.println("2 - Head Butler");
      choice = out2.nextLine();
      if (choice.equals("1")) {
        player.Jimmy();
        System.out.println("Your suspicions are proven correct when you have walk a bit closer and observe it to be Jimmy.");
      }
      else if (choice.equals("2")) {
        System.out.println("You walk a bit closer and observe the man to be Jimmy.");
      }
      else {
        wrongChoice();
      }

      System.out.println("Jimmy and you have eye contact and a frown makes its way on Jimmy's face.");

      Scanner in14 = new Scanner(System.in);
      System.out.println("What do you do?");
      System.out.println("1 - Greet him. (-1 energy)");
      System.out.println("2 - Walk past his table. (-0 energy)");
      player.amountEnergy();
      choice = in14.nextLine();
      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        System.out.println("YOU: Hello, Jimmy." +
        "\nThe men at the table stop chattering to look at you." +
        "\nMAN 1: A friend of yours, Jim?" +
        "\nJIMMY ECCLESTONE: Not so much a friend, but an acquaintence." +
        "\nMAN 2: Who are they really, then?" +
        "\nJIMMY ECCLESTONE: Someone hired by Kenna." +
        "\nMAN 3: None of this Kenna talk.");

        Scanner in15 = new Scanner(System.in);
        System.out.println("Do you ask why so?");
        System.out.println("1 - Yes. (-1 energy)");
        System.out.println("2 - Leave the table. (-0 energy)");
        player.amountEnergy();
        choice = in15.nextLine();

        if (choice.equals("1") && player.getEnergy() < 1) {
          System.out.println("You don't have enough energy to do that!");
        }
        else if (choice.equals("1")) {
          player.regularEnergy();
          player.upKnowledge();
          System.out.println("The men look at you in surprise." +
          "\nMAN 1: Have you not had a conversation with her?" +
          "\nYou are confused." +
          "\nYOU: I have..." +
          "\nMAN 2: Well, then. I'm sure you have only recently got to know her. She is quite charming when you do get to know her -- that's how my chap Jim here got to fall in love with her." +
          "\nJimmy nods his head in agreement, taking a sip of coffee.");

          Scanner in16 = new Scanner(System.in);
          System.out.println("Do you ask how Kenna has changed?");
          System.out.println("1 - Yes. (-1 energy)");
          System.out.println("2 - No. (-0 energy)");
          player.amountEnergy();
          choice = in16.nextLine();
          if (choice.equals("1") && player.getEnergy() < 1) {
            System.out.println("You don't have enough energy to do that!");
          }
          else if (choice.equals("1")) {
            player.regularEnergy();
            System.out.println("JIMMY ECCLESTONE: Well, I suppose I fell in love with college her. She was charming, sure. But, after getting married and having lived alongside her, she's changed. I don't know if she started showing her real colors, but it was not the Kenna I fell in love with and married." +
            "\nMAN 3: Truly a shame.");
          }
          else if (choice.equals("2")) {

          }
          else {
            wrongChoice();
          }

          System.out.println("YOU: What are you doing here, Jimmy?" +
          "\nJimmy frowns." +
          "\nMAN 1: Well..." +
          "\nJIMMY ECCLESTONE: I had an argument with Kenna last night. She kept meddling in my business." +
          "\nYOU: ..." +
          "\nJimmy's friend, noticing his change, decided to change the subject." +
          "\nMAN 2: Well, let's head over to the ol' place, huh?" +
          "\nJIMMY ECCLESTONE: We shall." +
          "\nJimmy takes one last sip of the coffee and gets up. He turns to you." +
          "\nJIMMY ECCLESTONE: See you soon, I suppose." +
          "\nYou bid him farewell.");
        }
        else if (choice.equals("2")) {
          player.Kenna();
          System.out.println("You don't want to hear Jimmy and his friends talk badly about Kenna so you decide to leave.");
        }
        else {
          wrongChoice();
        }
      }
      else if (choice.equals("2")) {
        Scanner in16 = new Scanner(System.in);
        System.out.println("You hear a scoff from the table, but decide to keep walking.");
      }
      else {
        wrongChoice();
      }
    }
    else {
      wrongChoice();
    }

    Scanner in17 = new Scanner(System.in);
    System.out.println("You leave. What do you do now?");
    System.out.println("1 - Go to the casino (-1 energy)");
    System.out.println("2 - Go home (-0 energy)");
    player.amountEnergy();
    choice = in17.nextLine();

    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      gotoCasino();
    }
    else if (choice.equals("2")) {
      System.out.println("______________" +
      "\n| ___________ |" +
      "\n| |_________| |" +
      "\n|_____________|" +
      "\n|_____________|" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|_____________|");

      player.upEnergy();
    }
    else {
      wrongChoice();
    }
  }

  public static void dayThree() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 3");
    player.dayEnergy();
    printStats(player);

    friend1.die();

    System.out.println("     _____" +
    "\n____|   |" +
    "\n|________|" +
    "\n  ^    ^");


    System.out.println("You pull into the mansion, but feel as if something was off. Your suspicions are proven right as you hear a commotion. Two panicked teenagers run up to you.");
    String tempfriend2 = friends.get(0);
    String tempfriend3 = friends.get(1);
    System.out.println(tempfriend2 + ": YOU!");

    while (true) {
      Scanner q = new Scanner(System.in);
      System.out.println("What are you?");
      String choice = q.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("private investigator") || choice.equals("PI")) {
        break;
      }
      else {
        System.out.println("No... what are you really?");
      }
    }

    System.out.println(tempfriend2 + ": You're the private investigator, right?" +
    "\nThey looked frantic and angry.\n" +
    "\nYOU: Yes, that's me. What's going on here?\n" +
    "\n" + tempfriend3 + ": " + friend1 + " is dead because of you!" +
    "\nYOU: Let's calm down here. What do you mean they're dead?\n" +
    "\n" + tempfriend2 + ": The head butler found " + friend1 + " in the garden shed out back.\n" +
    "\n" + tempfriend3 + ": Right after you talked to them yesterday. Right after Marisa disappeared." +
    "\nYOU: Can I see the body? Maybe there are still clues as to what happened to them.\n" +
    "\n" + tempfriend2 + ": Hell no! I don't want to be involved with this at all!\n" +
    "\n" + tempfriend3 + ": The last person that helped you is dead now... I'm not risking it!");

    System.out.println("\nWho do you want to convince to help you?");
    System.out.println("1 - " + tempfriend2);
    System.out.println("2 - " + tempfriend3);

    Scanner in1 = new Scanner(System.in);
    String choice = in1.nextLine();
    if (choice.equals("1")) {
      friend2.setName(tempfriend2);
      friend3.setName(tempfriend3);
    }
    else if (choice.equals("2")) {
      friend2.setName(tempfriend3);
      friend3.setName(tempfriend2);
    }
    else {
      wrongChoice();
    }

    System.out.println("YOU: " + friend2 + ", I know this is difficult, but the sooner we solve the case, the sooner it'll be over. The murderer won't just stop now that they have a taste for killing.\n" +
    friend2 + ": ... I suppose I can help. But I'm doing this to help Marisa and avenge" + friend1 + "\n" +
    friend3 + ": Are you kidding me? Whatever. I'm out of here!\n\n" +
    friend3 + " runs off the lot while you and " + friend2 + " make your way to the garden shed\n\n" +
    "YOU: Where did the body go?\n" +
    friend2 + ": The head butler called for someone to take it away. He was adamant about it being removed as quickly as possible.");

    while (true) {
      System.out.println("Do you find it strange?");
      Scanner q1 = new Scanner(System.in);
      choice = q1.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("yes")) {
        break;
      }
      else {
      }
    }

    System.out.println("YOU: That's a strange reaction. Someone dies on his watch and his first reaction is to get rid of the body?\n" +
    friend2 + ": Well... I didn't think about it that way. He's a queasy sort of person. Sort of a germophobe. Was never quite fond of us, except for Marisa.\n" +
    "YOU: Us... as in you and " + friend1 + "?\n" +
    friend2 + ": All of us. " + friend1 + ", " + "Marisa, " + friend3 + ", me. We pick up after ourselves when we hang out at Marisa's, but he constantly complains about picking up after us.\n" +
    "YOU: Still... quite the strange reaction to a murder. Where's the empathy?");

    player.upKnowledge();

    while (true) {
      System.out.println("Look around. (2 words)");
      Scanner q2 = new Scanner(System.in);
      choice = q2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("look around")) {
        break;
      }
      else {

      }
    }

    System.out.println("You look around the shed and notice a large arsenal of tools and supplies.");

    System.out.println("YOU: Did you see the body before he disposed of it? I'm sure there was some sort of evidence that would be useful right about now.\n" +
    friend2 + ": I did, for a bit. The one thing that stood out was a bruise on " + friend1 + "'s head.\n" +
    "YOU: Head trauma. Unfortunately for us, almost everything in this shed could've been used to inflict head trauma. Doesn't narrow it down much.\n" +
    friend2 + " looks around as well. A golf club catches their eye.\n" +
    friend2 + ": A golf club. Marisa's dad is a huge fan of golfing. I wonder how he's handling all of this. It must be hard, especially with Kenna around.");

    player.upKnowledge();

    System.out.println("\nIt seems like " + friend2 + " is about to badmouth Kenna. What will you do?");
    System.out.println("1 - Defend Kenna (-2 energy)");
    System.out.println("2 - Sympathize with Jimmy (-2 energy)");
    System.out.println("3 - Change the subject (-0 energy)");
    player.amountEnergy();

    Scanner in2 = new Scanner(System.in);
    choice = in2.nextLine();

    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.lotEnergy();
      player.Kenna();
      System.out.println("YOU: Hey, she's been having a hard time as well. At least she's trying her best to help out with the investigation.\n" +
      friend2 + ": ...I suppose. She seems nervous as well. I saw her pacing around for nearly an hour yesterday at the pier.\n");
    }
    else if (choice.equals("2")) {
      player.lotEnergy();
      player.Jimmy();
      System.out.println("YOU: Right? She's insufferable! It feels like she's using this as an excuse to feud with her husband\n" +
      friend2 + ": I couldn't agree more. They've been having marital problems since Marisa was 6. I wonder why he doesn't leave her.");
    }
    else if (!choice.equals("3")) {
      wrongChoice();
    }

    System.out.println("YOU: Let's stay focused. Now that I look at it again, the golf club seems a lot dirtier compared to the other tools.\n" +
    friend2 + ": I guess Marisa's dad must've played pretty recently then.\n" +
    "YOU: If he played BlackJack with his friends 2 days ago, then he must've played pretty recently. He'd be in the area of the kill.\n" +
    "YOU: And the butler is attentive to cleanliness, but didn't bother to clean the golf club?\n" +
    "YOU: I haven't seen Kenna at all either. She seems pretty busy with all those phone calls...\n" +
    friend2 + ": Hah... It could be anyone! How are we getting anywhere with this?");

    player.upKnowledge();

     System.out.println(" ____" +
     "\n |  |" +
     "\n |  |" +
     "\n |  |" +
     "\n |  |" +
     "\n |__|" +
     "\n  ___" +
     "\n  |_|");

    System.out.println("You follow " + friend2 + " as they leave the shed. " + friend2 + " puts a hand on their face and looks out into the garden.");

    System.out.println("What do you want to do now?");
    System.out.println("1 - Ask if Marisa seemed 'off' the last time they saw her. (-2 energy)");
    System.out.println("2 - Find someone to question (-1 energy)");
    System.out.println("3 - Leave " + friend2 + " for now (-0 energy)\n");
    player.amountEnergy();

    Scanner in3 = new Scanner(System.in);
    choice = in3.nextLine();

    if (choice.equals("1") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("2") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.lotEnergy();
      player.upKnowledge();
      if (player.clueBeach == true) {
        player.upKnowledge();
        System.out.println("I heard from " + friend1 + " that you and your friends last saw Marisa at the beach. Did she seem off at all?");
      }
      else {

      }
      System.out.println(friend2 + ": Not that I know of? I mean, she usually seems a bit down because her parents are constantly fighting. It's not out of the ordinary.\n" +
      "YOU: I see. Is there anything else you can tell me about that day?\n" +
      friend2 + ": Now that I'm thinking about it... Usually, it's the head butler that drives us. For some reason, he got sick that day. But he never gets sick.\n" +
      "YOU: A butler dead set on cleanliness falling ill. Interesting. Thank you, " + friend2 + ".\n");
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      player.upKnowledge();
      System.out.println("You and " + friend2 + " walk inside the mansion. It's quite empty today. The only person you see is the head maid.\n");

      System.out.println("Do you wish to go speak to her [the head maid]?");
      System.out.println("1 - Yes (-1 energy)");
      System.out.println("2 - No (-0 energy)");
      player.amountEnergy();

      Scanner in4 = new Scanner(System.in);
      choice = in4.nextLine();

      if (choice.equals("1") && player.getEnergy() < 1) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.regularEnergy();
        System.out.println("YOU: Good morning! You are the head maid, yes?\n" +
        "HEAD MAID: That's me! Did you need something?\n" +
        friend2 + ": Did you hear about what happened to " + friend1 + "?\n" +
        "HEAD MAID: Yes, it's truly terrible. I can only hope this all ends soon.\n" +
        "YOU: We were hoping you'd have some information that could help us. You were here yesterday?\n" +
        "HEAD MAID: Ah, yes, I was. I left early and headed upstate to my mother's last night. She has cancer.\n" +
        "YOU: I'm so sorry. I hope she gets better.\n" +
        "HEAD MAID: What I can tell you, though: I manage everyone's schedule. I can tell you where people were last night.\n");

        System.out.println("This is a great opportunity! Who do you want to ask about?");
        boolean hasQuestions = true;

        while (hasQuestions) {
          System.out.println("This is a great opportunity! Who do you want to ask about?");
          System.out.println("1 - The head butler (-1 energy)");
          System.out.println("2 - Kenna (-1 energy)");
          System.out.println("3 - Jimmy (-1 energy)");
          System.out.println("4 - I don't have anymore questions.");
          player.amountEnergy();

          Scanner in5 = new Scanner(System.in);
          choice = in5.nextLine();

          if (!choice.equals(4) && player.getEnergy() < 1) {
            System.out.println("You don't have enough energy to do that!");
          }
          else if (choice.equals("1")) {
            player.regularEnergy();
            System.out.println("HEAD MAID: The head butler was supposed to inspect the kitchen last night. He's usually diligent with his tasks, but the cooking crew reported that he arrived an hour late, seemingly out of breath.");
            System.out.println("YOU: Hmm... interesting.");
          }
          else if (choice.equals("2")) {
            player.regularEnergy();
            System.out.println("HEAD MAID: Kenna told maid Clarke that she was having a headache and spent the night in her bedroom. She refused any medicine.");
            System.out.println("YOU: Hmm... interesting.");
          }
          else if (choice.equals("3")) {
            player.regularEnergy();
            System.out.println("HEAD MAID: Jimmy didn't return home from the casino last night. He said he needed to 'let loose'.");
            System.out.println("YOU: Hmm... interesting.");
          }
          else if (choice.equals("4")) {
            System.out.println("HEAD MAID: Great! I trust that you will solve the case soon, PI" + player + ".");
            hasQuestions = false;
          }
          else {
            wrongChoice();
          }

          System.out.println("YOU: Thank you for your time.\n" +
          "HEAD MAID: Happy to help! I trust that you'll solve this case soon, PI " + player + ". " + friend2 + ", you can show " + player + " where the entrance is, right? It's getting late.\n" +
          friend2 + ": Yes, good night!\n");

          System.out.println("You and " + friend2 + " leave the mansion.");
          System.out.println("YOU: I don't think she did it.\n" +
          friend2 + ": I could've told you that. Sharon would never hurt anyone.\n" +
          "YOU: Well, it is quite dark outside. We should part ways. I'll see you tomorrow.\n" +
          friend2 + ": Alright. Stay safe.\n");
        }


      }
    }
    System.out.println("You and " + friend2 + " part ways. What do you want to do now?");

    Scanner in6 = new Scanner(System.in);
    System.out.println("1 - Go to the casino (-1 energy)");
    System.out.println("2 - Go home (-0 energy)");
    choice = in6.nextLine();


    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      gotoCasino();
    }
    else if (choice.equals("2")) {
      System.out.println("______________" +
      "\n| ___________ |" +
      "\n| |_________| |" +
      "\n|_____________|" +
      "\n|_____________|" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|             |" +
      "\n|_____________|");

      player.upEnergy();
    }
    else {
      wrongChoice();
    }
  }

  public static void dayFour() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 4");
    player.dayEnergy();
    printStats(player);

    friend2.die();

    System.out.println("You were sleeping when you are woken up by the ringing of your phone." +
    "\nYOU: ..." +
    "\nYou choose to ignore the first few rings in hope that the person calling you would stop doing so, but the ringing kept continuing. So, you, half awake and disgruntled, grab your phone on your bedside and answer the call." +
    "\nYOU: ..Hello?" +
    "\nYou are met with a few seconds of silence before you hear a low sob.");

    Scanner in = new Scanner(System.in);
    System.out.println("Who do you think is on the other end of this call?");
    System.out.println("1 - " + friend2);
    System.out.println("2 - " + friend3);
    System.out.println("3 - Kenna");
    System.out.println("4 - Jimmy");
    System.out.println("5 - Head Butler");
    System.out.println("6 - Head Maid");
    System.out.println("7 - Marisa");
    String choice = in.nextLine();
    if (choice.equals("1") || choice.equals("2") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7")) {
      System.out.println("..." +
      "\nKENNA ECCLESTONE: No... it's me, Kenna.");
    }
    else if (choice.equals("3")) {
      player.upKnowledge();
      System.out.println("...");
    }
    else {
      wrongChoice();
    }

    System.out.println("KENNA ECCLESTONE: I don't know... Something happened..." +
    "\nYou hear mumbling and incoherent words.");

    while (true) {
      Scanner w = new Scanner(System.in);
      System.out.println("What happened? (2 words)");
      choice = w.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("what happened")) {
        break;
      }
      else {

      }
    }

    System.out.println("YOU: What? What happened..?" +
    "\nKENNA ECCLESTONE: I - So I was missing Marisa... and I heard from someone that Marisa likes the beach so I went to the beach." +
    "\nYou sense a hesitance in her tone so you try to coax her to continue speaking." +
    "\nYOU: That's nice..." +
    "\nKENNA ECCLESTONE: So I went to the beach, yeah. And... I don't know, I don't know. I was just walking when I saw something poking out of the sand -- almost like a twig." +
    "\nYOU: Mhm." +
    "\nKENNA ECCLESTONE: I don't normally pull twigs out of sand or anything like that, but the twig was colored peculiarly so I decided to." +
    "\nYou are a bit skeptical on why this is of importance to call you early in the morning but you continue listening." +
    "\nKenna then proceeds to sob loudly.");

    System.out.println("            __" +
    "\n           / /" +
    "\n__________/_/_________" +
    "\n|____________________|");

    System.out.println("KENNA ECCLESTONE: But, it wasn't a twig or something. It was a leg -- a mutilated one at that." +
    "\nYou tense up.");

    while (true) {
      System.out.println("... What did Kenna just say the twig was? (2 words)");
      Scanner w2 = new Scanner(System.in);
      choice = w2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("a leg")) {
        break;
      }
      else {

      }
    }

    System.out.println("YOU: What do you mean.. a leg?" +
    "\nKENNA ECCLESTONE: I don't know, I don't know. I didn't realize that it was a leg at first, so I kept pulling it. But..." +
    "\nAt this point, Kenna is breaking down and sobbing. She spits out the next few words quickly..." +
    "\nKENNA ECCLESTONE: It's " + friend2 + "." + friend2 + ", " + friend2 + ". Oh my God, what happened?" +
    "\nYour blood turns cold, and you say the next words in denial.");

    while (true) {
      System.out.println("How do you feel (1 word)?");
      Scanner w3 = new Scanner(System.in);
      choice = w3.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("fearful") || choice.equals("scared") || choice.equals("doubtful") || choice.equals("suspicious")) {
        break;
      }
      else {

      }
    }

    System.out.println("YOU: " + friend2 + " ? It can't be... I saw them just yesterday." +
    "\nKENNA ECCLESTONE: I don't know, I don't know. God, why did this happen?" +
    "\nYou are in utter shock, but you decide to see the body for yourself." +
    "\nYOU: I'm coming, I'm coming. I'm going over to you, Kenna. Stay where you are and call the others." +
    "\nKenna lets out a sound that you think means that she will, so you end the call.");

    System.out.println("Where are you going? (1 word)");
    while (true) {
      Scanner in2 = new Scanner (System.in);
      choice = in2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("beach")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("------------------------------------------------------------------------------" +
    "\n" +
    "\n=================================DRIVING======================================" +
    "\n" +
    "\n------------------------------------------------------------------------------");

    System.out.println("When you park your car, you see " + friend3 + " in the parking lot, waiting for you.\n" +
    friend3 + " looks in a frazzled state.\n" +
    friend3 + ": Y-you talked to " + friend2 + " yesterday. They're dead now. You talked to " + friend1 + " the day before. They're also dead now. What the hell is going on?\n" +
    "YOU: ...I understand that-\n" +
    friend3 + ": The more you try to meddle in this business, the more people die!\n" +
    "YOU: ...I was hired to solve the case-\n" +
    friend3 + ": And I'm telling you that you're making things worse. This shouldn't have happened... This can't have happened.\n" +
    "YOU: Look, we can stand here and fight all you want, but the killer is still out there and we need to put them behind bars.\n" +
    "You notice that " + friend3 + " is conflicted.\n" +
    "YOU: If you agree to help me, we can solve this case together. Don't you want to avenge your friends? Afterward, you can get on with your life.\n" +
    friend3 + ": ..And if I die as well?");

    System.out.println("Comfort " + friend3);
    Scanner e = new Scanner(System.in);
    System.out.println("1 - I'll stay with you.");
    System.out.println("2 - You'll be fine.");
    choice = e.nextLine();
    if (choice.equals("1") || choice.equals("2")) {

    }
    else {
      wrongChoice();
    }

    System.out.println(friend3 + " stays silent for a few seconds. Their facial expression indicates that they are conflicted. Though, after a minute, they speak...\n" +
    friend3 + ": I don't think my life can go back to normal after this. But, I'll try my best. To help.\n");

    System.out.println("The two of you head down the beach and spot...");

    System.out.println("Who do you see?");
    while (true) {
      Scanner e2 = new Scanner(System.in);
      choice = e2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("kenna")) {
        break;
      }
      else {
        System.out.println("No... who do you really see?");
      }
    }

    System.out.println("KENNA: Thank God you're here.\n" +
    "She looks at " + friend3 + ".\n" +
    "KENNA: You too.\n" +
    friend3 + ": I'll help out anyway I can.\n" +
    "YOU: Can you bring us to the body?\n" +
    "KENNA: I don't think I can look at it again, but it's over there.\n" +
    "You and " + friend3 + " follow where she points her finger.\n" +
    "YOU: By the trees?\n" +
    "KENNA: Yes. I can't be here anymore. I want -- no, I need to go.\n");

    System.out.println("Kenna, distraught, wants to leave... Do you have one final question you want to ask her before she does?");
    System.out.println("1 - Do you know where Jimmy is? (-2 energy)");
    System.out.println("2 - Do you know where the head butler is? (-2 energy)");
    System.out.println("3 - Where are you going? (-2 energy)");
    System.out.println("4 - No more questions (-0 energy)");
    player.amountEnergy();

    Scanner inQuestion = new Scanner (System.in);
    choice = inQuestion.nextLine();

    if (choice.equals("1") || choice.equals("2") || choice.equals("3") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      System.out.println("KENNA: Jimmy... He didn't even sound concerned when I called. Sounded drunk, too. I couldn't care less where he's been.\n");
      player.lotEnergy();
    }
    else if (choice.equals("2")) {
      System.out.println("KENNA: The butler... I called Sharon earlier this morning. No one has seen him since he found " + friend2 + "'s body yesterday.\n'");
      player.lotEnergy();
    }
    else if (choice.equals("3")) {
      System.out.println("KENNA: Me? I don't know. Far away from this mess.\n");
      player.lotEnergy();
    }
    else if (choice.equals("4")) {
      player.Kenna();
    }
    else {
      wrongChoice();
    }

    System.out.println("YOU: Alright... I'll let you go then.\n");

    System.out.println("You and " + friend3 + " walk up to the body.\n" +
    "You felt like vomiting but held it in.\n" +
    friend3 + ": God, it's worse than I imagined...\n" +
    "YOU: The smell is almost worse than the sight.\n" +
    "And that was true... " + friend2 + "'s limbs were beaten and bruised beyond recognition. Though, unlike " + friend1 + " , " + friend2 + " showed signs of struggle.\n" +
    friend3 + ": What kind of person could've even done something like this?");

    while (true) {
      System.out.println("Stay focused. (2 words)");
      Scanner r = new Scanner(System.in);
      choice = r.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("stay focused")) {
        break;
      }
      else {

      }
    }

    System.out.println("YOU: Let's stay focused.\n" +
    friend3 + ": Right. But is there even anything to investigate? They're all bloody and mutilated.\n" +
    "YOU: No, no... Look at the trees and the bushes. Normally, people don't even go to these parts of the beach.\n" +
    friend3 + ": It's messy. Some of the trees have dents on them. Some of the bushes have been flattened.\n" +
    "YOU: Clearly, there was a fight. " + friend2 + " went down swinging.\n" +
    friend3 + ": This makes sense, actually. " + friend2 + " was incredibly strong. Went to the gym 3 times a week.\n" +
    "YOU: Our 3 main suspects at this point are the butler, Kenna, and Jimmy. Would anyone of them have been strong enough to take them on?\n" +
    friend3 + ": Maybe the butler? I heard a while back that he has an at-home gym. Kenna and Jimmy are both pretty busy with their social lives for exercise.\n" +
    "YOU: I've heard a lot of suspicions about the butler these past few days. More than I've heard from Kenna and Jimmy.\n");

    while (true) {
      System.out.println("Who are you going to investigate?");
      Scanner r2 = new Scanner(System.in);
      choice = r2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("head butler")) {
        break;
      }
      else {

      }
    }

    System.out.println("Where are you going? (1 word)");
    while (true) {
      Scanner in3 = new Scanner (System.in);
      choice = in3.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("mansion")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n------------------------------------------------------------------------------" +
    "\n" +
    "\n=================================DRIVING======================================" +
    "\n" +
    "\n------------------------------------------------------------------------------");

    System.out.println(friend3 + " and you are easily let in the mansion, but the problem is that the butler's room is locked." +
    "\n" + friend3 + ": ...How are we going to go in?");

    System.out.println("You see something on the floor that could be of help.");
    System.out.println("What is it? (1 word)");
    while (true) {
      Scanner in0 = new Scanner(System.in);
      choice = in0.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("hairpin") || choice.equals("pin") || choice.equals("paperclip")) {
        break;
      }
      else {
        System.out.println("No... what do you really see?");
      }
    }

    System.out.println("You pick it off the floor." +
    "\nYOU: Don't worry, " + friend3 + ". I have experience with lock picking.");

    System.out.println(
    "\n==================="+
    "\n|                 |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n|              O  |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n|                 |" +
    "\n===================");

    System.out.println("Open the door. (3 words)");
    while (true) {
      Scanner in4 = new Scanner(System.in);
      choice = in4.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("open the door")) {
        break;
      }
      else {
        System.out.println("Open the door");
      }
    }

    System.out.println("With a CLICK, the door opens." +
    "\n" + friend3 + " and you enter the butler's room and are surprised to see how neat the room is." +
    "\n" + friend3 + ": It's like no one's been living here..." +
    "\nYou: Nevermind. Let's get to work." +
    "\nThe two of you split up and look around the room." +
    "\n" + friend3 + ": This is impossible... It's like one of those room inspiration things at Ikea." +
    "\nYou: I can't argue with that. His bookshelf is devoid of any dust, too." +
    "\nYou look at the titles of the books on the bookshelf and notice one particular title: How to CompSci@Stuy.");

    while (true) {
      System.out.println("Does the book interest you?");
      Scanner t = new Scanner(System.in);
      choice = t.nextLine();
      choice.toLowerCase();
      if (choice.equals("yes")) {
        break;
      }
      else {

      }
    }


    System.out.println("You pull the book off the shelf and flip through it. Midway through, you find a slip of paper with an address. The handwriting is atrocious." +
    "\nYOU: Hey, I think I found something. It's a bit hard to read, though." +
    "\n" + friend3 + " peers over your shoulder." +
    "\n" + friend3 + ": ... Perry St, New York? Could that be where he is right now?" +
    "\nYOU: Well, it's not like we have many options at this point. Let's go.");

    System.out.println("Where are you going? (2 words)");
    while (true) {
      Scanner in5 = new Scanner (System.in);
      choice = in5.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("perry st") || choice.equals("perry street")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n------------------------------------------------------------------------------" +
    "\n" +
    "\n=================================DRIVING======================================" +
    "\n" +
    "\n------------------------------------------------------------------------------");

    System.out.println("\nYou: Here we are." +
    "\nAfter you find the location of the address on the slip, you realize that it's an apartment building." +
    "\n" + friend3 + " knocks on the door." +
    "\nThere is rusting heard before the door is opened... revealing the head butler." +
    "\nHEAD BUTLER: What... What are you two doing here? How..." +
    "\n" + friend3 + ": We're not the ones that need to explain ourselves here. Why are you here?" +
    "\nHEAD BUTLER: Why am *I* here? This is my apartment when I'm not at the mansion." +
    "\n" + friend3 + ": The question is: Why aren't you at the mansion?" +
    "\nYOU: The head maid told us that you've been gone since " + friend1 + "'s body was cleaned up. You destroyed evidence and left right after?" +
    "\nHEAD BUTLER: That... That was not my intention. They looked pretty beaten. I didn't want the others - especially their friends - to see them like that." +
    "\nYOU: And then you ran off... to the city. Didn't tell anyone where you went, either." +
    "\nHEAD BUTLER: Are you suggesting that I did this?" +
    "\n" + friend3 + ": Why wouldn't we? Kenna's been traumatized by " + friend2 + "'s death, we both know Sharon wouldn't do this, and Jimmy's just been out drinking. You're unaccounted for." +
    "\nHEAD BUTLER: Wait... " + friend2 + " died? " + friend2 + "?" +
    "\nThe head butler seems surprised." +
    "\nYOU: This morning, yes." +
    "\nHEAD BUTLER: But... I... They... They told me..." +
    "\nYOU: Who told you? What did they tell you? Spit it out!" +
    "\nHEAD BUTLER: ... Come in.\n");

    System.out.println("The two of you walk in and you realize that your heart is racing. This case seems to have affected you.");
    System.out.println("What do you want to do to calm down?");
    System.out.println("1 - Pour yourself a cup of tea");
    System.out.println("2 - Play with fidget");
    System.out.println("3 - Take a deep breath");
    Scanner calmDown = new Scanner (System.in);
    choice = calmDown.nextLine();

    if (!(choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
      wrongChoice();
    }

    System.out.println("\nThe butler rummages around in his backpack. He pulls out a clear binder protector with a note inside." +
    "\nYou and " + friend3 + " look at the note. The words are made up of cut out letters from a magazine.");

    while (true) {
      System.out.println("Read the note. (3 words)");
      Scanner t2 = new Scanner(System.in);
      choice = t2.nextLine();
      choice.toLowerCase();
      if (choice.equals("read the note")) {
        break;
      }
      else {

      }
    }

    System.out.println("========================================="+
    "\n|                                        |" +
    "\n|   GET      OUT     BEFORE    MORE      |" +
    "\n|                                        |" +
    "\n|     PEOPLE     GET      HURT           |" +
    "\n|                                        |" +
    "\n|                                        |" +
    "\n|  YOU    DON'T    KNOW    THE  THINGS   |" +
    "\n|                                        |" +
    "\n|        I    AM   CAPABLE    OF         |" +
    "\n|                                        |" +
    "\n=========================================" +
    "\n" + friend3 + ": So this is the reason why you've been gone?" +
    "\nHEAD BUTLER: Yea... I... I don't know. I was scared. We don't know what they're after." +
    "\nYOU: And because of this, we spent the day going after you instead of going after the killer." +
    "\nThe head butler bows his head in shame." +
    "\nHEAD BUTLER: I'm so sorry. I really thought that it'd be over by now." +
    "\n" + friend3 + ": It's too late now. Let's head back to the mansion and think of what to do next.");

    System.out.println("Where are you going? (1 word)");
    while (true) {
      Scanner in6 = new Scanner (System.in);
      choice = in6.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("mansion")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n------------------------------------------------------------------------------" +
    "\n" +
    "\n=================================DRIVING======================================" +
    "\n" +
    "\n------------------------------------------------------------------------------");

    System.out.println("You pull into the mansion's parking lot and are immediately greeted with police officers." +
    "\nYou, " + friend3 + " , and the head butler step our of your vehicle." +
    "\nYOU: What is the meaning of this?" +
    "\nPOLICE OFFICER 1: James Pountine, you're under arrest for the kidnapping of Marisa Ecclestone." +
    "\nPOLICE OFFICER 2: You have the right to remain silent. Anything you say can and will be used against you in a court of law." +
    "\nPOLICE OFFICER 3: You have the right to an attorney. If you cannot afford an attorney, one will be provided for you. Do you understand the rights I have just read to you?" +
    "\nYou're blinded by the glaring lights from the officers, but the last thing you see is the butler getting slammed down onto the hood.");
}

  public static void dayFive() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 5");
    player.dayEnergy();
    printStats(player);

    System.out.println("You wake up and are greeted by an unfamiliar surrounding." +
    "\nYOU: What..." +
    "\nYou let your guard down, though, when you remember last night's events.");

    Scanner in = new Scanner(System.in);
    System.out.println("Do you want to remember?");
    System.out.println("1 - Yes. (-1 energy)");
    System.out.println("2 - No. (-0 energy)");
    player.amountEnergy();
    String choice = in.nextLine();
    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      System.out.println("After the head butler was taken away, both you and " + friend3 + " were left confused and exhausted." +
      "\nYou both thought that the head butler was innocent but were surprised to see him arrested." +
      "\nYou decided that since it was late, it'd be better to stay at the mansion since you both were already there." +
      "\n" + friend3 + " agreed. So, you both walked in and were greeted by the head maid, who wasn't shocked when you told her of the head butler's arrest." +
      "Instead, she said that she would talk about it tomorrow, and that you and " + friend3 + " should get some sleep." +
      "And that leaves you where you are now.");
    }
    else if (choice.equals("2")) {

    }
    else {
      wrongChoice();
    }

    Scanner in2 = new Scanner(System.in);
    System.out.println("What do you do?");
    System.out.println("1 - Stay in bed a while longer. (-0 energy)");
    System.out.println("2 - Get up and about. (-1 energy)");
    player.amountEnergy();
    choice = in2.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      System.out.println("You eventually motivate yourself to get up." +
      "\nYou bathe, brush your teeth, get dressed in clothes that you suppose the head maid left for you, and leave your room." +
      "\nYou head down the stairs, following the aromatic smell."); //move on
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      System.out.println("You get up reluctantly." +
      "\nYou bathe, brush your teeth, get dressed in clothes that you suppose the head maid left for you, and leave your room." +
      "\nYou leave the room and walk down the hallway, with no destination in mind but an urge to walk." +
      "\nThough, you bump into Jimmy when turning a corner.");

      System.out.println("You haven't seen him in a long time, and Jimmy looks tense. What do you say?");
      Scanner in3 = new Scanner(System.in);
      System.out.println("1 - Greet him. (-2 energy)");
      System.out.println("2 - Ignore him. (-0 energy)");
      player.amountEnergy();
      choice = in3.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.lotEnergy();
        player.Jimmy();
        if (player.getJimmy() >= 9) { //player's relationship with Jimmy is greater than 9
          System.out.println("Jimmy, upon seeing you, loosens up." +
          "\nJIMMY ECCLESTONE: Oh, hey, " + player.name + " . It's been a while. How are you doing?" +
          "\nYOU: Well... it hasn't been my best week, but I'm hanging on." +
          "\nYou notice that Jimmy looks a bit ragged as he has prominent eyebags.");

          Scanner in4 = new Scanner(System.in);
          System.out.println("Do you ask him how he has been?");
          System.out.println("1 - Yes. (-1 energy)");
          System.out.println("2 - No. (-0 energy)");
          player.amountEnergy();
          choice = in4.nextLine();
          if (choice.equals("1") && player.getEnergy() < 1) {
            System.out.println("You don't have enough energy to do that!");
          }
          else if (choice.equals("1")) {
            player.regularEnergy();
            player.Jimmy();
            System.out.println("JIMMY ECCLESTONE: Thanks for asking, " + player + " . I have actually been doing pretty fine since I always have a Corona in my hand." +
            "\nHe lets out a chuckle." +
            "\nYou let out a chuckle in pity.");
            questionJimmy();

            System.out.println("JIMMY ECCLESTONE: Well, I will make my way then." +
            "\nYou offer your hand and Jimmy shakes it." +
            "\nThen, you part ways." +
            "\nYou head down the stairs, following the aromatic smell."); //move on
          } //yes to ask how he's been AND relationship better than 9
          else if (choice.equals("2")) { //ignore
              questionJimmy();

              System.out.println("JIMMY ECCLESTONE: Well, I will make my way then." +
              "\nYou offer your hand and Jimmy shakes it." +
              "\nThen, you part ways." +
              "\nYou head down the stairs, following the aromatic smell."); //move on
          }
          else {
            wrongChoice();
          }
        }
        System.out.println("You nod your head as a sign of acknowledgement as you walk by him." +
        "\nHe nods back to you." +
        "\nYou pass by him and head down the stairs, following the aromatic smell."); //move on
      } // end of greet him
      else if (choice.equals("2")) {
        System.out.println("You walk past him, earning a scoff from his direction." +
        "\nYou head down the stairs, following the aromatic smell."); //move on
      }
      else {
        wrongChoice();
      }
    }
    else {
      wrongChoice();
    }

    System.out.println("Where are you going? (1 word)");
    while (true) {
      Scanner in3 = new Scanner(System.in);
      choice = in3.nextLine();
      if (choice.equals("kitchen")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println(
      "__" +
    "\n  |__" +
    "\n     |__" +
    "\n        |__" +
    "\n           |__" +
    "\n              |");

    System.out.println("\nYou head down to the kitchen and see the head maid." +
    "\nYOU: Good morning. Crazy, huh?" +
    "\nHEAD MAID: Good morning! What's crazy?" +
    "\nYOU: Did you hear? The head butler got arrested yesterday. It's crazy because " + friend3 + " and I thought he was innocent." +
    "\nHEAD MAID: Wait, what? Why would you think James is innocent?");

    while (true) {
      System.out.println("Where did you go yesterday?");
      Scanner y = new Scanner(System.in);
      choice = y.nextLine();
      choice.toLowerCase();
      if (choice.equals("perry st") || choice.equals("perry street")) {
        break;
      }
      else {

      }
    }

    System.out.println("YOU: We went over to his apartment in New York and it turns out that he left because he was being threatened by the murderer. There was even a note." +
    "\nHEAD MAID: Oh no." +
    "\nYou notice the head maid has an unsure look on her face." +
    "\nYOU: ...What happened?" +
    "\nHEAD MAID: I didn't know... I was actually the one that turned him in. I was cleaning the hallways and found Marisa's bracelet in his briefcase." +
    "\nAnd, well, Marisa never takes off that bracelet. It means something to her. I figured that the only way he'd have it is if he was the one who had something to do with her disappearance.." +
    "\nYOU: Hmmm... It'd be easy for the actual murderer to plant a bracelet like that." +
    "\nHEAD MAID: I suppose..." +
    "\nYOU: It's okay. We can work with this. Next time, let me know when you find clues. The Ecclestone's did hire me to investigate, after all." +
    "\nHEAD MAID: I will. God's speed with you.");

    while (true) {
      System.out.println("What do you finish having?");
        Scanner y2 = new Scanner(System.in);
        choice = y2.nextLine();
        choice.toLowerCase();
        if (choice.equals("breakfast")) {
          break;
        }
        else {

        }
      }

    System.out.println("\nYou finish up breakfast and wake up " + friend3 + " to go solve the rest of the case.");

    System.out.println("Where are you going to go? (1 word)");
    while (true) {
      Scanner chooseJail = new Scanner (System.in);
      choice = chooseJail.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("jail")) {
        break;
      }
      else {
        System.out.println("Huh?");
      }
    }

    System.out.println("\n------------------------------------------------------------------------------" +
    "\n" +
    "\n=================================DRIVING======================================" +
    "\n" +
    "\n------------------------------------------------------------------------------");

    System.out.println("You and " + friend3 + " arrive at the jail. You provide your IDs to the guard, who lets you in to talk to the butler." +
    "\nYOU: I spoke to the head maid this morning... Apparently, she found out that you had Marisa's bracelet and called the police." +
    "\n" + friend3 + ": It should be fine though. The bracelet was definitely planted by the real murderer. " +
    "\nHEAD BUTLER: ...I killed her." +
    "\nYOU: Our next course of act-- Wait what?" +
    "\nHEAD BUTLER: You've only been here for the week, but you don't know what the regular day at the Ecclestone mansion is like." +
    "\n" + friend3 + ": James, this isn't funny." +
    "\nHEAD BUTLER: The Ecclestones walk around like they're the most important people in the world. So dignified. They don't live like you or me." +
    "\nYOU: But... You've always had a good relationship with them." +
    "\nHEAD BUTLER: Did you hear? About Sharon's mother? And the cancer? Did you know that she has to work extra hours doing delivery because the Ecclestones don't pay her enough to afford the medicine?" +
    "\n" + friend3 + ": What are you saying? Why are you doing this?" +
    "\nHEAD BUTLER: Sharon has been working in the mansion for two decades... you would think that the Ecclestone's would raise her salary or something. But, they didn't. Rather, when I advised Sharon to get a better job, she said that she couldn't. They must have something over her." +
    "\nWhat you need to understand is that the Ecclestone's take advantage of good people. People like Sharon. I just wanted a bit of revenge." +
    "\n" + friend3 + ": But... You've always liked Marisa." +
    "\nHEAD BUTLER: I didn't mean to kill her. It was unfortunate -- I was thinking of holding her for ransom. I tried holding her down, but she's a strong one. Though, one knock to the head, and she was out." +
    "\n" + friend3 + ": What about... What about " + friend1 + "? And " + friend2 + "?" +
    "\nHEAD BUTLER: They knew too much... they shouldn't have gotten involved with the case. Though..." +
    "\nThe head butler looks at you and says the next few words with menace." +
    "\nHEAD BUTLER: I suppose you're to blame, though. The deaths of " + friend1 + " and " + friend2 + " . I didn't enjoy getting rid of them, but I had to since you wanted to convince them to help. Look where their help got them!" +
    "\nYou feel disgust towards the head butler." +
    "\nI'm surprised you're still here. If I hadn't gotten arrested, I would've killed you, too.");

    Scanner jailtalk = new Scanner(System.in);
    System.out.println("Your anger is at its peak. What do you do?");
    System.out.println("1 - Curse him.");
    System.out.println("2 - Hold back your anger.");
    player.amountEnergy();
    choice = jailtalk.nextLine();
    if (choice.equals("1")) {
      System.out.println("YOU: I hope you rot in Hell for your crimes." +
      "\nThe head butler just lets out a chuckle.");
    }
    else {

    }

    System.out.println(friend3 + ": This doesn't make any sense..." +
    "\nHEAD BUTLER: It's all over now, anyway." +
    "\n" + friend3 + ": Wait... So you were the one to kill " + friend2 + "?" +
    "\nHEAD BUTLER: Hah... That kid put up a fight -- almost took me down too. So, I guess I enjoyed beating them up. Though, I would've hid the body better if Kenna wasn't at the beach.");

    System.out.println("\nYou heard enough. You pull " + friend3 + " out of their chair and leave the room. You get back into the car and lean your head against the wheel." +
    "\n" + friend3 + ": What... was that? There's no way, right? There's no way." +
    "\nYOU: How did he know? How did he know about " + friend3 + "? He didn't pick up when Kenna called and he hasn't BEEN here." +
    "\n" + friend3 + ": Doesn't that mean that he killed " + friend3 + " then? He never liked us... I don't understand, I don't understand.");

    System.out.println("\nThis decision is an important one. It's time. Do you think the Head Butler is the culprit?");
    System.out.println("1 - Yes.");
    System.out.println("2 - No.");
    while (true) {
      Scanner believeButler = new Scanner (System.in);
      choice = believeButler.nextLine();
      if (!(choice.equals("1") || choice.equals("2"))) {
        System.out.println("Do you believe him or not?");
      }
      else {
        break;
      }
    }

    if (choice.equals("1")) {
      System.out.println("YOU: He, himself, confessed. There's no other explanation." +
      "\n" + friend3 + ": I... I suppose." +
      "\nYOU: I'll drop you off at your house and alert the Ecclestone's. The case is closed." +
      "\n" + friend3 + ": Is this really the end?" +
      "\nYOU: ...Yes.");

      System.out.println("\nThat night, you receive a check from Kenna and Jimmy for $40,000." +
      "\nThe following day, you leave the mansion. You hear about the case on the news." +
      "\nYou tried to appear confident when you were speaking to " + friend3 + ", but a gnawing feeling of doubt filled your gut as you realize..." +
      "\n\t\t\t\t\t\t\t\tYou got the wrong guy.");

      System.out.println("_____________________________________________" +
      "\n|             _______________               |" +
      "\n|             |             |        _      |" +
      "\n|             |    B A D    |    o   |      |" +
      "\n|             |    E N D    |    o   |      |" +
      "\n|             |_____________|               |" +
      "\n|___________________________________________|");

      System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    else {
      System.out.println("YOU: There's no way it's true. He wouldn't have had that note in anticipation that we'd show up to the apartment." +
      "\n" + friend3 + ": Right... And he seemed so genuine yesterday. There's definitely something else." +
      "\nYOU: What if... The murderer reached out to him again? Via note?" +
      "\n" + friend3 + ": That's right! Maybe the murderer saw us gone and got suspicious. We need to go talk to him again." +
      "\nYOU: We just left, though. I don't think we're allowed another visit." +
      "\n" + friend3 + ": What if we bail him out? We need 200 dollars, though." +
      "\nYOU: Let me check...");

      System.out.println("Check your wallet (2 words)");
      while (true) {
        Scanner checkWallet = new Scanner(System.in);
        choice = in.nextLine();
        choice = choice.toLowerCase();
        if (choice.equals("check wallet")) {
          break;
        }
        else {
          System.out.println("No... Try again");
        }
      }

      if (player.total() > 333) {
        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |             |               |" +
        "\n|             |    MOOLA    |               |" +
        "\n|             |      $      |               |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        System.out.println("\nYOU: Aha! I have enough money. All that time spent at the casino paid off!" +
        "\n" + friend3 + ": ...You've been at the casino?" +
        "\nYOU: No talk of that...Let's go bail out the butler!");

        System.out.println("\nThe two of you return to the jail and pay the bail money. You drag the butler back to the car." +
        "\nYOU: All right. I need you to be honest with us now. You're already out, so there's no going back. What do you know?" +
        "\nHEAD BUTLER: ...I'm so, so sorry. I--" +
        "\nYOU: Stop apologizing and tell us the truth." +
        "\nHEAD BUTLER: Kenna. She visited me earlier this morning. She told me that she would kill my wife and kids if I didn't take the fall." +
        "\n" + friend3 + ": ...What should we do now?" +
        "\nYOU: We tell the police. They have more manpower than us." +
        "\n" + friend3 + ": We don't have physical evidence like Sharon did, though." +
        "\nYOU: I'm friends with the Police Commissioner. Leave it to me." +

        "\nShortly afterwards, Kenna Ecclestone is caught running in the forest and is apprehended." +
        "\nA few months later, she's convicted of the kidnapping of Marisa Ecclestone and the murders of " + friend1 + " and " + friend2 + "." +
        "\nAccording to the news, Kenna originally planned on kidnapping and keeping Marisa in a hidden location for 2 weeks." +
        "\nIn those 2 weeks, she was going to hire a private investigator as a witness to her husband's, Jimmy's, incompetance." +
        "\nThis would later be used to file for divorce, ensure Jimmy loses all custody rights, and potentially win the Ecclestone mansion." +
        "\nHowever, this went south as Marisa was accidentally killed in transport.");

        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |             |        _      |" +
        "\n|             |   G O O D   |    o   |      |" +
        "\n|             |    E N D    |    o   |      |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      }
      else {
        System.out.println("_____________________________________________" +
        "\n|             _______________               |" +
        "\n|             |     N O     |               |" +
        "\n|             |    MOOLA    |               |" +
        "\n|             |      $      |               |" +
        "\n|             |_____________|               |" +
        "\n|___________________________________________|");

        System.out.println("\nYOU: I don't have enough money." +
        "\n" + friend3 + ": What do we do now?" +
        "\nYOU: We can either wait for them to let him go since there's a lack of evidence, or try to figure it ourselves right now." +
        "\nYOU: I'm friends with the Police Commissioner, so she'll arrest whoever we decide on." +
        "\n" + friend3 + ": I have no clue. What do you want to do?");

        Scanner arrestOr = new Scanner (System.in);

        System.out.println("1 - Choose to arrest either Kenna or Jimmy");
        System.out.println("2 - Go back to the mansion and think about it");
        while (true) {
          choice = arrestOr.nextLine();
          if (!(choice.equals("1") || choice.equals("2"))) {
            break;
          }
          else {
            System.out.println("Choose either 1 or 2.");
          }

        }

        if (choice.equals("1")) {

          if (player.getKenna() > player.getJimmy()) {
            System.out.println("YOU: I personally have a better relationship with Kenna.");
            System.out.println(friend3 + ": Alright. Let's arrest Jimmy then.");
            System.out.println("Shortly after, Jimmy Ecclestone is arrested before boarding a flight to New York. You watch, on the news, how Jimmy struggles against the officers while handcuffed.");
            System.out.println("That night, you receive a check from Kenna and for $40,000." +
            "\nThe following day, you leave the mansion. You hear about the case on the news." +
            "\nYou tried to appear confident when you were speaking to " + friend3 + ", but a gnawing feeling of doubt filled your gut as you realize..." +
            "\n\n\n\n\nYou got the wrong guy.");

            System.out.println("_____________________________________________" +
            "\n|             _______________               |" +
            "\n|             |             |        _      |" +
            "\n|             |    B A D    |    o   |      |" +
            "\n|             |    E N D    |    o   |      |" +
            "\n|             |_____________|               |" +
            "\n|___________________________________________|");

            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

          }
          else if (player.getJimmy() > player.getKenna()) {
            System.out.println("YOU: I personally have a better relationship with Jimmy.");
            System.out.println("\n" + friend3 + ": Alright. Let's arrest Kenna then.");
            System.out.println("\n\nShortly afterwards, Kenna Ecclestone is caught running in the forest and is apprehended." +
            "\nA few months later, she's convicted of the kidnapping of Marisa Ecclestone and the murders of " + friend1 + " and " + friend2 + "." +
            "\nAccording to the news, Kenna originally planned on kidnapping and keeping Marisa in a hidden location for 2 weeks." +
            "\nIn those 2 weeks, she was going to hire a private investigator as a witness to her husband's, Jimmy's, incompetance." +
            "\nThis would later be used to file for divorce, ensure Jimmy loses all custody rights, and potentially win the Ecclestone mansion." +
            "\nHowever, this went south as Marisa was accidentally killed in transport.");

            System.out.println("_____________________________________________" +
            "\n|             _______________               |" +
            "\n|             |             |        _      |" +
            "\n|             |   G O O D   |    o   |      |" +
            "\n|             |    E N D    |    o   |      |" +
            "\n|             |_____________|              |" +
            "\n|___________________________________________|");

            System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
          }
          else {
            System.out.println("\nYOU: Hmm... My relationship with Jimmy and Kenna are equal. Who should I choose?");
            System.out.println(friend3 + ": Let's just go back to the mansion and think about it.");

            System.out.println("\nThe two of you head back to the mansion and spend the rest of the day reworking the evidence.");
            daySix();

          }
        } //end arrest option
        else { //choice.equals("2")
          System.out.println("\nThe two of you head back to the mansion and spend the rest of the day reworking the evidence.");
          daySix();
        }
      } //don't have enough money for bail statement
    } //don't believe that the butler is culprit statement
  }

  public static void daySix() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 6");

    System.out.println("You wake up at the mansion again. You get up bright and early and notice yourself feeling thirsty." +
    "\nYou reach over to your bedside table and drink from a glass of room temperature water." +
    "\nYou feel dizzy, so you lay back down onto the bed and fall asleep," +
    "\n\nBut, you never wake up.");

    System.out.println("_____________________________________________" +
    "\n|             _______________               |" +
    "\n|             |             |        |      |" +
    "\n|             |    S A D    |    o   |      |" +
    "\n|             |    E N D    |    o   |      |" +
    "\n|             |_____________|        |      |" +
    "\n|___________________________________________|");

    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
  }

//Main Method ----------------------------------------------------------------//

  public static void main(String[] args) {
    boolean continuePlay = true;
    playGame();
    while (continuePlay) {
      System.out.println("Do you wish to play again?");
      System.out.println("1 - Yes!");
      System.out.println("2 - No...");

      Scanner in = new Scanner(System.in);
      String choice = in.nextLine();

      if (choice.equals("1")) {
        System.out.println("Starting new game now...");
        playGame();
      }
      else if (choice.equals("2")) {
        System.out.println("Quitting game...");
        continuePlay = false;
      }
      else {
        System.out.println("That's not an option. Automatically quitting game...");
        continuePlay = false;
      }
    }
  }
}
