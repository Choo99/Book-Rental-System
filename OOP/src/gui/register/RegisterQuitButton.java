package gui.register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.main.ViewMain;
import model.User;

//button to quit from register menu to main menu
public class RegisterQuitButton implements ActionListener{

	private JFrame frame;
	private User user;
	public RegisterQuitButton (JFrame frame,User user)
	{
		this.frame = frame;
        this.user =user;
	}
	
	public void actionPerformed(ActionEvent arg0) 
	{
		ViewMain main = new ViewMain(user);
		main.setVisible(true);
		frame.dispose();
		
	}
}
