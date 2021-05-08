package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RentalController;
import model.Rental;
import model.User;

public class ViewOverdueFeeReceipt extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField durationField;
	private JTextField dateField;
	private JTextField amountField;

	 public ViewOverdueFeeReceipt(Rental rental, User user)
	 {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel receiptLabel = new JLabel("Overdue Fee Receipt");
		receiptLabel.setBounds(175, 232, 234, 40);
		receiptLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		contentPane.add(receiptLabel);		
		
		JLabel shopNameLabel = new JLabel("Pisces Rental Shop");
		shopNameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		shopNameLabel.setBounds(209, 190, 153, 31);
		contentPane.add(shopNameLabel);
		
		JLabel thankYouLabel = new JLabel("Thank You!");
		thankYouLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		thankYouLabel.setBounds(227, 457, 135, 31);
		contentPane.add(thankYouLabel);
		
		JLabel noticeLabel = new JLabel("*Fines might be charge if the book does not return on time");
		noticeLabel.setIcon(new ImageIcon(ViewReceipt.class.getResource("/png/avatar_1.png")));
		noticeLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		noticeLabel.setBounds(114, 482, 332, 31);
		contentPane.add(noticeLabel);
		
		JLabel rentalShopIcon = new JLabel("");
		rentalShopIcon.setIcon(new ImageIcon(ViewReceipt.class.getResource("/png/magical_1.png")));
		rentalShopIcon.setBounds(209, 40, 135, 139);
		contentPane.add(rentalShopIcon);
		
		JButton okButton = new JButton("OK");
		okButton.setBounds(227, 524, 89, 23);
		contentPane.add(okButton);
		
		JLabel totalLabel = new JLabel("Total ");
		totalLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		totalLabel.setBounds(291, 415, 71, 31);
		contentPane.add(totalLabel);
		
		JLabel durationLabel = new JLabel("Duration");
		durationLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 19));
		durationLabel.setBounds(88, 327, 135, 31);
		contentPane.add(durationLabel);
		
		durationField = new JTextField();
		durationField.setEditable(false);
		durationField.setBounds(303, 328, 162, 23);
		contentPane.add(durationField);
		durationField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setBounds(368, 276, 97, 23);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		amountField = new JTextField();
		amountField.setEditable(false);
		amountField.setBounds(379, 416, 86, 23);
		contentPane.add(amountField);
		amountField.setColumns(10);

		setData(rental);

		ActionListener actionListener = new ReceiptOkButtonListener(this,user);
		okButton.addActionListener(actionListener);
	}

	public void setData(Rental rental)
	{
		RentalController rentalController = new RentalController();
		int duration = rentalController.differentDate(rental.getExpectedDate(), rentalController.currentDate());

		dateField.setText(rentalController.currentDate());
		durationField.setText(String.valueOf(duration));
		amountField.setText(String.valueOf(rental.getOverdueFee()));
	}
}
