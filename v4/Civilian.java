/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class Civilian extends Character {

  protected String name;
  protected boolean isAlive;

  public Civilian(String input) {
    name = input;
    currency = 100;
    knowledge = 10;
    isAlive = true;
  }

  public void die() {
    isAlive = false;
  }

  public String toString() {
    return name;
  }

}
