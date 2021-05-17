package gui.register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.InputController;
import controller.UserController;
import gui.main.ViewMain;
import model.User;

//button to register user
public class RegisterButtonListener implements ActionListener {

	private ViewRegister frame;
	private JTextField name, ic, phone;
	private JPasswordField password1, password2;
	private JComboBox<String> role;

	public RegisterButtonListener(ViewRegister frame) {
		this.frame = frame;
		this.name = frame.getNameField();
		this.ic = frame.getICField();
		this.phone = frame.getPhoneField();
		this.password1 = frame.getPasswordField();
		this.password2 = frame.getPasswordField_1();
		this.role = frame.getRoleComboBox();

	}

	public void actionPerformed(ActionEvent arg0) {
		User user = new User();
		UserController userController = new UserController();
		InputController inputController = new InputController();
		ViewMain main;
		int status, newUserID;

		String message = "";
		// check empty input
		if (!inputController.isNullOrEmpty(name.getText())
				|| !inputController.isNullOrEmpty(new String(password1.getPassword()))
				|| !inputController.isNullOrEmpty(new String(password2.getPassword()))
				|| !inputController.isNullOrEmpty(ic.getText()) || !inputController.isNullOrEmpty(phone.getText())) {
			message = "Empty inputs are not available!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "CheckEmpty", 1);
			return;
		}
		// check length of name
		else if (!inputController.isOverLimit(name.getText(), 30)) {
			message = "Name cannot exist 30 characters!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "CheckName", 1);
			name.setText("");
			return;
		}

		// check digits for IC
		if (!inputController.isValidIc(ic.getText())) {
			message = "IC must be 12 digits!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "CheckIC", 1);
			ic.setText("");
			return;
		}

		// check IC exists or not
		if (userController.isUserICExist(ic.getText())) {
			message = "IC exist!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "CheckExistIc", 1);
			ic.setText("");
			return;
		}

		// check length of phone number
		if (!inputController.isValidPhoneNo(phone.getText())) {
			message = "Phone number must be 10 to 12 digits!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "CheckPhone", 1);
			phone.setText("");
			return;
		}

		// compare 2 passward
		if (new String(password1.getPassword()).equals(new String(password2.getPassword()))) {
			user.setPassword(new String(password1.getPassword()));
			user.setName(name.getText());
			user.setIC(ic.getText());
			user.setPhone(phone.getText());
			user.setRole((String) role.getSelectedItem());
			status = userController.addUser(user);

			// successfully register
			if (status != 0) {
				newUserID = userController.getNewUserID();
				message = "Register Successfully! Please Login With This ID : ";
				frame.setMessage(message);
				JOptionPane.showMessageDialog(null, message + newUserID, "Register", 1);
				main = new ViewMain(user);
				main.setVisible(true);
				frame.dispose();
			}
		} else {
			message = "Password and confirm password must be same!";
			frame.setMessage(message);
			JOptionPane.showMessageDialog(null, message, "Register", 1);
			password1.setText("");
			password2.setText("");
		}

	}

}
