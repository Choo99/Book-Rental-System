package gui.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.InputController;
import controller.UserController;
import gui.menu.admin.ViewAdminMenu;
import gui.menu.customer.ViewCustomerMenu;
import model.User;

//button to log in
public class LogInButtonListener implements ActionListener {

	private ViewLogIn jframe;
	private JTextField userIDField;
	private JPasswordField passwordField;
	public User user;

	public LogInButtonListener(ViewLogIn jframe, JTextField userIDField, JPasswordField passwordField, User user) {
		this.user = user;
		this.jframe = jframe;
		this.userIDField = userIDField;
		this.passwordField = passwordField;
	}

	public void actionPerformed(ActionEvent action) {

		InputController inputController = new InputController();

		// check digits
		if (!inputController.isDigit(userIDField.getText())) {
			JOptionPane.showMessageDialog(null, "Please key in digit for User ID", "Error", 1);
			return;
		}

		user.setUserID(Integer.parseInt(userIDField.getText()));
		user.setPassword(new String(passwordField.getPassword()));

		UserController userController = new UserController();

		// correct user ID and password
		if (userController.checkPassword(user.getUserID(), user.getPassword())) {
			String message = "Successfully login";
			jframe.setMessage(message);
			JOptionPane.showMessageDialog(null, "Successfully login", "Log In", 1);

			// if user ID is admin
			if (userController.getUserRole(user.getUserID()).equals("Admin")) {

				ViewAdminMenu adminMenu = new ViewAdminMenu(user);
				adminMenu.setVisible(true);
				jframe.dispose();
			}
			// user ID is customer
			else {
				jframe.dispose();
				ViewCustomerMenu customerMenu = new ViewCustomerMenu(user);
				customerMenu.setVisible(true);
			}
		}
		// wrong username or password
		else {
			JOptionPane.showMessageDialog(null, "INCORRECT User ID Or Password ! ", "LogIn", 1);
			userIDField.setText("");
			passwordField.setText("");
		}
	}
}
