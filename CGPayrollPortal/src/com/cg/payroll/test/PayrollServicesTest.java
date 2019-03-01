package com.cg.payroll.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {
//	private static PayrollServices services;
//	
//	@BeforeClass
//	public static void setUpTestEnv() {
//		services = new PayrollServicesImpl();
//	}
//	
//	@Before
//	public void setUpTestData() {
//		Associate associate1 = new Associate(101, 7834, "Akshay", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(150000, 125, 764), new BankDetails(1235, "CITI", "citi001"));
//		Associate associate2 = new Associate(102, 734, "Akki", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
//		
//		PayrollDBUtil.associates.put(associate1.getAssociateId(), associate1);
//		PayrollDBUtil.associates.put(associate2.getAssociateId(), associate2);
//		
//		PayrollDBUtil.ASSOCIATE_ID_COUNTER = 102;
//	}
//	
//	@Test(expected = AssociateDetailsNotfoundException.class)
//	public void testGetAssociateDetailsForInvalidAssociateId() throws AssociateDetailsNotfoundException {
//		services.getAssociateDetails(1234);
//	}
//	
//	@Test
//	public void testGetAssociateDetailsForValidAssociateId() throws AssociateDetailsNotfoundException {
//		Associate exptectedAssociate = new Associate(102, 734, "Akki", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
//		Associate actualAssociate = services.getAssociateDetails(102);
//		Assert.assertEquals(exptectedAssociate, actualAssociate);
//	}
//	
//	@Test
//	public void testAcceptAssociateDetailsForValidData() {
//		int expectedId = 103;
//		int actualId = services.acceptAssociateDetails("akshd", "hjkag", "hhjglahsg@fsdf", "fgfg", "sghasg", "ahgahghag", 456, 356873, 566, 3464, 7836, "citi", "citi001");
//		
//		Assert.assertEquals(expectedId, actualId);
//	}
//	
//	@Test(expected = AssociateDetailsNotfoundException.class)
//	public void testCalculateNetSalaryForInvalidAssociateId() throws AssociateDetailsNotfoundException {
//		services.calculateNetSalary(1234);
//	}
//	
//	@Test
//	public void testCalculateNetSalaryForValidAssociateId() throws AssociateDetailsNotfoundException {
//		int expectedNetSalary = 150000;
//		int actualNetSalary = services.calculateNetSalary(101);
//		Assert.assertEquals(expectedNetSalary, actualNetSalary);
//	}
//	
//	@Test
//	public void testGetAllAssociateDetails() {
//		Associate associate1 = new Associate(101, 7834, "Akshay", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(150000, 125, 764), new BankDetails(1235, "CITI", "citi001"));
//		Associate associate2 = new Associate(102, 734, "Akki", "Kataria", "training", "manager", "7985vsgg0", "akhdsaykjg@ghkj", new Salary(70000, 7528, 2800), new BankDetails(769456957, "CITI", "citi001"));
//		
//		ArrayList<Associate> expectedAssociateList = new ArrayList<Associate>();
//		expectedAssociateList.add(associate1);
//		expectedAssociateList.add(associate2);
//		
//		ArrayList<Associate> actualAssociateList = (ArrayList<Associate>)services.getAllAssociatesDetails();
//		
//		Assert.assertEquals(expectedAssociateList, actualAssociateList);
//	}
//	
//	@After
//	public void tearDownTest() {
//		PayrollDBUtil.associates.clear();
//		PayrollDBUtil.ASSOCIATE_ID_COUNTER = 100;
//	}
//	
//	@AfterClass
//	public static void tearDownTestEnv() {
//		services = null;
//	}
}
