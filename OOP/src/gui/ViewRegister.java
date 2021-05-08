package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import model.User;

public class ViewRegister extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField ICField;
	private JTextField phoneField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton registerButton;
	private User user;
	
	public ViewRegister() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel userRegisterLabel = new JLabel("Register");
		userRegisterLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 28));
		userRegisterLabel.setBounds(361, 70, 132, 36);
		contentPane.add(userRegisterLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		nameLabel.setBounds(147, 171, 71, 19);
		contentPane.add(nameLabel);
		
		JLabel ICLabel = new JLabel("Identity Number");
		ICLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		ICLabel.setBounds(147, 215, 176, 17);
		contentPane.add(ICLabel);
		
		JLabel phoneLabel = new JLabel("Phone Number");
		phoneLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		phoneLabel.setBounds(147, 262, 145, 19);
		contentPane.add(phoneLabel);
		
		nameField = new JTextField();
		nameField.setBounds(475, 172, 217, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		ICField = new JTextField();
		ICField.setBounds(475, 215, 217, 20);
		contentPane.add(ICField);
		ICField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(475, 263, 217, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel roleLabel = new JLabel("Role");
		roleLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		roleLabel.setBounds(147, 312, 73, 20);
		contentPane.add(roleLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		passwordLabel.setBounds(147, 356, 122, 24);
		contentPane.add(passwordLabel);
		
		JComboBox roleComboBox = new JComboBox();
		roleComboBox.setFont(new Font("Nunito", Font.BOLD, 14));
		roleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Customer"}));
		roleComboBox.setBounds(475, 313, 217, 22);
		contentPane.add(roleComboBox);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setMargin(new Insets(9, 14, 2, 14));
		cancelButton.setFont(new Font("Palatino Linotype", Font.BOLD, 21));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cancelButton.setBounds(562, 454, 132, 45);
		contentPane.add(cancelButton);

		
		registerButton = new JButton("Register");
		registerButton.setMargin(new Insets(9, 14, 2, 14));
		registerButton.setFont(new Font("Palatino Linotype", Font.BOLD, 21));
		registerButton.setBounds(137, 454, 132, 45);
		contentPane.add(registerButton);
		
		JLabel logo1 = new JLabel("");
		logo1.setIcon(new ImageIcon(ViewRegister.class.getResource("/png/kitty_1.png")));
		logo1.setBounds(243, 36, 80, 72);
		contentPane.add(logo1);
		
		JLabel comfirmPasswordLabel = new JLabel("Comfirm Password");
		comfirmPasswordLabel.setFont(new Font("FangSong", Font.BOLD, 20));
		comfirmPasswordLabel.setBounds(147, 402, 217, 24);
		contentPane.add(comfirmPasswordLabel);
		
		JLabel logo2 = new JLabel("");
		logo2.setIcon(new ImageIcon(ViewRegister.class.getResource("/png/kitty_2.png")));
		logo2.setBounds(517, 36, 71, 72);
		contentPane.add(logo2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(475, 360, 217, 19);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(475, 406, 217, 19);
		contentPane.add(passwordField_1);
		
		ActionListener actionListener = new RegisterButtonListener(this,nameField,ICField, phoneField, passwordField, passwordField_1,roleComboBox );
		registerButton.addActionListener(actionListener);

		ActionListener actionListener2 = new RegisterQuitButton(this,user);
		cancelButton.addActionListener(actionListener2);
		
		setComponentName();
	}
	
	private void setComponentName() {
		
		nameField.setName("name");
		ICField.setName("ic");;
		phoneField.setName("phone");
		passwordField.setName("password");
		passwordField_1.setName("password2");
		registerButton.setName("registerBtn");
		
	}
}
