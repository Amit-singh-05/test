package player;

import java.util.ArrayList;
import java.util.List;

import card.Card;

public class Player {
	private Integer id;
	private String name;
	private List<Card> hand;

    public Player(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", hand=" + hand + "]";
	}
    
    
}
