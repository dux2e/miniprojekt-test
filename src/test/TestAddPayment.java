package test;

import static org.junit.Assert.*;
import org.junit.*;

import controllayer.*;
import modellayer.*;

public class TestAddPayment {
	private ControlPayStation cps;
	private PPayStation pps;
	
	@Before
	public void setUp() {
		cps = new ControlPayStation();
		pps = cps.getPayStation();
	}
	
	@After
	public void cleanUp() {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
		cps.setReady();
	}
	
	
	//Check if 5 cent inserted to macchine
	//5 cent is added to paystation via getAmount() :)
	//Valid case should be (in this specific case) 0.05 EURO
	@Test
	public void testAddPaymentEUROCentValid() throws IllegalCoinException {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
		//Arrange
		int coinValue = 5;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		int expAmount = coinValue;
		
		//Act
		cps.addPayment(coinValue, coinCurrency, coinType);
		
		//Assert
		assertEquals(expAmount, pps.getAmount(), 5);
	}
	
	//Test case for invalid amount inserted into the machine
	//Invalid case should be 0.25 DKK
	@Test (expected = IllegalCoinException.class)
	public void testAddPaymentDKKOreInvalid() throws IllegalCoinException {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
		//Arrange
		int coinValue = 25;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		
		//Act
		cps.addPayment(coinValue, coinCurrency, coinType);
		
		//Assert
		//Not needed in this case :):):):):)
	}
}
