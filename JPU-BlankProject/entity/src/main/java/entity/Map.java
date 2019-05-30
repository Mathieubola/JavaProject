package entity;

/**
 * 
 * 
 */
public class Map {

	/**
	 * The name of the map
	 */
	private String name;
	
	/**
	 * The height of the map
	 */
	private int height;
	
	/**
	 * The width of the map
	 */
	private int width;
	
	/**
	 * Declaring the entity array 
	 * 
	 * @see Entity
	 */
	public Entity[][] element;
	
	/**
	 * The constructor of the Map class
	 * @param name
	 * @param height
	 * @param width
	 */
	public Map(final String name, final int height, final int width) {
		this.setName(name);
		this.setHeight(height);
		this.setWidth(width);
		element = new Entity[height][width];
		
	}
	
	/**
	 * Another constructor of the Map class
	 */
	public Map() {
		this("", 0, 0);
	}

	/**
	 * The getter of name
	 * 
	 * @see #name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * The setter of name
	 * 
	 * @see #name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * The getter of height
	 * 
	 * @see #height
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * The setter of height
	 * 
	 * @see #height
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * The getter of width
	 * 
	 * @see #width
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * The setter of width
	 * 
	 * @see #width
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}
