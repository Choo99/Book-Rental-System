package gui.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.InputController;
import controller.UserController;
import model.User;

//button for user to search information of a user ID
public class UpdateAccountSearchButtonListener implements ActionListener
{
	private JTextField userIDField;
	private JTextField userIDField2;
	private JTextField nameField;
	private JTextField phoneNumberField;

	public UpdateAccountSearchButtonListener(JTextField userIDField,JTextField nameField, JTextField phoneNumberField, JTextField userIDField2)
	{
		this.userIDField = userIDField;
		this.userIDField2 = userIDField2;
		this.nameField = nameField;
		this.phoneNumberField = phoneNumberField;
	}
	public void actionPerformed(ActionEvent action) 
    {
        UserController userController = new UserController();
        InputController inputController = new InputController ();

		//check empty input
		if(!inputController.isNullOrEmpty(userIDField.getText()))
		{
			JOptionPane.showMessageDialog(null,"User ID cannot be empty!","Check Empty",1);
			return;
		}

		//check digits
		else if(!inputController.isDigit(userIDField.getText()))
		{
			JOptionPane.showMessageDialog(null,"User ID must be digit!","Check Digits",1);
        	userIDField.setText("");
			nameField.setText("");
			phoneNumberField.setText("");
			userIDField2.setText("");
			return;
		}
        User user = userController.searchUser(Integer.parseInt(userIDField.getText()));

		//user found
		if(user != null)
		{
			userIDField.setText("");
			nameField.setText(user.getName());
			phoneNumberField.setText(user.getPhone());
			userIDField2.setText(Integer.toString(user.getUserID()));
		}

		//user not found
		else
		{
			JOptionPane.showMessageDialog(null,"This user ID cannot be found!","Check Digits",1);
			userIDField.setText("");
			nameField.setText("");
			phoneNumberField.setText("");
			userIDField2.setText("");
		}
	}
}
