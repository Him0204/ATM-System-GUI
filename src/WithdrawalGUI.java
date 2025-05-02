import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class WithdrawalGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel withdrawalPanel1, withdrawalPanel2;
	private JTextField textBox;
	private JLabel lblError;
	private String input;
	private boolean lock = true;
	private boolean chosen = false;

	public WithdrawalGUI(Screen screen) {

		withdrawalPanel1 = new JPanel();
		withdrawalPanel1.setBackground(new Color(255, 128, 128));
		withdrawalPanel1.setBounds(133, 30, 756, 400);
		withdrawalPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		withdrawalPanel1.setLayout(null);

		JLabel labelMenu = new JLabel("Withdrawal Menu");
		labelMenu.setBounds(203, 21, 331, 54);
		labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		withdrawalPanel1.add(labelMenu);

		lblError = new JLabel("");
		lblError.setBounds(56, 336, 656, 64);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		withdrawalPanel1.add(lblError);

		JButton button100 = new JButton("$100");
		button100.setFont(new Font("Tahoma", Font.BOLD, 40));
		button100.setBounds(103, 86, 250, 70);
		button100.setFocusable(false);
		button100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					input = "100";
					chosen = true;
				}
			}
		});
		withdrawalPanel1.add(button100);

		JButton button300 = new JButton("$300");
		button300.setFont(new Font("Tahoma", Font.BOLD, 40));
		button300.setBounds(388, 86, 250, 70);
		button300.setFocusable(false);
		button300.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					input = "300";
					chosen = true;
				}
			}
		});
		withdrawalPanel1.add(button300);

		JButton button500 = new JButton("$500");
		button500.setFont(new Font("Tahoma", Font.BOLD, 40));
		button500.setBounds(103, 174, 250, 70);
		button500.setFocusable(false);
		button500.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					input = "500";
					chosen = true;
				}
			}
		});
		withdrawalPanel1.add(button500);

		JButton button1000 = new JButton("$1000");
		button1000.setFont(new Font("Tahoma", Font.BOLD, 40));
		button1000.setBounds(388, 174, 250, 70);
		button1000.setFocusable(false);
		button1000.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					input = "1000";
					chosen = true;
				}
			}
		});
		withdrawalPanel1.add(button1000);

		JLabel labelCustom = new JLabel("Or enter custom amount:");
		labelCustom.setHorizontalAlignment(SwingConstants.LEFT);
		labelCustom.setFont(new Font("Tahoma", Font.BOLD, 30));
		labelCustom.setBounds(39, 241, 656, 54);
		withdrawalPanel1.add(labelCustom);

		textBox = screen.addTextField(40, 295);
		textBox.setFont(new Font("Tahoma", Font.BOLD, 30));
		withdrawalPanel1.add(textBox);

		withdrawalPanel2 = new JPanel();
		withdrawalPanel2.setBackground(new Color(255, 128, 128));
		withdrawalPanel2.setBounds(133, 30, 756, 400);
		withdrawalPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		withdrawalPanel2.setLayout(null);

		JLabel labelCash = new JLabel("Please take your cash now.");
		labelCash.setBounds(104, 182, 526, 54);
		labelCash.setHorizontalAlignment(SwingConstants.CENTER);
		labelCash.setFont(new Font("Tahoma", Font.BOLD, 30));
		withdrawalPanel2.add(labelCash);
	}

	public JPanel getPanel1() {
		return withdrawalPanel1;
	}

	public JPanel getPanel2() {
		return withdrawalPanel2;
	}

	public int getAmount(Keypad keypad) {
		lock = false;
		do {
			if (chosen) {
				textBox.setText(input);
				System.out.print("");
				keypad.reset();
				chosen = false;
			}
			input = keypad.getNum();
			if (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED))
					&& !input.equals("")) {
				textBox.setText(input);
				System.out.print("");
			}
		} while (!input.equals(Integer.toString(Keypad.ENTER)) && !input.equals(Integer.toString(Keypad.CANCELED)));
		lock = true;

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
