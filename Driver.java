import java.util.ArrayList;
import java.util.Scanner;

//Header
/*************************************************
 * The Driver Class
 * 
 * @author Dawit Ashenafi Getachew
 * @version Version1
 * @date 15-01-2024
 *************************************************/
public class Driver 
{
    public static void main(String[] args)
    {
        //Declaration and Instantiation
        Deck deck = new Deck(1);
        deck.shuffle();
        
        ArrayList<Card> PHand = new ArrayList<>();
        ArrayList<Card> DHand = new ArrayList<>();
        HandOfCards playerHand = new HandOfCards(PHand);
        HandOfCards dealerHand = new HandOfCards(DHand);
        
        //Dealing the Initial Cards
        playerHand.add(deck.dealCard());
        dealerHand.add(deck.dealCard());
        dealerHand.add(deck.dealCard());
        playerHand.add(deck.dealCard());
        
        //Showing the Initial Hand
        System.out.println("Player's Hand: ");
        playerHand.getPHand();
        System.out.println("Dealer's Hand: ");
        dealerHand.getDHand();
        
        //Players and Dealers Turn
        pTurn(deck, playerHand);
        dTurn(deck, dealerHand);
        
        //Winner
        winner(playerHand.blackjackScore(), dealerHand.blackjackScore());
        
    }
    //Methods
    //Player Turn method
        private static void pTurn(Deck deck, HandOfCards playerHand)
        {
            Scanner myScanner = new Scanner(System.in);
            //boolean check = true;
            //while(check != false)
            //{
            
                while (playerHand.blackjackScore() < 21) 
                {
                    System.out.println("Player's current score: " + playerHand.blackjackScore());
                    System.out.println("Do you want to hit (h) or stay (s)?");
                    char choice = myScanner.next().charAt(0);
        
                    if (choice == 'h') 
                    {
                        // Player wants to hit
                        Card newCard = deck.dealCard();
                        playerHand.add(newCard);
                        System.out.println("Player drew: " + newCard);
                    } 
                    else if (choice == 's') 
                    {
                        //check = true;
                        break;
                    }
                }
            //}
        }
        //Dealer Turn method
        private static void dTurn(Deck deck, HandOfCards dealerHand)
        {
            // Reveal the dealer's hidden card
            System.out.print("Dealer's hand: ");
            dealerHand.getPHand();
            System.out.println();
    
            // Dealer's logic
            while (dealerHand.blackjackScore() <= 16) 
            {
                // Dealer must hit if the score is 16 or lower
                Card newCard = deck.dealCard();
                dealerHand.add(newCard);
                System.out.println("Dealer drew: " + newCard);
            }
           
        }
        //Winner method
        private static void winner(int playerScore, int dealerScore)
        {
            
            System.out.println("Player's final hand: " + playerScore);
            System.out.println("Dealer's final hand: " + dealerScore);
    
            if (playerScore > 21) 
            {
                System.out.println("Player busts. Dealer wins!");
            } 
            else if (dealerScore > 21) 
            {
                System.out.println("Dealer busts. Player wins!");
            } 
            else if (playerScore > dealerScore) 
            {
                System.out.println("Player wins!");
            } 
            else if (playerScore < dealerScore) 
            {
                System.out.println("Dealer wins!");
            }
            else
            {
                System.out.println("It's a tie!");
            }
        }
        
}
