package modeltest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class ModelTest {

	private Model model;
	private int nbMap = 1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMap() {
		assertNotNull(model.getMap(nbMap));
	}
}
