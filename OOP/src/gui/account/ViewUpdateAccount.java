package gui.account;

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

public class ViewUpdateAccount extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userIDField;
	private JTextField nameField;
	private JTextField phoneNumberField;
	private JTextField userIDField2;

	public ViewUpdateAccount(User user) 
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
		
		JLabel updateAccountLabel = new JLabel("Update Account");
		updateAccountLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		updateAccountLabel.setBounds(339, 60, 239, 57);
		contentPane.add(updateAccountLabel);
		
		JLabel userIDLabel = new JLabel("Enter User ID");
		userIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		userIDLabel.setBounds(152, 128, 211, 44);
		contentPane.add(userIDLabel);
		
		userIDField = new JTextField();
		userIDField.setBounds(400, 135, 247, 25);
		contentPane.add(userIDField);
		userIDField.setColumns(10);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		nameLabel.setBounds(152, 224, 131, 44);
		contentPane.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(400, 231, 247, 25);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel phoneNumberLabel = new JLabel("Phone Number");
		phoneNumberLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		phoneNumberLabel.setBounds(152, 265, 156, 44);
		contentPane.add(phoneNumberLabel);
		
		phoneNumberField = new JTextField();
		phoneNumberField.setBounds(400, 272, 247, 25);
		contentPane.add(phoneNumberField);
		phoneNumberField.setColumns(10);
		
		JButton searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(ViewUpdateAccount.class.getResource("/png/transparency.png")));
		searchButton.setBounds(669, 135, 69, 25);
		contentPane.add(searchButton);
		
		JButton updateButton = new JButton("Update");
		updateButton.setIcon(new ImageIcon(ViewUpdateAccount.class.getResource("/png/refresh.png")));
		updateButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		updateButton.setBounds(152, 363, 131, 44);
		contentPane.add(updateButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewUpdateAccount.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		quitButton.setBounds(516, 363, 131, 44);
		contentPane.add(quitButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewUpdateAccount.class.getResource("/png/avatar_2.png")));
		lblNewLabel.setBounds(46, 418, 327, 134);
		contentPane.add(lblNewLabel);
		
		JLabel userIDLabel2 = new JLabel("User ID");
		userIDLabel2.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		userIDLabel2.setBounds(152, 183, 131, 42);
		contentPane.add(userIDLabel2);
		
		userIDField2 = new JTextField();
		userIDField2.setEditable(false);
		userIDField2.setBounds(400, 189, 131, 25);
		contentPane.add(userIDField2);
		userIDField2.setColumns(10);

		ActionListener actionListener = new UpdateAccountQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener);
		
		ActionListener actionListener2 = new UpdateAccountSearchButtonListener(userIDField,nameField,phoneNumberField,userIDField2);
		searchButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new UpdateAccountRenewButtonListener(userIDField2,nameField,phoneNumberField);
		updateButton.addActionListener(actionListener3);
		
	}
}
