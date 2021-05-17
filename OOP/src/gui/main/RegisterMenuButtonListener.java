package gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.register.ViewRegister;

//btuton to go to register menu 
public class RegisterMenuButtonListener implements ActionListener{
	
	private JFrame frame;
	
	public RegisterMenuButtonListener(JFrame frame)
	{
		this.frame = frame;
	}


	public void actionPerformed(ActionEvent arg0) 
	{
		ViewRegister register = new ViewRegister();
		register.setVisible(true);
		frame.dispose();
	}

}
