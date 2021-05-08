package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to quit from book management screen to admin menu screen
public class BookManagementQuitButtonListener implements ActionListener {

	private JFrame frame;
	private User user;
	public BookManagementQuitButtonListener(JFrame frame,User user)
	{
		this.frame=frame;
		this.user=user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewAdminMenu menu= new ViewAdminMenu(user);
		menu.setVisible(true);
		frame.dispose();
		
	}

}
