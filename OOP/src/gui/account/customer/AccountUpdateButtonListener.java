package gui.account.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.InputController;
import controller.UserController;
import gui.login.ViewLogIn;
import gui.menu.customer.ViewCustomerMenu;
import model.User;

public class AccountUpdateButtonListener implements ActionListener {

	private ViewAccountSetting frame;
	private User user;

	public AccountUpdateButtonListener(ViewAccountSetting frame, User user) {
		this.frame = frame;
		this.user = user;
	}

	public void actionPerformed(ActionEvent arg0) {

		UserController controller = new UserController();
		int updateResult = -1;

		boolean isPasswordField = checkField();
		if (isPasswordField) {
			if (checkNewPassword()) {
				boolean format = getInformation(isPasswordField);
				if(!format) {
					return;
				}
				updateResult = controller.updateAccountPassword(user);
			} else {
				JOptionPane.showMessageDialog(null, "New Password and Confirm Password not same!", "Error",
						JOptionPane.ERROR_MESSAGE);
				reset();
			}
		} else {
			boolean format = getInformation(isPasswordField);
			if(!format) {
				return;
			}
			updateResult = controller.updateAccountInfo(user);
		}

		if (updateResult == 1) {
			if(isPasswordField) {
				JOptionPane.showMessageDialog(frame, "Update Information and Password Successfully! Please login with new password!", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				redirectHome();
			}
			else {
			JOptionPane.showMessageDialog(frame, "Update Information Successfully!", "Success",
					JOptionPane.INFORMATION_MESSAGE);
			redirect();
			}
		} else if (updateResult == 2) {
			JOptionPane.showMessageDialog(frame, "Fail to update! Please try again!", "Error",
					JOptionPane.ERROR_MESSAGE);
			redirect();
		}
	}
	
	public void redirectHome() {
		ViewLogIn login = new ViewLogIn(user);
		login.setVisible(true);
		frame.dispose();
	}

	public void redirect() {
		ViewCustomerMenu menu = new ViewCustomerMenu(user);
		menu.setVisible(true);
		frame.dispose();
	}
	
	public void reset() {
		frame.getNewPasswordField().setText("");
		frame.getConfirmPasswordField().setText("");
		frame.getOldPasswordField().setText("");
		frame.getOldPasswordField().setEditable(true);
		frame.getSearchPasswordBtn().setEnabled(true);
		frame.getNewPasswordField().setEditable(false);
		frame.getConfirmPasswordField().setEditable(false);
	}

	public boolean checkInformation(boolean isPasswordField) {
		InputController controller = new InputController();
		if (isPasswordField) {
			String newPassword = new String(frame.getNewPasswordField().getPassword());
			if (newPassword.length() < 6) {
				JOptionPane.showMessageDialog(frame, "Password at least six digits!", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		if (!controller.isNullOrEmpty(frame.getNameField().getText())
				|| !controller.isNullOrEmpty(frame.getICField().getText())
				|| !controller.isNullOrEmpty(frame.getPhoneField().getText())) {
			JOptionPane.showMessageDialog(frame, "Empty input is not available", "Error", JOptionPane.ERROR_MESSAGE);
			return false; 
		} else if (!controller.isValidIc(frame.getICField().getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid IC!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (!controller.isValidPhoneNo(frame.getPhoneField().getText())) {
			JOptionPane.showMessageDialog(frame, "Invalid Phone Numer!", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} else {
			return true;
		}
	}

	public boolean getInformation(boolean isPasswordField) {
		boolean result = checkInformation(isPasswordField);
		if (result) {
			String name = frame.getNameField().getText();
			user.setName(name);

			String ic = frame.getICField().getText();
			user.setIC(ic);

			String phone = frame.getPhoneField().getText();
			user.setPhone(phone);

			if (isPasswordField) {
				String newPassword = new String(frame.getNewPasswordField().getPassword());
				user.setPassword(newPassword);
			}
		}
		else {
			frame.setInformation();
			if(isPasswordField) {
				reset();
			}
			return result;
		}
	
		boolean isSame = isInfoSame(isPasswordField);
		if(isSame) {
			JOptionPane.showMessageDialog(frame, "Your information same as before!","Error",JOptionPane.ERROR_MESSAGE);
			if(isPasswordField) {
				reset();
			}
			result = false;
		}
		return result;
	}
	
	public boolean isInfoSame(boolean isPasswordField) {
		
		UserController controller = new UserController();
		User user = controller.searchUserInfo(this.user.getUserID());
		if(isPasswordField) {
			if(user.getName().equals(this.user.getName()) &&
					user.getIC().equals(this.user.getIC()) &&
					user.getPhone().equals(this.user.getPhone()) &&
					user.getPassword().equals(this.user.getPassword())) {
				return true;
			}
		}
		else {
			if(user.getName().equals(this.user.getName()) &&
					user.getIC().equals(this.user.getIC()) &&
					user.getPhone().equals(this.user.getPhone())) {
				return true;
			}
		}	
		return false;
	}

	public boolean checkField() {
		if (frame.getConfirmPasswordField().isEditable() && frame.getNewPasswordField().isEditable()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkNewPassword() {
		String newPassword = new String(frame.getNewPasswordField().getPassword());
		String confirmPassword = new String(frame.getConfirmPasswordField().getPassword());
		if (newPassword.equals(confirmPassword)) {
			return true;
		} else {
			return false;
		}
	}

}
