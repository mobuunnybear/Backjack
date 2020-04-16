
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Card {

    private String point;
    private String suit;

    public static Card A_SPADE = new Card("A", "Spades");
    
    public static Card creatAceSpade() {
    	return new Card("A","Spades");
    }
    
    private Card (String cardPoint, String cardSuit){
        this.point = cardPoint;
        this.suit = cardSuit;
    }

    public String getPoint(){
        return point;
    }

    public String getSuit(){
        return suit;
    }

//    public String toString(){
//        return point +  suit;
//    }


    @Override
    public String toString() {
        return "Card{" +
                "point='" + point + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}