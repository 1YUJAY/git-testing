package com.sheridan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
@DisplayName("Testing Bank Account")
public class BankAccountTest {
    @Test
    @DisplayName("Withdraw test 400")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw (400);
        assertEquals(100, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Deposit test 200")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.deposit(200);
        assertEquals(700, bankAccount.getBalance());
    }
    @Nested
    class WhenBalanceEqualsZero{
        @Test
        public void testWithdrawMinimumBalanceIs0(){
            BankAccount bankAccount = new BankAccount(0, 0);
            assertThrows(RuntimeException.class, ()-> bankAccount.withdraw(500));
        }
    }

}
