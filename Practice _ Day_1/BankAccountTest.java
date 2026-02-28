package com.assignment.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BankAccountTest {

    private BankAccount bank;

    @BeforeEach
    void init() {
        bank = new BankAccount();
    }

    @ParameterizedTest
    @CsvSource({ "-1", "-4500" })
    void shouldThrowExceptionForNegativeDeposit(double amount) {

        assertThrows(IllegalArgumentException.class,
                () -> bank.deposit(amount));
    }


    @ParameterizedTest
    @CsvSource({
        "2000,12000",
        "4000,14000"
    })
    void shouldDepositSuccessfullyAndUpdateBalance(double amount, double expectedBalance) {

        bank.deposit(amount);

        assertEquals(expectedBalance, bank.getBalance());
    }

    @ParameterizedTest
    @CsvSource({ "10001", "20000" })
    void shouldThrowExceptionWhenWithdrawExceedsBalance(double amount) {

        assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(amount));
    }

    @ParameterizedTest
    @CsvSource({
        "2000,8000",
        "5000,5000",
        "10000,0"
    })
    void shouldWithdrawSuccessfullyAndUpdateBalance(double amount, double expectedBalance) {

        bank.withdraw(amount);

        assertEquals(expectedBalance, bank.getBalance());
    }
}
