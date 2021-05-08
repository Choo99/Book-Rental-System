package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import controller.InputController;
import model.Book;
import model.User;
//button in add book screen to add new books
public class AddBookButtonListener implements ActionListener {
 private JFrame frame;
 
 private JTextField titleField;
 private JTextField authorField;
 private JComboBox bookType;
 private JTextField quantityField;
 private Book book;
 private BookController bookController; 
 private User user;

 public AddBookButtonListener (JFrame frame, JTextField titleField, JTextField authorField, JComboBox bookType, JTextField quantityField, User user)
 {
     this.frame=frame;
     this.titleField = titleField;
     this.authorField=authorField;
     this.bookType=bookType;
     this.quantityField = quantityField;
     this.user = user;
 }


public void actionPerformed(ActionEvent arg0)
 {
	book= new Book();
    bookController = new BookController();
    InputController inputController = new InputController();
    int bookID;
    List<Book> bookList = new ArrayList<Book>();

    //not allow empty and invalid format input
    if(!inputController.isNullOrEmpty(titleField.getText()) ||!inputController.isNullOrEmpty(authorField.getText())||!inputController.isNullOrEmpty(quantityField.getText()))
    {
        JOptionPane.showMessageDialog(null,"Empty inputs are not available!","Check Empty",1);
        return;
    }
    else if(!inputController.isDigit(quantityField.getText()))
    {
        JOptionPane.showMessageDialog(null,"Quantity must be digit!","Check Digits",1);
        quantityField.setText("");
        return;
    }
    else if(Integer.parseInt(quantityField.getText()) == 0 )
    {
        JOptionPane.showMessageDialog(null,"Quantity must be at least 1!","Check Zero",1);
        quantityField.setText("");
        return;
    }
   
    int result = JOptionPane.showConfirmDialog(null,"Do you confirm your data?", "Update", 
    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    if(result == 0)
    {
        book.setTitle(titleField.getText());
        book.setAuthor(authorField.getText());
        book.setTypeID(bookController.searchTypeID((String)bookType.getSelectedItem()));

        bookID = bookController.insertBook(book);
        for(int index = 0 ;index <Integer.parseInt(quantityField.getText()); index++)
        {
            bookController.insertCopy(bookID);
            Book book = new Book();
            book.setBookID(bookID);
            book.setCopyID(bookController.searchMaxCopyID(bookID));
            bookList.add(book);
        } 
        // check and update book status to available after new books and copies are added
		bookController.updateBookToAvailable();
        JOptionPane.showMessageDialog(null,"Add the Book successfully !","Success",1);
        ViewAdminAddedBookList slip = new ViewAdminAddedBookList(bookList,user);
        slip.setVisible(true);
    }
    titleField.setText("");
    authorField.setText("");
    quantityField.setText("");
}



}
