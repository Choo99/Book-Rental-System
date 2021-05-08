package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Insets;

public class ViewLogIn extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userIDField;
	private JPasswordField passwordField;
	private JButton LogInButton;

	public ViewLogIn(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel LogInTittle = new JLabel("Log In");
		LogInTittle.setBounds(358, 225, 98, 48);
		LogInTittle.setFont(new Font("Palatino Linotype", Font.BOLD, 27));
		
		JLabel userIDLabel = new JLabel("User ID");
		userIDLabel.setBounds(278, 292, 164, 35);
		userIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(278, 353, 128, 35);
		passwordLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		
		userIDField = new JTextField();
		userIDField.setBounds(478, 287, 162, 31);
		userIDField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userIDField.setColumns(10);
		
		LogInButton = new JButton("Log In");
		LogInButton.setMargin(new Insets(8, 14, 2, 14));
		LogInButton.setBounds(216, 431, 135, 48);
		LogInButton.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(478, 348, 162, 32);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel pinkFlowerIcon = new JLabel("");
		pinkFlowerIcon.setBounds(219, 287, 32, 32);
		pinkFlowerIcon.setIcon(new ImageIcon(ViewLogIn.class.getResource("/png/pink-cosmos.png")));
		
		JLabel loginIcon = new JLabel("");
		loginIcon.setBounds(342, 72, 128, 128);
		loginIcon.setIcon(new ImageIcon(ViewLogIn.class.getResource("/png/register.png")));
		
		JLabel icon2 = new JLabel("");
		icon2.setBounds(219, 348, 32, 32);
		icon2.setIcon(new ImageIcon(ViewLogIn.class.getResource("/png/pink-cosmos.png")));
		
		contentPane.setLayout(null);
		contentPane.add(pinkFlowerIcon);
		contentPane.add(icon2);
		contentPane.add(LogInButton);
		contentPane.add(loginIcon);
		contentPane.add(passwordLabel);
		contentPane.add(userIDLabel);
		contentPane.add(passwordField);
		contentPane.add(userIDField);
		contentPane.add(LogInTittle);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setMargin(new Insets(8, 14, 2, 14));
		quitButton.setIcon(new ImageIcon(ViewLogIn.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.PLAIN, 25));
		quitButton.setBounds(505, 431, 135, 48);
		contentPane.add(quitButton);
		
		ActionListener actionListener = new LogInButtonListener(this,userIDField,passwordField,user);
		LogInButton.addActionListener(actionListener); 		
		
		ActionListener actionListener2 = new LogInQuitButtonListener(this, user);
		quitButton.addActionListener(actionListener2); 
		
		setComponentName();
	}
	
	private void setComponentName(){
		userIDField.setName("userID");
		passwordField.setName("password");
		LogInButton.setName("login");
	}
}
