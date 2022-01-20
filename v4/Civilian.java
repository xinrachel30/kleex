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

  public Civilian() {
    currency = 100;
    knowledge = 10;
    isAlive = true;
  }

  public void setName(String input) {
    name = input;
  }

  public void die() {
    isAlive = false;
  }

  public String toString() {
    return name;
  }

}
