package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.RentalController;
import model.Book;
import model.Rental;
import model.User;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ViewReceipt extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable receiptTable;
	private JTextField amountField;
	private JTextField dateField;
	private JTextField rentalIDField;
	private DefaultTableModel model;
	
	public ViewReceipt(Rental rental,User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel receiptLabel = new JLabel("Receipt");
		receiptLabel.setBounds(227, 232, 157, 42);
		receiptLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		contentPane.add(receiptLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 338, 380, 103);
	
		contentPane.add(scrollPane);
		
		receiptTable = new JTable();
		scrollPane.setViewportView(receiptTable);
		
		amountField = new JTextField();
		amountField.setEditable(false);
		amountField.setBounds(345, 452, 112, 31);
		contentPane.add(amountField);
		amountField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setEditable(false);
		dateField.setInheritsPopupMenu(true);
		dateField.setBounds(371, 285, 86, 20);
		contentPane.add(dateField);
		dateField.setColumns(10);
		
		rentalIDField = new JTextField();
		rentalIDField.setEditable(false);
		rentalIDField.setBounds(77, 285, 86, 20);
		contentPane.add(rentalIDField);
		rentalIDField.setColumns(10);
		
		JLabel shopNameLabel = new JLabel("Pisces Rental Shop");
		shopNameLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		shopNameLabel.setBounds(209, 190, 153, 31);
		contentPane.add(shopNameLabel);
		
		JLabel thankYouLabel = new JLabel("Thank You!");
		thankYouLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		thankYouLabel.setBounds(227, 530, 135, 31);
		contentPane.add(thankYouLabel);
		
		JLabel noticeLabel = new JLabel("*Fines might be charge if the book does not return on time");
		noticeLabel.setIcon(new ImageIcon(ViewReceipt.class.getResource("/png/avatar_1.png")));
		noticeLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 11));
		noticeLabel.setBounds(112, 572, 332, 31);
		contentPane.add(noticeLabel);
		
		JLabel rentalShopIcon = new JLabel("");
		rentalShopIcon.setIcon(new ImageIcon(ViewReceipt.class.getResource("/png/magical_1.png")));
		rentalShopIcon.setBounds(209, 40, 135, 139);
		contentPane.add(rentalShopIcon);
		
		addData(rental);

		JButton okButton = new JButton("OK");
		okButton.setBounds(227, 614, 89, 23);
		contentPane.add(okButton);
		
		JLabel totalLabel = new JLabel("Total ");
		totalLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		totalLabel.setBounds(292, 459, 71, 31);
		contentPane.add(totalLabel);
		receiptTable.getColumnModel().getColumn(2).setPreferredWidth(125);
		receiptTable.getColumnModel().getColumn(2).setPreferredWidth(125);

		ActionListener actionListener = new ReceiptOkButtonListener (this,user);
		okButton.addActionListener(actionListener);
	}

	public void addData(Rental rental)
	{
		rentalIDField.setText(Integer.toString(rental.getRentID()));
		
		String column[] = {"Book ID", "Copy ID", "Title", "Price"};
		model = new DefaultTableModel(null,column);
		
		RentalController rentalController = new RentalController();
		List<Book> bookList = rentalController.searchRentList(rental);
		
		for(int index = 0;index < bookList.size(); index ++)
		{
			Book book = bookList.get(index);
			Object object[] ={book.getBookID(),book.getCopyID(),book.getTitle(),book.getPrice()};
			model.addRow(object);
		}
		
		receiptTable.setModel(model);
		
		String date = rentalController.currentDate();
		dateField.setText(date);
		
		rental = rentalController.searchRentalFee(rental.getRentID());
		amountField.setText(Double.toString(rental.getRentFee()));
		
		rentalController.updateRenting(rental.getRentID());
	}
}

