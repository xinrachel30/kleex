/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class PrivateInvestigator extends Character {

  protected String name;

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

}
