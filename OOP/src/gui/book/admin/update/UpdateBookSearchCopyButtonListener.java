package gui.book.admin.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import model.Book;

//button to search copy id
public class UpdateBookSearchCopyButtonListener implements ActionListener{

	private JTextField bookIDField;
	private JTextField copyIDField;
	private JComboBox<String>  statusComboBox;
	private JTextField bookIDField3;
	private JTextField copyIDField3;
	
	public UpdateBookSearchCopyButtonListener (JTextField bookIDField, JTextField copyIDField, JComboBox<String>  statusComboBox, JTextField bookIDField3, JTextField copyIDField3 )
	{
		this.bookIDField = bookIDField;
		this.copyIDField = copyIDField;
		this.statusComboBox = statusComboBox;
		this.bookIDField3 = bookIDField3;
		this.copyIDField3 = copyIDField3;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		BookController bookController = new BookController();
        InputController inputController = new InputController();
       
		//check empty input
		 if (!inputController.isNullOrEmpty(bookIDField.getText()) || !inputController.isNullOrEmpty(copyIDField.getText()))
        {
            JOptionPane.showMessageDialog(null,"Empty input is not available!","Check Empty",1);
            return;
        }

		//check digits
        else if (!inputController.isDigit(bookIDField.getText()) || !inputController.isDigit(copyIDField.getText()) )
        {   bookIDField.setText("");
			copyIDField.setText("");
            JOptionPane.showMessageDialog(null,"ID must be digit!","Check Digit",1);
            return;
        }

		 Book book = bookController.searchCopyCondition(Integer.parseInt(bookIDField.getText()), Integer.parseInt(copyIDField.getText()));
		
		//book ID not found
		if (book == null)
		{
			bookIDField.setText("");
			copyIDField.setText("");
            JOptionPane.showMessageDialog(null,"This book ID cannot be found!","FindBookID",1);
            return;
		}
		else
		{
			bookIDField.setText("");
			copyIDField.setText("");
			bookIDField3.setText(Integer.toString(book.getBookID()));
			copyIDField3.setText(Integer.toString(book.getCopyID()));
			statusComboBox.setSelectedItem(book.getCondition());
			statusComboBox.setEnabled(true);
		}	
		
	}

}
