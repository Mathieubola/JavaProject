package entity;

public abstract class Falling extends Anime {
	
	public Falling(boolean isPushable, boolean isDigable, char sprite, int maxFrame) {
		super(isPushable, false, true, isDigable, sprite, maxFrame);
	}
	
}
