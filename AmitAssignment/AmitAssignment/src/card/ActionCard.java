package card;

import card.action.Action;
import card.color.Color;

public class ActionCard extends Card {
	
	private Action action;
	
	public ActionCard(Action action, Color color) {
		super(color);
		this.action = action;
	}
	
	public ActionCard() {
		
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public boolean isActionCard() {
		return true;
	}

	@Override
	public String toString() {
		return "ActionCard [action=" + action + "]";
	}
	
	

}
