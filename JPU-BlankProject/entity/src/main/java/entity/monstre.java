package entity;

/**
 * The class of the monsters
 * 
 * The logic of the monstrer's movement is to follow the left wall (like in the original game)
 * 
 * @see Anime
 */
public class monstre extends Anime {
	
	
	/**
	 * This attribute is uised to make the enemy "look" in one direction :
	 * - 0 : at the top
	 * - 1 : at the right
	 * - 2 : at the bottom
	 * - 3 : at the left
	 * 
	 * The direction is used to decide where the monstrer should go in ich case because he need to follow the left wall
	 * 
	 * @see moveEnemy
	 */
	int direction = 0;
	
	/**
	 * The contructor of the monster Class
	 */
	public monstre() {
		super(false, false, false, false, '@', 4);
	}

	/**
	 * This method is used to get the direction of the monster
	 * 
	 * @return The direction (0, 1, 2 or 3)
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * This method is used to set the direction attribute when the monster take another direction depending on the case
	 * 
	 * @see moveEnemy
	 * 
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	

}