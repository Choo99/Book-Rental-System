package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to update account menu
public class AdminMenuUpdateButtonListener implements ActionListener
{
	private JFrame frame;
	private User user;
	
	public AdminMenuUpdateButtonListener(JFrame frame,User user)
	{
		this.frame = frame;
		this.user = user;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		ViewUpdateAccount updateAccount = new ViewUpdateAccount(user);
		updateAccount.setVisible(true);
		frame.dispose();
		
	}

}
