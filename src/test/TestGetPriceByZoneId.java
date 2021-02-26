package test;

import controllayer.*;
import databaselayer.*;
import modellayer.PPrice;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestGetPriceByZoneId {
	private ControlPrice conPrice;
	private DatabasePPrice DBPPrice;
	
	@Before
	public void setUp() throws Exception {
		conPrice = new ControlPrice();
		DBPPrice = new DatabasePPrice();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getPriceByZoneId_Zone1() throws DatabaseLayerException {
		int thePriceInCent = DBPPrice.getPriceByZoneId(1).getParkingPrice();
		int expPriceInCent = 35;
		assertEquals(expPriceInCent, thePriceInCent, 0);
	}
	
	@Test
	public void getPriceByZoneId_Zone2() throws DatabaseLayerException {
		int thePriceInCent = DBPPrice.getPriceByZoneId(2).getParkingPrice();
		int expPriceInCent = 25;
		assertEquals(expPriceInCent, thePriceInCent, 0);
	}
	
	@Test
	public void getPriceByZoneId_Zone3() throws DatabaseLayerException {
		int thePriceInCent = DBPPrice.getPriceByZoneId(3).getParkingPrice();
		int expPriceInCent = 15;
		assertEquals(expPriceInCent, thePriceInCent, 0);
	}
	
	@Test (expected = Exception.class)
	public void getPriceByZoneId_Zone4() throws DatabaseLayerException {
		DBPPrice.getPriceByZoneId(4);
	}

}
