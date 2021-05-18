package gui.rental.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.menu.customer.ViewCustomerMenu;
import model.User;

//button to return to customer menu
public class CustomerRentalReturnButtonListener implements ActionListener {

	private JFrame frame;
	private User user;

	public CustomerRentalReturnButtonListener(JFrame frame, User user) {
		this.frame = frame;
		this.user = user;
	}

	public void actionPerformed(ActionEvent arg0) {
		ViewCustomerMenu menu = new ViewCustomerMenu(user);
		menu.setVisible(true);
		frame.dispose();
	}

}
