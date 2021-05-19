package gui.book.admin.insert;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BookController;
import model.Book;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class ViewAdminAddBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField bookIDField;
	private JTextField bookNameField;
	private JTextField quantityField2;
	private JComboBox<String> bookTypeComboBox;
	private JTextField titleField;
	private JTextField authorField;
	private JTextField quantityField;

	private JRadioButton addNewBookRadioButton;
	private JButton addNewBookButton;
	private JRadioButton addCopyRadioButton;
	private JButton searchIDButton;
	private JButton addCopyButton;
	private JButton quitButton;

	private String message = "";

	public ViewAdminAddBook(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel addBookLabel = new JLabel("Add Book");
		addBookLabel.setBounds(348, 21, 202, 61);
		addBookLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		contentPane.add(addBookLabel);

		addNewBookRadioButton = new JRadioButton("Add New Book");
		addNewBookRadioButton.setBounds(67, 83, 147, 23);
		addNewBookRadioButton.setBackground(new Color(255, 240, 245));
		addNewBookRadioButton.setMargin(new Insets(3, 2, 2, 2));
		addNewBookRadioButton.setFont(new Font("Open Sans", Font.PLAIN, 13));
		contentPane.add(addNewBookRadioButton);

		addCopyRadioButton = new JRadioButton("Add Copy");
		addCopyRadioButton.setBounds(67, 301, 147, 23);
		addCopyRadioButton.setBackground(new Color(255, 240, 245));
		addCopyRadioButton.setFont(new Font("Open Sans", Font.PLAIN, 13));
		contentPane.add(addCopyRadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(addNewBookRadioButton);
		buttonGroup.add(addCopyRadioButton);

		JPanel addNewBookPanel = new JPanel();
		addNewBookPanel.setBounds(287, 83, 443, 206);
		addNewBookPanel.setBackground(new Color(255, 240, 245));
		contentPane.add(addNewBookPanel);
		addNewBookPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		titleLabel.setBounds(10, 11, 76, 14);
		addNewBookPanel.add(titleLabel);

		JLabel AuthorLabel = new JLabel("Author");
		AuthorLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AuthorLabel.setBounds(10, 46, 76, 27);
		addNewBookPanel.add(AuthorLabel);

		bookTypeComboBox = new JComboBox<>();
		bookTypeComboBox.setBounds(203, 88, 167, 22);
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
		BookController bookController = new BookController();
		List<Book> bookList = bookController.selectProductType();
		for (int index = 0; index < bookList.size(); index++) {
			comboBoxModel.addElement(bookList.get(index).getTypeName());
		}
		bookTypeComboBox.setModel(comboBoxModel);
		addNewBookPanel.add(bookTypeComboBox);

		JLabel bookTypeLabel = new JLabel("Book Type");
		bookTypeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookTypeLabel.setBounds(10, 86, 106, 22);
		addNewBookPanel.add(bookTypeLabel);

		titleField = new JTextField();
		titleField.setBounds(203, 7, 167, 22);
		addNewBookPanel.add(titleField);
		titleField.setColumns(10);

		authorField = new JTextField();
		authorField.setBounds(203, 50, 167, 22);
		addNewBookPanel.add(authorField);
		authorField.setColumns(10);

		addNewBookButton = new JButton("Add");
		addNewBookButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addNewBookButton.setBounds(203, 157, 89, 23);
		addNewBookPanel.add(addNewBookButton);

		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel.setBounds(10, 119, 106, 27);
		addNewBookPanel.add(quantityLabel);

		quantityField = new JTextField();
		quantityField.setBounds(203, 121, 167, 22);
		addNewBookPanel.add(quantityField);
		quantityField.setColumns(10);

		Component component[] = addNewBookPanel.getComponents();
		for (int index = 0; index < component.length; index++) {
			component[index].setEnabled(false);
		}

		JPanel addCopyPanel = new JPanel();
		addCopyPanel.setBounds(287, 301, 443, 182);
		addCopyPanel.setBackground(new Color(255, 240, 245));
		contentPane.add(addCopyPanel);
		addCopyPanel.setLayout(null);

		JLabel bookNameLabel = new JLabel("Book Name");
		bookNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bookNameLabel.setBounds(10, 47, 96, 20);
		addCopyPanel.add(bookNameLabel);

		JLabel bookLabel = new JLabel("Book ID");
		bookLabel.setBounds(10, 6, 96, 18);
		bookLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addCopyPanel.add(bookLabel);

		bookIDField = new JTextField();
		bookIDField.setBounds(199, 5, 167, 22);
		addCopyPanel.add(bookIDField);
		bookIDField.setColumns(10);

		bookNameField = new JTextField();
		bookNameField.setBounds(199, 48, 167, 22);
		addCopyPanel.add(bookNameField);
		bookNameField.setColumns(10);

		JLabel quantityLabel2 = new JLabel("Quantity");
		quantityLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quantityLabel2.setBounds(10, 87, 96, 20);
		addCopyPanel.add(quantityLabel2);

		quantityField2 = new JTextField();
		quantityField2.setBounds(199, 88, 167, 22);
		addCopyPanel.add(quantityField2);
		quantityField2.setColumns(10);

		searchIDButton = new JButton("");
		searchIDButton.setIcon(new ImageIcon(ViewAdminAddBook.class.getResource("/png/transparency.png")));
		searchIDButton.setBounds(377, 5, 56, 22);
		addCopyPanel.add(searchIDButton);

		addCopyButton = new JButton("Add");
		addCopyButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addCopyButton.setBounds(199, 137, 89, 23);
		addCopyPanel.add(addCopyButton);

		Component component2[] = addCopyPanel.getComponents();
		for (int index = 0; index < component2.length; index++) {
			component2[index].setEnabled(false);
		}

		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(ViewAdminAddBook.class.getResource("/png/avatar_2.png")));
		logoLabel.setBounds(10, 404, 324, 141);
		contentPane.add(logoLabel);

		quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewAdminAddBook.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		quitButton.setBounds(622, 483, 108, 41);
		contentPane.add(quitButton);

		ActionListener actionListener = new AddBookJRadioButtonListener(addNewBookRadioButton, addNewBookPanel,
				addCopyPanel);
		addNewBookRadioButton.addActionListener(actionListener);

		ActionListener actionListener2 = new AddCopyJRadioButtonListener(addCopyRadioButton, addNewBookPanel,
				addCopyPanel);
		addCopyRadioButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new AddBookButtonListener(this, titleField, authorField, bookTypeComboBox,
				quantityField, user);
		addNewBookButton.addActionListener(actionListener3);

		ActionListener actionListener4 = new AddCopyButtonListener(this, bookIDField, quantityField2, bookNameField,
				user);
		addCopyButton.addActionListener(actionListener4);

		ActionListener actionListener5 = new AddBookQuitButtonListener(this, user);
		quitButton.addActionListener(actionListener5);

		ActionListener actionListener6 = new AddCopySearchBookIDButtonListener(bookIDField, bookNameField,
				quantityField2, addCopyButton);
		searchIDButton.addActionListener(actionListener6);

		setComponentName();

	}

	public JTextField getBookIDField() {
		return bookIDField;
	}

	public JTextField getBookNameField() {
		return bookNameField;
	}

	public JTextField getQuantityField2() {
		return quantityField2;
	}

	public JComboBox<String> getBookTypeComboBox() {
		return bookTypeComboBox;
	}

	public JTextField getTitleField() {
		return titleField;
	}

	public JTextField getAuthorField() {
		return authorField;
	}

	public JTextField getQuantityField() {
		return quantityField;
	}

	public JButton getSearchIDButton() {
		return searchIDButton;
	}

	public JRadioButton getAddNewBookRadioButton() {
		return addNewBookRadioButton;
	}

	public JRadioButton getAddCopyRadioButton() {
		return addCopyRadioButton;
	}

	public JButton getAddNewBookButton() {
		return addNewBookButton;
	}

	public JButton getAddCopyButton() {
		return addCopyButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	private void setComponentName() {
		bookIDField.setName("bookID");
		bookNameField.setName("bookName");
		quantityField2.setName("quantity2");
		bookTypeComboBox.setName("bookType");
		titleField.setName("title");
		authorField.setName("author");
		quantityField.setName("quantity");
		searchIDButton.setName("searchIDBtn");
		addNewBookRadioButton.setName("addBookRbtn");
		addCopyRadioButton.setName("addCopyRbtn");
		addNewBookButton.setName("addBookBtn");
		addCopyButton.setName("addCopyBtn");
		quitButton.setName("quitBtn");
	}

}
