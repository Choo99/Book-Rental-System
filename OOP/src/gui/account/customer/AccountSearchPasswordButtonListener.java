package gui.account.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.UserController;
import model.User;

public class AccountSearchPasswordButtonListener implements ActionListener {
	
	private ViewAccountSetting frame;
	private User user;
	
	public AccountSearchPasswordButtonListener(ViewAccountSetting frame, User user) {
		this.frame = frame;
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		boolean result = checkPassword();
		
		if(result) {
			frame.getNewPasswordField().setEditable(true);
			frame.getConfirmPasswordField().setEditable(true);
			frame.getSearchPasswordBtn().setEnabled(false);
			frame.getOldPasswordField().setEditable(false);
		}
		
	}
	
	public boolean checkPassword() {
		boolean result = false;
		
		String password = new String(frame.getOldPasswordField().getPassword());
		user.setPassword(password);
		
		UserController controller = new UserController();
		
		System.out.println(user.getPassword());
		if(controller.checkPassword(user.getUserID(), user.getPassword())) {
			frame.getNewPasswordField().setEditable(true);
			frame.getConfirmPasswordField().setEditable(true);
			result = true;
		}
		else {
			JOptionPane.showMessageDialog(frame, "You enter a wrong password", "Error", JOptionPane.ERROR_MESSAGE);
			frame.getOldPasswordField().setText("");
			result = false;
		}
		return result;
	}

}
