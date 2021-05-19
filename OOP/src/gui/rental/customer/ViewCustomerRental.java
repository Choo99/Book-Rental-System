package gui.rental.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.rental.customer.slip.ViewRentalSlip;
import model.User;

import javax.swing.JButton;
import java.awt.Insets;

public class ViewCustomerRental extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rentBookTextField;
	private JTable rentalBookListTable; 
	private JTextField copyIDField;
	private ViewRentalSlip slip;
	private JButton addBookButton;
	private JButton rentBookButton;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ViewRentalSlip getSlip() {
		return slip;
	}
 
	public void setSlip(ViewRentalSlip slip) {
		this.slip = slip;
	}

	public ViewCustomerRental(User user) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel rentBookLabel = new JLabel("Rent Book");
		rentBookLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 23));
		rentBookLabel.setBounds(340, 157, 117, 52);
		contentPane.add(rentBookLabel);
		
		JLabel rentBookIcon = new JLabel("");
		rentBookIcon.setIcon(new ImageIcon(ViewCustomerRental.class.getResource("/png/rent_1.png")));
		rentBookIcon.setBounds(339, 11, 139, 155);
		contentPane.add(rentBookIcon);
		
		JLabel enterBookIDLabel = new JLabel("Book ID");
		enterBookIDLabel.setFont(new Font("FangSong", Font.BOLD, 23));
		enterBookIDLabel.setBounds(99, 198, 164, 38);
		contentPane.add(enterBookIDLabel);
		
		rentBookTextField = new JTextField();
		rentBookTextField.setBounds(386, 207, 256, 26);
		contentPane.add(rentBookTextField);
		rentBookTextField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(99, 312, 611, 103);
		contentPane.add(scrollPane);
		
		rentalBookListTable = new JTable();
		String column[] ={"Book ID","Copy ID", "Book Name", "Book Type", "Author", "Available Unit", "Price"};
		DefaultTableModel model= new DefaultTableModel(column,0);
		rentalBookListTable.setModel(model);
		rentalBookListTable.getColumnModel().getColumn(0).setPreferredWidth(68);
		rentalBookListTable.getColumnModel().getColumn(1).setPreferredWidth(68);
		rentalBookListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		rentalBookListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		rentalBookListTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		rentalBookListTable.getColumnModel().getColumn(5).setPreferredWidth(100);
		rentalBookListTable.getColumnModel().getColumn(6).setPreferredWidth(90);
			
		scrollPane.setViewportView(rentalBookListTable);
		
		addBookButton = new JButton("");
		addBookButton.setIcon(new ImageIcon(ViewCustomerRental.class.getResource("/png/transparency.png")));
		addBookButton.setBounds(652, 259, 58, 28);
		contentPane.add(addBookButton);
		
		rentBookButton = new JButton("Rent");
		rentBookButton.setFont(new Font("FangSong", Font.BOLD, 21));
		rentBookButton.setBounds(99, 469, 110, 38);
		contentPane.add(rentBookButton);
		
		JButton quitButton = new JButton("Cancel");
		quitButton.setFont(new Font("FangSong", Font.BOLD, 21));
		quitButton.setBounds(593, 469, 117, 38);
		contentPane.add(quitButton);
		
		copyIDField = new JTextField();
		copyIDField.setBounds(386, 259, 256, 26);
		contentPane.add(copyIDField);
		copyIDField.setColumns(10);
		
		JLabel copyIDLabel = new JLabel("Copy ID");
		copyIDLabel.setFont(new Font("FangSong", Font.BOLD, 23));
		copyIDLabel.setBounds(99, 247, 164, 38);
		contentPane.add(copyIDLabel);
		
		ActionListener actionListener = new CustomerRentButtonListener(this,model,user);
		rentBookButton.addActionListener(actionListener);

		ActionListener actionListener2 = new CustomerAddRentalButtonListener(this,rentBookTextField,copyIDField,model);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setMargin(new Insets(12, 14, 2, 14));
		deleteButton.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		deleteButton.setBounds(350, 469, 107, 38);
		contentPane.add(deleteButton);
		addBookButton.addActionListener(actionListener2);
		
		ActionListener actionListener3 = new CustomerRentalReturnButtonListener(this,user);	
		quitButton.addActionListener(actionListener3);
		
		ActionListener actionListener4 = new CustomerDeleteRentalButtonListener(rentalBookListTable,model);
		deleteButton.addActionListener(actionListener4);
		
		setName();
	}
	
	void setName() {
		rentBookTextField.setName("bookID");
		copyIDField.setName("copyID");
		addBookButton.setName("addBookBtn");
		rentBookButton.setName("rentBookBtn");
		rentalBookListTable.setName("table");
	}
}
