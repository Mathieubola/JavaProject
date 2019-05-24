package entity;

import contract.ControllerOrder;

public class Player extends Anime {
	
	private boolean isAlive = true;
	private ControllerOrder direction;

	public Player() {
		super(false, true, false, 'P', 1);
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public ControllerOrder getDirection() {
		return direction;
	}
	public void setDirection(ControllerOrder direction) {
		this.direction = direction;
	}
	
	
	
}
