package com.assignment.day1;

public class BankAccount {
	double balance = 10000;
	
	public void withdraw(double amount) {
		if(amount > balance) {
			throw new IllegalArgumentException("insufficient balance");
		}
		System.out.println("successful withdrawl " + amount);
		balance -= amount;
		System.out.println("Balance: " + balance);
	}
	
	public void deposit(double amount) {
		if(amount<0) {
			throw new IllegalArgumentException("negative deposit");
		}

		System.out.println("successful deposit " + amount);
		balance += amount;
		System.out.println("Balance: " + balance);
	}
	
	public double getBalance() {
	    return balance;
	}

}
