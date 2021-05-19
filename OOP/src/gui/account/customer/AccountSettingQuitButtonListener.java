package gui.account.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.menu.customer.ViewCustomerMenu;
import model.User;

public class AccountSettingQuitButtonListener implements ActionListener{

	private User user;
	private ViewAccountSetting frame;
	
	public AccountSettingQuitButtonListener(ViewAccountSetting frame, User user) {
		this.user = user;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ViewCustomerMenu view = new ViewCustomerMenu(user);
		view.setVisible(true);
		
		frame.dispose();
	}

}
