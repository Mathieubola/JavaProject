package entity;

public class Map {

	private String name;
	private int height;
	private int width;
	public Entity[][] element;
	
	public Map(final String name, final int height, final int width) {
		this.setName(name);
		this.setHeight(height);
		this.setWidth(width);
		element = new Entity[height][width];
		
	}
	
	
	public Map() {
		this("", 0, 0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
