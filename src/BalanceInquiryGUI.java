import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class BalanceInquiryGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel balanceInquiryPanel;

	public BalanceInquiryGUI(double availableBalance, double totalBalance, Screen screen) {

		balanceInquiryPanel = new JPanel();
		balanceInquiryPanel.setBackground(new Color(255, 128, 128));
		balanceInquiryPanel.setBounds(133, 30, 756, 400);
		balanceInquiryPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		balanceInquiryPanel.setLayout(null);

		JLabel lblBalanceInfo = new JLabel("Balance Information");
		lblBalanceInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalanceInfo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBalanceInfo.setBounds(163, 56, 417, 75);
		balanceInquiryPanel.add(lblBalanceInfo);

		JLabel lblAvailable = new JLabel("- Available balance: " + availableBalance);
		lblAvailable.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAvailable.setBounds(99, 199, 544, 75);
		balanceInquiryPanel.add(lblAvailable);

		JLabel lblTotal = new JLabel("- Total balance: " + totalBalance);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTotal.setBounds(99, 272, 544, 75);
		balanceInquiryPanel.add(lblTotal);
	}

	public JPanel getPanel() {
		return balanceInquiryPanel;
	}

}