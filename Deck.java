 //Header
/*************************************************
 * The Deck Class
 * 
 * @author Dawit Ashenafi Getachew
 * @version Version1
 * @date 15-01-2024
 *************************************************/
import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
    //Instance Data
    private static int num = 0;
    private ArrayList<Card> cards = new ArrayList<>();
    
    Random rand = new Random();
    //Constructor
    public Deck(int k)
    {
        cards = new ArrayList<>();
        for(int i = 0; i < k; i++)
        {
            for(int suit = 1; suit <= 4; suit++)
            {
                for(int face = 1; face <=13; face++)
                {
                    cards.add(new Card(suit, face));
                    num++;
                }
            }
        }

    }
    //Size
    public int size()
    {
        return num;
    }
    //Top Card
    public Card getTop()
    {
        Card top = cards.get(0);
        cards.remove(0);
        num = num -1;
        return top;
    }
    

    //Shuffle method using Fisher Yates Algorithm
    public void shuffle()
    {
        Card temp1,temp2;
        for(int i = cards.size() - 1; i >= 0; i--)
        {
            int random = rand.nextInt(cards.size());
            int j = rand.nextInt(i+1);
            temp1 = cards.get(random);
            temp2 = cards.get(i);
            cards.remove(random);
            cards.add(random, temp2);
            cards.remove(i);
            cards.add(i,temp1);
        }
    }
    
    //Deal Card method
    public Card dealCard()
    {
        if(!cards.isEmpty())
        {
            return cards.remove(0);
        }
        else
        {
            System.out.println("Empty Deck");
            return null;
        }   
    }
    
    //String
    public String toString()
    {
        String c = "";
        for(int i = 0; i < cards.size(); i++)
        {
            c += cards.get(i).toString() + "\n";
        }
        return c;
    }
}
