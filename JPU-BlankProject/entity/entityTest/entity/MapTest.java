package entity;

import static org.junit.Assert.*;

import org.junit.*;

import entity.Map;

/**
 * The mapTest class
 * 
 */
public class MapTest {

	/**
	 * Declaration of a map
	 */
	public static Map map;
	
	/**
	 * Instanciation of the map
	 * The has empty name ("") and his dimensions are 0 and 0
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new Map("", 0, 0);
	}

	/**
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	

	/**
	 * The test class for the getName method
	 * "" is the expected name of the map and this method compare it with the result of the getName method
	 */
	@Test
	public void testGetName() {
		  final String expected = "";
	        assertEquals(expected, MapTest.map.getName());
	        System.out.println("Name is a success");
	    }

	/**
	 * The test class for the getHeight method
	 * 0 is the expected height of the map and this method compare it with the result of the getHeight method
	 */
	@Test
	public void testGetHeight() {
		  final int expected = 0;
	        assertEquals(expected, MapTest.map.getHeight());
	        System.out.println("Height is a success");
	    }

	/**
	 * The test class for the getWidth method
	 * 0 is the expected width of the map and this method compare it with the result of the getWidth method
	 */
	@Test
	public void testGetWidth() {
		  final int expected = 0;
	        assertEquals(expected, MapTest.map.getWidth());
	        System.out.println("Width is a success");
	    }

}
