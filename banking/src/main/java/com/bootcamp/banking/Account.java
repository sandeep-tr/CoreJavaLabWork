package com.bootcamp.banking;

public abstract class Account {

	private long balance;
	private String holderName;

	public Account(String holderName) {
		this.holderName = holderName;
	}

	public final void transaction(String message, long amount) {
		System.out.println(holderName + " - " + message + " - " + amount);
		balance += amount;
	}

	public long getBalance() {
		return balance;
	}

	public abstract boolean deposit(long amount);

	public abstract boolean withdraw(long amount);
}
