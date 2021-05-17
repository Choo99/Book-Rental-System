package gui.book.admin.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.book.admin.searchBook.ViewAdminViewBook;
import model.User;

//button to go to view book screen
public class BookManagementViewBookButtonListener implements ActionListener{

	private JFrame frame;
	private User user;
	
	public BookManagementViewBookButtonListener (JFrame frame, User user)
	{
		this.frame=frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewAdminViewBook menu = new ViewAdminViewBook(user);
        menu.setVisible(true);
        frame.dispose();

	}

}
