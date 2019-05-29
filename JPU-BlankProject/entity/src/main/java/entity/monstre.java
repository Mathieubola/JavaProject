package entity;

public class monstre extends Anime {
	
	int direction = 0;
	
	public monstre() {
		super(false, false, false, false, '@', 4);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	

}