/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class PrivateInvestigator extends Character {

  protected String name;
  protected int relationKenna = 0;
  protected int relationJimmy = 0;

  public PrivateInvestigator(String input) {
    currency = 10;
    name = input;
  }

  public void regularEnergy() {
    energy --;
  }

  public void lotEnergy() {
    energy --;
    energy --;
  }

  public void goodKnowledge() {
    knowledge ++;
  }

  public void badKnowledge() {
    knowledge --;
  }

  public void payForGame() {
    currency -= 10;
  }

  public void winGame() {
    currency += 50;
  }

  public void draw(){
    currency += 30;
  }

  public void Kenna() {
    relationKenna ++;
  }

  public void Jimmy() {
    relationJimmy ++;
  }

  public String tired() {
    if (energy == 0) {
      System.out.println("You don't have enough energy. You decide to go home to rest.")
    }
    else {
      
    }
  }

}
