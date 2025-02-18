Bank Account System
A simple Java project simulating a bank account system with features like depositing, withdrawing, and transferring money.

Features
    Create an account with an initial balance.
    Deposit and withdraw money.
    Transfer money between accounts.
    Check account balance.
Example Usage
    BankAccount account1 = new BankAccount(1000, "Dagoberto");
    BankAccount account2 = new BankAccount(300, "Amado");
    account1.deposit(100);
    account1.withdraw(1000);
    account1.transfer(100, account2.accountNumber);
    account2.checkBalance();
Methods
    deposit(double amount)
    withdraw(double amount)
    transfer(double amount, int accountNumber)
    checkBalance()

Requirements
Java 8 or higher.
