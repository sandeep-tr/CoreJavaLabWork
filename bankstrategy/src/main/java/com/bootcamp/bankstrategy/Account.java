package com.bootcamp.bankstrategy;

import com.bootcamp.bankstrategy.strategy.ApplyFeesStrategy;
import com.bootcamp.bankstrategy.strategy.GrantWithdrawalStrategy;

public class Account {
	private long balance;
	private String holderName;
	private GrantWithdrawalStrategy withdrawStrategy;
	private ApplyFeesStrategy applyFeeStrategy;

	public Account(String holderName, long balance, GrantWithdrawalStrategy withdrawStrategy,
			ApplyFeesStrategy applyFeeStrategy) {
		this.holderName = holderName;
		this.balance = balance;
		this.withdrawStrategy = withdrawStrategy;
		this.applyFeeStrategy = applyFeeStrategy;
	}

	public boolean withdraw(long amount) {
		boolean status = withdrawStrategy.withdraw(this, amount);
		if (status) {
			transaction("Money withdrawn from account", -1 * amount);
			applyFee(amount);
		}
		return status;
	}

	private void applyFee(long amount) {
		long fee = applyFeeStrategy.applyFees(this, amount);
		if (fee > 0) {
			transaction("Fees applied on transaction", -1 * fee);
		}
	}

	private void transaction(String message, long amount) {
		System.out.println(holderName + " - " + message + " - " + amount);
		balance += amount;
	}

	public long getBalance() {
		return balance;
	}

	public void setWithdrawStrategy(GrantWithdrawalStrategy withdrawStrategy) {
		this.withdrawStrategy = withdrawStrategy;
	}

	public void setApplyFeeStrategy(ApplyFeesStrategy applyFeeStrategy) {
		this.applyFeeStrategy = applyFeeStrategy;
	}

}
