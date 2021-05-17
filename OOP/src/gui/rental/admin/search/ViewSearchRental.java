package gui.rental.admin.search;

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

import controller.RentalController;
import model.Rental;
import model.User;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewSearchRental extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField rentalIDField;
	private JTable bookRentalTable;
	private User user;
	private DefaultTableModel model;
	
	public ViewSearchRental() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255, 240, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel searchRentalLabel = new JLabel("Search Rental");
		searchRentalLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 25));
		searchRentalLabel.setBounds(310, 96, 180, 43);
		contentPane.add(searchRentalLabel);
		
		JLabel rentalIDLabel = new JLabel("Enter Rental ID");
		rentalIDLabel.setFont(new Font("Palatino Linotype", Font.BOLD, 20));
		rentalIDLabel.setBounds(49, 135, 154, 43);
		contentPane.add(rentalIDLabel);
		
		rentalIDField = new JTextField();
		rentalIDField.setBounds(382, 139, 285, 28);
		contentPane.add(rentalIDField);
		rentalIDField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 189, 717, 290);
		contentPane.add(scrollPane);
		
		bookRentalTable = new JTable()
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
		addModel();
		bookRentalTable.getTableHeader().setReorderingAllowed(false);		
	
		bookRentalTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		bookRentalTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		bookRentalTable.getColumnModel().getColumn(3).setPreferredWidth(120);
		bookRentalTable.getColumnModel().getColumn(5).setPreferredWidth(70);
		scrollPane.setViewportView(bookRentalTable);
		
		JButton searchButton = new JButton("");
		searchButton.setIcon(new ImageIcon(ViewSearchRental.class.getResource("/png/transparency.png")));
		searchButton.setBounds(677, 139, 89, 28);
		contentPane.add(searchButton);
		
		JButton quitButton = new JButton("Quit");
		quitButton.setIcon(new ImageIcon(ViewSearchRental.class.getResource("/png/exit_1.png")));
		quitButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		quitButton.setBounds(621, 490, 145, 34);
		contentPane.add(quitButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		clearButton.setBounds(49, 490, 145, 34);
		contentPane.add(clearButton);
		
		JLabel rentalIcon = new JLabel("");
		rentalIcon.setIcon(new ImageIcon(ViewSearchRental.class.getResource("/png/view-details.png")));
		rentalIcon.setBounds(350, 16, 81, 69);
		contentPane.add(rentalIcon);

		ActionListener actionListener = new BookRentalQuitButtonListener(this,user);
		quitButton.addActionListener(actionListener);

		ActionListener actionListener2 = new SearchRentalSearchButtonListener (rentalIDField, bookRentalTable, model);
		searchButton.addActionListener(actionListener2);

		ActionListener actionListener3 = new SearchRentalClearButtonListener (rentalIDField, model);
		clearButton.addActionListener(actionListener3);
	}

	public void addModel()
	{
		String column[] ={"Rental ID", "Customer Name", "Rent Date", "Expected Return Date", "Return Date", "Price", "Status"};
		model = new DefaultTableModel(null,column);
		RentalController rentalController = new RentalController();
		List<Rental> rentalList = rentalController.viewAllRentList();
		for(int index =0; index < rentalList.size();index++)
		{
			Rental rent = rentalList.get(index);
			Object object[] = {rent.getRentID(),rent.getCustomerName(),rent.getRentDate(),
			rent.getExpectedDate(),rent.getReturnDate(),rent.getRentFee(),rent.getStatus()};
			model.addRow(object);
		}
		bookRentalTable.setModel(model);
	}
}
