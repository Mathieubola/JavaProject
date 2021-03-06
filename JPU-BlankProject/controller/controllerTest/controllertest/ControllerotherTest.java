package controllertest;

import static org.junit.Assert.*;

import java.util.Random;

import contract.IView;
import controller.Controllerother;
import entity.Destructible;
import entity.Entity;
import entity.Indestructible;
import entity.Player;
import entity.Rock;
import entity.monstre;
import contract.IControllerother;
import contract.IEntity;
import contract.IModel;
import org.junit.*;

/** 
 * This is the test class for Controllerother 
 *  
 * @see Controllerother 
 *  
 */ 
public class ControllerotherTest {
	
	/** 
	 * creater a controllerother object 
	 */ 
	IModel model = null;
	IView view = null;
	IControllerother controllero;
	
	/** 
	 * This test method is applied before the test methods 
	 *  
	 * @throws Exception 
	 */ 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** 
	 * This method is applied after the test methods 
	 *  
	 * @throws Exception 
	 */ 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/** 
	 * This test method is applied before the test methods 
	 *  
	 * Setting up a controllerother that we need for the tests 
	 *  
	 * @throws Exception 
	 */ 
	@Before
	public void setUp() throws Exception {

		controllero = new Controllerother(view, model);
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
	 * This method is the test for the falling objects the controllerother Class 
	 *  
	 * It create a test map, call the method that is used to make the diamonds and rocks falling and finnaly checks if they fell down well 
	 *  
	 * @see moveFallingObject 
	 */ 
	@Test
	public void testMoveFallingObject() {
		IEntity[][] map1 = new Entity[3][3];
		final char expected = '_';
		
        map1[0][0] = new Destructible();
        map1[0][1] = new Destructible();
        map1[0][2] = new Destructible();
        map1[1][0] = new Destructible();
        map1[1][2] = new Destructible();
        map1[2][0] = new Destructible();
        map1[2][2] = new Destructible();
        controllero.moveFallingObject(map1);
        assertEquals(expected, map1[0][1].getSprite());
	}

	/** 
	 * This is the method to test the movement of a monster depending on the possibility 
	 *  
	 * It create a test map and fill it randomly. 
	 * Then it place a monster in this map and call the method that make the monsters moving. 
	 * Finaly it checks if the monster is in the expected position 
	 *  
	 * @see monstre 
	 * @see moveMonster 
	 */ 
	@Test
	public void testMoveMonster() {
		final char expected = '@';
		
		IEntity[][] map = new Entity[60][60];
        Random rand = new Random();
        double alea;
        for (int i = 0; i < 60; i++) {
            for (int j = 0; j < 60; j++) {
                alea = rand.nextDouble();
                if (i == 0 || i == 59 || j == 0 || j == 59) {
                    map[i][j] = new Indestructible();
                } else if (alea < 0.8) {
                    map[i][j] = new Destructible();
                } else if (alea < 0.9) {
                    map[i][j] = new Player();
                } else {
                    map[i][j] = new Rock();
                }
                //System.out.println("ligne : " + i + " colonne : " + j + " Signe : " + map[i][j].getSprite());
            }
        }
        map[31][31] = new monstre();
        controllero.moveMonster(map);
        assertEquals(expected, map[31][31].getSprite());

	}

}
