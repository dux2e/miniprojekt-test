package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;


import controllayer.*;
import modellayer.*;
import utility.*;

public class TestAddPayment {
	private ControlPayStation conPay;
	private ControlPrice conPrice;
	private ControlReceipt pr;
	private PPayStation PStation;
	private Coin coin;
	private PPrice pPrice;
	private Validation valid;
	//private PReceipt PReceipt;
	
	@Before
	public void setup() throws Exception {
		System.out.println("setup()");
		conPay = new ControlPayStation();
		conPrice = new ControlPrice();
		PStation = conPay.getPayStation();
		pPrice = new PPrice();
		//PReceipt = new PReceipt();
	}
		
	@After
	public void deup() throws Exception {
		conPay.setReady();
		
	}
	
	 @Test
	 public void testAddPaymentCENT() throws IllegalCoinException {
	    System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
	    //Arrange
	    int coinValue = 5;
	    Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
	    Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
	        
	    int expAmount = coinValue;
	        
	    //Act
	    conPay.addPayment(coinValue, coinCurrency, coinType);
	        
	    //Assert
	    assertEquals(expAmount, PStation.getAmount(), 0);
	    }		
		
	 @Test
	 public void testAddPaymentOERE() throws IllegalCoinException {
	    System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
	    //Arrange
	    int coinValue = 50;
	    Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
	    Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
	        
	    double expAmount = Double.valueOf(coinValue) / 7.5;
	        
	    //Act
	    conPay.addPayment(coinValue, coinCurrency, coinType);
	        
	    //Assert
	    assertEquals(expAmount, PStation.getAmount(), 0);
	    }
	 
	 @Test
	 public void testAddPaymentEURO() throws IllegalCoinException {
	    System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
	    //Arrange
	    int coinValue = 1;
	    Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.EURO;
	    Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
	        
	    int expAmount = coinValue * 100;
	        
	    //Act
	    conPay.addPayment(coinValue, coinCurrency, coinType);
	        
	    //Assert
	    assertEquals(expAmount, PStation.getAmount(), 0);
	    }
	 
	 @Test 
	 public void testAddPaymentDKK() throws IllegalCoinException {
	    System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
	    //Arrange
	    int coinValue = 20;
	    Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
	    Currency.ValidCoinType coinType = Currency.ValidCoinType.INTEGER;
	        
	    double expAmount = Double.valueOf(coinValue) / 7.5d * 100;
	        
	    //Act
	    conPay.addPayment(coinValue, coinCurrency, coinType);
	        
	    //Assert
	    assertEquals(expAmount, PStation.getAmount(), 0.000000000001);
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
		conPay.addPayment(coinValue, coinCurrency, coinType);
		
		//Assert
		assertEquals(expAmount, PStation.getAmount(), 0);
	}
	
	//Invalid case should be 0.25 DKK
	//Test case for invalid amount inserted into the machine
	@Test (expected = IllegalCoinException.class)
	public void testAddPaymentDKKOreInvalid() throws IllegalCoinException {
		System.out.println(new Object() {}.getClass().getEnclosingMethod().getName());
		//Arrange
		int coinValue = 25;
		Currency.ValidCoinType coinType = Currency.ValidCoinType.FRACTION;
		Currency.ValidCurrency coinCurrency = Currency.ValidCurrency.DKK;
		
		//Act
		conPay.addPayment(coinValue, coinCurrency, coinType);
		
		//Assert
		//Not needed in this case :):):):):)
	}
}
