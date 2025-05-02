// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction {
	private int amount; // amount to withdraw
	private CashDispenser cashDispenser; // reference to cash dispenser
	private Keypad keypad;

	// Withdrawal constructor
	public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad,
			CashDispenser atmCashDispenser) {
		// initialize superclass variables
		super(userAccountNumber, atmScreen, atmBankDatabase);

		// initialize references to cash dispenser
		cashDispenser = atmCashDispenser;
		keypad = atmKeypad;
	} // end Withdrawal constructor

	// perform transaction
	public void execute() {
		boolean cashDispensed = false; // cash was not dispensed yet
		double availableBalance; // amount available for withdrawal

		// get references to bank database and screen
		BankDatabase bankDatabase = getBankDatabase();
		Screen screen = getScreen();
		WithdrawalGUI GUI = new WithdrawalGUI(screen);

		// loop until cash is dispensed or the user cancels
		do {
			// obtain a chosen withdrawal amount from the user
			amount = displayMenuOfAmounts(screen, GUI);

			// check whether user chose a withdrawal amount or canceled
			if (amount != Keypad.CANCELED) {
				// get available balance of account involved
				availableBalance = bankDatabase.getAvailableBalance(getAccountNumber());

				// check whether the user has enough money in the account
				if (amount <= availableBalance) {

					// check whether the cash dispenser has enough money
					if (cashDispenser.isSufficientCashAvailable(amount)) {
						// update the account involved to reflect withdrawal
						bankDatabase.debit(getAccountNumber(), amount);

						cashDispenser.dispenseCash(amount); // dispense cash

						// instruct user to take cash
						GUI.getPanel1().setVisible(false);
						screen.showScreen(GUI.getPanel2());

						screen.dispenseCash();

						cashDispensed = true; // cash was dispensed
					} // end if
					else // cash dispenser does not have enough cash
						GUI.errorMessage(
								"<html>Insufficient cash available in the ATM.<br>Please choose a smaller amount.</html>");
				} // end if
				else // not enough money available in user's account
				{
					GUI.errorMessage(
							"<html>Insufficient funds in your account.<br>Please choose a smaller amount.</html>");
				} // end else
			} // end if
			else // user chose cancel menu option
			{
				GUI.getPanel1().setVisible(false);
				return; // return to main menu because user canceled
			} // end else
		} while (!cashDispensed);

		GUI.getPanel2().setVisible(false);

	} // end method execute

	// display a menu of withdrawal amounts and the option to cancel;
	private int displayMenuOfAmounts(Screen screen, WithdrawalGUI GUI) {

		screen.showScreen(GUI.getPanel1());

		int userChoice;
		do {
			userChoice = GUI.getAmount(keypad); // get user input through keypad

			// loop while no valid choice has been made
			if (userChoice % 100 != 0) {
				// alert message
				GUI.errorMessage("Amount need to be multiple of $100");
			}
		} while (!(userChoice % 100 == 0 || userChoice == Keypad.CANCELED));

		return userChoice; // return withdrawal amount or CANCELED
	} // end method displayMenuOfAmounts

} // end class Withdrawal
