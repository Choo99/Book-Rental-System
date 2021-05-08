package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;

//button to search book ID
public class CustomerSearchButtonListener implements ActionListener{

	private JComboBox searchComboBox;
	private DefaultTableModel model;
	private JTextField textField;
	private Book book;

	public CustomerSearchButtonListener(JComboBox searchComboBox,JTextField textField,DefaultTableModel model)
	{
		this.searchComboBox=searchComboBox;
		this.model = model;
		this.textField = textField;
	}
	
	public void actionPerformed(ActionEvent action) 
	{
		
		int bookID = 0;
		book = new Book();
		BookController bookController = new BookController();
		
		String value = searchComboBox.getSelectedItem().toString();
		
		
		//Book ID found
		if(value.equals("Book ID"))
		{
			if(textField.getText().length() == 0)
			{
				return;
			}
	
			bookID = Integer.parseInt(textField.getText());
			book = bookController.searchBookID(bookID);
			//no book ID exist
			if(book == null)
			{
				JOptionPane.showMessageDialog(null,"No result found!","Error",1);
				textField.setText("");
				return;
			}
			model.setRowCount(0);
			Object object[] = new Object[] {book.getBookID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getAvailableUnit(),book.getPrice()};
			model.addRow(object);			
		}
		else
		{
			book.setTitle(textField.getText());
			List<Book> bookList = new ArrayList<Book>();
			bookList = bookController.searchBookTitle(book.getTitle());
			
			model.setRowCount(0);
			for(int index = 0; index < bookList.size(); index++)
			{
				book = bookList.get(index);
				Object object[] = new Object[] {book.getBookID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getAvailableUnit(),book.getPrice()};
				model.addRow(object);
			}		
		}
		textField.setText("");
		
	}

	
}
