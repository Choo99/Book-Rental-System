package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookController;

import model.Book;

//button to clear input in text field
public class ViewBookClearButtonListener implements ActionListener
{
    private JTable table;
    private DefaultTableModel model;
    
	public ViewBookClearButtonListener(JTable table,DefaultTableModel model)
    {
        this.table = table;
        this.model = model;
    }

	public void actionPerformed(ActionEvent arg0) 
    {
        BookController bookController = new BookController();
        model.setRowCount(0);

        List<Book> bookList = bookController.viewAllBook();
        for(int index = 0; index < bookList.size(); index++)
        {
            Book book = bookList.get(index);
			Object object[] = {book.getBookID(),book.getCopyID(),book.getTitle(),book.getTypeName(),book.getAuthor(),book.getCondition(),book.getPrice()};
			model.addRow(object);
        }
        table.setModel(model);
    }

}
