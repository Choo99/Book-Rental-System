package gui.book.admin.update;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.BookController;
import model.Book;

//button to update book copy information
public class UpdateBookRenewCopyButtonListener implements ActionListener
{
    private JTextField bookIDField;
    private JTextField copyIDField;
    private JComboBox<String> statusComboBox;


    UpdateBookRenewCopyButtonListener(JTextField bookIDField,JTextField copyIDField,JComboBox<String> statusComboBox)
    {
        this.bookIDField = bookIDField;
        this.copyIDField = copyIDField;
        this.statusComboBox = statusComboBox;
    }
	
	public void actionPerformed(ActionEvent arg0) 
    {
        
        int result = JOptionPane.showConfirmDialog(null,"Do you confirm your data?", "Update", 
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        //Confirm to update
        if(result == 0)
        {
            Book book = new Book();
            book.setBookID(Integer.parseInt(bookIDField.getText()));
            book.setCopyID(Integer.parseInt(copyIDField.getText()));
            book.setCondition(String.valueOf(statusComboBox.getSelectedItem()));
            
            BookController bookController = new BookController();
            int status = bookController.updateCopy(book); 

            // check and update the book status when the copy condition is updated
            if(statusComboBox.getSelectedItem().equals("Broken"))
            {
                bookController.updateBookToNotAvailable();
            }
            else
            {
                bookController.updateBookToAvailable();
            } 

            //successfully update
            if(status != 0)
            {
                JOptionPane.showMessageDialog(null, "Successfully update the copy!", "Update", 1); 
            }
        }
        bookIDField.setText("");
        copyIDField.setText("");
        
        statusComboBox.setSelectedIndex(0);     
	}

}
