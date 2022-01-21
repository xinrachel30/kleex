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

  public String toString() {
    return name;
  }

  public void regularEnergy() {
    energy --;
  }

  public void lotEnergy() {
    energy -= 2;
  }

  public void upKnowledge() {
    knowledge ++;
  }

  public void Kenna() {
    relationKenna ++;
  }

  public void Jimmy() {
    relationJimmy ++;
  }

  //-------------------------------------------------------//

  public void upEnergy() {
    energy += 5;
  }

  public void dayEnergy() {
    energy += 10;
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

  public int getEnergy() {
    return energy;
  }

}
