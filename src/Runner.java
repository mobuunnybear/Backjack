


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

    	Card c1 = Card.A_SPADE;
    	Card c2 = Card.A_SPADE;
    	
    	if(c1 == c2) {
    		System.out.println("YES");
    	}
    	else {
    		System.out.println("NO!");
    	}

        System.out.println("###### START PROCESS ######");

        System.out.println("###### STEP[0] Generate & Setting ,,, All Envorment... ######");
        Scanner scanner = new Scanner(System.in);
        Table table = new Table();

        
        table.addstartplayer();
        

       // table.isplayagain = true;
        while(table.getListOfPlayer().size()>0) {
        	
        
        
        
        System.out.println("###### STEP[2] Check ######");
      
        System.out.println();

        table.getDeck().SwarpCard();
        table.startBlackjack();

        
        table.tableReset();
    }
        
    }
}