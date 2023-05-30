package card.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import card.ActionCard;
import card.Card;
import card.ColoredCard;
import card.action.Action;
import card.color.Color;
import player.Player;

public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		initialiseDeck();
		
	}
	
	public Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards =cards;
	}
	
	public List<Card> getCards(){
		return this.cards;
	}
	
	private void initialiseDeck() {
		 cards = new ArrayList<>();
	        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
	        
	        for (Color color : colors) {
	            for (int i=1;i<=9;i++) {
	                cards.add(new ColoredCard(i,color));
	                cards.add(new ColoredCard(i,color));
	            }
	            cards.add(new ColoredCard(0,color));
	            cards.add(new ActionCard(Action.DRAW_TWO,color));
	            cards.add(new ActionCard(Action.DRAW_TWO,color));
	            cards.add(new ActionCard(Action.REVERSE,color));
	            cards.add(new ActionCard(Action.REVERSE,color));
	            cards.add(new ActionCard(Action.SKIP,color));
	            cards.add(new ActionCard(Action.SKIP,color));
	        }

            cards.add(new ActionCard(Action.WILD,null));
            cards.add(new ActionCard(Action.WILD,null));
            cards.add(new ActionCard(Action.WILD,null));
            cards.add(new ActionCard(Action.WILD,null));
            cards.add(new ActionCard(Action.DRAW_FOUR,null));          
            cards.add(new ActionCard(Action.DRAW_FOUR,null));     
            cards.add(new ActionCard(Action.DRAW_FOUR,null));
            cards.add(new ActionCard(Action.DRAW_FOUR,null));
	        
	        Collections.shuffle(cards);
	}
	
	public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void dealCards(List<Player> players, int numCards) {
        for (int i = 0; i < numCards; i++) {
            for (Player player : players) {
                Card card = drawCard();
                if (card != null) {
                    player.addCard(card);
                }
            }
        }
    }

	
	
	
	
	
}
