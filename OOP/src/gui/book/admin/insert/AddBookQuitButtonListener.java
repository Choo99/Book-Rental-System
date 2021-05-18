package gui.book.admin.insert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.book.admin.menu.ViewBookManagementMenu;
import model.User;
//quit button in add book screen
public class AddBookQuitButtonListener implements ActionListener{

	private JFrame frame;
	private User user;
	public AddBookQuitButtonListener (JFrame frame, User user)
	{
		this.frame=frame;
		this.user=user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewBookManagementMenu menu = new ViewBookManagementMenu (user);
		menu.setVisible(true);
		frame.dispose();
		
	}

}
