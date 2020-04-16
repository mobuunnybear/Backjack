

public class Dealer extends Human{

    
    Card closedCard;

    Dealer(String name){
        this.Name = name;
    }

    public void printInformationThisPerson(){
        System.out.println("###### Information of "+getName()+" #######");
        
        if(closedCard != null) {
        	System.out.println("Having Card : CLOSED CARD" );
        }
          
         for(Card card : CardInHand){
        	 
            System.out.println("Having Card : "+card.toString());
        }
        System.out.println("All Point is : "+getPoint());
    }
    
    public void closeCard() {
    	closedCard = CardInHand.remove(0);
    }
    
    public void openCard() {
    	
    	CardInHand.add(0, closedCard);;
    
    	
    	closedCard = null;
    }

   


}
