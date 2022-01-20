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

    dayTwo();
  }

  public static void wrongChoice() {
    System.out.println("Your inability to choose a valid option baffles me." +
    "\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<GAME OVER<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    System.exit(0);
  }

  public static void gotoCasino() {
    System.out.println("You walk into the Moonlit 251 Casino. You walk past lines and lines of slot machines and tables of calculating players.\n" +
    "\nWhat do you want to play now, PI?");
    Scanner casino = new Scanner(System.in);
    System.out.println("1 - Play against Bobo, a master at picking high value cards from a standard deck of cards (-1 energy)\n");
    System.out.println("2 - Return home (-0 energy)\n");

    String choice = casino.nextLine();
    if (choice.equals("1")) {
      playAgainstBobo();
    }
    else if (choice.equals("2")) {
      return;
    }
    else {
      wrongChoice();
    }
  }

  // public static int checkEnergy() {
  //   if (player.tired()) {
  //     System.out.println("You don't have enough energy. Choose an option that requires no energy next time.");
  //     return -1;
  //   }
  //   else {
  //     return 0;
  //   }
  // }

  public static void dayOne() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 1");
    printStats(player);

    System.out.println("KENNA ECCLESTONE: This is just horrible..." +
    "\nJIMMY ECCLESTONE: You're the one that insisted on going to those RIDICULOUS wine tastings. You could have spent more time with her..." +
    "\nKENNA ECCLESTONE: You act as if you don't golf with your friends every weekend!");

    Scanner in = new Scanner(System.in);
    System.out.println("Kenna and Jimmy glare at each other. You feel the tension in the room. What do you do, " + player.name + "?");
    System.out.println("1 - Talk to Kenna (-2 energy)");
    System.out.println("2 - Talk to Jimmy (-2 energy)");
    System.out.println("3 - Take control of the situation (-1 energy)");
    String choice = in.nextLine();
    if (player.getEnergy() < 2 && (choice.equals("1") || choice.equals("2")) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (play.getEnergy() < 1 && choice.equals("3")) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      System.out.println("KENNA ECCLESTONE: It's difficult caring for a 16 year old girl, let alone having to do it by myself!");
      player.Kenna();
      player.lotEnergy();
      player.upKnowledge();
    }
    else if (choice.equals("2")) {
      System.out.println("JIMMY ECCLESTONE: You don't understand how much that woman aggravates me. I spend enough time with my daughter. My wife just has a flair for dramatics.");
      player.Jimmy();
      player.lotEnergy();
      player.upKnowledge();
    }
    else if (choice.equals("3")) {
      player.regularEnergy();
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
    "\nJIMMY ECCLESTONE: Give " + player.name + "the contact information. I've got things to do.");

    Scanner in2 = new Scanner(System.in);
    System.out.println("1 - Stop Jimmy (-1 energy)");
    System.out.println("2 - Don't stop Jimmy (-0 energy)");
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
      }
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
    choice = in4.nextLine();
    if (choice.equals("1") && player.getEnergy < 2) {
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
      "\nKENNA ECCLESTONE: This is Private Investigator " + player.name + ". Please escort " + player.name + "to the bathroom and then to the exit." +
      "\nThe man nods his head." +
      "\nHEAD BUTLER: Hello, PI " + player.name + ". Please, follow me." +
      "\nYou trail after the head butler after casting a look at Kenna, noticing that she seemed visibly upset while talking into the phone.");

      Scanner in5 = new Scanner(System.in);
      System.out.println("Do you pity Kenna?");
      System.out.println("1 - Yes. (-1 energy)");
      System.out.println("2 - No. (-1 energy)");
      System.out.println("3 - You're neutral. (0 energy)");
      choice = in5.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy < 1) {
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
      System.out.println("2 - Continue to walk in silence (-2 energy)");
      System.out.println("3 - Stop following the head butler and try to go into another room (-1 energy)");
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
        "\nHEAD BUTLER: ... I would say so. The Ecclestone's treat me well, and Marisa has always been a dear." +
        "\nYOU: Speaking of Ma-" +
        "\nHEAD BUTLER: We have arrived. I trust that you will be able to leave this premise after you're done with the facilities." +
        "\nYOU: Of course, of course. But, may I have a conversation with you about Marisa later on?" +
        "\nHEAD BUTLER: Someday, for I have some things to attend to at the moment." +
        "\nYou nod your head in agreeance as the head butler leaves." +
        "\nOnce you finish your business, you decide to...");

        Scanner in7 = new Scanner(System.in);
        System.out.println("1 - Go to the casino (-1 energy)");
        System.out.println("2 - Go home (-0 energy)");
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
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      gotoCasino();
    }
    else {
      System.out.println("You go back home for more rest.");
      player.upEnergy();
    }
  }

  public static void dayTwo() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 2");
    player.dayEnergy();
    printStats(player);

    System.out.println("You feel refreshed. You received Kenna's email and decided to contact Marisa's friends for some clues." +
    "\n");


  }

  public static void dayThree() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 3");
    player.dayEnergy();
    printStats(player);


  }

  public static void dayFour() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 4");
    player.dayEnergy();
    printStats(player);
  }

  public static void dayFive() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 5");
    player.dayEnergy();
    printStats(player);
  }

  public static void playAgainstBobo() {
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
    }
  }

  public static void main(String[] args) {
    playGame();
  }


}
