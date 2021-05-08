package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import model.User;

//button to go to customer rental screen
public class CustomerRentalBookButtonListener implements ActionListener{

	private JFrame frame;
	private User user;
	
	CustomerRentalBookButtonListener(JFrame frame,User user)
	{
		this.frame = frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent action)
	{	
		ViewCustomerRental customerRental = new ViewCustomerRental(user);
		customerRental.setVisible(true);

		frame.dispose();
	}
}
