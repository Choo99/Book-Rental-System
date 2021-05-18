package gui.book.admin.searchBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

import gui.book.admin.menu.ViewBookManagementMenu;
import model.User;

//button to quit from view book menu to book management menu
public class ViewBookQuitButtonListener implements ActionListener{


	private JFrame frame;
	private User user;
	public  ViewBookQuitButtonListener(JFrame frame,User user)
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
