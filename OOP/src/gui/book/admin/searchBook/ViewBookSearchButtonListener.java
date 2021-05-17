package gui.book.admin.searchBook;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import controller.InputController;
import model.Book;

//button to search book ID
public class ViewBookSearchButtonListener implements ActionListener {
	private JTextField bookIDField;
	private DefaultTableModel model;

	public ViewBookSearchButtonListener(JTextField bookIDField, JTable table, DefaultTableModel model) {
		this.bookIDField = bookIDField;
		this.model = model;
	}

	public void actionPerformed(ActionEvent action) {
		InputController inputController = new InputController();
		BookController bookController = new BookController();
		List<Book> bookList;

		// check empty input
		if (!inputController.isNullOrEmpty(bookIDField.getText())) {
			JOptionPane.showMessageDialog(null, "Empty input is not available!", "Check Empty", 1);
			return;
		}

		// check digits
		else if (!inputController.isDigit(bookIDField.getText())) {
			bookIDField.setText("");
			JOptionPane.showMessageDialog(null, "Book ID must be digit!", "Check Digit", 1);
			return;
		}

		model.setRowCount(0);
		bookList = bookController.searchAllBook(Integer.parseInt(bookIDField.getText()));

		// if book ID not found
		if (bookList == null) {
			bookIDField.setText("");
			JOptionPane.showMessageDialog(null, "This book ID cannot be found!", "Search Book Fail", 1);
			return;
		} else
			bookIDField.setText("");

		for (int index = 0; index < bookList.size(); index++) {
			Book book = bookList.get(index);
			Object object[] = { book.getBookID(), book.getCopyID(), book.getTitle(), book.getTypeName(),
					book.getAuthor(), book.getCondition(), book.getPrice() };
			model.addRow(object);
		}
	}
}
