package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewAdminRentalMenu extends JFrame 
{
	private JPanel contentPane;
	private User user;

	public ViewAdminRentalMenu(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel rentalMenuLabel = new JLabel("Rental Menu");
		rentalMenuLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 27));
		rentalMenuLabel.setBounds(345, 197, 243, 53);
		contentPane.add(rentalMenuLabel);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewAdminRentalMenu.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		quitButton.setBounds(537, 398, 183, 53);
		contentPane.add(quitButton);
		
		JButton returnBookButton = new JButton("Book Return");
		//record return time
		//print overdue receipt
		returnBookButton.setIcon(new ImageIcon(ViewAdminRentalMenu.class.getResource("/png/receipt_2.png")));
		returnBookButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		returnBookButton.setBounds(134, 398, 183, 53);
		contentPane.add(returnBookButton);
		
		JButton searchRentalButton = new JButton("Rental Search");
		searchRentalButton.setIcon(new ImageIcon(ViewAdminRentalMenu.class.getResource("/png/search_3.png")));
		searchRentalButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		searchRentalButton.setBounds(537, 292, 183, 53);
		contentPane.add(searchRentalButton);
		
		JButton rentalFeeButton = new JButton("Rental Fee");
		//enter rental ID
		//print receipt
		rentalFeeButton.setIcon(new ImageIcon(ViewAdminRentalMenu.class.getResource("/png/flying-money_2.png")));
		rentalFeeButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		rentalFeeButton.setBounds(134, 292, 183, 53);
		contentPane.add(rentalFeeButton);
		
		JLabel rentalMenuIcon = new JLabel("");
		rentalMenuIcon.setIcon(new ImageIcon(ViewAdminRentalMenu.class.getResource("/png/rent_1.png")));
		rentalMenuIcon.setBounds(351, 28, 183, 141);
		contentPane.add(rentalMenuIcon);

		ActionListener actionListener = new RentalMenuQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener);

		ActionListener actionListener2 = new RentalMenuRentalSearchButtonListener (this,user);
		searchRentalButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new  RentalMenuPaymentButtonListener(this,user);
		rentalFeeButton.addActionListener(actionListener3);

		ActionListener actionListener4 = new RentalMenuBookReturnButtonListener(this,user);
		returnBookButton.addActionListener(actionListener4);
	}
}
