package entity;

public abstract class Anime extends Entity {
	
	private double frame = 0;
	private double step = 0.05;
	private int maxFrame;
	
	public Anime(boolean isPushable, boolean isPlayer, boolean isFalling, boolean isDigable, char sprite, int maxFrame) {
		super(true, isPushable, isPlayer, isFalling, isDigable, sprite);
		this.maxFrame = maxFrame;
	}
	
	public int update() {
		frame = frame > maxFrame - 0.1 ? 0 : frame + step;
		return (int) frame;
	}
	
	public void setStep(double step) {
		this.step = step;
	}
	
}
