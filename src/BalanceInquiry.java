// BalanceInquiry.java
// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction {
	private Keypad keypad;

	// BalanceInquiry constructor
	public BalanceInquiry(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
		super(userAccountNumber, atmScreen, atmBankDatabase);
		keypad = atmKeypad;
	} // end BalanceInquiry constructor

	// performs the transaction
	public void execute() {
		// get references to bank database and screen
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		// get the available balance for the account involved
		double availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

		// get the total balance for the account involved
		double totalBalance = bankDatabase.getTotalBalance(getAccountNumber());

		// display the balance information on the screen
		BalanceInquiryGUI GUI = new BalanceInquiryGUI(availableBalance, totalBalance, screen);
		screen.showScreen(GUI.getPanel());

		String input;
		do {
			input = keypad.getNum();
			System.out.print("");
		} while (!input.equals(Integer.toString(Keypad.CANCELED)));

		GUI.getPanel().setVisible(false);
	} // end method execute

} // end class BalanceInquiry
