package entity;

public class Entity {
	
	private boolean isAnimated;
	private boolean isPushable;
	private boolean isPlayer;
	private boolean isFalling;
	private char sprite;
	
	public Entity(boolean isAnimated, boolean isPushable, boolean isPlayer, boolean isFalling, char sprite) {
		this.isAnimated = isAnimated;
		this.isPushable = isPushable;
		this.isPlayer = isPlayer;
		this.isFalling = isFalling;
		this.sprite = sprite;
	}

	public char getSprite() {
		return sprite;
	}
	public boolean isAnimated() {
		return isAnimated;
	}
	public boolean isPushable() {
		return isPushable;
	}
	public boolean isPlayer() {
		return isPlayer;
	}
	public boolean isFalling() {
		return isFalling;
	}
	public int update() {
		return -1;
	}
	
}
