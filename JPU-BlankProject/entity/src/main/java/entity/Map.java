package entity;


public class Map extends Entity {

	private String name;
	private int length;
	private int width;
	private Entitys element[][];
	
	public Map(final String name, final int length, final int width) {
		this.setName(name);
		this.setLength(length);
		this.setWidth(width);
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

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
