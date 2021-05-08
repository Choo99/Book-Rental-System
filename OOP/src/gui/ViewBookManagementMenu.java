 package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class ViewBookManagementMenu extends JFrame
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewBookManagementMenu(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel bookManagementLabel = new JLabel("Book Management");
		bookManagementLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		bookManagementLabel.setBounds(316, 177, 303, 59);
		contentPane.add(bookManagementLabel);
		
		JButton addBookButton = new JButton("Add Book");
		addBookButton.setIcon(new ImageIcon(ViewBookManagementMenu.class.getResource("/png/magic-book_2.png")));
		addBookButton.setMargin(new Insets(12, 14, 2, 14));
		addBookButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		addBookButton.setBounds(65, 258, 295, 51);
		contentPane.add(addBookButton);
		
		JButton viewBookButton = new JButton("View Book Information");
		viewBookButton.setIcon(new ImageIcon(ViewBookManagementMenu.class.getResource("/png/list.png")));
		viewBookButton.setMargin(new Insets(12, 14, 2, 14));
		viewBookButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		viewBookButton.setBounds(447, 258, 295, 51);
		contentPane.add(viewBookButton);
		
		JButton bookManagementQuitButton = new JButton("Quit");
		bookManagementQuitButton.setIcon(new ImageIcon(ViewBookManagementMenu.class.getResource("/png/exit_1.png")));
		bookManagementQuitButton.setMargin(new Insets(12, 14, 2, 14));
		bookManagementQuitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		bookManagementQuitButton.setBounds(448, 357, 294, 59);
		contentPane.add(bookManagementQuitButton);
		
		JButton updateBookButton = new JButton("Update Book");
		updateBookButton.setIcon(new ImageIcon(ViewBookManagementMenu.class.getResource("/png/refresh.png")));
		updateBookButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		updateBookButton.setMargin(new Insets(12, 14, 2, 14));
		updateBookButton.setBounds(65, 361, 295, 51);
		contentPane.add(updateBookButton);
		
		JLabel bookManagementIcon = new JLabel("");
		bookManagementIcon.setIcon(new ImageIcon(ViewBookManagementMenu.class.getResource("/png/magic-book_3.png")));
		bookManagementIcon.setBounds(348, 36, 134, 130);
		contentPane.add(bookManagementIcon);
		
		ActionListener actionListener = new BookManagementQuitButtonListener(this,user);
		bookManagementQuitButton.addActionListener(actionListener);
		
		ActionListener actionListener3 = new BookManagementAddBookButtonListener (this,user);
		addBookButton.addActionListener(actionListener3);
		
		ActionListener actionListener4 = new BookManagementUpdateButtonListener (this, user);
		updateBookButton.addActionListener(actionListener4); 

		ActionListener actionListener5 = new BookManagementViewBookButtonListener (this, user);
		viewBookButton.addActionListener(actionListener5);
	}
}
