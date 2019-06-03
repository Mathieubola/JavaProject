package controller;

import static org.junit.Assert.*;

import java.util.Random;

import contract.IView;
import contract.IControllerother;
import contract.IControllerplayer;
import contract.IEntity;
import contract.IModel;
import org.junit.*;
import entity.*;


public class ControllerotherTest {
	IModel model = null;
	IView view = null;
	IControllerother controllero;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		controllero = new Controllerother(view, model);
	}

	@After
	public void tearDown() throws Exception {
	}

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
