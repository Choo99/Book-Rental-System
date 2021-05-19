package gui.account.customer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.UserController;
import model.User;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ViewAccountSetting extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userIDField;
	private JTextField nameField;
	private JTextField ICField;
	private JTextField phoneField;
	private JButton searchPasswordBtn;
	private JPasswordField oldPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;
	private User user;

	public ViewAccountSetting(User user) {
		
		this.user = user;
		
		setLocationRelativeTo(null);
		
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		getContentPane().setBackground(new Color(255, 240, 245));
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JLabel accountLabel = new JLabel("Account Setting");
		accountLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		accountLabel.setBounds(333, 47, 145, 55);
		getContentPane().add(accountLabel);
		
		JLabel UserIDLabel = new JLabel("User ID");
		UserIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserIDLabel.setBounds(251, 164, 67, 25);
		getContentPane().add(UserIDLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nameLabel.setBounds(266, 212, 52, 25);
		getContentPane().add(nameLabel);
		
		JLabel icLabel = new JLabel("IC Number");
		icLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		icLabel.setBounds(225, 259, 104, 25);
		getContentPane().add(icLabel);
		
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phoneLabel.setBounds(193, 308, 136, 25);
		getContentPane().add(phoneLabel);
		
		JLabel oldPasswordLabel = new JLabel("Old Password");
		oldPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oldPasswordLabel.setBounds(198, 358, 120, 25);
		getContentPane().add(oldPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New Password");
		newPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newPasswordLabel.setBounds(189, 416, 129, 25);
		getContentPane().add(newPasswordLabel);
		
		JLabel confirmPasswordLabel = new JLabel("Confirm Password");
		confirmPasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirmPasswordLabel.setBounds(148, 462, 170, 25);
		getContentPane().add(confirmPasswordLabel);
		
		searchPasswordBtn = new JButton("Search");
		searchPasswordBtn.setBounds(519, 363, 89, 23);
		getContentPane().add(searchPasswordBtn);
		
		oldPasswordField = new JPasswordField();
		oldPasswordField.setBounds(393, 364, 85, 20);
		getContentPane().add(oldPasswordField);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setEditable(false);
		newPasswordField.setBounds(392, 422, 86, 20);
		getContentPane().add(newPasswordField);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setEditable(false);
		confirmPasswordField.setBounds(396, 468, 82, 20);
		getContentPane().add(confirmPasswordField);
		
		userIDField = new JTextField();
		userIDField.setEditable(false);
		userIDField.setBounds(392, 164, 86, 20);
		getContentPane().add(userIDField);
		userIDField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(392, 218, 86, 20);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		ICField = new JTextField();
		ICField.setBounds(392, 265, 86, 20);
		getContentPane().add(ICField);
		ICField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(392, 314, 86, 20);
		getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(519, 421, 89, 23);
		getContentPane().add(updateBtn);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setBounds(645, 421, 89, 23);
		getContentPane().add(quitButton);
		
		ActionListener buttonListener = new AccountSettingQuitButtonListener(this,user);
		quitButton.addActionListener(buttonListener);
		
		ActionListener buttonListener2 = new AccountSearchPasswordButtonListener(this,user);
		searchPasswordBtn.addActionListener(buttonListener2);
		
		ActionListener buttonListener3 = new AccountUpdateButtonListener(this,user);
		updateBtn.addActionListener(buttonListener3);
		
		setInformation();
	}
	
	public JButton getSearchPasswordBtn() {
		return searchPasswordBtn;
	}

	public JTextField getUserIDField() {
		return userIDField;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JTextField getICField() {
		return ICField;
	}

	public JTextField getPhoneField() {
		return phoneField;
	}

	public JPasswordField getOldPasswordField() {
		return oldPasswordField;
	}

	public JPasswordField getNewPasswordField() {
		return newPasswordField;
	}

	public JPasswordField getConfirmPasswordField() {
		return confirmPasswordField;
	}
	
	public void setInformation() {
		UserController controller = new UserController();
		User user = controller.searchUserInfo(this.user.getUserID());
		
		userIDField.setText(Integer.toString(this.user.getUserID()));
		nameField.setText(user.getName());
		ICField.setText(user.getIC());
		phoneField.setText(user.getPhone());
	}
}
