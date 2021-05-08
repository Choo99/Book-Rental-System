package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.InputController;
import controller.UserController;
import model.User;

//button to register user
public class RegisterButtonListener implements ActionListener{
	
	private JFrame frame;
	private JTextField name, ic, phone;
	private JPasswordField password1, password2;
	private JComboBox role;
	
	public RegisterButtonListener (JFrame frame, JTextField name, JTextField ic, JTextField phone,JPasswordField password1, JPasswordField password2, JComboBox role )
	{
		this.frame=frame;
		this.name=name;
		this.ic=ic;
		this.phone=phone;
		this.password1=password1;
		this.password2= password2;
		this.role=role;
		
	}

	public void actionPerformed(ActionEvent arg0) {
		User user = new User();
		UserController userController = new UserController();
		InputController inputController = new InputController();
		ViewMain main;
		int status, newUserID;

		//check empty input
		if (!inputController.isNullOrEmpty(name.getText()) || !inputController.isNullOrEmpty(new String (password1.getPassword())) || !inputController.isNullOrEmpty(new String (password2.getPassword())) || !inputController.isNullOrEmpty(ic.getText())||!inputController.isNullOrEmpty(phone.getText()))
		{
			JOptionPane.showMessageDialog(null,"Empty inputs are not available!","CheckEmpty",1);
			return;
		}
		//check length of name
		else if(!inputController.isOverLimit(name.getText(), 30))
		{
			JOptionPane.showMessageDialog(null,"Name cannot exist 30 characters!","CheckName",1);
			name.setText("");
			return;
		}

		//check digits for IC
		if(!inputController.isValidIc(ic.getText()) )
		{
			JOptionPane.showMessageDialog(null,"IC must be 12 digits!","CheckIC",1);
			ic.setText("666");
			return;
		}
		
		//check IC exists or not
		if (userController.isUserICExist(ic.getText()))
		{
			JOptionPane.showMessageDialog(null,"IC exist!","CheckExistIc",1);
			ic.setText("");
			return;
		}

		//check length of phone number
		if(!inputController.isValidPhoneNo(phone.getText()))
		{
			JOptionPane.showMessageDialog(null,"Phone number must be 10 to 12 digits!","CheckPhone",1);
			phone.setText("666");
			return;		
		}

		//compare 2 passward 
		if(new String (password1.getPassword()).equals(new String (password2.getPassword())))
		{
			user.setPassword(new String (password1.getPassword()));
			user.setName(name.getText());
			user.setIC(ic.getText());
			user.setPhone(phone.getText());
			user.setRole((String)role.getSelectedItem());
			status= userController.addUser(user);
			
			//successfully register
			if(status!=0)
			{
				newUserID = userController.getNewUserID();
				JOptionPane.showMessageDialog(null,"Register Successfully! Please Login With This ID : "+ newUserID,"Register",1);
				main = new ViewMain(user);
				main.setVisible(true);
				frame.dispose();
			}
		}
		else
		{
				password1.setText("");
				password2.setText("");
		}
		
		
		
		
		
	}

}
