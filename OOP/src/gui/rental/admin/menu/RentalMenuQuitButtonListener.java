package gui.rental.admin.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.menu.admin.ViewAdminMenu;
import model.User;

//button to quit from rental menu to admin menu
public class RentalMenuQuitButtonListener implements ActionListener{

		private JFrame frame;
        private User user;
	public RentalMenuQuitButtonListener (JFrame frame,User user)
	{
		this.frame = frame;
        this.user=user;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		ViewAdminMenu menu = new ViewAdminMenu (user);
		menu.setVisible(true);
		frame.dispose();
		
	}

}
