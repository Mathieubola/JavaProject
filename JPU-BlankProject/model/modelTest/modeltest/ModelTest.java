package modeltest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

/** 
 * This is the test class for Model
 *  
 * @see Model
 *  
 */
public class ModelTest {

	/**
	 * Instanciation of a new Model
	 */
	private Model model;
	private int nbMap = 1;

	/** 
	 * This test method is applied before the test methods 
	 *  
	 * @throws Exception 
	 */ 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** 
	 * This test method is applied before the test methods 
	 *  
	 * @throws Exception 
	 */ 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/** 
	 * This test method is applied before the test methods 
	 *  
	 * Setting up a model that we need for the tests 
	 *  
	 * @throws Exception 
	 */ 
	@Before
	public void setUp() throws Exception {
		this.model = new Model();
	}

	/** 
	 * This method is applied after the test methods 
	 *  
	 * @throws Exception 
	 */ 
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * This method is the test for the getMap methode
	 * 
	 * It test if the element of the BDD are in the array
	 * 
	 * @see testGetMap
	 */
	@Test
	public void testGetMap() {
		assertNotNull(model.getMap(nbMap));
	}
}
