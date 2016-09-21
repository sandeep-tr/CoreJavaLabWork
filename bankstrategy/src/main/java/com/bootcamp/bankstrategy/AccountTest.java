package com.bootcamp.bankstrategy;

import com.bootcamp.bankstrategy.strategy.CheckingStrategy;
import com.bootcamp.bankstrategy.strategy.CreditStrategy;

public class AccountTest {
	public static void main(String[] args) {

		CheckingStrategy checkingStrategy = new CheckingStrategy(500, 2);
		CreditStrategy creditStrategy = new CreditStrategy(50);

		Account[] accounts = { new Account("Tom", 1000, checkingStrategy, checkingStrategy),
				new Account("John", 500, creditStrategy, creditStrategy) };

		for (Account account : accounts) {
			System.out.println("Withdraw 100 - " + account.withdraw(100) + ", balance - " + account.getBalance());
			System.out.println("Withdraw 200 - " + account.withdraw(150) + ", balance - " + account.getBalance());
			System.out.println("Withdraw 300 - " + account.withdraw(300) + ", balance - " + account.getBalance());
		}
	}
}
