/**
* Represents a simple bank account.
*
* @author Christine Reilly
* Copyright 2023 Christine F. Reilly
*/
public class SimpleAccount {

  /** This BankAccount's balance */
  private double balance;


  /**
  * Creates a BankAccount object
  *
  * @param initialBalance The initial balance.
  */
  public SimpleAccount(double initialBalance) {
    this.balance = initialBalance;
  }

  /**
  * Returns the balance of this bank account.
  *
  * @return The account balance.
  */
  public double getBalance() {
    return balance;
  }

  /**
  * Deposits money into the bank account.
  *
  * @param amount The amount of money to deposit into the account.
  */
  public void deposit(double amount) {
    balance += amount;
  } // end of deposit method

  /**
  * Withdraws money from the bank account.
  *
  * @param amount The amount of money to withdraw from the account.
  */
  public void withdraw(double amount) {
    balance -= amount;
  }
}
