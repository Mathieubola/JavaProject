package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;

public class ViewTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKeyCodeToControllerOrder() {
		final ControllerOrder expected = ControllerOrder.Up;
		final ControllerOrder expected1 = ControllerOrder.Left;
		final ControllerOrder expected2 = ControllerOrder.Down;
		final ControllerOrder expected3 = ControllerOrder.Right;
		final ControllerOrder expected4 = ControllerOrder.Null;
		
		
		assertEquals(expected, View.keyCodeToControllerOrder(90));
		assertEquals(expected1, View.keyCodeToControllerOrder(81));
		assertEquals(expected2, View.keyCodeToControllerOrder(83));
		assertEquals(expected3, View.keyCodeToControllerOrder(68));
		assertEquals(expected4, View.keyCodeToControllerOrder(321));
	}

}
