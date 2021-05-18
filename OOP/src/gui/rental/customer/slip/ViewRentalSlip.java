
//done

package gui.rental.customer.slip;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.RentalController;
import model.Book;
import model.Rental;
import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ViewRentalSlip extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rentIDField;
	private JTextField nameField;
	private JTextField currentDateField;
	private JTextField returnDateField;
	private DefaultTableModel model;
	private JTable rentListTable;

	public ViewRentalSlip(Rental rental,User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 690);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(ViewRentalSlip.class.getResource("/png/magical_1.png")));
		logo.setBounds(213, 0, 137, 163);
		contentPane.add(logo);
		
		JLabel shopName = new JLabel("Pisces Rental Shop");
		shopName.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		shopName.setBounds(196, 145, 221, 51);
		contentPane.add(shopName);
		
		JLabel rentIDlabel = new JLabel("Rental ID");
		rentIDlabel.setFont(new Font("FangSong", Font.BOLD, 18));
		rentIDlabel.setBounds(84, 185, 112, 23);
		contentPane.add(rentIDlabel);
		
		JButton printButton = new JButton("Print");
		printButton.setIconTextGap(6);
		printButton.setIcon(new ImageIcon(ViewRentalSlip.class.getResource("/png/printer.png")));
		printButton.setMargin(new Insets(13, 14, 2, 14));
		printButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		printButton.setBounds(208, 566, 130, 43);
		contentPane.add(printButton);
		
		JLabel customerLabel = new JLabel("Customer Name");
		customerLabel.setFont(new Font("FangSong", Font.BOLD, 18));
		customerLabel.setBounds(81, 219, 180, 20);
		contentPane.add(customerLabel);
		
		JLabel currentDateLabel = new JLabel("Current Date");
		currentDateLabel.setFont(new Font("FangSong", Font.BOLD, 18));
		currentDateLabel.setBounds(84, 250, 112, 26);
		contentPane.add(currentDateLabel);
		
		JLabel returnDateLbael = new JLabel("Expected Return Date");
		returnDateLbael.setFont(new Font("FangSong", Font.BOLD, 18));
		returnDateLbael.setBounds(84, 287, 196, 23);
		contentPane.add(returnDateLbael);
		
		rentIDField = new JTextField();
		rentIDField.setBounds(329, 187, 112, 21);
		contentPane.add(rentIDField);
		rentIDField.setColumns(10);
		rentIDField.setEditable(false);
		
		nameField = new JTextField();
		nameField.setBounds(329, 219, 112, 21);
		contentPane.add(nameField);
		nameField.setColumns(10);
		nameField.setEditable(false);
		
		currentDateField = new JTextField();
		currentDateField.setBounds(329, 254, 112, 21);
		contentPane.add(currentDateField);
		currentDateField.setColumns(10);
		currentDateField.setEditable(false);
		
		returnDateField = new JTextField();
		returnDateField.setBounds(329, 288, 112, 21);
		contentPane.add(returnDateField);
		returnDateField.setColumns(10);
		returnDateField.setEditable(false);
		String column[] ={"Book ID","Copy ID","Title", "Book Type", "Author", "Price"};
		model= new DefaultTableModel(column,0);
		
		rentListTable = new JTable()
		{
		  	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) 
		  	{                
                return false;               
        	};
		};
		rentListTable.getTableHeader().setReorderingAllowed(false);	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 350, 385, 161);
		contentPane.add(scrollPane);
		
		rentListTable = new JTable();
		scrollPane.setViewportView(rentListTable);
		rentListTable.setModel(model);
		
		setRentInformation(rental);
		ActionListener actionListener = new CustomerRentalPrintButtonListener (this,user);
		printButton.addActionListener(actionListener);
	}
	
	public void setRentInformation(Rental rental)
	{
		User user = new User();
		RentalController rentController = new RentalController();
		rentController.searchRecipeInformation(rental,user);
		rentIDField.setText(Integer.toString(rental.getRentID()));
		nameField.setText(user.getName());
		
		currentDateField.setText(rental.getRentDate());
		returnDateField.setText(rental.getExpectedDate());
	
		List<Book> bookList = new ArrayList<Book>();
		bookList = rentController.searchRentList(rental);
		for(int index =0; index <bookList.size(); index++)
		{
			Book book = bookList.get(index);
			Object object[] =new Object[]{book.getBookID(),book.getCopyID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getPrice()};
			model.addRow(object);
		}
	}
}
