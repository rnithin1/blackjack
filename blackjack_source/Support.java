package blkjak21support;
import java.lang.Integer;
import java.lang.Character;
import java.util.Vector;
import java.util.Random;
import java.util.Scanner;
public class Support extends dealhand {
  private Vector<String> hand;
  public Scanner scan;
  private int x;
  public Support() {
    super();
    scan = new Scanner(System.in);
    hand = new Vector<String>(1);
    super.deal(hand);
    check();
  }

  public void deal(Dealer dealer) {
    super.deal(hand);
    this.printHands(dealer);
  }
  public void printHands(Dealer dealer) {
    super.printHands(this.getHand(),dealer.getHand());
  }
  public Vector<String> getHand() {
    return hand;
  }
  public void readCards() {
    int k = rand.nextInt(4);
    int l = rand.nextInt(deckCards.get(k).size());
    int j = Integer.parseInt(deckCards.get(k).get(l));
    System.out.println(j > 10 ? Character.toString((char) j) : j);
    System.out.println(k);
    switch(k) {
      case 0: System.out.println("Clubs");
              break;
      case 1: System.out.println("Diamonds");
	      break;
      case 2: System.out.println("Hearts");
	      break;
      case 3: System.out.println("Spades");
	      break;
      default: System.out.println("Mao Zedong");
    }
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
    super.hit(this.getHand());
    if(Integer.parseInt(hand.get(hand.size() - 1)) == 65) {System.out.println("Do you want your ace to be 1 or 11?");
    int x = scan.nextInt();
    switch(x) {
      case 1: {hand.set(hand.size() - 1,"1");
              break;}
      case 11: {hand.set(hand.size() - 1,"11");
	      break;}
      default: {System.out.println("Hey gandu, do you mean 11?");
              hand.set(hand.size() - 1,"11");
	      break;} 
      }}
  }
  private void check() {
    if(Integer.parseInt(hand.get(0)) == 65) {
      System.out.println("Do you want your ace to be 1 or 11?");
    int x = scan.nextInt();
    switch(x) {
      case 1: {hand.set(0,"1");
              break;}
      case 11: {hand.set(0,"11");
	      break;}
      default: {System.out.println("Hey gandu, do you mean 11?");
              hand.set(0,"11");
	      break;} 
      }
    }
    if(Integer.parseInt(hand.get(1)) == 65) {
    System.out.println("Do you want your ace to be 1 or 11?");
    x = scan.nextInt();
    switch(x) {
      case 1: {hand.set(1,"1");
              break;}
      case 11: {hand.set(1,"11");
	      break;}
      default: {System.out.println("Hey gandu, do you mean 11?");
              hand.set(1,"11");
	      break;} 
    }
   }
  }
/*
  public void overboard(ArrayList x);
  public void aces_count(ArrayList x);*/
}

