\/*
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
    "\n" +
    "\nHave in mind that failure to choose a valid option will result in a GAME OVER." +
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

  public static void gotoCasino() {
    player.regularEnergy();
    System.out.println("You walk into the Moonlit 251 Casino. You walk past lines and lines of slot machines and tables of calculating players.");

    while (true) {
    System.out.println("\nWhat do you want to play now, PI?");
    Scanner casino = new Scanner(System.in);
    System.out.println("1 - Play against Bobo, a master at picking high value cards from a standard deck of cards (-1 energy)\n");
    System.out.println("2 - Return home (-0 energy)\n");

    String choice = casino.nextLine();
    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy! A bouncer kicks you out.");
      break;
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      playAgainstBobo();
    }
    else if (choice.equals("2")) {
      break;
    }
    else {
      wrongChoice();
    }
    }
    System.out.println("You return home via Uber and the day ends.");
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

  public static void playAgainstJojo() {
    System.out.println("You paid JOJO 10 dollars.");
    //player.payForGame();

    Deck BlackJack = new Deck();
    System.out.println(BlackJack.deck.size());

    int input = (int)(Math.random() * 52);
    System.out.println(input);
    System.out.println(BlackJack.get(input));
    BlackJack.remove(input);

    System.out.println(BlackJack.deck.size());

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
    System.out.println("3 - Take control of the situation (-0 energy)");
    player.amountEnergy();
    String choice = in.nextLine();
    if (player.getEnergy() < 2 && (choice.equals("1") || choice.equals("2"))) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (player.getEnergy() < 1 && choice.equals("3")) {
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
      "\nKENNA ECCLESTONE: This is Private Investigator " + player.name + ". Please escort " + player.name + "to the bathroom and then to the exit." +
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

  public static void walkinDay2() {
    System.out.println("\nYou walk into the cafe, which was surprisingly bustling. You scan the premise for a person wearing a green shirt with the queen of spades." +
    "\nYou see a teenager that fits the description and walk up to them." +
    "\nYOU: Hello... are you " + friend1 + "?" +
    "\n" + friend1 + ": Yes. That's me. I assume you know my name via how you got my phone number. What's your name?" +
    "\nYOU: My name is " + player.name + "." +
    "\n" + friend1 + ": Nice to meet you." +
    "\nYOU: Right back at you. Now, let's get started. Shall we?" +
    "\n" + friend1 + "nods their head.");
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
        System.out.println("Well, Marisa's parents don't really spend that much time with her. They're always busy with work or arguing with each other.");
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
        System.out.println("I wouldn't say so. We're a tight knit group since we met each other at around the same time.");
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
      System.out.println("Do you ask " + friend1 + "to elaborate on how Marisa reacts to the subject of her parents?");
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
        System.out.println("We try not to bring it up, of course. But whenever someone did, she would just become stonefaced and be kinda mean. But, that's just her defense mechanism.");

        System.out.println("/Let's see if you have enough knowledge points..." +
        "\nIs what " + friend1 + "saying make sense? You think..." +
        "\n" + player.getKnowledge() +
        "You need 10 knowledge.");
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
    }
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
      player.upKnowledge();
      System.out.println(friend1 + ": Well, Marisa usually isolates herself for a week... It's already been ten days, so I guess since three days ago.");
    }
    else if (choice.equals("2")) {
      System.out.println(friend1 + ": Of course! I'm her friend... so why wouldn't I be?");
    }
    else {
      wrongChoice();
    }

    Scanner in10 = new Scanner(System.in);
    System.out.println("Do you ask if " + friend1 + "has done anything to find out about Marisa's absence?");
    System.out.println("1 - Yes. (-1 energy)");
    System.out.println("2 - No. (-0 energy)");
    player.amountEnergy();
    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
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
      player.Kenna();
    }
    else if (choice.equals("2")) {
      player.Jimmy();
    }
    else if (choice.equals("3")) {

    }
    else {
      wrongChoice();
    }

    System.out.println("KENNA ECCLESTONE: We have our regular arguments here and there, of course. It can be about how he eats his food sloppily or come home late. But, this time -- last night -- it was something completely different.");

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
      friends.remove("KLAUS");
    }
    else if (choice.equals("2")) {
      friend1.setName("ADELINE");
      friends.remove("ADELINE");
    }
    else if (choice.equals("3")) {
      friend1.setName("JONAS");
      friends.remove("JONAS");
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
      System.out.println("Your conversation with " + friend1 + "comes to a close when you see a lady by the cashier that looks familiar." +
      "\nYour suspicions are proven true when the lady turns around... revealing it to be Kenna." +
      "\nKenna also notices you and makes her way over." +
      "\nKENNA ECCLESTONE: Well, if it isn't " + player + " and " + friend1 + ". Lovely to see you both here." +
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
      System.out.println("1 - Say that you are here questioning " + friend1 + " . (-2 energy)");
      System.out.println("2 - Say that you just met " + friend1 + " . (-1 energy)");
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
            "\nKenna had a look of surprise on her face and looked at " + friend1 + " ." +
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
      }
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

      //write here
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
    }
    else {
      wrongChoice();
    }

    System.out.println("What do you do?");
    System.out.println("1 - Go to the casino (-1 energy)");
    System.out.println("2 - Go home (-0 energy)");

    if (choice.equals("1") && player.getEnergy() < 1) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      gotoCasino();
    }
    else if (choice.equals("2")) {
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

    System.out.println("You pull into the mansion, but feel as if something was off. Your suspicions are proven right as you hear a commotion. Two panicked teenagers run up to you.");
    String tempfriend2 = friends.get(0);
    String tempfriend3 = friends.get(1);
    System.out.println(tempfriend2 + ": YOU! You're the private investigator, right?" +
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
    player.amountEnergy();


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
    friend3 + "runs off the lot while you and " + friend2 + " make your way to the garden shed\n\n" +
    "YOU: Where did the body go?\n" +
    friend2 + ": The head butler called for someone to take it away. He was adamant about it being removed as quickly as possible.\n" +
    "YOU: That's a strange reaction. Someone dies on his watch and his first reaction is to get rid of the body?\n" +
    friend2 + ": Well... I didn't think about it that way. He's a queasy sort of person. Sort of a germophobe. Was never quite fond of us, except for Marisa.\n" +
    "YOU: Us... as in you and " + friend1 + "?\n" +
    friend2 + ": All of us. " + friend1 + ", " + "Marisa, " + friend3 + ", me. We pick up after ourselves when we hang out at Marisa's, but he constantly complains about picking up after us.\n" +
    "YOU: Still... quite the strange reaction to a murder. Where's the empathy?");

    player.upKnowledge();

    System.out.println("You look around the shed and notice a large arsenal of tools and supplies.");

    System.out.println("YOU: Did you see the body before he disposed of it? I'm sure there was some sort of evidence that would be useful right about now.\n" +
    friend2 + ": I did, for a bit. The one thing that stood out was a bruise on " + friend1 + "'s head.\n'" +
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
      friend2 + ": I suppose. She seems nervous as well. I saw her pacing around for nearly an hour yesterday at the pier.\n");
    }
    else if (choice.equals("2")) {
      player.lotEnergy();
      player.Jimmy();
      System.out.println("YOU: Right? She's insufferable! It feels like she's using this as an excuse to feud with her husband\n" +
      friend2 + ": Couldn't agree more. They've been having marital problems since Marisa was 6. I wonder why he doesn't leave her.");
    }
    else if (!choice.equals("3")) {
      wrongChoice();
    }

    System.out.println("YOU: Let's stay focused. Now that I look at it again, the golf club seems a lot dirtier compared to the other tools.\n" +
    friend2 + ": I guess Marisa's dad must've played pretty recently then.\n" +
    "YOU: If he played BlackJack with his friends 2 days ago, then he must've played pretty recently. He'd be in the area of the kill.\n" +
    "YOU: And the butler is attentive to cleanliness, but didn't bother to clean the golf club?\n" +
    "YOU: I haven't seen Kenna at all either. She seems pretty busy with all those phone calls...\n" +
    friend2 + ": Hah... It could be anyone! How are we getting anywhere with this?\n");

    player.upKnowledge();

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
      System.out.println(friend2 + ": Not that I know of? I mean, she usually seems a bit down because her parents are constantly fighting. It's not out of the ordinary." +
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
            System.out.println("HEAD MAID: The head butler was supposed to inspect the kitchen last night. He's usually diligent with his tasks, but the cooking crew reported that he arrived an hour late, seemingly out of breath.");
            System.out.println("YOU: Hmm... interesting.");
          }
          else if (choice.equals("2")) {
            System.out.println("HEAD MAID: Kenna told maid Clarke that she was having a headache and spent the night in her bedroom. She refused any medicine.");
            System.out.println("YOU: Hmm... interesting.");
          }
          else if (choice.equals("3")) {
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

          System.out.println("You and " + friend2 + " part ways. What do you want to do now?");

          System.out.println("1 - Go to the casino (-1 energy)");
          System.out.println("2 - Go home (-0 energy)");

          if (choice.equals("1") && player.getEnergy() < 1) {
            System.out.println("You don't have enough energy to do that!");
          }
          else if (choice.equals("1")) {
            player.regularEnergy();
            gotoCasino();
          }
          else if (choice.equals("2")) {
            player.upEnergy();
          }
          else {
            wrongChoice();
          }
        }


      }
    }
  }

  public static void dayFour() {
    player.dayEnergy();
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
      "KENNA ECCLESTONE: No... it's me, Kenna.");
    }
    else if (choice.equals("3")) {
      player.upKnowledge();
      System.out.println("...");
    }
    else {
      wrongChoice();
    }

    System.out.println("KENNA ECCLESTONE: I don't know... Something happened..." +
    "\nYou hear mumbling and incoherent words." +
    "\nYOU: What? What happened..?" +
    "\nKENNA ECCLESTONE: I - So I was missing Marisa... and I heard from someone that Marisa likes the beach so I went to the beach." +
    "\nYou sense a hesitance in her tone so you try to coax her to continue speaking." +
    "\nYOU: That's nice..." +
    "\nKENNA ECCLESTONE: So I went to the beach, yeah. And... I don't know, I don't know. I was just walking when I saw something poking out of the sand -- almost like a twig." +
    "\nYOU: Mhm." +
    "\nKENNA ECCLESTONE: I don't normally pull twigs out of sand or anything like that, but the twig was colored peculiarly so I decided to." +
    "\nYou are a bit skeptical on why this is of importance to call you early in the morning but you continue listening." +
    "\nKenna then proceeds to sob loudly." +
    "\nKENNA ECCLESTONE: But, it wasn't a twig or something. It was a leg -- a mutilated one at that." +
    "\nYou tense up." +
    "\nYOU: What do you mean.. a leg?" +
    "\nKENNA ECCLESTONE: I don't know, I don't know. I didn't realize that it was a leg at first, so I kept pulling it. But..." +
    "\nAt this point, Kenna is breaking down and sobbing. She spits out the next few words quickly..." +
    "\nKENNA ECCLESTONE: It's " + friend2 + " ." + friend2 + " , " + friend2 + " . Oh my God, what happened?" +
    "\nYour blood turns cold, and you say the next words in denial." +
    "\nYOU: " + friend2 + " ? It can't be... I saw them just yesterday." +
    "\nKENNA ECCLESTONE: I don't know, I don't know. God, why did this happen?" +
    "\nYou are in utter shock, but you decide to see the body for yourself." +
    "\nYOU: I'm coming, I'm coming. I'm going over to you, Kenna. Stay where you are and call the others." +
    "\nKenna lets out a sound that you think means that she will, so you end the call.");

    while (true) {
      Scanner in2 = new Scanner (System.in);
      System.out.println("Where are you going? (1 word)");
      choice = in2.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("beach")) {
        break;
      }
      else {
        System.out.println("Np... where are you really going?");
      }
    }

    System.out.println("--------------------------------------------------------------------------------" +
    "\n" +
    "\n==================================DRIVING=======================================" +
    "\n" +
    "\n--------------------------------------------------------------------------------");

    System.out.println("When you park your car, you see" + friend3 + " in the parking lot, waiting for you.\n" +
    friend3 + " looks in a frazzled state.\n" +
    friend3 + ": Y-you talked to " + friend2 + " yesterday. They're dead now. You talked to " + friend1 + " the day before. They're also dead now. What the hell is going on?\n" +
    "YOU: ...I understand that-\n" +
    friend3 + ": The more you try to meddle in this business, the more people die!\n" +
    "YOU: ...I was hired to solve the case-\n" +
    friend3 + ": And I'm telling you that you're making things worse. This shouldn't have happened... This can't have happened.\n" +
    "YOU: Look, we can stand here and fight all you want, but the killer is still out there and we need to put them behind bars.\n" +
    "You notice that " + friend3 + " is conflicted.\n" +
    "YOU: If you agree to help me, we can solve this case together. Don't you want to avenge your friends? Afterward, you can get on with your life.\n" +
    friend3 + ": ..And if I die as well?\n" +
    "YOU: I'll stay with you.\n" +
    friend3 + " stays silent for a few seconds. His facial expression indicates that he is conflicted. Though, after a minute, he speaks..." +
    friend3 + ": I don't think my life can go back to normal after this. But, I'll try my best. To help.\n");

    System.out.println("The two of you head down the beach and spot Kenna by the shore.\n" +
    "KENNA: Thank God you're here.\n" +
    "She look at " + friend3 + "." +
    "KENNA: You too." +
    friend3 + ": I'll help out anyway I can.\n" +
    "YOU: Can you bring us to the body?\n" +
    "KENNA: I don't think I can look at it again, but it's over there.\n" +
    "You and " + friend3 + " follow where she points her finger." +
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
    friend3 + ": What kind of person could've even done something like this?" +
    "YOU: Let's stay focused.\n" +
    friend3 + ": Right. But is there even anything to investigate? They're all bloody and mutilated.\n" +
    "YOU: No, no... Look at the trees and the bushes. Normally, people don't even go to these parts of the beach.\n" +
    friend3 + ": It's messy. Some of the trees have dents on them. Some of the bushes have been flattened.\n" +
    "YOU: Clearly, there was a fight. " + friend2 + " went down swinging.\n" +
    friend3 + ": This makes sense, actually. " + friend2 + " was incredibly strong. Went to the gym 3 times a week.\n" +
    "YOU: Our 3 main suspects at this point are the butler, Kenna, and Jimmy. Would anyone of them have been strong enough to take them on?\n" +
    friend3 + ": Maybe the butler? I heard a while back that he has an at-home gym. Kenna and Jimmy are both pretty busy with their social lives for exercise.\n" +
    "YOU: I've heard a lot of suspicions about the butler these past few days. More than I've heard from Kenna and Jimmy. Let's go find him.\n");

    while (true) {
      Scanner in3 = new Scanner (System.in);
      System.out.println("Where are you going? (1 word)");
      choice = in3.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("mansion")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n--------------------------------------------------------------------------------" +
    "\n" +
    "\n==================================DRIVING=======================================" +
    "\n" +
    "\n--------------------------------------------------------------------------------");

    System.out.println(friend3 + " and you are easily let in the mansion, but the problem is that the butler's room is locked." +
    "\n" + friend3 + ": ...How are we going to go in?");

    //write here//

    System.out.println("You notice a hairpin on the floor." +
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

    while (true) {
      Scanner in4 = new Scanner(System.in);
      System.out.println("Open the door (3 words)");
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
    "\nYou look at the titles of the books on the bookshelf and notice one particular title: How to CompSci@Stuy." +
    "\nYou pull the book off the shelf and flip through it. Midway through, you find a slip of paper with an address. The handwriting is atrocious." +
    "\nYOU: Hey, I think I found something. It's a bit hard to read, though." +
    "\n" + friend3 + " peers over your shoulder." +
    "\n" + friend3 + ": ... Perry St, New York? Could that be where he is right now?" +
    "\nYOU: Well, it's not like we have many options at this point. Let's go.");

    while (true) {
      Scanner in5 = new Scanner (System.in);
      System.out.println("Where are you going? (2 words)");
      choice = in5.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("perry st") || choice.equals("perry street")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n--------------------------------------------------------------------------------" +
    "\n" +
    "\n==================================DRIVING=======================================" +
    "\n" +
    "\n--------------------------------------------------------------------------------");

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
    "\nYou and " + friend3 + " read the note. The words are made up of cut out letters from a magazine." +
    "\nThe note reads: " +
    "\n========================================="+
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

    while (true) {
      Scanner in6 = new Scanner (System.in);
      System.out.println("Where are you going? (1 word)");
      choice = in6.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("mansion")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("\n--------------------------------------------------------------------------------" +
    "\n" +
    "\n==================================DRIVING=======================================" +
    "\n" +
    "\n--------------------------------------------------------------------------------");

    System.out.println("You pull into the mansion's parking lot and are immediately greeted with police officers." +
    "\nYou, " + friend3 + " , and the head butler step our of your vehicle." +
    "\nYOU: What is the meaning of this?" +
    "\nPOLICE OFFICER 1: James Pountine, you're under arrest for the kidnapping of Marisa Ecclestone." +
    "\nPOLICE OFFICER 2: You have the right to remain silent. Anything you say can and will be used against you in a court of law." +
    "\nPOLICE OFFICER 3: You have the right to an attorney. If you cannot afford an attorney, one will be provided for you. Do you understand the rights I have just read to you?" +
    "\nYou're blinded by the glaring lights from the officers, but the last thing you see is the butler getting slammed down onto the hood.");
}

  public static void dayFive() {
    player.dayEnergy();
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
    System.out.println("1 - Stay in bed a while longer. (-1 energy)");
    System.out.println("2 - Get up and about. (-1 energy)");
    player.amountEnergy();
    choice = in2.nextLine();
    if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.regularEnergy();
      System.out.println("You eventually motivate yourself to get up." +
      "\nYou bathe, brush your teeth, get dressed in clothes that you suppose the head maid left for you, and leave your room." +
      "\nYou head down the stairs, following the aromatic smell.");
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
      System.out.println("2 - Insult him. (-2 energy)");
      System.out.println("3 - Ignore him. (-0 energy)");
      player.amountEnergy();
      choice = in3.nextLine();
      if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 2) {
        System.out.println("You don't have enough energy to do that!");
      }
      else if (choice.equals("1")) {
        player.lotEnergy();
        player.Jimmy();
        if (player.getJimmy() > 10) {
          System.out.println("Jimmy, upon seeing you, noticeably loosens up." +
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
            System.out.println("JIMMY ECCLESTONE: Thanks for asking, " + player.name + " . I have actually been doing pretty fine since I always have a Corona in my hand." +
            "\nHe lets out a chuckle." +
            "\nYou let out a chuckle in pity.");

            Scanner in5 = new Scanner(System.in);
            System.out.println("What do you ask him?");
            System.out.println("1 - Where are you heading to? (-1 energy)");
            System.out.println("2 - Where did you come from? (-1 energy)");
            System.out.println("3 - I have no questions. I don't want to talk to him anymore.");
            choice = in5.nextLine();
            if ((choice.equals("1") || choice.equals("2")) && player.getEnergy() < 1) {
              System.out.println("You don't have enough energy to do that!");
            }
            else if (choice.equals("1")) {
              player.upKnowledge();
              System.out.println("JIMMY ECCLESTONE: I'm actually going to play golf with some old friends." +
              "\nYOU: That's cool... where?" +
              "\nJIMMY ECCLESTONE: In New York, actually. I'm going to spend some time there... I don't know when I'm coming back.");

              Scanner in6 = new Scanner(System.in);
              System.out.println("Do you find it suspicious?");
              System.out.println("1 - Yes.");
              System.out.println("2 - No.");
              choice = in6.nextLine();
              if (choice.equals("1")) {
                player.Jimmy();
              }
              else if (choice.equals("2")) {

              }
              else {
                wrongChoice();
              }
            }
            else if (choice.equals("2")) {
              player.upKnowledge();
              System.out.println("JIMMY ECCLESTONE: I actually came from the butler's room. He had something of mine..." +
              "\nJimmy's face gives way that he is extremely upset.");

              Scanner in7 = new Scanner(System.in);
              System.out.println("Do you ask him if he's upset because...");
              System.out.println("1 - The butler stole from him? (-1 energy)");
              System.out.println("2 - The butler killed his daughter? (-1 energy)");
              System.out.println("3 - The butler betrayed him? (-1 energy)");
              System.out.println("4 - Don't ask anything. (-0 energy)");
              choice = in7.nextLine();
              if ((choice.equals("1") || choice.equals("2") || choice.equals("3")) && player.getEnergy() < 1) {
                System.out.println("You don't have enough energy to do that!");
              }
              else if (choice.equals("1")) {

              }
              else if (choice.equals("2")) {

              }
              else if (choice.equals("3")) {

              }
              else if (choice.equals("4")) {

              }
            }
            else if (choice.equals("3")) {
              System.out.println("JIMMY ECCLESTONE: ...");
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
        }
      }
      else if (choice.equals("2")) {
        player.lotEnergy();
        System.out.println("");
      }
      else if (choice.equals("3")) {

      }
      else {
        wrongChoice();
      }

      System.out.println("");
    }
    else {
      wrongChoice();
    }

    while (true) {
      Scanner in3 = new Scanner(System.in);
      System.out.println("Where are you going? (1 word)");
      choice = in3.nextLine();
      if (choice.equals("kitchen")) {
        break;
      }
      else {
        System.out.println("No... where are you really going?");
      }
    }

    System.out.println("__" +
    "\n  |__" +
    "\n     |__" +
    "\n        |__" +
    "\n           |__" +
    "\n              |");

    while (true) {
      Scanner chooseJail = new Scanner (System.in);
      System.out.println("Where are you going? (1 word)");
      choice = chooseJail.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("jail")) {
        break;
      }
      else {
        System.out.println("Huh?");
      }
    }

    System.out.println("\n--------------------------------------------------------------------------------" +
    "\n" +
    "\n==================================DRIVING=======================================" +
    "\n" +
    "\n--------------------------------------------------------------------------------");

    System.out.println("You and " + friend3 + " arrive at the jail. You provide your IDs to the guard, who lets you in to talk to the butler." +
    "\nYOU: Hey, I spoke to the head maid this morning. Apparently, she found out that you had Marisa's bracelet and called the police." +
    "\n" + friend3 + ": It should be fine though. The bracelet was definitely planted by the real murderer. " +
    "\nHEAD BUTLER: I killed her." +
    "\nYOU: Our next course of act-- Wait what?" +
    "\nHEAD BUTLER: You've only been here for the week, but you don't know what the regular day at the Ecclestone mansion is like." +
    "\n" + friend3 + ": James, this isn't funny." +
    "\nHEAD BUTLER: The Ecclestones walk around like they're the most important people in the world. So dignified. They don't live like you or me." +
    "\nYOU: But... You've always had a good relationship with them." +
    "\nHEAD BUTLER: Did you hear? About Sharon's mother? And the cancer? Did you know that she has to work extra hours doing delivery because the Ecclestones don't pay her enough to afford the medicine?" +
    "\n" + friend3 + ": What are you saying? Why are you doing this?" +
    "\nHEAD BUTLER: The Ecclestones have always taken advantage of good people. People like Sharon. I just wanted a bit of revenge." +
    "\n" + friend3 + ": But... You've always liked Marisa." +
    "\nHEAD BUTLER: Didn't mean to kill her. It was unfortunate. I was thinking of giving her back for money, too. She's a strong one though." +
    "\n" + friend3 + ": What about... What about " + friend1 + "? And " + friend2 + "?" +
    "\nHEAD BUTLER: Knew too much. Shouldn't have gotten involved with the case. I'm surprised you're still here. If I hadn't gotten arrested, I would've killed you, too." +
    "\nYOU: This doesn't make any sense..." +
    "\nHEAD BUTLER: It's all over now anyway. There was no way I'd get away with it." +
    "\n" + friend3 + ": Wait... So you were the one to kill " + friend2 + "?" +
    "\nHEAD BUTLER: Hah... That little kid sure can put up a fight. Almost took me down. Would've hid the pieces of their body better if Kenna wasn't at the beach.");

    System.out.println("\nYou pull " + friend3 + " out of their chair and leave the room. You get back into the car and lean your head against the seat." +
    "\n" + friend3 + ": What... was that? There's no way, right? There's no way." +
    "\nYOU: How did he know? How did he know about " + friend3 + "? He didn't pick up when Kenna called and he hasn't BEEN here." +
    "\n" + friend3 + ": I've never seen him that cold before. He never liked us, but he was always warm to Marisa. I don't understand.");

    System.out.println("\nThis decision is an important one. It's time. Do you think the Head Butler is the culprit?");
    System.out.println("1 - Yes.");
    System.out.println("2 - No.");

    Scanner believeButler = new Scanner (System.in);

    while (true) {
      choice = believeButler.nextLine();
      if (!(choice.equals("1") || choice.equals("2"))) {
        System.out.println("You have to choose 1 or 2.");
      }
      else {
        break;
      }
    }

    if (choice.equals("1")) {
      System.out.println("YOU: All of the evidence has been pointing to him. And he just gave us his confession. There's no other explanation." +
      "\n" + friend3 + ": I... I suppose." +
      "\nYOU: I'll drop you off at your house. And let the Ecclestones know. The case is closed." +
      "\n" + friend3 + ": Is this really the end?" +
      "\nYOU: I guess so.");

      System.out.println("\nThat night, you receive a check from Kenna and Jimmy for $4000." +
      "\nThe following day, you leave the mansion. You hear about the case on the news." +
      "\nYou tried to appear confident when you were speaking to " + friend3 + ", but a gnawing feeling of doubt filled your gut as you realized" +
      "\n\t\t\t\t\t\t\t\tYou got the wrong guy.");
    }
    else {
      System.out.println("YOU: There's no way it's true. He wouldn't have had that note in anticipation that we'd show up to the apartment." +
      "\n" + friend3 + ": Right... And he seemed so genuine yesterday. There's definitely something else." +
      "\nYOU: What if... The murderer reached out to him again? Via note?" +
      "\n" + friend3 + ": That's right! Maybe the murderer saw us gone and got suspicious. We need to go talk to him again." +
      "\nYOU: We just left, though. I don't think we're allowed another visit." +
      "\n" + friend3 + ": What if we bail him out? We need 200 dollars, though." +
      "\nYOU: Let me check...");

      if (player.getMoney() > 200) {
        System.out.println("\nYOU: Aha! I have enough money. All that time spent at the casino paid off!" +
        "\n" + friend3 + ": You've been at the casino?" +
        "\nYOU: Let's go bail out the butler!");

        System.out.println("\nThe two of you return to the jail and pay the bail money. You drag the butler back to the car." +
        "\nYOU: Alright. I need you to be honest with us now. You're already out, so there's no going back. What do you know?" +
        "\nHEAD BUTLER: I'm so, so sorry. I--" +
        "\nYOU: Stop apologizing and tell us the truth." +
        "\nHEAD BUTLER: Kenna. She visited me earlier this morning. Showed me a picture of my wife and kids outside our house. Told me that she'd kill them if I didn't take the fall." +
        "\n" + friend3 + ": Oh no... What do we do now? ");
      }
    }
  }

  public static void main(String[] args) {
    playAgainstJojo();
    // boolean continuePlay = true;
    // while (continuePlay) {
    //   playGame();
    //   System.out.println("Do you wish to try again?");
    //   System.out.println("1 - Yes!");
    //   System.out.println("2 - No...");
    //
    //   Scanner in = new Scanner(System.in);
    //   String choice = in.nextLine();
    //
    //   if (choice.equals("1")) {
    //     System.out.println("Starting new game now...");
    //   }
    //   else if (choice.equals("2")) {
    //     System.out.println("Quitting game...");
    //     continuePlay = false;
    //   }
    //   else {
    //     System.out.println("That's not an option. Automatically quitting game...");
    //     continuePlay = false;
    //   }
    // }
  }

}

