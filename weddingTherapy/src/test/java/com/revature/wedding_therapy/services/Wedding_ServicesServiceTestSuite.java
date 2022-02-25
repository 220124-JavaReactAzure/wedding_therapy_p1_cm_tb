package com.revature.wedding_therapy.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.wedding_therapy.exceptions.*;
import com.revature.wedding_therapy.dao.Wedding_ServicesDAO;
import com.revature.wedding_therapy.exceptions.Wedding_ServiceNotNamedException;
import com.revature.wedding_therapy.models.Service_Types;
import com.revature.wedding_therapy.models.Wedding_Services;

public class Wedding_ServicesServiceTestSuite {

	Wedding_ServicesService sut;
	
	Wedding_ServicesDAO mockWedding_ServicesDAO;
	
	Wedding_Services validWedding_Services;
	
	@Before
	public void testprep() {
		mockWedding_ServicesDAO = mock(Wedding_ServicesDAO.class);
		sut = new Wedding_ServicesService(mockWedding_ServicesDAO);
		validWedding_Services = new Wedding_Services(1, "serviceName", 5.01, new Service_Types(1, "Service"));
	}
	
	@Test
	public void test_createWedding_Services_returnTrue_returnFalse() throws Wedding_ServiceNotNamedException {
		
		when(mockWedding_ServicesDAO.createNewWedding_Services(validWedding_Services)).thenReturn(true);
		Assert.assertTrue(sut.createWedding_Services(validWedding_Services));
		
		Wedding_Services IdAlreadyExists = new Wedding_Services(4, "serviceName", 5.01, new Service_Types(1, "Service"));
		when(mockWedding_ServicesDAO.createNewWedding_Services(IdAlreadyExists)).thenReturn(false);
		Assert.assertFalse(sut.createWedding_Services(IdAlreadyExists));
		
	}
	
	@Test
	public void test_createWedding_Services_throwsServicesNotNamesException() {
		
		Wedding_Services nullName = new Wedding_Services(4, null, 5.01, new Service_Types(1, "Service"));
		Assert.assertThrows(Wedding_ServiceNotNamedException.class, ()->sut.createWedding_Services(nullName));
		
		Wedding_Services emptyName = new Wedding_Services(4, "  ", 5.01, new Service_Types(1, "Service"));
		Assert.assertThrows(Wedding_ServiceNotNamedException.class, ()->sut.createWedding_Services(emptyName));
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
