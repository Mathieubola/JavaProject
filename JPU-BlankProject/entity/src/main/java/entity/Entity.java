package entity;

import java.awt.Image;

public class Entity {
	
	private boolean isMovable;
	private boolean isAnimated;
	private boolean isPushable;
	private boolean isPlayer;
	private Image sprite;
	
	public Entity(boolean isMovable, boolean isAnimated, boolean isPushable, boolean isPlayer, Image sprite) {
		this.isMovable = isMovable;
		this.isAnimated = isAnimated;
		this.isPushable = isPushable;
		this.isPlayer = isPlayer;
		this.sprite = sprite;
	}

	public Image getSprite() {
		return sprite;
	}
	protected void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	public boolean isMovable() {
		return isMovable;
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
	
}
