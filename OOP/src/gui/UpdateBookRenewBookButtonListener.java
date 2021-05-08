package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import model.Book;

//button to renew book information
public class UpdateBookRenewBookButtonListener implements ActionListener{

	private JTextField bookIDField4;
    private JTextField titleField;
    private JTextField authorField;	
	
	
	
	public UpdateBookRenewBookButtonListener (JTextField bookIDField4, JTextField titleField, JTextField authorField)
	{
		this.bookIDField4 = bookIDField4;
        this.titleField = titleField;
        this.authorField = authorField;
	}


	public void actionPerformed(ActionEvent arg0) 
	{	
			BookController bookController = new BookController();
			Book book = new Book ();
			int status=0;

			
			
		int result = JOptionPane.showConfirmDialog(null,"Do you confirm your data?", "Update", 
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		//Confirm to renew
		if(result == 0)
		{
			book.setTitle(titleField.getText());
			book.setAuthor(authorField.getText());
			book.setBookID(Integer.parseInt(bookIDField4.getText()));
			status = bookController.updateBook(book);

			//successfully update
			if (status != 0)
			{
				JOptionPane.showMessageDialog(null,"Update Successfully!","Check Update",1);
			}
			//if failed
			else
			{
				JOptionPane.showMessageDialog(null,"Update Failed!","Check Update",1);
			}
		}
		titleField.setText("Success");
		authorField.setText("");
		bookIDField4.setText("");
		
	}

}
