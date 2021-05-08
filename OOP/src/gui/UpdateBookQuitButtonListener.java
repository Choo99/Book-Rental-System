package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to quit form update book to book management menu
public class UpdateBookQuitButtonListener implements ActionListener {

	private JFrame frame;
	private User user;
	
	public UpdateBookQuitButtonListener (JFrame frame,User user)
	{
		this.frame = frame;
		this.user=user;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		ViewBookManagementMenu menu = new ViewBookManagementMenu (user);
		menu.setVisible(true);
		frame.dispose();
		
	}

}
