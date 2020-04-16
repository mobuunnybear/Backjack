
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Table {
	List<Player> ListOfPlayer = new ArrayList<>();
    Dealer dealer = new Dealer("Dealer");
    Deck deck = new Deck();
    Boolean candraw = true;
    boolean isplayagain = true;
    
    public void startBlackjack() {
    	  
    	

    	Scanner scanner = new Scanner(System.in);
  	

    	
    	
    	for(int i =0; i <2;i++) {
    		GiveCard(this.dealer);
    		  for (Player player : this.ListOfPlayer) {
    			  GiveCard(player);
    	           this.tableCheckPlayerPoint(player);
    	        }
    	}
    	
    	
        this.tablePrintAllStatus();

        
        System.out.println("");
        System.out.println("############### STEP[2] Loop Gameming ##############");
        System.out.println("!!!! Dealer GettingCard [1] !!!!");
       // table.getDealer().reciveCard(table.getDeck().drawCard());
        System.out.println("!!!! Dealer GettingCard [2] !!!!");
       // table.getDealer().reciveCard(table.getDeck().drawCard());
       this.getDealer().closeCard();
        
        this.getDealer().printInformationThisPerson();

        for (int i = 0; i < this.getListOfPlayer().size(); i++) {
            System.out.println("This Play        : " + this.getListOfPlayer().get(i).getName());
            System.out.println("How Much Bet Money : ");
            this.getListOfPlayer().get(i).status = Player.Status.BETTING;
            System.out.println("Status:"+Player.Status.BETTING);
            
            
            
            
            int betMoney = scanner.nextInt();
            this.getListOfPlayer().get(i).setBet(betMoney);
            
            
          //  outerloop:
            
            while (this.getListOfPlayer().get(i).getCardInHand().size() < 5 && this.getListOfPlayer().get(i).getcandraw()==true) {
            	
                System.out.println("If Want to \"Hit , Stay\" Type in That Word");
                String status = scanner.next().toLowerCase();
                System.out.println("Input command is : " + status);
                switch (status) {
                    case "hit":
//                      
                    	this.hit(this.getListOfPlayer().get(i));
                        this.getListOfPlayer().get(i).status = Player.Status.PLAYING;
                        System.out.println("Status:"+Player.Status.PLAYING);
                        
                    	break;
                    case "stay":
//                        
                    	this.stay(this.getListOfPlayer().get(i));
                        this.getListOfPlayer().get(i).status = Player.Status.PLAYING;
                        System.out.println("Status:"+Player.Status.PLAYING);
                    	break;
                    default:
                        System.out.println("!!!! Wrong Input  !!!!");
                }
            }
            System.out.println(" : : : : : ");
            }
    	
        System.out.println("############### STEP[3] Checker Dealer Setting ##############");
        this.getDealer().openCard();

        this.dealerGetCard();
        this.getDealer().printInformationThisPerson();
      
        System.out.println("############### STEP[4] Checker Table This round ##############");
        this.comparePoint();
        for (int i = 0; i < this.getListOfPlayer().size(); i++) {
        	this.getListOfPlayer().get(i).printInformationThisPerson();
        }
        
        System.out.println("###### END PROCESS  ######");
        this.isPlayagain();
//        for (int i = 0; i < this.getListOfPlayer().size(); i++) {
//        	System.out.println("This Play        : " + this.getListOfPlayer().get(i).getName());	
//        	System.out.println("play again?");
//        String playagain = scanner.next().toLowerCase();
//        if(!playagain.equalsIgnoreCase("yes")) {
//        	this.getListOfPlayer().remove(i);
//        	i = i -1;
//        }
//        if(this.getListOfPlayer().size()>0) {
//        	this.isplayagain = true;
//        }else {
//        	this.isplayagain = false;
//        }
//        
//        }
    }
    
    public void isPlayagain() {
    	
    	Scanner scanner = new Scanner(System.in);
    	  for (int i = 0; i < this.getListOfPlayer().size(); i++) {
          	System.out.println("This Play        : " + this.getListOfPlayer().get(i).getName());	
          	System.out.println("play again?");
          String playagain = scanner.next().toLowerCase();
          if(!playagain.equalsIgnoreCase("yes")) {
          	this.getListOfPlayer().remove(i);
          	i = i -1;
          }
          if(this.getListOfPlayer().size()>0) {
          	this.isplayagain = true;
          }else {
          	this.isplayagain = false;
          }
          
          }
    }
    public void dealerGetCard() {
    	
        while (this.getDealer().getPoint() < 16) {
            System.out.println("!!!! Dealer GettingCard  !!!!");
            this.getDealer().reciveCard(this.getDeck().drawCard());
        }
    }
    
    public void hit(Player player) {
    	
    	 player.reciveCard(this.getDeck().drawCard());
    	 player.printInformationThisPerson();
         this.tableCheckPlayerPoint(player);
         if(player.getWinGame()||player.getLoseGame()) {
         	player.setcandraw(false);
         }else {
         player.setcandraw(true);
         }
    }
    
    public void addstartplayer() {
    	int CountPlayer;
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("###### STEP[1] Play ######");
        System.out.print("System Command : How Many Player Wanna Play : ");
        CountPlayer = scanner.nextInt();
        System.out.println();
    	
        
    	
    	  for (int i = 0; i < CountPlayer; i++) {
              System.out.print("Player Number [" + i + "] Insert Name : ");
              String Name = scanner.next();
              Player player = new Player(Name);
              this.AddPlayer(player);
          }
    }

    public void stay(Player player) {
        System.out.println("Stop in This Player");
        player.setcandraw(false);
    }
    public Dealer getDealer() {
        return this.dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void AddPlayer(Player player) {
        this.ListOfPlayer.add(player);
    }

    public void RemovePlayer(Player player) {
        this.ListOfPlayer.remove(player);
    }

    public void GiveCard(Human human) {
         human.reciveCard(this.deck.drawCard()); 
    }

    public List<Player> getListOfPlayer() {
        return this.ListOfPlayer;
    }

    public void setListOfPlayer(List<Player> listOfPlayer) {
        this.ListOfPlayer = listOfPlayer;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void comparePoint(){
        int KingPoint = this.dealer.getPoint();
         for (Player player : this.ListOfPlayer) {
            int playerNumber = player.getPoint();
            if(playerNumber>KingPoint){
                player.setWinGame(true);
            }else if(playerNumber<KingPoint){
                player.setLoseGame(true);
            }else {
                player.setDrawGame(true);
            }

            if(playerNumber<21&&player.getWinGame()){
                System.out.println("This Player "+player.getName() + " IF");
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" + "+(player.getBet()*1.5));
                player.setMoney((player.getMoney()+(player.getBet()*1.5)));
            }else if((playerNumber == 21)){
                System.out.println("This Player "+player.getName() + " Else IF");
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" + "+(player.getBet()*2));
                player.setMoney((player.getMoney()+(player.getBet()*2)));
            }else{
                System.out.println("This Player "+player.getName() + " Else");
                System.out.println("This Player Money is "+player.getMoney());
                System.out.println("This Player Bet is "+player.getBet());
                System.out.println("This Player will be "+player.getMoney()+" - "+(player.getBet()));
                player.setMoney((player.getMoney()-(player.getBet())));
            }
        }
    }
    
    public void tableCheckPlayerPoint(Player player) {
    	if(player.getPoint()>21) {
    		player.setLoseGame(true);
    		player.setcandraw(false);
    
    	}else if((player.getPoint()==21)||player.getCardInHand().size()==5) {
    		player.setWinGame(true);
    		player.setcandraw(false);
    	}else {
    	
    	player.setcandraw(true);
    	}
    }

    public void tablePrintAllStatus() {
        for (int i = 0; i < this.ListOfPlayer.size(); i++) {
            String name = this.ListOfPlayer.get(i).getName();
            double moneyNow = this.ListOfPlayer.get(i).getMoney();
            List<Card> CardInHand = this.ListOfPlayer.get(i).getCardInHand();
            int allPoint = this.ListOfPlayer.get(i).getPoint();
            

            System.out.println("###### Information of "+name+" #######");
            System.out.println("Money Now is : "+moneyNow);
            for(Card card : CardInHand){
                System.out.println("Having Card : "+card.toString());
            }
            System.out.println("All Point is : "+allPoint);

        }
    }
    
    public void tableReset() {
    	this.deck.resetDeck();
    	this.dealer.resetCard();
    	
    	for(int i = 0; i < this.ListOfPlayer.size(); i++){
    		this.ListOfPlayer.get(i).resetPlayer();
    		
    	}
    }
    
}
