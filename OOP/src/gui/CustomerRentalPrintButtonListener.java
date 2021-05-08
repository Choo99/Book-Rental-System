package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.User;

//button to pop out inform message and back to customer menu screen
public class CustomerRentalPrintButtonListener implements ActionListener {
	
	private JFrame frame;
	private User user;

	public CustomerRentalPrintButtonListener (JFrame frame,User user)
	{
		this.frame = frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewCustomerMenu menu = new ViewCustomerMenu(user);
		JOptionPane.showMessageDialog(null,"Please pay at counter!","PrintRental",1);
		menu.setVisible(true);
		frame.dispose();
	}
	
	
	
	
	
	

}
