package card;

import card.color.Color;

public class ColoredCard extends Card{
	private Integer value;
	
	public ColoredCard(Integer value, Color color) {
		super(color);
		this.value = value;
	}
	
	public ColoredCard() {
		
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public boolean isActionCard() {
		return false;
	}

	@Override
	public String toString() {
		return "ColoredCard [value=" + value +" "+ "colour="+super.getColor()+"]";
	}
	
	
}
