package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewBookReturn extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rentalIDField;
	private JTextField customerNameField;
	private JTextField expectedDateField;
	private JTextField returnDateField;
	private JTextField rentalIDField2;
	private JButton searchButton;

	public ViewBookReturn(User user)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel bookReturnLabel = new JLabel("Book Return");
		bookReturnLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		bookReturnLabel.setBounds(330, 107, 257, 66);
		contentPane.add(bookReturnLabel);
		
		JLabel EnterRentalIDLabel = new JLabel("Enter Rental ID");
		EnterRentalIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		EnterRentalIDLabel.setBounds(67, 168, 165, 42);
		contentPane.add(EnterRentalIDLabel);
		
		rentalIDField = new JTextField();
		rentalIDField.setBounds(367, 175, 296, 23);
		contentPane.add(rentalIDField);
		rentalIDField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Customer Name");
		nameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		nameLabel.setBounds(67, 262, 174, 42);
		contentPane.add(nameLabel);
		
		customerNameField = new JTextField();
		customerNameField.setEditable(false);
		customerNameField.setBounds(367, 269, 296, 23);
		contentPane.add(customerNameField);
		customerNameField.setColumns(10);
		
		JLabel expectedDateLabel = new JLabel("Expected Date");
		expectedDateLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		expectedDateLabel.setBounds(67, 319, 149, 23);
		contentPane.add(expectedDateLabel);
		
		JLabel returnDateLabel = new JLabel("Return Date");
		returnDateLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		returnDateLabel.setBounds(67, 353, 149, 49);
		contentPane.add(returnDateLabel);
		
		expectedDateField = new JTextField();
		expectedDateField.setEditable(false);
		expectedDateField.setBounds(367, 316, 296, 23);
		contentPane.add(expectedDateField);
		expectedDateField.setColumns(10);
		
		returnDateField = new JTextField();
		returnDateField.setEditable(false);
		returnDateField.setBounds(367, 363, 296, 23);
		contentPane.add(returnDateField);
		returnDateField.setColumns(10);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewBookReturn.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		quitButton.setBounds(537, 459, 149, 42);
		contentPane.add(quitButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setIcon(new ImageIcon(ViewBookReturn.class.getResource("/png/refresh.png")));
		updateButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		updateButton.setBounds(67, 459, 149, 42);
		contentPane.add(updateButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewBookReturn.class.getResource("/png/magic-book_4.png")));
		lblNewLabel.setBounds(354, 27, 118, 92);
		contentPane.add(lblNewLabel);
		
		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(ViewBookReturn.class.getResource("/png/transparency.png")));
		searchButton.setBounds(675, 175, 64, 23);
		contentPane.add(searchButton);
		
		JLabel rentalIDLabel = new JLabel("Rental ID");
		rentalIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		rentalIDLabel.setBounds(67, 221, 139, 30);
		contentPane.add(rentalIDLabel);
		
		rentalIDField2 = new JTextField();
		rentalIDField2.setEditable(false);
		rentalIDField2.setBounds(367, 222, 139, 23);
		contentPane.add(rentalIDField2);
		rentalIDField2.setColumns(10);
		
		ActionListener actionListener = new BookReturnQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener);

		ActionListener actionListener2 = new BookReturnSearchButtonListener (rentalIDField,customerNameField,expectedDateField,returnDateField, rentalIDField2);
		searchButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new BookReturnUpdateButtonListener (rentalIDField2,customerNameField,expectedDateField,returnDateField, user);
		updateButton.addActionListener(actionListener3);
		
		setComponentNames();
	}
	
	private void setComponentNames() {
		searchButton.setName("search");
		rentalIDField.setName("rentalID");
	}
}
