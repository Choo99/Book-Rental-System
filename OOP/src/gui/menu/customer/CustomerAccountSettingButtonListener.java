package gui.menu.customer;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.account.customer.ViewAccountSetting;
import model.User;

public class CustomerAccountSettingButtonListener implements ActionListener{

	private User user;
	private ViewCustomerMenu frame;
	
	public CustomerAccountSettingButtonListener(ViewCustomerMenu frame,User user) {
		this.frame = frame;
		this.user = user;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		ViewAccountSetting view = new ViewAccountSetting(user);
		view.setVisible(true);
		frame.dispose();
	}

}
