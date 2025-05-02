// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase {
	private Account accounts[]; // array of Accounts

	// no-argument BankDatabase constructor initializes accounts
	public BankDatabase() {
		accounts = new Account[6]; // 6 accounts for testing
		// 3 Saving accounts + 3 Cheque accounts
		accounts[0] = new SavingAccount(12345, 54321, 1000.0, 1200.0);
		accounts[1] = new SavingAccount(98765, 56789, 200.0, 200.0);
		accounts[2] = new SavingAccount(56789, 11111, 50000.0, 60000.0);
		accounts[3] = new ChequeAccount(55555, 32165, 300.0, 300.0);
		accounts[4] = new ChequeAccount(99999, 00000, 1000.0, 1600.0);
		accounts[5] = new ChequeAccount(77777, 95123, 70000.0, 90000.0);
	} // end no-argument BankDatabase constructor

	// retrieve Account object containing specified account number
	private Account getAccount(int accountNumber) {
		// loop through accounts searching for matching account number
		for (Account currentAccount : accounts) {
			// return current account if match found
			if (currentAccount.getAccountNumber() == accountNumber)
				return currentAccount;
		} // end for

		return null; // if no matching account was found, return null
	} // end method getAccount

	// verify if the account is exit in the database
	public boolean authenticateAccount(int userAccountNumber) {
		// attempt to retrieve the account with the account number
		Account userAccount = getAccount(userAccountNumber);

		if (userAccount != null)
			return true; // if account exists, return true
		else
			return false; // account number not found, so return false
	} // end method authenticateAccount

	// determine whether user-specified account number and PIN match
	// those of an account in the database
	public boolean authenticateUser(int userAccountNumber, int userPIN) {
		// attempt to retrieve the account with the account number
		Account userAccount = getAccount(userAccountNumber);

		// if account exists, return result of Account method validatePIN
		if (userAccount != null)
			return userAccount.validatePIN(userPIN);
		else
			return false; // account number not found, so return false
	} // end method authenticateUser

	// return available balance of Account with specified account number
	public double getAvailableBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getAvailableBalance();
	} // end method getAvailableBalance

	// return total balance of Account with specified account number
	public double getTotalBalance(int userAccountNumber) {
		return getAccount(userAccountNumber).getTotalBalance();
	} // end method getTotalBalance

	// credit an amount to Account with specified account number
	public void credit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).credit(amount);
	} // end method credit

	// debit an amount from of Account with specified account number
	public void debit(int userAccountNumber, double amount) {
		getAccount(userAccountNumber).debit(amount);
	} // end method debit

} // end class BankDatabase
