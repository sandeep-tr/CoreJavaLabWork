package com.bootcamp.bankstrategy.strategy;

import com.bootcamp.bankstrategy.Account;

public interface ApplyFeesStrategy {
	public long applyFees(Account account, long amount);
}
