package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to return from search book menu screen to customer menu screen
public class CustomerSearchBookReturnButtonListener implements ActionListener{

	private JFrame frame;
	private User user;
	
	CustomerSearchBookReturnButtonListener(JFrame frame,User user)
	{
		this.frame = frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent action) 
	{
		ViewCustomerMenu customerMenu = new ViewCustomerMenu(user);
		customerMenu.setVisible(true);
		frame.dispose();
	}

	
}
