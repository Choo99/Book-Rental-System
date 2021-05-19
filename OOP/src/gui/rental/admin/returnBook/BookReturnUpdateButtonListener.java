package gui.rental.admin.returnBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.RentalController;
import gui.rental.admin.returnBook.overdue.ViewOverdueFeeReceipt;
import model.Book;
import model.Rental;
import model.User;

public class BookReturnUpdateButtonListener implements ActionListener {

	private JTextField rentalIDField2;
	private JTextField customerNameField;
	private JTextField expectedDateField;
	private JTextField returnDateField;
	private User user;
	private ViewBookReturn frame; 

	public BookReturnUpdateButtonListener(ViewBookReturn frame, JTextField rentalIDField2, JTextField customerNameField,
			JTextField expectedDateField, JTextField returnDateField, User user) {
		this.frame = frame;
		this.rentalIDField2 = rentalIDField2;
		this.customerNameField = customerNameField;
		this.expectedDateField = expectedDateField;
		this.returnDateField = returnDateField;
		this.user = user;
	}

	public void actionPerformed(ActionEvent action) {
		RentalController rentalController = new RentalController();
		BookController bookController = new BookController();
		Rental rental = new Rental();
		int status = 0;
		rental.setRentID(Integer.parseInt(rentalIDField2.getText()));

		List<Book> bookList = rentalController.searchNotCompleteRentList(rental);
		if (bookList.size() == 0) {
			JOptionPane.showMessageDialog(null, "This rental has been completed!", "Completed", 1);
			rentalIDField2.setText("");
			customerNameField.setText("");
			expectedDateField.setText("");
			returnDateField.setText("");
			return;
		}

		// to update return book copy status from Renting to Available
		for (int index = 0; index < bookList.size(); index++) {
			status = rentalController.returnBook(bookList.get(index).getBookID(), bookList.get(index).getCopyID());
		}

		rental = rentalController.searchRenting(rental.getRentID());
		int duration = rentalController.differentDate(rental.getExpectedDate(), rentalController.currentDate());
		int updateResult = rentalController.completeStatus(rental.getRentID());
		if (updateResult == 1) {
			frame.setMessage("Completed");
		}

		// check and update unavailable book to available
		bookController.updateBookToAvailable();
		// if overdue
		if (duration >= 0) {
			rental.setOverdueFee(duration * rental.getRentFee() * 0.1);
			rentalController.updateOverDueFee(rental.getOverdueFee(), rental.getRentID());
			JOptionPane.showMessageDialog(null, "This rental is overdue!", "Check Overdue", 1);
			rentalIDField2.setText("");
			customerNameField.setText("");
			expectedDateField.setText("");
			returnDateField.setText("");

			ViewOverdueFeeReceipt rentalSlip = new ViewOverdueFeeReceipt(rental, user);
			frame.setOverdue(rentalSlip);
			frame.getOverdue().setVisible(true);
		}

		// update successfully
		else if (status != 0) {
			JOptionPane.showMessageDialog(null, "Update Successfully!", "Check Update", 1);
			rentalIDField2.setText("");
			customerNameField.setText("");
			expectedDateField.setText("");
			returnDateField.setText("");
		}
	}
}
