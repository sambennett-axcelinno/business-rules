package com.sam;

import static org.junit.Assert.*;

import org.junit.Test;

import com.myspace.loan.*;

public class LoanTest {

	@Test
	public void test1() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(800);
		applicant.setAmount(1100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		runProcess.runLoan(applicant);
		assertEquals(true,  applicant.getApproved());
	}
	
	@Test
	public void amountTooHighForSalary() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(800);
		applicant.setAmount(5100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		runProcess.runLoan(applicant);
		assertEquals(false,  applicant.getApproved());
	}
	
	@Test
	public void amountTooHigh() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(800);
		applicant.setAmount(10100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		runProcess.runLoan(applicant);
		assertEquals(false,  applicant.getApproved());
	}
	
	@Test
	public void taxScoreandAgeGood() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(650);
		applicant.setAmount(1100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		runProcess.runLoan(applicant);
		assertEquals(true,  applicant.getApproved());
	}
	
	@Test
	public void lowAmountRequested() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(550);
		applicant.setAmount(100.0);
		applicant.setSalary(50000.00);
		applicant.setAge(35);
		runProcess.runLoan(applicant);
		assertEquals(true,  applicant.getApproved());
	}
	
	@Test
	public void tooYoungForAmount() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(650);
		applicant.setAmount(2000.0);
		applicant.setSalary(50000.00);
		applicant.setAge(24);
		runProcess.runLoan(applicant);
		assertEquals(false,  applicant.getApproved());
	}
	
	@Test
	public void taxScoreTooLow() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(350);
		applicant.setAmount(2000.0);
		applicant.setSalary(50000.00);
		applicant.setAge(34);
		runProcess.runLoan(applicant);
		assertEquals(false,  applicant.getApproved());
	}
	
	@Test
	public void taxScoreTooLowForAmmount() {
		RunProcess runProcess = new RunProcess();
		Applicant applicant = new Applicant();
		applicant.setTaxScore(450);
		applicant.setAmount(2000.0);
		applicant.setSalary(50000.00);
		applicant.setAge(24);
		runProcess.runLoan(applicant);
		assertEquals(false,  applicant.getApproved());
	}

}
