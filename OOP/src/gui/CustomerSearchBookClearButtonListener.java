package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;

//button to clear the input in text field
public class CustomerSearchBookClearButtonListener implements ActionListener
{
	private DefaultTableModel model;
	private Book book;
	private JTextField textField;
	
	public CustomerSearchBookClearButtonListener(DefaultTableModel model,JTextField textField)
	{
		this.model = model;
		this.textField = textField;
	}

	public void actionPerformed(ActionEvent action) 
	{
		List<Book> bookList;
		BookController bookController = new BookController();
		bookList = bookController.viewAvailableBook();
		model.setRowCount(0);
		for (int index=0; index<bookList.size(); index++) 
		{
			book = bookList.get(index);
			model.addRow(new Object[] {book.getBookID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getAvailableUnit(),book.getPrice()});
		}
		textField.setText("");
	}
	
	
}
