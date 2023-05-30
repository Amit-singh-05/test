package card;

import card.color.Color;

public abstract class Card{
	private Color color;
	
	
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(Color color) {
		this.color = color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public abstract boolean isActionCard();

	@Override
	public String toString() {
		return "Card [color=" + color + "]";
	}
	
	
}