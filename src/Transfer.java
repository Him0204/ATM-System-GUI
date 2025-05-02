// Transfer.java
// Represents a Transfer ATM transaction

public class Transfer extends Transaction {
	private double transferAmount; // amount to transfer
	private boolean accountAuthenticated; // whether account is exist
	private Keypad keypad; // reference to keypad
	private TransferGUI GUI;

	// Transfer constructor
	public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad) {
		// initialize superclass variables
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// initialize references to keypad
		keypad = atmKeypad;
		GUI = new TransferGUI(atmScreen);
	} // end Transfer constructor

	// perform transaction
	public void execute() {
		boolean transferred = false; // not transferred yet
		double availableBalance; // amount available for transfer
		int currentAccountNumber = getAccountNumber(); // account to be debited
		int receiveAccount; // account to be credited

		// get references to bank database and screen
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();

		// loop until transferred or the user cancels
		do {
			// obtain the transfer amount
			transferAmount = inputTransferAmounts();

			if (transferAmount == Keypad.CANCELED) {
				GUI.getPanel1().setVisible(false);
				return;
			}
			// check whether user input a transfer amount or canceled
			if (transferAmount != Keypad.CANCELED) {
				// get available balance of account involved
				availableBalance = bankDatabase.getAvailableBalance(currentAccountNumber);

				// check whether the user has enough money in the account
				if (transferAmount <= availableBalance) {
					// obtain the account to be credited
					GUI.getPanel1().setVisible(false);
					screen.showScreen(GUI.getPanel2());
					// loop until obtain a valid account number
					do {
						receiveAccount = GUI.getAccount(keypad, screen); // get user input through keypad

						if (receiveAccount == Keypad.CANCELED) {
							GUI.getPanel2().setVisible(false);
							return;
						}
						// verify if the account exist
						accountAuthenticated = bankDatabase.authenticateAccount(receiveAccount);
						if (!accountAuthenticated)
							GUI.errorMessage("Invalid account number. Please try again: ");
						if (receiveAccount == transferAmount)
							GUI.errorMessage("Cannot transfer to same account. Please try again: ");
					} while (!accountAuthenticated || receiveAccount == transferAmount);
					GUI.getPanel2().setVisible(false);

					// confirm the account and amount
					int confirm = confirmationMessage(transferAmount, receiveAccount);
					if (confirm == 1) {
						// update the account involved to reflect transfer
						bankDatabase.debit(getAccountNumber(), transferAmount);
						bankDatabase.credit(receiveAccount, transferAmount);

						transferred = true; // transferred successfully

						GUI.getPanel3().setVisible(false);
						screen.showScreen(GUI.getPanel4());

						screen.getReceipt();
						GUI.getPanel4().setVisible(false);
					} // end if
					else {
						transferred = false; // transfer is canceled
						GUI.getPanel3().setVisible(false);
						return ;
					} // end else

				} // end if
				else // not enough amount available in user's account
				{
					GUI.errorMessage(
							"<html>Insufficient funds in your account.<br>Please choose a smaller amount.</html>");
				} // end else
			} // end if
			else // user cancel the transaction
			{
				return; // return to main menu because user canceled
			} // end else

		} while (!transferred);

	} // end method execute

	// confirm the account and amount for the transfer
	private int confirmationMessage(double amount, int account) {
		Screen screen = getScreen(); // get screen reference (set screen as reference of Screen class)

		GUI.setPanel3(amount, account);
		screen.showScreen(GUI.getPanel3());
		// loop while no valid choice has been made
		String input;
		do {
			input = keypad.getNum();
			System.out.print("");
		} while (!input.equals(Integer.toString(Keypad.CANCELED)) && !input.equals(Integer.toString(Keypad.ENTER)));

		if(input.equals(Integer.toString(Keypad.CANCELED)))
			return -1;
		else
			return 1;
	} // end method confirmationMessage

	// obtain transfer amount and provide the option to cancel;
	private double inputTransferAmounts() {
		double userChoice = -1; // local variable to store return value
		Screen screen = getScreen(); // get screen reference (set screen as reference of Screen class)

		screen.showScreen(GUI.getPanel1());
		// loop while no valid choice has been made

		userChoice = GUI.getAmount(keypad); // get user input through keypad

		return userChoice; // returns the valid amount or 0 to cancel
	} // end method inputTransferAmounts

} // end class Transfer
