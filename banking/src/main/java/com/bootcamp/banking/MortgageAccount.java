package com.bootcamp.banking;

public class MortgageAccount extends Account {

	public MortgageAccount(String holderName, long borrowedAmount) {
		super(holderName);
		transaction("Initial Borrowed Amount", borrowedAmount);
	}

	@Override
	public boolean deposit(long amount) {
		transaction("Mortgage Payment", -1 * amount);
		return true;
	}

	@Override
	public boolean withdraw(long amount) {
		return false;
	}

}
