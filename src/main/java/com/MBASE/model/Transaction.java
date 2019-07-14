package com.MBASE.model;

public class Transaction {
	int LoanId;
	int CustomerId;
	double LoanAmount;
	int LoanProductId;
	public Transaction() {}
	public Transaction(int loanId, int customerId, double loanAmount, int loanProductId) {
		super();
		LoanId = loanId;
		CustomerId = customerId;
		LoanAmount = loanAmount;
		LoanProductId = loanProductId;
	}
	
	public int getLoanId() {
		return LoanId;
	}
	public void setLoanId(int loanId) {
		LoanId = loanId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	
	public double getLoanAmount() {
		return LoanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}
	public int getLoanProductId() {
		return LoanProductId;
	}
	public void setLoanProductId(int loanProductId) {
		LoanProductId = loanProductId;
	}
	

}
