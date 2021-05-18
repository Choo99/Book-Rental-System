package gui.menu.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.main.ViewMain;
import model.User;

//btuton to quit from customer menu screen to main menu screen
public class CustomerQuitButtonListener implements ActionListener{

	JFrame frame;
	User user;
	CustomerQuitButtonListener(JFrame frame,User user)
	{
		this.frame=frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent action) {
		
		ViewMain menu = new ViewMain(user);
		menu.setVisible(true);
		frame.dispose();
	}
}