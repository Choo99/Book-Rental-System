package gui.rental.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import controller.InputController;
import gui.rental.customer.slip.ViewRentalSlip;
import model.Book;

//click button and add rental info
public class CustomerAddRentalButtonListener implements ActionListener {

	private DefaultTableModel model;
	private JTextField bookIDField;
	private JTextField copyIDField;
	private Book book;
	private ViewCustomerRental frame;

	CustomerAddRentalButtonListener(ViewCustomerRental frame,JTextField bookIDField, JTextField copyIDField, DefaultTableModel model) {
		this.frame = frame;
		this.bookIDField = bookIDField;
		this.copyIDField = copyIDField;
		this.model = model;
	}

	public void actionPerformed(ActionEvent arg0) {
		InputController inputController = new InputController();

		// check both field has been filled
		if ((bookIDField.getText().length() == 0) || (!inputController.isDigit(copyIDField.getText()))
				|| (copyIDField.getText().length() == 0) || (!inputController.isDigit(bookIDField.getText()))) {
			JOptionPane.showMessageDialog(null, "Must fill in both book ID and copy ID !", "Error", 1);
			bookIDField.setText("");
			copyIDField.setText("");
			return;
		}

		// limit 5 books to be rent
		if (model.getRowCount() >= 5) {
			String message = "Maximum five books in one rental !";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null,message , "Error", 1);
			bookIDField.setText("");
			copyIDField.setText("");
			return;
		}

		int bookID = 0;
		int copyID = 0;
		BookController bookController = new BookController();

		bookID = Integer.parseInt(bookIDField.getText());
		copyID = Integer.parseInt(copyIDField.getText());
		book = bookController.searchBookID(bookID, copyID);

		// no book ID found
		if (book == null) {
			String message =  "No result found!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null,message, "Error", 1);
			bookIDField.setText("");
			copyIDField.setText("");
			return;
		}
		else if(book.getCondition().equals("Rented") || book.getCondition().equals("Broken")) {
			String message =  "This book is broken/rented! Please find other book";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null,message , "Error", 1);
			bookIDField.setText("");
			copyIDField.setText("");
			return;
		}

		// check repeat list
		for (int index = 0; index < model.getRowCount(); index++) {
			if (Integer.toString(book.getBookID()).equals(model.getValueAt(index, 0).toString())
					&& (Integer.toString(book.getCopyID()).equals(model.getValueAt(index, 1).toString()))) {
				String message =  "Repeated book in the list!";
				frame.setMessage(message);
				JOptionPane.showMessageDialog(null, message, "Error", 1);
				bookIDField.setText("");
				copyIDField.setText("");
				return;
			}
		}

		Object object[] = new Object[] { book.getBookID(), book.getCopyID(), book.getTitle(), book.getTypeName(),
				book.getAuthor(), book.getAvailableUnit(), book.getPrice() };
		model.addRow(object);

		bookIDField.setText("");
		copyIDField.setText("");
	}

}
