package com.bootcamp.banking;

public class CheckingAccount extends Account {

	private long overDraftAmount;

	public CheckingAccount(String holderName, long overDraftAmount) {
		super(holderName);
		this.overDraftAmount = overDraftAmount;
	}

	@Override
	public boolean deposit(long amount) {
		transaction("Checking Deposit", amount);
		return true;
	}

	@Override
	public boolean withdraw(long amount) {
		if (amount < overDraftAmount) {
			transaction("Checking Withdrawl", -1 * amount);
			return true;
		}
		return false;
	}

}
