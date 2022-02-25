package com.revature.wedding_therapy.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.wedding_therapy.exceptions.*;
import com.revature.wedding_therapy.dao.WeddingDAO;
import com.revature.wedding_therapy.models.Service_Types;
import com.revature.wedding_therapy.models.Wedding_Services;
import com.revature.wedding_therapy.models.Weddings;

public class WeddingServiceTestSuite {

	WeddingService sut;
	
	WeddingDAO mockWeddingDAO;
	
	Weddings validWedding;
	
	@Before
	public void testPrep() {
		mockWeddingDAO = mock(WeddingDAO.class);
		sut = new WeddingService(mockWeddingDAO);
		validWedding = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")));
	}
	
	@Test
	public void test_validWeddingServices_return_true() {
		
		Assert.assertTrue(sut.validWeddingServices(validWedding));
		Weddings emptyWedding = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "Empty")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "Empty")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "Empty")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "Empty")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "Empty")));
		Assert.assertTrue(sut.validWeddingServices(emptyWedding));
	}
	
	public void test_validWeddingServices_return_false() {
		Weddings rongcaterers = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")));
		Assert.assertFalse(sut.validWeddingServices(rongcaterers));
		Weddings rongflorists = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")));
		Assert.assertFalse(sut.validWeddingServices(rongflorists));
		Weddings rongmusician = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")));
		Assert.assertFalse(sut.validWeddingServices(rongcaterers));
		Weddings rongphotographers = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "venues")));
		Assert.assertFalse(sut.validWeddingServices(rongcaterers));
		Weddings venues = new Weddings(0, "Empty", "Empty", 100.01, new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "florists")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "musician")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "photographers")), 
				new Wedding_Services(0, "Empty", 0, new Service_Types(0, "caterers")));
		Assert.assertFalse(sut.validWeddingServices(rongcaterers));
	}
	
	@Test
	public void test_validId() {
		Assert.assertTrue(sut.validId(5));
		Assert.assertFalse(sut.validId(-1));
		Assert.assertFalse(sut.validId(100000));
	}
	
	
	@Test                        
	public void test_createNewWeddings_Return_True_WeddingNotNamedException() throws WeddingNotNamedException {

		when( mockWeddingDAO.createNewWedding(validWedding) ).thenReturn(true);
		
		// Return true given valid wedding
		Assert.assertTrue(sut.createNewWedding(validWedding));
	}
	
	@Test  // Return weddingNotNamedException
	public void test_createNewWeddings_return_WeddingNotNamedException() {
		
		Weddings nullName = new Weddings(12345, null, "jan 1, 2023", 5555.55, new Wedding_Services(), 
				new Wedding_Services(), new Wedding_Services(), new Wedding_Services(), new Wedding_Services());
		
		Assert.assertThrows(WeddingNotNamedException.class, () -> sut.createNewWedding(nullName));
		
		Weddings emptyName = new Weddings(12345, "", "jan 1, 2023", 5555.55, new Wedding_Services(), 
				new Wedding_Services(), new Wedding_Services(), new Wedding_Services(), new Wedding_Services());
		
		Assert.assertThrows(WeddingNotNamedException.class, () -> sut.createNewWedding(emptyName));
		
		Weddings nullDate = new Weddings(12345, "TestWedding", null, 5555.55, new Wedding_Services(), 
				new Wedding_Services(), new Wedding_Services(), new Wedding_Services(), new Wedding_Services());
		
		Assert.assertThrows(WeddingNotNamedException.class, () -> sut.createNewWedding(nullDate));
		
		Weddings emptyDate = new Weddings(12345, "TestWedding", "", 5555.55, new Wedding_Services(), 
				new Wedding_Services(), new Wedding_Services(), new Wedding_Services(), new Wedding_Services());
		Assert.assertThrows(WeddingNotNamedException.class, () -> sut.createNewWedding(emptyDate));
		
		 Weddings inValidbudget = new Weddings(12345, "TestWedding", "jan 1, 2023", -1.3, new Wedding_Services(), 
				new Wedding_Services(), new Wedding_Services(), new Wedding_Services(), new Wedding_Services());
		 
		Assert.assertThrows(WeddingNotNamedException.class, () -> sut.createNewWedding(inValidbudget));
	}
	
	
	@Test
	public void test_getWedding_return_null_and_wedding() {
		
		int valid_ID = 0;
		when (mockWeddingDAO.findWeddingByID(valid_ID)).thenReturn(validWedding);
		Assert.assertEquals(validWedding, sut.getWedding(valid_ID));
		
		int ID_doesNotExist = 1;
		when (mockWeddingDAO.findWeddingByID(ID_doesNotExist)).thenReturn(null);
		Assert.assertNull(sut.getWedding(ID_doesNotExist));
	}
	
	@Test
	public void test_updateWedding_return_false_and_true() {
		
		when(mockWeddingDAO.updateWedding(validWedding)).thenReturn(true);
		Assert.assertTrue(sut.updateWedding(validWedding));
		
		Weddings wedIdNotExist = new Weddings();
		when(mockWeddingDAO.updateWedding(wedIdNotExist)).thenReturn(false);
		Assert.assertFalse(sut.updateWedding(wedIdNotExist));
	}
	
	@Test
	public void test_deleteWedding_return_true_false() {
		int validID = 0;
		when(mockWeddingDAO.deleteWedding(validID)).thenReturn(true);
		Assert.assertTrue(sut.deleteWedding(validID));
		
		int IdDoesNotExist = 666;
		when(mockWeddingDAO.deleteWedding(IdDoesNotExist)).thenReturn(false);
		Assert.assertFalse(sut.deleteWedding(IdDoesNotExist));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
