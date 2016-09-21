package com.bootcamp.bankstrategy.strategy;

import com.bootcamp.bankstrategy.Account;

public class CreditStrategy implements GrantWithdrawalStrategy, ApplyFeesStrategy {

	private long overCreditFee;

	public CreditStrategy(long overCreditFee) {
		this.overCreditFee = overCreditFee;
	}

	@Override
	public boolean withdraw(Account account, long amount) {
		long balance = account.getBalance();
		if (balance < 1) {
			return false;
		}
		return true;
	}

	@Override
	public long applyFees(Account account, long amount) {
		long balance = account.getBalance();
		if (amount > balance) {
			return overCreditFee;
		}
		return 0;
	}

}
