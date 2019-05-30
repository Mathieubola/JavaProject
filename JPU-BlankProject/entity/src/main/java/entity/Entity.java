package entity;
import contract.IEntity;

/**
 * 
 * 
 *@see IEntity
 */
public abstract class Entity implements IEntity{
	
	/**
	 * This attribute indicates if an entity is Animated or not 
	 */
	private boolean isAnimated;
	
	/**
	 * This attribute indicates if an entity is Pushable by the player or not
	 */
	private boolean isPushable;
	
	/**
	 * This attribute indicates if the entity is the player or not
	 */
	private boolean isPlayer;
	
	/**
	 * This attribute indicates if the entity can fall or not
	 * 
	 * Please note that if isFalling is true it doesn't mean that the entity is falling at the moment (just that the entity can fall depending on the circumstances
	 */
	private boolean isFalling;
	
	/**
	 * This attribute indicates if the entity is digable by the player
	 */
	private boolean isDigable;
	
	/**
	 * This attribute will store the char value that correspond to the entity
	 * 
	 * @see Diamant
	 * @see monstre
	 * @see Player
	 * @see Portal
	 * @see Rock
	 */
	private char sprite;
	
	
	/**
	 * The constructor of the Entity class
	 * 
	 * @param isAnimated
	 * @see isAnimated
	 * @param isPushable
	 * @see isPushable
	 * @param isPlayer
	 * @see isPlayer
	 * @param isFalling
	 * @see isFalling
	 * @param isDigable
	 * @see sprite
	 * @param sprite
	 */
	public Entity(boolean isAnimated, boolean isPushable, boolean isPlayer, boolean isFalling, boolean isDigable, char sprite) {
		this.isAnimated = isAnimated;
		this.isPushable = isPushable;
		this.isPlayer = isPlayer;
		this.isFalling = isFalling;
		this.isDigable = isDigable;
		this.sprite = sprite;
	}
	
	/**
	 * This method is used to get the char representation of the entity
	 * 
	 * For example if there is a rock to entitys[y][x], you'll have to use entitys[y][x].getSprite() to get the 'O' char
	 */
	public char getSprite() {
		return sprite;
	}
	
	/**
	 * This method is used to know if an entity is animated or not
	 * 
	 * @return true : this entity is animated, false : the entity is not animated
	 */
	public boolean isAnimated() {
		return isAnimated;
	}
	
	/**
	 * This method is used to know if an entity is pushable or not
	 * 
	 * @return true : the entity can be pushed; false : the entity cannot being pushed
	 */
	public boolean isPushable() {
		return isPushable;
	}
	
	/**
	 * This method is used to know if an entity is the player or not
	 * 
	 * @return isPlayer true : the entity is the player; false : the entity is not the player
	 */
	public boolean isPlayer() {
		return isPlayer;
	}
	
	/**
	 * This method is used to know if an entity can fall or not
	 * 
	 * Please be careful !!
	 * This method only indicates if an entity can fall but not now
	 * For example a rock can fall sometime but even if it will not fall at the moment isFalling will be true
	 * 
	 * @return isFalling
	 * 
	 */
	public boolean isFalling() {
		return isFalling;
	}
	
	/**
	 * This method is used to know if an entity is digable
	 * 
	 */
	public boolean isDigable() {
		return isDigable;
	}

	/**
	 * 
	 */
	public int update() {
		return -1;
	}
	
}
