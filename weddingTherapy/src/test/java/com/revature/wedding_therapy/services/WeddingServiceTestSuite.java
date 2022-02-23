package com.revature.wedding_therapy.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.wedding_therapy.exceptions.*;
import com.revature.wedding_therapy.dao.WeddingDAO;
import com.revature.wedding_therapy.exceptions.WeddingNotNamedException;
import com.revature.wedding_therapy.models.Weddings;

public class WeddingServiceTestSuite {

	WeddingService sut;
	
	WeddingDAO mockWeddingDAO;
	
	@Before
	public void testPrep() {
		mockWeddingDAO = mock(WeddingDAO.class);
		sut = new WeddingService(mockWeddingDAO);
	}
	
	
	@Test
	public void test_createNewWeddings() throws WeddingNotNamedException {
		
		Weddings validWedding = new Weddings(12345, "TestWedding", "jan 1, 2023", 5555.55, 0, 0, 0, 0, 0);
		when( mockWeddingDAO.createNewWedding(validWedding) ).thenReturn(true);
		Assert.assertTrue(sut.createNewWedding(validWedding));
		
		try {
		Weddings nullName = new Weddings(12345, null, "jan 1, 2023", 5555.55, 0, 0, 0, 0, 0);
		sut.createNewWedding(nullName);
		}catch(WeddingNotNamedException e) {
			Assert.assertEquals(e, Exception.class);
		
		Weddings emptyName = new Weddings(12345, "", "jan 1, 2023", 5555.55, 0, 0, 0, 0, 0);
		
		Weddings nullDate = new Weddings(12345, "TestWedding", null, 5555.55, 0, 0, 0, 0, 0);
		
		Weddings emptyDate = new Weddings(12345, "TestWedding", "", 5555.55, 0, 0, 0, 0, 0);
		
		Weddings inValidbudget = new Weddings(12345, "TestWedding", "jan 1, 2023", 0.0, 0, 0, 0, 0, 0);
		
		
		
		
	}
	
	
	@Test
	public void test_getWedding() {
		
		//Arrange
		
		//Act
				
		//Assert
	}
}
