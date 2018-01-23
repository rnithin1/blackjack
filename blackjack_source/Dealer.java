package blkjak21support;
import java.io.*;
import java.lang.Integer;
import java.lang.Character;
import java.util.Vector;
import java.util.Random;
public class Dealer extends dealhand {
  private Vector<String> hand;
  public Dealer() {
    super();
    hand = new Vector<String>(1);
    super.deal(hand);
    if(Integer.parseInt(hand.get(1)) == 65) hand.set(1,"11");
    if(Integer.parseInt(hand.get(0)) == 65) hand.set(1,"11");
  }
  protected Vector<String> getHand() {
    return hand;
  }
  public void printHands(Support suphand) {
    super.printHands(suphand.getHand(),this.getHand());
  }
  public void printHandsFinal(Support suphand) {
    super.printHandsFinal(suphand.getHand(),this.getHand());
  }
  public int handTotal() {
    int sum = 0;
    for(int i = 0; i < hand.size(); i++) {
      if(Integer.parseInt(hand.get(i)) > 10 && Integer.parseInt(hand.get(i)) != 65) sum += 10;
      else sum += Integer.parseInt(hand.get(i));
    }
    return sum;
  }
  public void hit() {
    int b = handTotal();
    if(b == 21) {
      System.out.println("\nThe dealer got a blackjack!");
      return;
    }
    while(b < 15) {
      super.hit(this.getHand());
      if((Integer.parseInt(hand.get(hand.size() - 1)) == 65) && b < 10) 
        hand.set(hand.size() - 1, "11");
      if((Integer.parseInt(hand.get(hand.size() - 1)) == 65) && b < 21)      
        hand.set(hand.size() - 1, "1");
      b = handTotal();     
    }
    if(b > 21) {
      System.out.print("The dealer bust! You win!");
      return;
    }
  }  
}
