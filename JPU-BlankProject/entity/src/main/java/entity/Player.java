package entity;


public class Player extends Anime {
	
	private boolean isAlive = true;

	public Player() {
		super(false, true, false, false, 'P', 3);
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	
	
	
}
