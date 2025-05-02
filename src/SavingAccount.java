// SavingAccount.java
// Represents a specific type of bank accounts

public class SavingAccount extends Account {
	private static double interestRate = 0.001;

	// SavingAccount constructor
	public SavingAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
		super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
	} // end SavingAccount constructor

	// modify the interest rate
	public void setInterestRate(double IR) {
		interestRate = IR;
	} // end method setInterestRate

	// returns the interest rate
	public double getInterestRate() {
		return interestRate;
	} // end method getInterestRate

} // end class SavingAccount
