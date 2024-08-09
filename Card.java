 //Header
/*************************************************
 * The Card Class
 * 
 * @author Dawit Ashenafi Getachew
 * @version Version1
 * @date 15-01-2024
 *************************************************/
public class Card 
{
    //Instance Data
    private int suit;
    private int face;

    //Constructor
    public Card(int suit, int face)
    {
        this.suit = suit;
        this.face= face;
    }

    //Methods
    //Accessor
    public int getSuit()
    {
        return suit;
    }
    public int getFace()
    {
        return face;
    }

    //Special methods
    public String getSuitString()
    {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        return suits[suit-1];
    }
        
    public String getFaceString()
    {
        String[] faces = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        return faces[face-1];
    }

    //toString
    public String toString()
    {
        return getFaceString() + " of " + getSuitString();
    }
}
