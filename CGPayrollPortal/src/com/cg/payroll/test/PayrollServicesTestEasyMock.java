/*package com.cg.payroll.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTestEasyMock {

	private static PayrollServices payrollServices;
	private static AssociateDAO mockAssociateDao;
	
	@BeforeClass
	public static void setUpTestEnv() {
		mockAssociateDao = EasyMock.mock(AssociateDAO.class);
		payrollServices = new PayrollServicesImpl(mockAssociateDao);
	}

	@AfterClass
	public static void tearDownTestEnv() {
	mockAssociateDao = null;
	payrollServices = null;
	}

	@Before
	public void setUpTestMockData() {
		Associate associate1 = new Associate(101, 7834, "Akshay", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
		Associate associate2 = new Associate(102, 734, "Akki", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
		Associate associate3 = new Associate(10533, 734, "Ak", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
		
		ArrayList<Associate> associatesList = new ArrayList<>();
		associatesList.add(associate1);
		associatesList.add(associate2);
		
		EasyMock.expect(mockAssociateDao.save(associate3)).andReturn(associate3);
		
		EasyMock.expect(mockAssociateDao.findOne(101)).andReturn(associate1);
		EasyMock.expect(mockAssociateDao.findOne(102)).andReturn(associate2);
		EasyMock.expect(mockAssociateDao.findOne(12143)).andReturn(null);
		EasyMock.expect(mockAssociateDao.findAll()).andReturn(associatesList);
		EasyMock.replay(mockAssociateDao);
	}

	@After
	public void tearDownTestMockData() throws Exception {
		EasyMock.resetToDefault(mockAssociateDao);
	}

	@Test(expected = AssociateDetailsNotfoundException.class)
	public void testGetAssociateDataForInvalidAssociateId() throws  AssociateDetailsNotfoundException {
		payrollServices.getAssociateDetails(12143);
		EasyMock.verify(mockAssociateDao.findOne(12143));
	}
	
	@Test
	public void testGetAssociateDataForValidAssociateId() throws AssociateDetailsNotfoundException {
		Associate expectedAssociate = new Associate(101, 7834, "Akshay", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
		
		Associate actualAssociate = payrollServices.getAssociateDetails(101);
		EasyMock.verify(mockAssociateDao.findOne(101));
		assertEquals(expectedAssociate, actualAssociate);
	}

}
*/