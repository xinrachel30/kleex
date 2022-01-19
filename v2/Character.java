/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/ 

public class Character {

  protected double currency = 0;
  protected int knowledge = 0;
  protected int hp = 100;
  protected int strength = 10;
  protected int energy = 10;

  public boolean alive() {
    return hp > 0;
  }

}
