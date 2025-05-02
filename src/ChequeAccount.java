// ChequeAccount.java
// Represents a specific type of bank accounts

public class ChequeAccount extends Account {
	private static int limitPerCheque = 10000;

	// ChequeAccount constructor
	public ChequeAccount(int theAccountNumber, int thePIN, double theAvailableBalance, double theTotalBalance) {
		super(theAccountNumber, thePIN, theAvailableBalance, theTotalBalance);
	} // end ChequeAccount constructor

	// modify the limit per cheque
	public void setLimit(int limit) {
		limitPerCheque = limit;
	} // end method setLimit

	// returns the limit per cheque
	public int getLimit() {
		return limitPerCheque;
	} // end method getLimit

} // end class ChequeAccount
