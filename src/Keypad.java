import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

public class Keypad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel keypadPanel;
	private boolean lock = true;
	public static final int DOT = -1, CANCELED = -999, CLEAR = -2, ENTER = -3, EMPTY = -888;
	private String input = "";
	private int decimal = 0;
	private boolean dotted = false;
	private boolean Int = false;

	public Keypad() {

		// Buttons for keypad
		JButton btn1 = new JButton();
		btn1.setBackground(new Color(230, 230, 230));
		btn1.setBounds(0, 0, 60, 50);
		btn1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn1.setText("1");
		btn1.setFocusable(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "1";
						decimal++;
					} else if (!dotted)
						input += "1";
				}

			}
		});

		JButton btn2 = new JButton();
		btn2.setBackground(new Color(230, 230, 230));
		btn2.setBounds(60, 0, 60, 50);
		btn2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2.setText("2");
		btn2.setFocusable(false);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "2";
						decimal++;
					} else if (!dotted)
						input += "2";
				}
			}
		});

		JButton btn3 = new JButton();
		btn3.setBackground(new Color(230, 230, 230));
		btn3.setBounds(120, 0, 60, 50);
		btn3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn3.setText("3");
		btn3.setFocusable(false);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "3";
						decimal++;
					} else if (!dotted)
						input += "3";
				}
			}
		});

		JButton btn4 = new JButton();
		btn4.setBackground(new Color(230, 230, 230));
		btn4.setBounds(0, 50, 60, 50);
		btn4.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn4.setText("4");
		btn4.setFocusable(false);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "4";
						decimal++;
					} else if (!dotted)
						input += "4";
				}
			}
		});

		JButton btn5 = new JButton();
		btn5.setBackground(new Color(230, 230, 230));
		btn5.setBounds(60, 50, 60, 50);
		btn5.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn5.setText("5");
		btn5.setFocusable(false);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "5";
						decimal++;
					} else if (!dotted)
						input += "5";
				}
			}
		});

		JButton btn6 = new JButton();
		btn6.setBackground(new Color(230, 230, 230));
		btn6.setBounds(120, 50, 60, 50);
		btn6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn6.setText("6");
		btn6.setFocusable(false);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "6";
						decimal++;
					} else if (!dotted)
						input += "6";
				}
			}
		});

		JButton btn7 = new JButton();
		btn7.setBackground(new Color(230, 230, 230));
		btn7.setBounds(0, 100, 60, 50);
		btn7.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn7.setText("7");
		btn7.setFocusable(false);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "7";
						decimal++;
					} else if (!dotted)
						input += "7";
				}
			}
		});

		JButton btn8 = new JButton();
		btn8.setBackground(new Color(230, 230, 230));
		btn8.setBounds(60, 100, 60, 50);
		btn8.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn8.setText("8");
		btn8.setFocusable(false);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "8";
						decimal++;
					} else if (!dotted)
						input += "8";
				}
			}
		});

		JButton btn9 = new JButton();
		btn9.setBackground(new Color(230, 230, 230));
		btn9.setBounds(120, 100, 60, 50);
		btn9.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn9.setText("9");
		btn9.setFocusable(false);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "9";
						decimal++;
					} else if (!dotted)
						input += "9";
				}
			}
		});

		JButton btn0 = new JButton();
		btn0.setBackground(new Color(230, 230, 230));
		btn0.setBounds(60, 150, 60, 50);
		btn0.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn0.setText("0");
		btn0.setFocusable(false);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (dotted && decimal < 2) {
						input += "0";
						decimal++;
					} else if (!dotted)
						input += "0";
				}
			}
		});

		JButton btnDot = new JButton();
		btnDot.setBackground(new Color(230, 230, 230));
		btnDot.setBounds(120, 150, 60, 50);
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDot.setText(".");
		btnDot.setFocusable(false);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					if (!dotted && !Int) {
						input += ".";
						dotted = true;
					}
				}
			}
		});

		JButton btnEmpty = new JButton();
		btnEmpty.setBackground(new Color(230, 230, 230));
		btnEmpty.setBounds(0, 150, 60, 50);
		btnEmpty.setText(" ");
		btnEmpty.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEmpty.setFocusable(false);

		JButton btnCancel = new JButton();
		btnCancel.setBackground(new Color(255, 74, 74));
		btnCancel.setBounds(200, 30, 100, 45);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setText("Cancel");
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = Integer.toString(CANCELED);
			}
		});

		JButton btnClear = new JButton();
		btnClear.setBackground(new Color(222, 255, 91));
		btnClear.setBounds(200, 75, 100, 45);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClear.setText("Clear");
		btnClear.setFocusable(false);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock) {
					input = "";
					decimal = 0;
					dotted = false;
				}
			}
		});

		JButton btnEnter = new JButton();
		btnEnter.setBackground(new Color(0, 174, 0));
		btnEnter.setBounds(200, 120, 100, 45);
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnter.setText("Enter");
		btnEnter.setFocusable(false);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lock)
					input = Integer.toString(ENTER);
			}
		});

		// Keypad Panel
		keypadPanel = new JPanel();
		keypadPanel.setBounds(375, 460, 300, 200);
		keypadPanel.setLayout(null);
		keypadPanel.add(btn1);
		keypadPanel.add(btn2);
		keypadPanel.add(btn3);
		keypadPanel.add(btn4);
		keypadPanel.add(btn5);
		keypadPanel.add(btn6);
		keypadPanel.add(btn7);
		keypadPanel.add(btn8);
		keypadPanel.add(btn9);
		keypadPanel.add(btn0);
		keypadPanel.add(btnDot);
		keypadPanel.add(btnEmpty);
		keypadPanel.add(btnCancel);
		keypadPanel.add(btnClear);
		keypadPanel.add(btnEnter);
	}

	public JPanel getPanel() {
		return keypadPanel;
	}

	public String getNum() {
		lock = false;
		Int = true;
		if (input.equals(Integer.toString(ENTER))) {
			reset();
			return Integer.toString(ENTER);
		} else if (input.equals(Integer.toString(CANCELED))) {
			reset();
			return Integer.toString(CANCELED);
		} else
			return input;
	}

	public void reset() {
		lock = true;
		dotted = false;
		Int = false;
		decimal = 0;
		input = "";
	}

	public String getAmount() {
		lock = false;
		if (input.equals(Integer.toString(ENTER))) {
			reset();
			return Integer.toString(ENTER);
		} else if (input.equals(Integer.toString(CANCELED))) {
			reset();
			return Integer.toString(CANCELED);
		}
		return input;
	}
}