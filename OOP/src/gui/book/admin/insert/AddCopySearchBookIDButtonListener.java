package gui.book.admin.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import model.Book;
//search Book ID button
public class AddCopySearchBookIDButtonListener implements ActionListener {

	private JTextField bookIDField;
	private JTextField bookNameField;
	private JTextField quantityField;
	private JButton addCopyButton;
	private BookController bookController;
	private InputController inputController;
	
	public AddCopySearchBookIDButtonListener(JTextField bookIDField, JTextField bookNameField, JTextField quantityField, JButton addCopyButton)
	{
		this.bookIDField =bookIDField;
		this.bookNameField=bookNameField;
		this.quantityField=quantityField;
		this.addCopyButton=addCopyButton;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		bookController = new BookController();
		inputController = new InputController();
		Book book ;

		bookNameField.setEditable(false);
		//not allow empty input	
		if(!inputController.isNullOrEmpty(bookIDField.getText()))
		{	
			JOptionPane.showMessageDialog(null,"Please enter book ID!","FindBookID",1);
			return;
		}
		else if(!inputController.isDigit(bookIDField.getText()))
		{
			bookIDField.setText("");
			JOptionPane.showMessageDialog(null,"Book ID must be digit!","Check Digit",1);
			return;
		}
		else
			book = bookController.searchBook(Integer.parseInt(bookIDField.getText())); 

		if(book==null)
		{	bookIDField.setText("");
			JOptionPane.showMessageDialog(null,"This book ID cannot be found!","FindBookID",1);
			return;
		}
		
		//cannot found Book ID
		if(!inputController.isNullOrEmpty(book.getTitle()))
		{ 
			JOptionPane.showMessageDialog(null,"This book ID cannot be found!","FindBookID",1);
			bookIDField.setText("");
			quantityField.setEnabled(false);
			addCopyButton.setEnabled(false);
		}
		else
		{
			bookNameField.setText(book.getTitle());
			quantityField.setEnabled(true);
			addCopyButton.setEnabled(true);

		}

	
		
		
		
		
	}

}
