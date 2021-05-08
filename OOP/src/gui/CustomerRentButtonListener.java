package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import controller.RentalController;
import model.User;
import model.Book;
import model.Rental;

//button to rent and pop out message and go to rental slip screen
public class CustomerRentButtonListener implements ActionListener
{
	private JFrame frame;
	private DefaultTableModel model;
	private User user;

	public CustomerRentButtonListener(JFrame frame,DefaultTableModel model,User user)
	{
		this.frame = frame;
		this.user = user;
		this.model = model;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		BookController bookController = new BookController();

		//if no book in list
		if(model.getRowCount() == 0)
		{
			JOptionPane.showMessageDialog(null,"Please add at least one book into list !","Error",1);
		}
		else 
		{
			int result = JOptionPane.showConfirmDialog(null,"Do you confirm your data?", "Update", 
        	JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			//confirmation to rent
			if(result == 0)
			{
				RentalController rentController = new RentalController();
				
				rentController.insertRental(user);
				Rental rental = new Rental();
				rental.setRentID(rentController.maxRental());
		
				for(int index = 0; index < model.getRowCount(); index++)
				{				
					rental.setBookID(Integer.parseInt(model.getValueAt(index, 0).toString()));
					rental.setCopyID(Integer.parseInt(model.getValueAt(index, 1).toString()));
					rentController.insertRentalCopy(rental);
				
					bookController.updateRentBook(rental.getBookID(),rental.getCopyID());
				}

				// check and update available book to not available after user rent books
				bookController.updateBookToNotAvailable();
				
				JOptionPane.showMessageDialog(null,"Please print the slip!","Rent",1);
				ViewRentalSlip slip = new ViewRentalSlip(rental,user);
				slip.setVisible(true);
				frame.dispose();
			}
		}
	}

}
