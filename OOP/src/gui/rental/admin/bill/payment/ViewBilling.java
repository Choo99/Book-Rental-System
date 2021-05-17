package gui.rental.admin.bill.payment;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.UIManager;

public class ViewBilling extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rentalIDField;
	private JTextField nameField;
	private JTextField currentDateField;
	private JTextField expectedField;
	private JTextField rentalFeeField;
	private JTextField rentalIDField2;

	public ViewBilling(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel paymentIcon = new JLabel("");
		paymentIcon.setIcon(new ImageIcon(ViewBilling.class.getResource("/png/calculate.png")));
		paymentIcon.setBounds(380, 11, 81, 90);
		contentPane.add(paymentIcon);

		JButton printButton = new JButton("Print");
		printButton.setMargin(new Insets(8, 14, 2, 14));
		printButton.setIcon(new ImageIcon(ViewBilling.class.getResource("/png/printer.png")));
		printButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		printButton.setBackground(UIManager.getColor("Button.background"));
		printButton.setBounds(349, 442, 126, 41);
		contentPane.add(printButton);

		JLabel enterRentalIDLabel = new JLabel("Enter Rental ID");
		enterRentalIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		enterRentalIDLabel.setBounds(173, 156, 174, 23);
		contentPane.add(enterRentalIDLabel);

		rentalIDField = new JTextField();
		rentalIDField.setBounds(481, 156, 155, 25);
		contentPane.add(rentalIDField);
		rentalIDField.setColumns(10);

		JLabel customerNameLabel = new JLabel("Customer Name");
		customerNameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		customerNameLabel.setBounds(173, 249, 137, 20);
		contentPane.add(customerNameLabel);

		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBounds(481, 245, 155, 23);
		contentPane.add(nameField);
		nameField.setColumns(10);

		JButton searchButton = new JButton("");

		searchButton.setIcon(new ImageIcon(ViewBilling.class.getResource("/png/transparency.png")));
		searchButton.setBounds(671, 156, 49, 23);
		contentPane.add(searchButton);

		JLabel cuteIcon = new JLabel("");
		cuteIcon.setIcon(new ImageIcon(ViewBilling.class.getResource("/png/avatar_2.png")));
		cuteIcon.setBounds(0, 399, 368, 264);
		contentPane.add(cuteIcon);

		JLabel currentDateLabel = new JLabel("Current Date");
		currentDateLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		currentDateLabel.setBounds(173, 289, 126, 29);
		contentPane.add(currentDateLabel);

		currentDateField = new JTextField();
		currentDateField.setEditable(false);
		currentDateField.setBounds(481, 289, 155, 23);
		contentPane.add(currentDateField);
		currentDateField.setColumns(10);

		JLabel expectedReturnDateLabel = new JLabel("Expected Return Date");
		expectedReturnDateLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		expectedReturnDateLabel.setBounds(171, 338, 197, 23);
		contentPane.add(expectedReturnDateLabel);

		expectedField = new JTextField();
		expectedField.setEditable(false);
		expectedField.setBounds(481, 335, 155, 23);
		contentPane.add(expectedField);
		expectedField.setColumns(10);

		rentalFeeField = new JTextField();
		rentalFeeField.setEditable(false);
		rentalFeeField.setBounds(481, 380, 155, 23);
		contentPane.add(rentalFeeField);
		rentalFeeField.setColumns(10);

		JLabel rentalFeeLabel = new JLabel("Rental Fee");
		rentalFeeLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		rentalFeeLabel.setBounds(173, 380, 137, 29);
		contentPane.add(rentalFeeLabel);

		JLabel lblNewLabel_7 = new JLabel("Payment");
		lblNewLabel_7.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		lblNewLabel_7.setBounds(367, 104, 126, 41);
		contentPane.add(lblNewLabel_7);

		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewBilling.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		quitButton.setBounds(594, 445, 126, 41);
		contentPane.add(quitButton);

		JLabel rentalIDLabel2 = new JLabel("Rental ID");
		rentalIDLabel2.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		rentalIDLabel2.setBounds(173, 206, 150, 24);
		contentPane.add(rentalIDLabel2);

		rentalIDField2 = new JTextField();
		rentalIDField2.setEditable(false);
		rentalIDField2.setBounds(481, 208, 155, 22);
		contentPane.add(rentalIDField2);
		rentalIDField2.setColumns(10);

		ActionListener actionlistener = new PaymentSearchButtonListener(rentalIDField, nameField, currentDateField,
				expectedField, rentalFeeField, printButton, rentalIDField2);
		searchButton.addActionListener(actionlistener);

		ActionListener actionlistener2 = new PaymentQuitButtonListener(this, user);
		quitButton.addActionListener(actionlistener2);

		ActionListener actionlistener3 = new PaymentPrintButtonListener(this, rentalIDField2, user);
		printButton.addActionListener(actionlistener3);
	}
}
