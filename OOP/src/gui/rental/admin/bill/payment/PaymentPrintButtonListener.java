package gui.rental.admin.bill.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.rental.admin.bill.receipt.ViewReceipt;
import model.Rental;
import model.User;

//button to go to receipt menu screen
public class PaymentPrintButtonListener implements ActionListener {

	private JFrame frame;
	private JTextField rentalIDField;
	private User user;

	public PaymentPrintButtonListener(JFrame frame, JTextField rentalIDField, User user) {
		this.frame = frame;
		this.rentalIDField = rentalIDField;
		this.user = user;
	}

	public void actionPerformed(ActionEvent arg0) {
		int result = JOptionPane.showConfirmDialog(null, "Do you confirm your data?", "Update",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == 0) {
			Rental rental = new Rental();
			rental.setRentID(Integer.parseInt(rentalIDField.getText()));

			ViewReceipt menu = new ViewReceipt(rental, user);
			menu.setVisible(true);
			frame.dispose();
		}

	}

}
