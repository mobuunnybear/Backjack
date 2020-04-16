

import java.util.ArrayList;
import java.util.List;

public class Human {
    List<Card> CardInHand ;
    //int point ;
    String Name;
    public Human() {
        CardInHand = new ArrayList<>();

    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Card> getCardInHand() {
        return CardInHand;
    }

    public void setCardInHand(List<Card> cardInHand) {
        CardInHand = cardInHand;
    }

    public void reciveCard(Card card) {
        this.CardInHand.add(card);
    }

    public int getPoint() {
        return calculatePoint();
        
    }

    

    private int calculatePoint(){
        int returnPoint = 0;
        
        
        for(Card card : CardInHand){
        	if(card.getPoint().equals("J")||card.getPoint().equals("Q")||card.getPoint().equals("K")) {
        		returnPoint = returnPoint+10;
        	}
        	
        	else if(card.getPoint().equals("A")) {
                	 
                	returnPoint = returnPoint+11;
                	
                }else {
                	returnPoint = returnPoint+Integer.parseInt(card.getPoint());
                }
        }
        
        for(Card card : CardInHand){
        	if(returnPoint>21) {
        		if(card.getPoint().equals("A")) {
        			returnPoint = returnPoint - 10;
        		}
        	}
        }
        return returnPoint;
    }
    
    public void resetCard() {
    	CardInHand = new ArrayList<>();
    }
    

}
