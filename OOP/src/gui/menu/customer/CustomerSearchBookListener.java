package gui.menu.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.book.customer.ViewCustomerSearchBook;
import model.User;

//button to search book menu screen
public class CustomerSearchBookListener implements ActionListener{
	
	private JFrame frame;
	private User user;
	CustomerSearchBookListener(JFrame frame, User user)
	{
		this.frame = frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent action) 
	{
		ViewCustomerSearchBook bookScreen = new ViewCustomerSearchBook(user);
		bookScreen.setVisible(true);
		frame.dispose();
	}
}
