
// Screen.java
// Represents the screen of the ATM
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel screenGUI;
	private JButton btnCash, btnReceipt, btnCard;
	private JPasswordField pwField;
	private JTextField textBox;
	private Keypad keypad;
	private boolean lock = true;
	private static final int[] ACCOUNTS = new int[] { 12345, 98765, 56789 };
	public static final int CASHDISPENSER = 1, RECEIPT = 2, CARD = 3, EMPTY = -888;
	private int input = EMPTY;

	public Screen(Keypad Keypad) {

		keypad = Keypad;
		this.setSize(1000, 800);
		getContentPane().setLayout(null);
		this.setVisible(true);

		btnCash = new JButton();
		btnCash.setBackground(new Color(192, 192, 192));
		btnCash.setBounds(0, 170, 829, 50);
		btnCash.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCash.setText("Cash Dispenser");
		btnCash.setFocusable(false);
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = CASHDISPENSER;
			}
		});

		btnReceipt = new JButton();
		btnReceipt.setBackground(new Color(192, 192, 192));
		btnReceipt.setBounds(50, 40, 171, 50);
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReceipt.setText("Receipt Output");
		btnReceipt.setFocusable(false);
		btnReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = RECEIPT;
			}
		});

		btnCard = new JButton();
		btnCard.setBackground(new Color(192, 192, 192));
		btnCard.setBounds(630, 0, 150, 55);
		btnCard.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCard.setText("Card Reader");
		btnCard.setFocusable(false);
		btnCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = CARD;
			}
		});

		JButton btnC1 = new JButton();
		btnC1.setBackground(new Color(192, 192, 192));
		btnC1.setBounds(630, 80, 50, 50);
		btnC1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnC1.setText("1");
		btnC1.setFocusable(false);
		btnC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = ACCOUNTS[0];
			}
		});

		JButton btnC2 = new JButton();
		btnC2.setBackground(new Color(192, 192, 192));
		btnC2.setBounds(680, 80, 50, 50);
		btnC2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnC2.setText("2");
		btnC2.setFocusable(false);
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = ACCOUNTS[1];
			}
		});

		JButton btnC3 = new JButton();
		btnC3.setBackground(new Color(192, 192, 192));
		btnC3.setBounds(730, 80, 50, 50);
		btnC3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnC3.setText("3");
		btnC3.setFocusable(false);
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = ACCOUNTS[2];
			}
		});

		// Screen Panel
		screenGUI = new JPanel();
		screenGUI.setBounds(90, 500, 830, 220);
		screenGUI.setLayout(null);
		screenGUI.add(btnCash);
		screenGUI.add(btnReceipt);
		screenGUI.add(btnCard);
		screenGUI.add(btnC1);
		screenGUI.add(btnC2);
		screenGUI.add(btnC3);
	}

	public JPasswordField addPwField(int x, int y) {
		pwField = new JPasswordField();
		pwField.setBounds(x, y, 690, 50);
		return pwField;
	}

	public JTextField addTextField(int x, int y) {
		textBox = new JTextField();
		textBox.setBounds(x, y, 690, 50);
		return textBox;
	}

	public int getInput() {
		lock = false;
		int temp = input;
		if (input != EMPTY) {
			input = EMPTY;
			lock = true;
		}
		return temp;
	}

	public void showScreen(JPanel panel) {
		panel.setVisible(true);
		this.getContentPane().add(panel);
		this.getContentPane().add(keypad.getPanel());
		this.getContentPane().add(screenGUI);
		this.revalidate();
		this.repaint();
	}

	void dispenseCash() {
		btnCash.setBackground(new Color(128, 255, 255));
		int input;
		do {
			input = getInput();
			System.out.print("");
		} while (input != CASHDISPENSER);
		btnCash.setBackground(new Color(192, 192, 192));
	}

	void getReceipt() {
		btnReceipt.setBackground(new Color(128, 255, 255));
		int input;
		do {
			input = getInput();
			System.out.print("");
		} while (input != RECEIPT);
		btnReceipt.setBackground(new Color(192, 192, 192));
	}

	void getCard() {
		btnCard.setBackground(new Color(128, 255, 255));
		int input;
		do {
			input = getInput();
			System.out.print("");
		} while (input != CARD);
		btnCard.setBackground(new Color(192, 192, 192));
	}

} // end class Screen
