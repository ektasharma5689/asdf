package com.cg.payroll.services;

import java.util.List;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.beans.Salary;
import com.cg.payroll.daoservices.AssociateDAO;
import com.cg.payroll.daoservices.AssociateDAOImpl;
import com.cg.payroll.exceptions.AssociateDetailsNotfoundException;

public class PayrollServicesImpl implements PayrollServices {

	private AssociateDAO associateDao = new AssociateDAOImpl();

	@Override
	public int acceptAssociateDetails(Associate associate) {
		
		associate= associateDao.save(associate);
		return associate.getAssociateId();
	}


	@Override
	public Associate getAssociateDetails(int associateId) throws AssociateDetailsNotfoundException {
		Associate associate = associateDao.findOne(associateId);
		if(associate == null)
			throw new AssociateDetailsNotfoundException("Associate details not found for ID:" + associateId);
		return associate;
	}

	@Override
	public List<Associate> getAllAssociatesDetails() {
		return associateDao.findAll();
	}

	@Override
	public double calculateNetSalary(int associateId) throws AssociateDetailsNotfoundException  {
		Associate associate=getAssociateDetails(associateId);
		Salary salary = salaryDetails(associate);
		double taxableAmount =(salary.getGrossSalary()-associate.getYearlyInvestmentUnder80C());
		salary.setMonthlyTax(calculateTax(associate, taxableAmount));
		double netSalary =  (taxableAmount - (salary.getMonthlyTax() + associate.getSalary().getEpf() + associate.getSalary().getCompanyPf() + associate.getYearlyInvestmentUnder80C()));
		associate.getSalary().setNetSalary(netSalary);
		associate.setSalary(salaryDetails(associate));
		associateDao.update(associate);
		return netSalary;
	}

	public double calculateTax(Associate associate, double taxableAmount) {
		double taxAmount =0;
		while(taxableAmount>250000) {
			if(taxableAmount>250000&&taxableAmount<=500000) {
				taxableAmount = taxableAmount - 250000;
				taxAmount = taxAmount+taxableAmount/10;		
			}
			if(taxableAmount>500000&&taxableAmount<=1000000) {
				taxableAmount=taxableAmount-500000;
				taxAmount =taxAmount+taxableAmount/20;
			}
			if(taxableAmount>1000000) {
				taxableAmount = taxableAmount-1000000;
				taxAmount=taxAmount+taxableAmount/30;
			}
		}
		System.out.println("Monthly tax: " + taxAmount);
		return taxAmount;
	}

	public Salary salaryDetails(Associate associate) {
		associate.getSalary().setHra((associate.getSalary().getBasicSalary()*30/100));
		associate.getSalary().setConveyenceAllowance((associate.getSalary().getBasicSalary()*30/100));
		associate.getSalary().setOtherAllowance((associate.getSalary().getBasicSalary()*35/100));
		associate.getSalary().setPersonalAllowance(associate.getSalary().getBasicSalary()/5);
		associate.getSalary().setGrossSalary(associate.getSalary().getBasicSalary()+associate.getSalary().getConveyenceAllowance()+associate.getSalary().getHra()+associate.getSalary().getOtherAllowance()+associate.getSalary().getPersonalAllowance());
		return associate.getSalary();
	}

}
