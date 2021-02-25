package test;

import static org.junit.Assert.*;
import org.junit.*;

import controllayer.*;
import modellayer.*;

public class TestAddPayment {
	private ControlPayStation ps;
	
	@Before
	public void setUp() {
		ps = new ControlPayStation();
	}
	
	@After
	public void cleanUp() {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
		ps.setReady();
	}
	
	@Test
	public void testValidateCoind() {
		
	}
	
//	@Test
//	public void testAddPayment() throws IllegalCoinException {
//		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
//		assertEquals(
//				ps.addPayment(5, 
//							Currency.ValidCurrency.DKK, 
//							Currency.ValidCoinType.INTEGER),
//				ps.readDisplay(), 120);
//	}

}
