package entity;

/**
 * 
 * @see Anime
 */
public class Player extends Anime {
	
	/**
	 * This attribute indicates if the player is alive or not
	 * 
	 */
	private boolean isAlive = true;

	/**
	 * The constructor of the player class
	 */
	public Player() {
		super(false, true, false, false, 'P', 3);
	}
	
	/**
	 * getter of isAlive
	 * @return
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * setter of isAlive
	 * 
	 * @param isAlive
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	
	
	
}
