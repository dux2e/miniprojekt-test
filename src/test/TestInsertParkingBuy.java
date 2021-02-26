package test;

import databaselayer.*;
import modellayer.*;
import controllayer.*;

import java.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestInsertParkingBuy {
	private ControlPayStation conPayStation;
	private DatabasePBuy DBPBuy;
	private LocalDate currentTime;
	private PBuy thisBuy;
	
	@Before
	public void setUp() throws Exception {
		conPayStation = new ControlPayStation();
		DBPBuy = new DatabasePBuy();
		currentTime = LocalDate.now();
		thisBuy = new PBuy();
		thisBuy.setAssociatedPaystation(conPayStation.getPayStation());
		thisBuy.setBuyTime(currentTime);
		
		
	}

	@After
	public void tearDown() throws Exception {
		DBPBuy.deleteParkingBuy(thisBuy);
	}

	@Test
	public void testInsertParkingBuy() throws DatabaseLayerException {
		int result1 = DBPBuy.insertParkingBuy(thisBuy);
		System.out.println(thisBuy.getId());
		assertEquals(1, result1, 0);
	}

}
