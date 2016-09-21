package com.bootcamp.bankstrategy.strategy;

import com.bootcamp.bankstrategy.Account;

public class CheckingStrategy implements GrantWithdrawalStrategy, ApplyFeesStrategy {

	private long overDraft;
	private int freeMonthlyWithdrawls;
	private int withdrawls;

	public CheckingStrategy(long overDraft, int freeMonthlyWithdrawls) {
		this.overDraft = overDraft;
		this.freeMonthlyWithdrawls = freeMonthlyWithdrawls;
	}

	@Override
	public boolean withdraw(Account account, long amount) {
		long balance = account.getBalance();
		if (amount < overDraft && amount < balance) {
			++withdrawls;
			return true;
		}
		return false;
	}

	@Override
	public long applyFees(Account account, long amount) {
		if (withdrawls > freeMonthlyWithdrawls) {
			return 10;
		}
		return 0;
	}

}
