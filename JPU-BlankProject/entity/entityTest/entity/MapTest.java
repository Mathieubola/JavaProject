package entity;

import static org.junit.Assert.*;

import org.junit.*;

import entity.Map;

public class MapTest {

	public static Map map;

	@Before
	public void setUp() throws Exception {
		map = new Map("", 0, 0);
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testGetName() {
		  final String expected = "";
	        assertEquals(expected, MapTest.map.getName());
	        System.out.println("Name is a success");
	    }

	@Test
	public void testGetHeight() {
		  final int expected = 0;
	        assertEquals(expected, MapTest.map.getHeight());
	        System.out.println("Height is a success");
	    }

	@Test
	public void testGetWidth() {
		  final int expected = 0;
	        assertEquals(expected, MapTest.map.getWidth());
	        System.out.println("Width is a success");
	    }

}
