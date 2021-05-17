package gui.rental.admin.returnBook.overdue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.rental.admin.menu.ViewAdminRentalMenu;
import model.User;

//button to go to admin rental menu 
public class ReceiptOkButtonListener2 implements ActionListener {

	private JFrame frame;
	private User user;

	public ReceiptOkButtonListener2(JFrame frame, User user) {
		this.frame = frame;
		this.user = user;
	}

	public void actionPerformed(ActionEvent arg0) {
		ViewAdminRentalMenu menu = new ViewAdminRentalMenu(user);
		menu.setVisible(true);
		frame.dispose();
	}

}
