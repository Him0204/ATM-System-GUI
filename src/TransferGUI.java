import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

public class TransferGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel transferPanel1, transferPanel2, transferPanel3, transferPanel4;
	private JTextField textBox;
	private JLabel lblError, lblConfirm;

	public TransferGUI(Screen screen) {

		transferPanel1 = new JPanel();
		transferPanel1.setBounds(133, 30, 756, 400);
		transferPanel1.setBackground(new Color(255, 128, 128));
		transferPanel1.setLayout(null);

		JLabel lblTransfer = new JLabel("Transfer Menu");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTransfer.setBounds(207, 23, 331, 94);
		transferPanel1.add(lblTransfer);

		JLabel lblAmount = new JLabel("Input the amount you would like to transfer:");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAmount.setBackground(new Color(240, 240, 240));
		lblAmount.setBounds(37, 195, 687, 61);
		transferPanel1.add(lblAmount);

		textBox = screen.addTextField(40, 250);
		textBox.setFont(new Font("Tahoma", Font.BOLD, 30));
		transferPanel1.add(textBox);

		transferPanel2 = new JPanel();
		transferPanel2.setLayout(null);
		transferPanel2.setBackground(new Color(255, 128, 128));
		transferPanel2.setBounds(133, 30, 756, 400);

		JLabel lblAccount = new JLabel("Please enter the designated account:");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAccount.setBackground(UIManager.getColor("Button.background"));
		lblAccount.setBounds(37, 195, 687, 61);
		transferPanel2.add(lblAccount);

		lblError = new JLabel("");
		lblError.setBounds(56, 336, 656, 64);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		transferPanel2.add(lblError);

		transferPanel3 = new JPanel();
		transferPanel3.setLayout(null);
		transferPanel3.setBackground(new Color(255, 128, 128));
		transferPanel3.setBounds(133, 30, 756, 400);

		lblConfirm = new JLabel("");
		lblConfirm.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblConfirm.setBackground(UIManager.getColor("Button.background"));
		lblConfirm.setBounds(103, 135, 555, 156);
		transferPanel3.add(lblConfirm);

		transferPanel4 = new JPanel();
		transferPanel4.setLayout(null);
		transferPanel4.setBackground(new Color(255, 128, 128));
		transferPanel4.setBounds(133, 30, 756, 400);

		JLabel lblReceipt = new JLabel("Please take your receipt");
		lblReceipt.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblReceipt.setBackground(UIManager.getColor("Button.background"));
		lblReceipt.setBounds(103, 135, 555, 156);
		transferPanel4.add(lblReceipt);
	}

	public JPanel getPanel1() {
		return transferPanel1;
	}

	public JPanel getPanel2() {
		return transferPanel2;
	}

	public void setPanel3(double amount, int account) {
		lblConfirm
				.setText("<html>Please confirm for transfering $" + amount + " to <br>account(" + account + ")</html>");
	}

	public JPanel getPanel3() {
		return transferPanel3;
	}

	public JPanel getPanel4() {

		return transferPanel4;
	}

	public double getAmount(Keypad keypad) {
		keypad.reset();
		String input;
		do {
			input = keypad.getAmount();

			if (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED))) {
				textBox.setText(input);
				System.out.print("");
			}
		} while (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED)));

		if (input.equals(Integer.toString(Keypad.CANCELED)))
			return Keypad.CANCELED;
		else {
			input = textBox.getText();
			textBox.setText("");
			return Double.parseDouble(input);
		}
	}

	public int getAccount(Keypad keypad, Screen screen) {

		textBox = screen.addTextField(40, 250);
		;
		textBox.setFont(new Font("Tahoma", Font.BOLD, 30));
		transferPanel2.add(textBox);
		screen.showScreen(transferPanel2);

		String input;
		do {
			input = keypad.getNum();

			if (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED))) {
				textBox.setText(input);
				System.out.print("");
			}
		} while (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED)));

		if (input.equals(Integer.toString(Keypad.CANCELED)))
			return Keypad.CANCELED;
		else {
			input = textBox.getText();
			textBox.setText("");
			return Integer.parseInt(input);
		}
	}

	public void errorMessage(String message) {
		textBox.setText("");
		lblError.setText(message);
	}
}