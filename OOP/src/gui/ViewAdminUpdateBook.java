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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Cursor;
import javax.swing.DefaultComboBoxModel;

public class ViewAdminUpdateBook extends JFrame 
{
	private JPanel contentPane;
	private JTextField bookIDField;
	private JTextField authorField;
	private JTextField titleField;
	private JTextField bookIDField2;
	private JTextField copyIDField;
	private JTextField bookIDField3;
	private JTextField copyIDField3;
	private JTextField bookIDField4;
	private JButton searchCopyButton;
	private JButton renewButton;
	private JButton searchBookButton;

	
	public ViewAdminUpdateBook(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel updateBookLabel = new JLabel("Update Book");
		updateBookLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		updateBookLabel.setBounds(331, 106, 194, 32);
		contentPane.add(updateBookLabel);
		
		JLabel bookIDLabel = new JLabel("Enter Book ID");
		bookIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		bookIDLabel.setBounds(30, 164, 154, 41);
		contentPane.add(bookIDLabel);
		
		bookIDField = new JTextField();
		bookIDField.setBounds(194, 169, 165, 25);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);
		
		searchBookButton = new JButton("");
		searchBookButton.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/transparency.png")));
		searchBookButton.setBounds(298, 205, 61, 25);
		contentPane.add(searchBookButton);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		titleLabel.setBounds(30, 291, 133, 32);
		contentPane.add(titleLabel);
		
		JLabel authorLabel = new JLabel("Author");
		authorLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		authorLabel.setBounds(30, 338, 95, 32);
		contentPane.add(authorLabel);
		
		authorField = new JTextField();
		authorField.setBounds(194, 339, 165, 25);
		contentPane.add(authorField);
		authorField.setColumns(10);
		
		titleField = new JTextField();
		titleField.setBounds(194, 292, 164, 25);
		contentPane.add(titleField);
		titleField.setColumns(10);
		
		JLabel copyIDLabel = new JLabel("Enter Copy ID");
		copyIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		copyIDLabel.setBounds(445, 219, 133, 32);
		contentPane.add(copyIDLabel);
		
		bookIDField2 = new JTextField();
		bookIDField2.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		bookIDField2.setBounds(620, 169, 165, 25);
		contentPane.add(bookIDField2);
		bookIDField2.setColumns(10);
		
		JLabel statusLabel = new JLabel("Status");
		statusLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		statusLabel.setBounds(445, 378, 111, 32);
		contentPane.add(statusLabel);
		
		JComboBox statusComboBox = new JComboBox();
		statusComboBox.setModel(new DefaultComboBoxModel(new String[] {null,"Broken", "Available"}));
		statusComboBox.setBounds(620, 379, 165, 25);
		contentPane.add(statusComboBox);
		
		renewButton = new JButton("Renew");
		renewButton.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/refresh.png")));
		renewButton.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		renewButton.setBounds(216, 409, 145, 41);
		contentPane.add(renewButton);
		
		JLabel updateBookIcon = new JLabel("");
		updateBookIcon.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/magic-book_4.png")));
		updateBookIcon.setBounds(368, 11, 105, 84);
		contentPane.add(updateBookIcon);
		
		searchCopyButton = new JButton("");
		searchCopyButton.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/transparency.png")));
		searchCopyButton.setBounds(719, 251, 61, 25);
		contentPane.add(searchCopyButton);
		
		JButton renewButton2 = new JButton("Renew");
		renewButton2.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/refresh.png")));
		renewButton2.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		renewButton2.setBounds(640, 423, 145, 41);
		contentPane.add(renewButton2);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		quitButton.setIcon(new ImageIcon(ViewAdminUpdateBook.class.getResource("/png/exit_1.png")));
		quitButton.setBounds(640, 475, 145, 41);
		contentPane.add(quitButton);
		
		copyIDField = new JTextField();
		copyIDField.setBounds(620, 220, 165, 25);
		contentPane.add(copyIDField);
		copyIDField.setColumns(10);
		
		JLabel bookIDLabel2 = new JLabel("Enter Book ID");
		bookIDLabel2.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		bookIDLabel2.setBounds(445, 169, 164, 32);
		contentPane.add(bookIDLabel2);
		
		JLabel bookIDLabel3 = new JLabel("Book ID");
		bookIDLabel3.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		bookIDLabel3.setBounds(445, 304, 101, 24);
		contentPane.add(bookIDLabel3);
		
		bookIDField3 = new JTextField();
		bookIDField3.setEditable(false);
		bookIDField3.setBounds(694, 303, 86, 20);
		contentPane.add(bookIDField3);
		bookIDField3.setColumns(10);
		
		JLabel copyIDLabel2 = new JLabel("Copy ID");
		copyIDLabel2.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		copyIDLabel2.setBounds(445, 338, 91, 32);
		contentPane.add(copyIDLabel2);
		
		copyIDField3 = new JTextField();
		copyIDField3.setEditable(false);
		copyIDField3.setBounds(694, 341, 86, 20);
		contentPane.add(copyIDField3);
		copyIDField3.setColumns(10);
		
		JLabel bookIDLabel4 = new JLabel("Book ID");
		bookIDLabel4.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		bookIDLabel4.setBounds(30, 255, 95, 25);
		contentPane.add(bookIDLabel4);
		
		bookIDField4 = new JTextField();
		bookIDField4.setEditable(false);
		bookIDField4.setBounds(273, 251, 86, 20);
		contentPane.add(bookIDField4);
		bookIDField4.setColumns(10);
		
		titleField.setEnabled(false);
		authorField.setEnabled(false);
		statusComboBox.setEnabled(false);

		ActionListener actionListener = new UpdateBookQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener);

		ActionListener actionListener2 = new UpdateBookSearchBookButtonListener (bookIDField, titleField, authorField,bookIDField4);
		searchBookButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new UpdateBookRenewBookButtonListener (bookIDField4, titleField, authorField);
		renewButton.addActionListener(actionListener3);
		
		ActionListener actionListener4 = new UpdateBookRenewCopyButtonListener(bookIDField3,copyIDField3,statusComboBox);
		renewButton2.addActionListener(actionListener4);

		ActionListener actionListener5 = new UpdateBookSearchCopyButtonListener (bookIDField2, copyIDField, statusComboBox,bookIDField3,copyIDField3);
		searchCopyButton.addActionListener(actionListener5);
		
		setComponentName();
	}
	public void setComponentName() {
		bookIDField.setName("bookID");
		authorField.setName("author");
		titleField.setName("title");
		searchBookButton.setName("search");
		renewButton.setName("renew");
	}
}
