
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

	List<Card> ListOfCard = new ArrayList<Card>();

	public Deck() {
		this.resetDeck();
	}

	public void addCard(Card card) {
		this.ListOfCard.add(card);
	}

	public Card drawCard() {
		Card returnCard = getThisList().remove(getThisList().size() - 1);
		// getThisList().remove(getThisList().size()-1);
		return returnCard;
	}

	public void resetDeck() {
		// Deck deck = new Deck();
		// this.ListOfCard = deck.getThisList();
		this.ListOfCard.clear();
		String[] suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

		for (int j = 0; j < suits.length; j++) {

			for (int i = 2; i <= 10; i++) {
				Card card = new Card(i + "", suits[j]);
				this.addCard(card);
			}

			// A J Q K
			this.addCard(new Card("A", suits[j]));
			this.addCard(new Card("J", suits[j]));
			this.addCard(new Card("Q", suits[j]));
			this.addCard(new Card("K", suits[j]));
		}

	}

	private List<Card> getThisList() {
		return this.ListOfCard;
	}

	public void SwarpCard() {
		List<Card> cardsTemp = getThisList();
		List<Card> returnCards = new ArrayList<>();

		while (cardsTemp.size() > 0) {
			Random randomCard = new Random();
			int randomCardIndex = randomCard.nextInt(cardsTemp.size());
			returnCards.add(cardsTemp.get(randomCardIndex));
			cardsTemp.remove(randomCardIndex);
		}
		this.ListOfCard = returnCards;
	}

	public void printAllCard() {
		System.out.println("All Card In Deck Is : " + this.ListOfCard.size());
		for (int i = 0; i < ListOfCard.size(); i++) {
			System.out.println(this.ListOfCard.get(i).toString());
		}
	}

}