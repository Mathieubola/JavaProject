package entity;

public class Anime extends Entity {
	
	private double frame = 0;
	private double step = 0.1;
	private int maxFrame;
	
	public Anime(boolean isPushable, boolean isPlayer, boolean isFalling, char sprite, int maxFrame) {
		super(true, isPushable, isPlayer, isFalling, sprite);
		this.maxFrame = maxFrame;
	}
	
	public int update() {
		return (int) ( frame > maxFrame ? 0 : frame + step );
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
}
