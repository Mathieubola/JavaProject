package entity;

public abstract class Falling extends Anime {
	
	boolean killing = false;
	
	public Falling(boolean isPushable, boolean isDigable, char sprite, int maxFrame) {
		super(isPushable, false, true, isDigable, sprite, maxFrame);
	}

	public boolean getKilling() {
		return killing;
	}

	public void setKilling(boolean killing) {
		this.killing = killing;
	}
	
	
	
}
