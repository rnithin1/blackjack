package blkjak21;
import blkjak21support.*;
import java.util.Scanner;
import java.util.ArrayList;
public class blackjack {
  public static Scanner scan = new Scanner(System.in);
  public static Dealer dealer = new Dealer();
  public static Support player = new Support();
  public static int[] Scores = new int[2];
  protected static ArrayList ondru() {
    int playersum = player.handTotal();
    player.printHands(dealer);
    System.out.print("\nYour card total: " +playersum);
    if(playersum == 21) {
      System.out.println("Congratulations! You got a blackjack!");
      return new ArrayList<String>();
    }
    else while(true) {
      System.out.printf("\nWould you like to hit? (1,2)\n");
      playersum = player.handTotal();
      if(scan.nextInt() == 1) {
        player.hit();
        player.printHands(dealer);
        playersum = player.handTotal();
        System.out.print("\nYour card total: " +playersum);
      }
      if(scan.nextInt() == 2) break;
      if(playersum > 21) {
        System.out.printf("You lose!");
        break;
      }

    }
    System.out.println("\nYour final total: " + playersum);
    dealer.hit();
    if(dealer.handTotal() > 21) return new ArrayList<String>();
    irandu();
    return new ArrayList<String>();
  }
  public static void irandu() {
    dealer.printHandsFinal(player);

    Scores[0] = player.handTotal();
    Scores[1] = dealer.handTotal();
    if(Scores[0] > Scores[1]) System.out.println("\nYou win! Points: " 
         + Scores[0] + " to " + Scores[1]);
    if(Scores[0] < Scores[1]) System.out.println("\nYou lose! Points: " 
         + Scores[0] + " to " + Scores[1]);
    if(Scores[0] == Scores[1]) System.out.println("Tie!");
    System.out.println("\nDo you want to play again? (1,2)");
    int asdf = scan.nextInt();
    if(asdf == 1) {
      System.out.println("Too bad!");
    }
  }
  public static void main(String[] args) {  
    System.out.println("Welcome to blackjack!");
    ondru();
  }
}
    
