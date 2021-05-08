package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;
import model.User;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;

public class ViewCustomerSearchBook extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField searchBookTextField;
	private List<Book> bookList;
	private BookController bookController;
	private DefaultTableModel model;

	public ViewCustomerSearchBook(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Cambria", Font.PLAIN, 11));
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel searchBookLabel = new JLabel("Search Book");
		searchBookLabel.setBounds(352, 164, 132, 32);
		searchBookLabel.setToolTipText("");
		searchBookLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 282, 620, 182);
		scrollPane.setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		searchBookTextField = new JTextField();
		searchBookTextField.setBounds(306, 221, 356, 28);
		searchBookTextField.setColumns(10);
		
		JComboBox searchComboBox = new JComboBox();
		searchComboBox.setBounds(101, 221, 168, 26);
		searchComboBox.setFont(new Font("FangSong", Font.BOLD, 17));
		searchComboBox.setModel(new DefaultComboBoxModel(new String[] {"Book Name", "Book ID"}));
		
		JLabel searchBookIcon = new JLabel("");
		searchBookIcon.setBounds(356, 25, 128, 128);
		searchBookIcon.setIcon(new ImageIcon(ViewCustomerSearchBook.class.getResource("/png/library.png")));
		
		JButton searchBookButton = new JButton("");
		searchBookButton.setBounds(672, 221, 49, 28);
		searchBookButton.setIcon(new ImageIcon(ViewCustomerSearchBook.class.getResource("/png/transparency.png")));
		
		table = new JTable();
		table.setBackground(new Color(255, 248, 220));
		table.setForeground(Color.BLACK);
		
		String column[] ={"Book ID", "Book Name", "Book Type", "Author", "Available Unit", "Price"};
		model = new DefaultTableModel(column,0);
		addModel();
	
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(84);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(searchBookLabel);
		contentPane.add(searchBookIcon);
		contentPane.add(searchComboBox);
		contentPane.add(searchBookTextField);
		contentPane.add(searchBookButton);
		contentPane.add(scrollPane);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		quitButton.setIcon(new ImageIcon(ViewCustomerSearchBook.class.getResource("/png/exit_1.png")));
		quitButton.setBounds(598, 475, 123, 32);
		contentPane.add(quitButton);
		
		ActionListener actionListener = new CustomerSearchButtonListener(searchComboBox,searchBookTextField,model);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setMargin(new Insets(12, 14, 2, 14));
		clearButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		clearButton.setBounds(101, 475, 96, 32);
		contentPane.add(clearButton);
		searchBookButton.addActionListener(actionListener);
		ActionListener actionListener2 = new CustomerSearchBookReturnButtonListener(this,user);
		quitButton.addActionListener(actionListener2);
		ActionListener actionListener3 = new CustomerSearchBookClearButtonListener(model,searchBookTextField);
		clearButton.addActionListener(actionListener3);

	}

	public void addModel()
	{
		Book book;
		bookController=new BookController();
		bookList=bookController.viewAvailableBook();
		
		for (int index=0; index<bookList.size(); index++) 
		{
			book = bookList.get(index);
			model.addRow(new Object[] {book.getBookID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getAvailableUnit(),book.getPrice()});
		}
		table.setModel(model);
	}
}
