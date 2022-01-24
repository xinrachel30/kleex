/*
kleex -- Lindsay Phung and Xinqing Lin
APCS pd07
FP: Show Us What You Got
2022-01-21
*/

public class Character {
 
  protected int currency = 0;
  protected int knowledge = 0;
  protected int energy = 10;

  protected int blackJackValue = 0;

  public void updtBlackJack(Card a) {
    blackJackValue += a.blackJackValue();
  }

  public int getBlackJack() {
    return blackJackValue;
  }

  public boolean bust() {
    return blackJackValue > 21;
  }

}
