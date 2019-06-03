package controller;

import static org.junit.Assert.*;

import java.util.Random;

import contract.IView;
import contract.IModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import entity.*;


public class ControllerotherTest {
	private Controllerother controllero;
	private IModel model;
	private IView view;

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
		Entity[][] map1 = new Entity[3][3];
		final char expected = 'O';
		
        map1[0][0] = new Destructible();
        map1[0][1] = new Rock();
        map1[0][2] = new Destructible();
        map1[1][0] = new Destructible();
        map1[1][2] = new Destructible();
        map1[2][0] = new Destructible();
        map1[2][2] = new Destructible();
        //controllero.moveFallingObject(map1);
        System.out.println(map1[0][1].getSprite());
        assertEquals(expected, map1[0][1].getSprite());
        
        Entity[][] map2 = new Entity[3][3];
		final char expected2 = 'T';
		
		map2[0][0] = new Destructible();
		map2[0][1] = new Destructible();
		map2[0][2] = new Rock();
		map2[1][0] = new Destructible();
		map2[1][2] = new Destructible();
		map2[2][0] = new Destructible();
		map2[2][1] = new monstre();
		map2[2][2] = new Destructible();
        //controllero.moveFallingObject(map1);
		map2[2][1] = new Diamond();
        System.out.println(map2[2][1].getSprite());
        assertEquals(expected2, map2[2][1].getSprite());
        
        Entity[][] map3 = new Entity[3][3];
		final char expected3 = 'O';
		
		map3[0][0] = new Destructible();
		map3[0][1] = new Rock();
		map3[0][2] = new Destructible();
		map3[1][0] = new Destructible();
		map3[1][2] = new Destructible();
		map3[2][0] = new Destructible();
		map3[2][2] = new Destructible();
        //controllero.moveFallingObject(map1);
        System.out.println(map3[0][1].getSprite());
        assertEquals(expected3, map3[0][1].getSprite());
        
	}

	@Test
	public void testMoveMonster() {
		final char expected = '@';
		
		Entity[][] map = new Entity[60][60];
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
