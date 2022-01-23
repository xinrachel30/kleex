/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class PrivateInvestigator extends Character {

  protected String name;
  protected int currency;
  protected int relationKenna = 0;
  protected int relationJimmy = 0;
  protected boolean clueCafe = false;
  protected boolean clueCoffee = false;
  protected boolean clueMansion = false;
  protected boolean clueBeach = false;
  protected boolean clueKennaRant = false;
  protected boolean clueAbsentParents = false;
  protected boolean clueWrongKenna = false;
  protected boolean clueJimmyButler = false;


  public PrivateInvestigator(String input) {
    currency = 10;
    name = input;
  }

//Updt Values ----------------------------------------------------------------//

  public void regularEnergy() {
    energy --;
  }

  public void lotEnergy() {
    energy -= 2;
  }

  public void upKnowledge() {
    knowledge ++;
  }

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

  public void Kenna() {
    relationKenna ++;
  }

  public void Jimmy() {
    relationJimmy ++;
  }

//Get Values -----------------------------------------------------------------//

  public int getEnergy() {
    return energy;
  }

  public int getKnowledge() {
    return knowledge;
  }

  public int getMoney() {
    return currency;
  }

  public void amountEnergy() {
    System.out.println("You have " + energy + " energy.");
  }

  public void amountKnowledge() {
    System.out.println("You have" + knowledge + "knowledge.");
  }

  public int getJimmy() {
    return relationJimmy;
  }

  public int getKenna() {
    return relationKenna;
  }

}
