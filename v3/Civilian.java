/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class Civilian extends Character {

  public Civilian() {
    currency = 100;
    knowledge = 10;
  }

  public receiveMoney() {
    currency += 10;
  }

  public loseGame() {
    currency -= 50;
  }

}
