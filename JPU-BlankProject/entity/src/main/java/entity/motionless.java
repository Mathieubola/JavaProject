package entity;

/**
 * 
 * @see Entity
 */
public abstract class motionless extends Entity {

	/**
	 * The constructor of motionless class
	 * 
	 * @param isDigable is a boolean to indicate if an entity is digable or not
	 * @param sprite is a char to indicate what type on entity it is
	 */
	public motionless(boolean isDigable, char sprite) {
		super(false, false, false, false, isDigable, sprite);
	}
	
}
