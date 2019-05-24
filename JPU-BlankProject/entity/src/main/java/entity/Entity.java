package entity;

import java.awt.Image;

public class Entity {
	
	private boolean isAnimated;
	private boolean isPushable;
	private boolean isPlayer;
	private boolean isFalling;
	private Image sprite;
	
	public Entity(boolean isAnimated, boolean isPushable, boolean isPlayer, boolean isFalling, Image sprite) {
		this.isAnimated = isAnimated;
		this.isPushable = isPushable;
		this.isPlayer = isPlayer;
		this.isFalling = isFalling;
		this.sprite = sprite;
	}

	public Image getSprite() {
		return sprite;
	}
	protected void setSprite(Image sprite) {
		this.sprite = sprite;
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
	
}
