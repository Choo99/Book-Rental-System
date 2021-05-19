package gui.book.admin.searchBook;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;
import model.User;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewAdminViewBook extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField bookIDField;
	private JTable viewBookTable;
	private DefaultTableModel model;
	private JButton searchButton;
	private String message;

	public ViewAdminViewBook(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel viewBookLabel = new JLabel("View Book");
		viewBookLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		viewBookLabel.setBounds(346, 124, 214, 50);
		contentPane.add(viewBookLabel);

		JLabel enterBookIDLabel = new JLabel("Enter Book ID");
		enterBookIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		enterBookIDLabel.setBounds(51, 160, 172, 37);
		contentPane.add(enterBookIDLabel);

		bookIDField = new JTextField();
		bookIDField.setBounds(362, 163, 301, 25);
		contentPane.add(bookIDField);
		bookIDField.setColumns(10);

		JScrollPane viewBookScrollPanel = new JScrollPane();
		viewBookScrollPanel.setBounds(51, 208, 709, 268);
		contentPane.add(viewBookScrollPanel);

		viewBookTable = new JTable() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		addModel();

		viewBookTable.getTableHeader().setReorderingAllowed(false);

		viewBookTable.getColumnModel().getColumn(2).setPreferredWidth(125);
		viewBookTable.getColumnModel().getColumn(4).setPreferredWidth(125);
		viewBookScrollPanel.setViewportView(viewBookTable);

		searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(ViewAdminViewBook.class.getResource("/png/transparency.png")));
		searchButton.setBounds(673, 163, 85, 25);
		contentPane.add(searchButton);

		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		quitButton.setIcon(new ImageIcon(ViewAdminViewBook.class.getResource("/png/exit_1.png")));
		quitButton.setBounds(601, 487, 159, 37);
		contentPane.add(quitButton);

		JLabel viewBookIcon = new JLabel("");
		viewBookIcon.setIcon(new ImageIcon(ViewAdminViewBook.class.getResource("/png/bookshelf_2.png")));
		viewBookIcon.setBounds(336, 0, 130, 133);
		contentPane.add(viewBookIcon);

		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
		clearButton.setBounds(51, 487, 159, 37);
		contentPane.add(clearButton);

		ActionListener actionListener = new ViewBookQuitButtonListener(this, user);
		quitButton.addActionListener(actionListener);

		ActionListener actionListener2 = new ViewBookSearchButtonListener(this, bookIDField, viewBookTable, model);
		searchButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new ViewBookClearButtonListener(viewBookTable, model);
		clearButton.addActionListener(actionListener3);

		setComponentName();
	}

	public void addModel() {
		List<Book> bookList;
		String column[] = { "Book ID", "Copy ID", "Title", "Type", "Author", "Condition", "Price" };
		model = new DefaultTableModel(null, column);

		BookController bookController = new BookController();
		bookList = bookController.viewAllBook();
		for (int index = 0; index < bookList.size(); index++) {
			Book book = bookList.get(index);
			Object object[] = { book.getBookID(), book.getCopyID(), book.getTitle(), book.getTypeName(),
					book.getAuthor(), book.getCondition(), book.getPrice() };
			model.addRow(object);
		} 
		viewBookTable.setModel(model);
	}

	public JTextField getBookIDField(){
		return bookIDField;
	}
	public JButton getSearchButton(){
		return searchButton;
	}
	public String getMessage(){
		return message;
	}
	public void setComponentName(){
		viewBookTable.setName("table");
		bookIDField.setName("bookID");
		searchButton.setName("searchBtn");
	}



}
