package controllertest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import contract.IControllerplayer;
import contract.IEntity;
import contract.IModel;
import contract.IView;
import controller.Controllerplayer;
import entity.Destructible;
import entity.Entity;
import entity.Player;

public class ControllerplayerTest {
	IView view = null;
	IModel model = null;
	IControllerplayer controllerp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		controllerp = new Controllerplayer(view, model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPlayerPosition() {
		final int expected = 1;
		final int expected2 = 1;		
		IEntity[][] map = new Entity[3][3];
		map[1][1] = new Player();
		assertEquals(expected, controllerp.getPlayerPosition(map)[0]);
		assertEquals(expected2, controllerp.getPlayerPosition(map)[1]);
	}

	@Test
	public void testOrderPerform() {
		
		final char expected = '_';
		
		IEntity[][] map1 = new Entity[2][2];
		
		map1[0][0] = new Destructible();
		map1[0][1] = new Destructible();
		map1[1][0] = new Player();
		map1[1][1] = new Destructible();
		//controllerp.orderPerform(ControllerOrder.Right, map1);
		assertEquals(expected, map1[1][1].getSprite());
	}
}
