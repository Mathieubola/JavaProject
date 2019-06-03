package entity;

/**
 * 
 * @see Entity
 */
public abstract class Anime extends Entity {
	
	/**
	 * The number of frame to show
	 */
	private double frame = 0;
	
	/**
	 * The speed between two frames
	 */ 
	private double step = 0.05;
	
	/**
	 * The maximum of frames
	 */
	private int maxFrame;
	
	/**
	 * The constructor of Anime class
	 * 
	 * @param isPushable
	 * @param isPlayer
	 * @param isFalling
	 * @param isDigable
	 * @param sprite
	 * @param maxFrame
	 */
	public Anime(boolean isPushable, boolean isPlayer, boolean isFalling, boolean isDigable, char sprite, int maxFrame) {
		super(true, isPushable, isPlayer, isFalling, isDigable, sprite);
		this.maxFrame = maxFrame;
	}
	
	/**
	 * updating the frame
	 */
	public int update() {
		frame = frame > maxFrame - 0.2 ? 0 : frame + step;
		return (int) frame;
	}
	
	/**
	 * Setter of step
	 * @param step
	 */
	public void setStep(double step) {
		this.step = step;
	}
	
}
