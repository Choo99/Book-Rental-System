package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class ViewAdminMenu extends JFrame 
{
	private JPanel contentPane;

	public ViewAdminMenu(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel adminMenuLabel = new JLabel("Admin Menu");
		adminMenuLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		adminMenuLabel.setBounds(328, 152, 228, 65);
		contentPane.add(adminMenuLabel);
		
		JButton bookButton = new JButton("Book Management");
		bookButton.setIcon(new ImageIcon(ViewAdminMenu.class.getResource("/png/magic-book_2.png")));
		bookButton.setMargin(new Insets(10, 14, 2, 14));
		bookButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		bookButton.setBounds(90, 228, 263, 55);
		contentPane.add(bookButton);
		
		JButton rentalButton = new JButton("Rental Management");
		rentalButton.setIcon(new ImageIcon(ViewAdminMenu.class.getResource("/png/real-estate_2.png")));
		rentalButton.setMargin(new Insets(10, 14, 2, 14));
		rentalButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		rentalButton.setBounds(90, 377, 263, 55);
		contentPane.add(rentalButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewAdminMenu.class.getResource("/png/exit_1.png")));
		quitButton.setMargin(new Insets(10, 14, 2, 14));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));

		quitButton.setBounds(475, 377, 263, 55);
		contentPane.add(quitButton);
		
		JButton updateButton = new JButton("Update Account");
		updateButton.setIcon(new ImageIcon(ViewAdminMenu.class.getResource("/png/refresh.png")));
		updateButton.setMargin(new Insets(10, 14, 2, 14));
		updateButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));

		updateButton.setBounds(475, 227, 263, 57);
		contentPane.add(updateButton);
		
		JLabel adminIcon = new JLabel("");
		adminIcon.setIcon(new ImageIcon(ViewAdminMenu.class.getResource("/png/administrator.png")));
		adminIcon.setBounds(337, 11, 142, 151);
		contentPane.add(adminIcon);
		
		ActionListener actionListener1 = new AdminQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener1);
		
		ActionListener actionListener2 = new AdminBookManagementButtonListener (this,user);
		bookButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new AdminRentalManagementButtonListener (this,user);
		rentalButton.addActionListener(actionListener3);
		
		ActionListener actionListener4 = new AdminMenuUpdateButtonListener(this,user);
		updateButton.addActionListener(actionListener4);
	}
}
