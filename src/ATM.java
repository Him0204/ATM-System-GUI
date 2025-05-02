// ATM.java
// Represents an automated teller machine

import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ATM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel loginPanel1, loginPanel2, mainPanel, getCardPanel;
	private JLabel lblError;
	private JPasswordField passwordField;

	private boolean userAuthenticated; // whether user is authenticated
	private int currentAccountNumber; // current user's account number
	private Screen screen; // ATM's screen
	private Keypad keypad; // ATM's keypad
	private CashDispenser cashDispenser; // ATM's cash dispenser
	private BankDatabase bankDatabase; // account information database

	private int input = EMPTY;
	private boolean lock = true;
	// constants corresponding to main menu options
	private static final int BALANCE_INQUIRY = 1;
	private static final int WITHDRAWAL = 2;
	private static final int TRANSFER = 3;
	private static final int EMPTY = -888;

	public ATM() {

		userAuthenticated = false; // user is not authenticated to start
		currentAccountNumber = 0; // no current account number to start
		keypad = new Keypad(); // create keypad
		screen = new Screen(keypad); // create screen
		cashDispenser = new CashDispenser(); // create cash dispenser
		bankDatabase = new BankDatabase(); // create acct info database

		loginPanel1 = new JPanel();
		loginPanel1.setBackground(new Color(255, 128, 128));
		loginPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		loginPanel1.setBounds(133, 30, 756, 400);
		loginPanel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome to HKCC Bank!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(144, 29, 450, 96);
		loginPanel1.add(lblNewLabel);

		Icon icon = new ImageIcon(getClass().getResource("ICON.png"));
		JLabel lblPleaseInsertYour = new JLabel("Please insert your ATM card ");
		lblPleaseInsertYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseInsertYour.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPleaseInsertYour.setBounds(-77, -30, 892, 540);
		lblPleaseInsertYour.setIcon(icon);
		lblPleaseInsertYour.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPleaseInsertYour.setVerticalTextPosition(SwingConstants.BOTTOM);
		loginPanel1.add(lblPleaseInsertYour);

		loginPanel2 = new JPanel();
		loginPanel2.setBackground(new Color(255, 128, 128));
		loginPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		loginPanel2.setBounds(133, 30, 756, 400);
		loginPanel2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Please enter your PIN:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(28, 212, 414, 67);
		loginPanel2.add(lblNewLabel_1);

		passwordField = screen.addPwField(28, 278);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		loginPanel2.add(passwordField);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblError.setBounds(28, 322, 690, 67);
		loginPanel2.add(lblError);

		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(255, 128, 128));
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		mainPanel.setBounds(133, 30, 756, 400);
		mainPanel.setLayout(null);

		JLabel lblMenu = new JLabel("Main Menu");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMenu.setBounds(210, 10, 310, 84);
		mainPanel.add(lblMenu);

		JButton btnBalance = new JButton("Balance Inquiry");
		btnBalance.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBalance.setFocusable(false);
		btnBalance.setBounds(155, 93, 421, 84);
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = BALANCE_INQUIRY;
			}
		});
		mainPanel.add(btnBalance);

		JButton btnWithdrawal = new JButton("Withdrawal");
		btnWithdrawal.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnWithdrawal.setFocusable(false);
		btnWithdrawal.setBounds(155, 188, 421, 84);
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = WITHDRAWAL;
			}
		});
		mainPanel.add(btnWithdrawal);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnTransfer.setFocusable(false);
		btnTransfer.setBounds(155, 286, 421, 84);
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = TRANSFER;
			}
		});
		mainPanel.add(btnTransfer);

		getCardPanel = new JPanel();
		getCardPanel.setBackground(new Color(255, 128, 128));
		getCardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		getCardPanel.setBounds(133, 30, 756, 400);
		getCardPanel.setLayout(null);

		JLabel lblgetCard = new JLabel("<html>Canceled.<br>Please take your card</html>");
		lblgetCard.setHorizontalAlignment(SwingConstants.CENTER);
		lblgetCard.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblgetCard.setBounds(101, 126, 528, 148);
		getCardPanel.add(lblgetCard);

	}

	public void run() {
		// welcome and authenticate user; perform transactions
		while (true) {
			do {
				authenticateUser(); // authenticate user
			} while (currentAccountNumber == Keypad.EMPTY);

			if (currentAccountNumber != Keypad.CANCELED) {
				performTransactions(); // user is now authenticated
			} else {
				userAuthenticated = false; // reset before next ATM session
				currentAccountNumber = 0; // reset before next ATM session
				loginPanel2.setVisible(false);
			}
			cancelProcedure();
		}
	} // end method run

	// attempts to authenticate user against database
	private void authenticateUser() {
		screen.showScreen(loginPanel1);

		int accountNumber;
		do {
			accountNumber = screen.getInput(); // input account number
			System.out.print("");
		} while (accountNumber == Screen.CASHDISPENSER || accountNumber == Screen.RECEIPT
				|| accountNumber == Screen.CARD || accountNumber == Screen.EMPTY);

		loginPanel1.setVisible(false);
		screen.showScreen(loginPanel2); // prompt for PIN

		String input = "";
		do {
			input = keypad.getNum();
			if (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED))) {
				passwordField.setText(input);
				System.out.print("");
			}
			if (input.equals(Integer.toString(Keypad.ENTER))) {

				if (!String.valueOf(passwordField.getPassword()).equals("")) {

					int pin = Integer.parseInt(String.valueOf(passwordField.getPassword()));

					// set userAuthenticated to boolean value returned hby database
					userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

					// check whether authentication succeeded
					if (userAuthenticated) {
						currentAccountNumber = accountNumber; // save user's account #
					} // end if
					else {
						input = "";
						passwordField.setText("");
						lblError.setText("Incorrect PIN. Please try again.");
					}
				} else {
					input = "";
					passwordField.setText("");
					lblError.setText("Please input your PIN.");
				}
			}
			if (input.equals(Integer.toString(Keypad.CANCELED))) {
				currentAccountNumber = Keypad.CANCELED;
			}

		} while (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED)));

	} // end method authenticateUser

	// display the main menu and perform transactions
	private void performTransactions() {
		// local variable to store transaction currently being processed
		Transaction currentTransaction = null;

		boolean userExited = false; // user has not chosen to exit

		// loop while user has not chosen option to exit system
		while (!userExited) {
			// show main menu and get user selection
			int mainMenuSelection = displayMainMenu();

			// decide how to proceed based on user's menu selection
			switch (mainMenuSelection) {
			// user chose to perform one of three transaction types
			case BALANCE_INQUIRY:
			case WITHDRAWAL:
			case TRANSFER:
				// initialize as new object of chosen type
				currentTransaction = createTransaction(mainMenuSelection);
				currentTransaction.execute(); // execute transaction
				break;
			case Keypad.CANCELED: // user chose to terminate session
				mainPanel.setVisible(false);
				cancelProcedure();
				userExited = true; // this ATM session should end
				break;
			} // end switch
		} // end while
	} // end method performTransactions

	// display the main menu and return an input selection
	private int displayMainMenu() {

		loginPanel2.setVisible(false);
		screen.showScreen(mainPanel);

		int selection;
		String selection2;
		lock = false;
		do {
			selection = input;
			selection2 = keypad.getNum();
			if (input != EMPTY) {
				lock = true;
				selection = input;
				input = EMPTY;
			}
			System.out.print("");
		} while (!((selection == WITHDRAWAL || selection == BALANCE_INQUIRY || selection == TRANSFER)
				|| selection2.equals(Integer.toString(Keypad.CANCELED))));

		if (selection2.equals(Integer.toString(Keypad.CANCELED)))
			return Keypad.CANCELED;
		else
			return selection; // return user's selection
	} // end method displayMainMenu

	// return object of specified Transaction subclass
	private Transaction createTransaction(int type) {

		mainPanel.setVisible(false);
		Transaction temp = null; // temporary Transaction variable

		// determine which type of Transaction to create
		switch (type) {
		case BALANCE_INQUIRY: // create new BalanceInquiry transaction
			temp = new BalanceInquiry(currentAccountNumber, screen, bankDatabase, keypad);
			break;
		case WITHDRAWAL: // create new Withdrawal transaction
			temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, keypad, cashDispenser);
			break;
		case TRANSFER: // create new Transfer transaction
			temp = new Transfer(currentAccountNumber, screen, bankDatabase, keypad);
			break;
		} // end switch

		return temp; // return the newly created object
	} // end method createTransaction

	private void cancelProcedure() {
		screen.showScreen(getCardPanel);
		screen.getCard();
		getCardPanel.setVisible(false);
	}
}