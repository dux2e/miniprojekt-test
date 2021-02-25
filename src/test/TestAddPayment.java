package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;


import controllayer.*;
import modellayer.*;

public class TestAddPayment {
	private ControlPayStation conPay;
	private ControlPrice conPrice;
	private ControlReceipt pr;
	private PPayStation PStation;
	private Coin coin;
//	private PPrice currentPrice;
//	private PReceipt PReceipt;
	
	@Before
	public void setup() throws Exception {
		System.out.println("setup()");
		conPay = new ControlPayStation();
		conPrice = new ControlPrice();
		PStation = new PPayStation(1, "test-123");
		//PReceipt = new PReceipt();
		
	}
	
//	@Test
//	public void addPayment() throws IllegalCoinException {
//		int addPaymentCoin = 10;
////		coin = new Coin(addPaymentCoin, coinCurrency, coinType);
//		conPay.addPayment(addPaymentCoin, Currency.ValidCurrency.DKK, Currency.ValidCoinType.INTEGER);
//		assertEquals(dd);
//		assertTrue(dd);
////		int expectedR = PStation.addAmount(coin, currentPrice); 
//	}
//	
	@Test
	public void testValidCoin() throws IllegalCoinException {
		int paymentCoin = 20;
		conPay.addPayment(paymentCoin, Currency.ValidCurrency.NOK, Currency.ValidCoinType.INTEGER);
		coin = new Coin(paymentCoin, Currency.ValidCurrency.NOK, Currency.ValidCoinType.INTEGER)
		assertEquals("Should display Invalid coin: ", coin, conPay.readDisplay());
	}
}
