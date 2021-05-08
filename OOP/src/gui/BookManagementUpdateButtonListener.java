package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to go to update book screen
public class BookManagementUpdateButtonListener implements ActionListener {

	private JFrame frame;
	private User user;
	
	public BookManagementUpdateButtonListener (JFrame frame,User user)
	{
		this.frame= frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewAdminUpdateBook menu = new ViewAdminUpdateBook(user);
		menu.setVisible(true);
		frame.dispose();
	}

}
