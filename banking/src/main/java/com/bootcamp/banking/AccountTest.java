package com.bootcamp.banking;

public class AccountTest {

	public static void main(String[] args) {
		Account[] accounts = { new MortgageAccount("Tom", 100000), new CheckingAccount("John", 200),
				new CheckingAccount("Victor", 1000) };

		for (Account account : accounts) {
			System.out.println("Deposit 1000 - " + account.deposit(1000) + ", balance - " + account.getBalance());
			System.out.println("Withdraw 500 - " + account.withdraw(500) + ", balance - " + account.getBalance());
			System.out.println("Withdraw 1000 - " + account.withdraw(1000) + ", balance - " + account.getBalance());
			System.out.println("Withdraw 2000 - " + account.withdraw(2000) + ", balance - " + account.getBalance());
		}
	}
}
