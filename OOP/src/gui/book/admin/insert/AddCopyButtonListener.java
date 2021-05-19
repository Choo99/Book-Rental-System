package gui.book.admin.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import gui.book.admin.insert.bookList.ViewAdminAddedBookList;
import model.Book;
import model.User;

//button to add book copy
public class AddCopyButtonListener implements ActionListener {
	private ViewAdminAddBook frame;
	private JTextField bookIDField;
	private JTextField quantityField;
	private JTextField bookNameField;
	private BookController bookController;
	private User user;

	public AddCopyButtonListener(ViewAdminAddBook frame, JTextField bookIDField, JTextField quantityField,
			JTextField bookNameField, User user) {
		this.frame = frame;
		this.bookIDField = bookIDField;
		this.quantityField = quantityField;
		this.bookNameField = bookNameField;
		this.user = user;
	}

	public void actionPerformed(ActionEvent arg0) {

		bookController = new BookController();
		InputController inputController = new InputController();
		int status = 0, count = 0;

		// not allow empty input
		if (!inputController.isNullOrEmpty(quantityField.getText())) {
			JOptionPane.showMessageDialog(null, "Empty input is not available!", "Check Empty", 1);
			return;
		}

		// check digitd
		else if (!inputController.isDigit(quantityField.getText())) {
			JOptionPane.showMessageDialog(null, "Quantity must be digit!", "Check Digits", 1);
			return;
		}
		// check quantity=>1
		else if (Integer.parseInt(quantityField.getText()) == 0) {
			JOptionPane.showMessageDialog(null, "Quantity must be at least 1!", "Check Zero", 1);
			return;
		}

		// confirmation for update
		int result = JOptionPane.showConfirmDialog(null, "Do you confirm your data?", "Update",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == 0) {
			List<Book> bookList = new ArrayList<Book>();

			for (int i = 0; i < Integer.parseInt(quantityField.getText()); i++) {
				status = bookController.insertCopy(Integer.parseInt(bookIDField.getText()));
				if (status != 0) {
					Book book = new Book();
					book.setBookID(Integer.parseInt((bookIDField.getText())));
					book.setCopyID(bookController.searchMaxCopyID(book.getBookID()));
					bookList.add(book);
					count++;
				}
			}
			// check and update book status to available after new copies are added
			bookController.updateBookToAvailable();
			
			// check the add copy unit is same as the expected quantity or not
			if (count != Integer.parseInt(quantityField.getText())) {
				JOptionPane.showMessageDialog(null, "Add Copy Failed!", "Check Add Copy", 1);
			}
			else
				{
					JOptionPane.showMessageDialog(null,"Add the copy successfully !","Success",1);
					frame.setMessage("Add the copy successfully !");
				}
			
			ViewAdminAddedBookList menu = new ViewAdminAddedBookList(bookList, user);
			menu.setVisible(true);
		
		}
		bookIDField.setText("");
		bookNameField.setText("");
		quantityField.setText("");
	}
}
