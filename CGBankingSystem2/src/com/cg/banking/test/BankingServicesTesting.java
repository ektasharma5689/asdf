package com.cg.banking.test;
import javax.security.auth.login.AccountNotFoundException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.util.BankingDBUtil;
import com.cg.banking.beans.*;
import com.cg.banking.exceptions.*;
import com.cg.banking.services.*;
public class BankingServicesTesting {
private static Services services;
	
@BeforeClass
public static void setUpTestEnv() {
	services = new ServiceImpl();
}
@Before
public void setUpTestData() {
	Account account = new Account("savings", 151722,"Active", 1, 10000, new Customer("Ankush","Bathla","1517219135383332","ankush2525","8510895097"));
	Account account1 = new Account("Current", 151723,"Active", 2, 1000, new Customer("vikram","Bathla","1517219156238955","vikram3030","8130674906"));
	BankingServiceDbUtil.accountInfo.put(account.getAccountNumber(), account);
	BankingServiceDbUtil.accountInfo.put(account1.getAccountNumber(), account1);
	
	BankingServiceDbUtil.ACCOUNT_NUMBER=151723;
}
@After
public void tearDownTestData() {
	BankingServiceDbUtil.accountInfo.clear();
	BankingServiceDbUtil.ACCOUNT_NUMBER=151721;
}
@Test(expected= InvalidAccountNumberException.class)
public void getAccountDetailsForInvalidAccountNumber()throws InvalidAccountNumberException{
	services.findOne(121230);
}

@Test
public void getAccountDetailsForValidAccountNumber() throws InvalidAccountNumberException {
	Account expectedAccount= new Account("savings", 151722,"Active", 1, 10000, new Customer("Ankush","Bathla","1517219135383332","ankush2525","8510895097"));
	BankingServiceDbUtil.accountInfo.put(expectedAccount.getAccountNumber(),expectedAccount);
	Account actualAccount =services.findOne(151722);
	Assert.assertEquals(expectedAccount, actualAccount);
}
@Test(expected=InvalidAccountNumberException.class)
public void testDepositForInvalidAccountNumber() throws InvalidAccountNumberException{
	services.findOne(121230);
}
@Test
public void testDepositForValidAccountNumber() throws InvalidAmountException, AccountNotFoundException, InvalidAccountNumberException, AccountBlockedException{
	long expectedBalance =2000;
    long actualBalance=(long) services.deposit(151723,1000);
    Assert.assertEquals(expectedBalance, actualBalance);
}
@Test
public void testAcceptAccountDetailsForValidData() throws InvalidAccountTypeException, InvalidAmountException, InvalidAdharNoException {
	long expectedAccountNumber=151724;
	Account actualAccountNumber=services.createAccount("Savings", 5000, "Robin", "Singh", "7896541230123654", "robin4521","9896705007");
    Assert.assertEquals(expectedAccountNumber, actualAccountNumber);
}
@Test(expected=InvalidAdharNoException.class)
public void testAcceptAccountDetailsForInvalidAdharNumber() throws InvalidAccountTypeException, InvalidAmountException, InvalidAdharNoException {
	services.createAccount("Savings", 5000, "Robin", "Singh", "7896541230", "robin4521","9896705007");
}
@Test(expected=InvalidAccountTypeException.class)
public void testAcceptAccountDetailsForInvalidAccountType() throws InvalidAccountTypeException, InvalidAmountException, InvalidAdharNoException {
	services.createAccount("Sa", 5000, "Robin", "Singh", "7896541230221254", "robin4521","9896705007");
}
@Test
public void testWithdrawForValidData() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException {
	long expectedBalance =8000;
	long actualBalance= (long)services.withdraw(151722, 1, 2000);
	Assert.assertEquals(expectedBalance, actualBalance);
}
@Test(expected=InvalidAccountNumberException.class)
public void testWithdrawForInvalidAccountNumberException() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException{
	services.withdraw(25412, 1, 1200);
}
@Test(expected=InvalidPinNumberException.class)
public void testWithdrawForInvalidPinNumberException() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException{
	services.withdraw(151722, 5, 1200);
}
@Test(expected=InvalidAmountException.class)
public void testWithdrawForInvalidAmountNumberException() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException{
	services.withdraw(151723, 2, 1200);
}
@Test(expected=InvalidAccountNumberException.class)
public void testFundTransferForInvalidAccountNumberOfSenderAccount() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException{
	services.fundtransfer(1254, 151723, 1, 1200);
}
@Test(expected=InvalidAccountNumberException.class)
public void testFundTransferForInvalidAccountNumberOfReceiverAccount() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException{
	services.fundtransfer(151722, 15123, 1, 200);
}
@Test(expected=InvalidPinNumberException.class)
public void testFundTransferForInvalidPinNumberOfSenderAccount() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException{
	services.fundtransfer(151722, 151723, 5, 200);
}
@Test(expected=InvalidAmountException.class)
public void testFundtransferForInvalidAccountNumberOfReceiverAccount() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException{
	services.fundtransfer(151722, 151723, 1, 11000);
}
@Test
public void testfundTransferForvalidData() throws AccountNotFoundException, InvalidAccountNumberException, InvalidAmountException, InvalidPinNumberException, AccountBlockedException, InvalidAccountTypeException{
	int expectedWithdrawAccBal=8000;
	int actualWithdrawAccBal= (int)services.withdraw(151722, 1, 2000);
	int expectedDepositAccBal =3000;
	int actualDepositAccBal=(int)services.deposit(151723, 2000);
	Assert.assertEquals(expectedWithdrawAccBal, actualWithdrawAccBal);
	Assert.assertEquals(expectedDepositAccBal, actualDepositAccBal);
}

}