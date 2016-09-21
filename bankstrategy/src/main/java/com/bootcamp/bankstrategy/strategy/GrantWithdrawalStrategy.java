package com.bootcamp.bankstrategy.strategy;

import com.bootcamp.bankstrategy.Account;

public interface GrantWithdrawalStrategy {
	public boolean withdraw(Account account, long amount);
}
