package gui.book.admin.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.book.admin.insert.ViewAdminAddBook;
import model.User;

//button to add book screen
public class BookManagementAddBookButtonListener implements ActionListener{

	private JFrame frame;
	private User user;
	
	public BookManagementAddBookButtonListener (JFrame frame, User user)
	{
		this.frame= frame;
		this.user=user;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		ViewAdminAddBook menu = new ViewAdminAddBook(user);
		menu.setVisible(true);
		frame.dispose();
	}

}
