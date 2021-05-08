package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to quit from admin menu
public class AdminQuitButtonListener implements ActionListener 
{
	private JFrame frame;
	private User user;
	
	public AdminQuitButtonListener(JFrame frame, User user)
	{
		this.frame=frame;
		this.user =user;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{		
		ViewMain main = new ViewMain(user);
		main.setVisible(true);
		frame.dispose();
	}
	

}
