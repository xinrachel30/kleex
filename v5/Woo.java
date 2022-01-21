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
    player.regularEnergy();
    System.out.println("You walk into the Moonlit 251 Casino. You walk past lines and lines of slot machines and tables of calculating players.\n" +
    "\nWhat do you want to play now, PI?");
    Scanner casino = new Scanner(System.in);
    System.out.println("1 - Play against Bobo, a master at picking high value cards from a standard deck of cards (-1 energy)\n");
    System.out.println("2 - Return home (-0 energy)\n");

    String choice = casino.nextLine();
    if (choice.equals("1")) {
      player.regularEnergy();
      playAgainstBobo();
    }
    else if (choice.equals("2")) {
      return;
    }
    else {
      wrongChoice();
    }
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
        "\nHEAD BUTLER: ... I would say so. The Ecclestone's treat me well, though Marisa is a bit sloppy at times." +
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
      System.out.println(friend1 + ": I went over to Marisa's mansion and tried talking to her parents, but the head butler dismissed me before I had the chance to.");
    }
    else if (choice.equals("2")) {

    }
    else {
      wrongChoice();
    }
  }


  public static void dayTwo() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 2");
    player.dayEnergy();
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
    player.amountEnergy();
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
      System.out.println("1 - Ask her what she is doing here. ()");
      System.out.println("2 - Ask her what she is drinking. ()");
      System.out.println("3 - Just stare at her. ()");
      player.amountEnergy();
      choice = in11.nextLine();
    //   if () {
    //
    //   }
    //
    // else if (choice.equals("2")) {
    //   System.out.println(
    //   ": Okay then, I'll meet you there. I'll be wearing a green shirt with the design of the queen of spades." +
    //   "\nThe call ends, and you leave your house after grabbing the neccessary goods." +
    //   "\n-------------------------------------------------------------------------------" +
    //   "\n                                  MARBLIN DINE                                 " +
    //   "\n-------------------------------------------------------------------------------");
    //   walkinDay2();
    //   questionSet1();
    //   questionSet2();
    //   questionSet3();
    // }
    // else {
    //   wrongChoice();
    // }
  }
}

  public static void dayThree() {
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"
    + "\nDay 3");
    player.dayEnergy();
    printStats(player);

    friend1.die();

    System.out.println("As you pull into the mansion, you hear a commotion. Two panicked kids run up to you.");
    String tempfriend2 = friends.get(0);
    String tempfriend3 = friends.get(1);
    System.out.println(tempfriend2 + ": YOU! You're the private investigator, right?" +
    "\nYOU: Yes, that's me. What's going on here?\n" +
    tempfriend3 + ": " + friend1 + " is dead because of you!" +
    "\nYOU: Let's calm down here. What do you mean they're dead?\n" +
    tempfriend2 + ": The head butler found " + friend1 + " in the garden shed out back.\n" +
    tempfriend3 + ": Right after you talked to them yesterday. Right after Marisa disappeared." +
    "\nYOU: Can I see the body? Maybe there are still clues as to what happened to them.\n" +
    tempfriend2 + ": Hell no! I don't want to be involved with this at all!\n" +
    tempfriend3 + ": The last person that helped you is dead now... I'm not risking it!");

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
    friend2 + ": ... I suppose I can help. But I'm doing this to help Marisa and" + friend1 + "\n" +
    friend3 + ": Are you kidding me? Whatever. I'm out of here!\n\n" +
    friend3 + "runs off the lot while you and " + friend2 + " make your way to the garden shed\n\n" +
    "YOU: Where did the body go?\n" +
    friend2 + ": The head butler called for someone to take it away. He was adamant about it being removed as quickly as possible.\n" +
    "YOU: That's a strange reaction. Someone dies on his watch and his first reaction is to get rid of the body?\n" +
    friend2 + ": Well... I didn't think about it that way. He's a queasy sort of person. Sort of a germophobe. Was never quite fond of us.\n" +
    "YOU: Us... as in you and " + friend1 + "?\n" +
    friend2 + ": All of us. " + friend1 + ", " + "Marisa, " + friend3 + ", me. We pick up after ourselves when we hang out at Marisa's, but he constantly complains about picking up after us.\n" +
    "YOU: Still. Quite the strange reaction to a murder. Where's the empathy?");

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

    if (choice.equals("1") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("1")) {
      player.lotEnergy();
      System.out.println("YOU: Hey, she's been having a hard time as well. At least she's trying her best to help out with the investigation.\n" +
      friend2 + ": I suppose. She seems nervous as well. I saw her pacing around for nearly an hour yesterday at the pier.\n");
    }
    else if (choice.equals("2") && player.getEnergy() < 2) {
      System.out.println("You don't have enough energy to do that!");
    }
    else if (choice.equals("2")) {
      player.lotEnergy();
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
      System.out.println("I heard from " + friend1 + " that you and your friends last saw Marisa at the beach. Did she seem off at all?\n" +
      friend2 + ": Not that I know of? I mean, she usually seems a bit down because her parents are constantly fighting. It's not out of the ordinary.\n" +
      "YOU: I see. Is there anything else you can tell me about that day?\n" +
      friend2 + ": Now that I'm thinking about it... Usually, it's the head butler that drives us. For some reason, he got sick that day. But he never gets sick.\n" +
      "YOU: A butler dead set on cleanliness falling ill. Interesting. Thank you, " + friend2 + ".\n");
      player.upKnowledge();
    }
    else if (choice.equals("2")) {
      player.regularEnergy();
      System.out.println("You and " + friend2 + " walk inside the mansion. It's quite empty today. The only person you see is the head maid.\n");

      Scanner in4 = new Scanner(System.in);
      choice = in4.nextLine();

      System.out.println("Do you wish to go speak to her [the head maid]?");
      System.out.println("1 - Yes (-1 energy)");
      System.out.println("2 - No (-0 energy)");
      player.amountEnergy();

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
          friend2 + ": Alright. Stay safe\n");

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

          }
          else {
            wrongChoice();
          }
        }


      }
    }
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
    boolean continuePlay = true;
    while (continuePlay) {
      playGame();
      System.out.println("Do you wish to try again?");
      System.out.println("1 - Yes!");
      System.out.println("2 - No...");

      Scanner in = new Scanner(System.in);
      String choice = in.nextLine();

      if (choice.equals("1")) {
        System.out.println("Starting new game now...");
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
