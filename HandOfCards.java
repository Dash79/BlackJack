import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

 //Header
/*************************************************
 * The HandOfCards Class
 * 
 * @author Dawit Ashenafi Getachew
 * @version Version1
 * @date 15-01-2024
 *************************************************/
public class HandOfCards 
{
    //Instance Data
    private ArrayList<Card> hand = new ArrayList<>();
    Random rand = new Random();
    private int acePlayer = 0;
    private int aceDealer = 0;
    
    //Constructor
    public HandOfCards(ArrayList<Card> hand)
    {
        this.hand = hand;
    }
    //Methods
    //deal
    public void dealCard(Deck deck)
    {
        hand.add(deck.getTop());
    }
    //Adding a Card
    public void add(Card cards)
    {
        hand.add(cards);
    }
    
    //Getting the players hand
    public void getPHand()
    {
        for(int i = 0; i<hand.size(); i++)
        {
            System.out.println(hand.get(i));
        }
    }
    //Getting the dealers hand
    public void getDHand()
    {
        System.out.println(hand.get(hand.size()-1));
    }
    //Blackjack score
    public int blackjackScore()
    {
        int score = 0;
        int aceNum = 0;
        
        for(int i = 0; i < hand.size(); i++)
        {
            Card cd = hand.get(i);
            int face = cd.getFace();
            
            if(face ==1)
            {
                aceNum++;
                //let ace be 11 first
                score += 11;
            }
            else if(face >= 10)
            {
                score += 10;
            }
            else
            {
                score += face;
            }
        }
        while(score > 21 && aceNum > 0)
        {
            score -= 10;
            aceNum--;
        }
        return score;
    }    
}
