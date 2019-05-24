package entity;

public class Map extends Entity {
	private int X;
	private String message;
	
	public Map(final int X, final String message) {
		this.setX(X);
		this.setMessage(message);
	}
	
	public Map() {
		this(0, "");
	}
	
	public int getX() {
		return this.X;
	}
	
	public void setX(final int X) {
		this.X = X;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
