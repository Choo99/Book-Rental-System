package gui.book.admin.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import model.Book;

//button to search book
public class UpdateBookSearchBookButtonListener implements ActionListener {

    private JTextField bookIDField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField bookIDField4;


    public UpdateBookSearchBookButtonListener (JTextField bookIDField, JTextField titleField, JTextField authorField, JTextField bookIDField4)
    {
        this.bookIDField = bookIDField;
        this.titleField = titleField;
        this.authorField = authorField;
        this.bookIDField4 = bookIDField4;
    }

	public void actionPerformed(ActionEvent arg0) 
    {
		BookController bookController = new BookController();
        InputController inputController = new InputController();
        Book book = new Book();

        //check empty input
        if (!inputController.isNullOrEmpty(bookIDField.getText()))
        {
            JOptionPane.showMessageDialog(null,"Empty input is not available!","Check Empty",1);
            return;
        }

        //check digits
        else if (!inputController.isDigit(bookIDField.getText()))
        {   bookIDField.setText("");
            JOptionPane.showMessageDialog(null,"Book ID must be digit!","Check Digit",1);
            return;
        }

        book = bookController.searchBook(Integer.parseInt(bookIDField.getText()));

        // if book id not exist
        if (book == null)
        {   bookIDField.setText("");
            titleField.setText("");
            authorField.setText("");
            bookIDField4.setText("");
            JOptionPane.showMessageDialog(null,"This book ID cannot be found!","Find BookID",1);
            return;
        }
        else
        {   bookIDField.setText("");
            titleField.setText(book.getTitle());
            authorField.setText(book.getAuthor());
            bookIDField4.setText(Integer.toString(book.getBookID()));
            titleField.setEnabled(true);
            authorField.setEnabled(true);
        }




		
	}

}
