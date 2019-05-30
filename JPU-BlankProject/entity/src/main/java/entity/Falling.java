package entity;

/**
 * 
 * 
 * @see Anime
 */
public abstract class Falling extends Anime {
	
	/**
	 * This attribute is used to know if rock can kill the player
	 * 
	 * In other words, killing will be true when the rock has momentum
	 */
	boolean killing = false;
	
	/**
	 * The constructor of Falling class
	 * 
	 * @param isPushable
	 * @param isDigable
	 * @param sprite
	 * @param maxFrame
	 */
	public Falling(boolean isPushable, boolean isDigable, char sprite, int maxFrame) {
		super(isPushable, false, true, isDigable, sprite, maxFrame);
	}

	/**
	 * The getter of killing
	 * 
	 * @return killing
	 */
	public boolean getKilling() {
		return killing;
	}

	/**
	 * The setter of killing
	 * 
	 * @param killing
	 */
	public void setKilling(boolean killing) {
		this.killing = killing;
	}
	
	
	
}
