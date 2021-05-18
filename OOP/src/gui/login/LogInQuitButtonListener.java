package gui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.main.ViewMain;
import model.User;

//button to quit from log in menu to main menu
public class LogInQuitButtonListener implements ActionListener {

	private JFrame frame;
	private User user;
	
	public LogInQuitButtonListener (JFrame frame,User  user)
	{
		this.frame = frame;
		this.user= user;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		ViewMain menu = new ViewMain(user);
		menu.setVisible(true);
		frame.dispose();
		
	}

}
