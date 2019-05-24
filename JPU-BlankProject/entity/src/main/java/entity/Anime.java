package entity;

import java.awt.Image;
import java.util.ArrayList;

public class Anime extends Entity {
	
	private ArrayList<Image> sprites = new ArrayList<Image>();
	private double frame = 0.0;
	private double step = 0.1;

	public Anime(boolean isPushable, boolean isPlayer, boolean isFalling, Image sprite) {
		super(true, isPushable, isPlayer, isFalling, sprite);
		this.addSprite(sprite);
	}
	
	public void frameUpdate() {
		frame = frame > sprites.size() ? 0 : frame + step;
		this.setSprite(sprites.get((int) frame)); 
	}
	
	protected void addSprite(Image image) {
		sprites.add(image);
	}
	protected void addSprite(ArrayList<Image> images) {
		sprites.addAll(images);
	}
	protected void clearSprites() {
		sprites.clear();
	}

	public void setFrame(double frame) {
		this.frame = frame;
	}
	public void setStep(double step) {
		this.step = step;
	}

}
