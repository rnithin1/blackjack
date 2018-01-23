package blkjak21support;
import java.io.*;
import java.util.Random;
import java.util.Vector;
import java.util.Date;
class dealhand {
  public static Vector<Vector<String>> deckCards;
  public Random rand;
  public Vector<String> clubs;
  private String x;
  dealhand() {
    Date date = new Date();
    deckCards = new Vector<Vector<String>>(1); 
    rand = new Random(date.getTime() * 1000); 
    clubs = new Vector<String>();
    try(BufferedReader scan = new BufferedReader(new FileReader("cards.txt"))) {
      while ((x = scan.readLine()) != null) clubs.add(x);
    }
    catch(IOException fishburn) {
      System.out.printf("Something\n");
      fishburn.printStackTrace();
    }
    for(int i = 0; i < 4; i++) deckCards.add((Vector<String>)clubs.clone());
    //Order: clubs, diamonds, hearts, spades
  }
  protected void deal(Vector<String> hand) {
    int i,k,l;
    i = k = l = -1;
    for(i = 0; i < 2; i++) {
      k = rand.nextInt(4);
      l = rand.nextInt(deckCards.get(k).size());
      try {
        hand.add(deckCards.get(k).get(l));
        deckCards.get(k).remove(l);
      } 
      catch (ArrayIndexOutOfBoundsException neeraj) {
        return;
      }
    }
  }
  protected void printHands(Vector<String> hand, Vector<String> dealerHand) {
    System.out.printf("Your cards are:\n");
    for(int i = 0; i < hand.size(); i++) {
      int j = Integer.parseInt(hand.get(i));
      if(j == 1 || j == 11) System.out.println("A");
      System.out.println(j > 10 ? Character.toString((char) j) : j);
    }
    System.out.printf("\nThe dealer's cards:\n");
    int j = Integer.parseInt(dealerHand.get(0));
    if(j == 1 || j == 11) System.out.println("A");
    else System.out.println(j > 10 ? Character.toString((char) j) : j);
    for(int i = 0; i < dealerHand.size() - 1; i++) System.out.println("X");
  }    
  protected void printHandsFinal(Vector<String> hand, Vector<String> dealerHand) {
    System.out.printf("Your cards are:\n");
    for(int i = 0; i < hand.size(); i++) {
      int j = Integer.parseInt(hand.get(i));
      if(j == 1 || j == 11) System.out.println("A");
      System.out.println(j > 10 ? Character.toString((char) j) : j);
    }
    System.out.printf("\nThe dealer's cards:\n");
    for(int i = 0; i < dealerHand.size(); i++) {
      int j = Integer.parseInt(dealerHand.get(i));
      if(j == 1 || j == 11) System.out.println("A");
      System.out.println(j > 10 ? Character.toString((char) j) : j);
    }
  }
  protected void hit(Vector<String> hand) {
    int i,k,l;
    i = k = l = -1;
    k = rand.nextInt(4);
    l = rand.nextInt(deckCards.get(k).size());
    try {
      hand.add(deckCards.get(k).get(l));
      deckCards.get(k).remove(l);
    } 
    catch (ArrayIndexOutOfBoundsException neeraj) {
      return;
    }
    
  }
}
    
