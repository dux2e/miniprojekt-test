package test;

import org.junit.*;

import controllayer.*;
import modellayer.*;

public class TestAddPayment {
	private ControlPayStation conPay;
	//private ControlPrice conPrice;
	
	@Before
	public void setup() throws Exception {
		System.out.println("setup()");
		conPay = new ControlPayStation();
		//conPrice = new ControlPrice();
		
	}
}
