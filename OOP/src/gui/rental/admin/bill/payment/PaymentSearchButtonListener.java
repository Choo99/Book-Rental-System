package gui.rental.admin.bill.payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.InputController;
import controller.RentalController;
import model.Rental;

//button to search rental ID
public class PaymentSearchButtonListener implements ActionListener {

	private JTextField rentalIDField;
	private JTextField nameField;
	private JTextField currentDateField;
	private JTextField expectedField;
	private JTextField rentalFeeField;
	private JButton printButton;
	private JTextField rentalIDField2;

	public PaymentSearchButtonListener(JTextField rentalIDField, JTextField nameField, JTextField currentDateField,
			JTextField expectedField, JTextField rentalFeeField, JButton printButton, JTextField rentalIDField2) {
		this.rentalIDField = rentalIDField;
		this.nameField = nameField;
		this.currentDateField = currentDateField;
		this.expectedField = expectedField;
		this.rentalFeeField = rentalFeeField;
		this.printButton = printButton;
		this.rentalIDField2 = rentalIDField2;
	}

	public void actionPerformed(ActionEvent arg0) {

		RentalController rentalController = new RentalController();
		InputController inputController = new InputController();

		// check empty input
		if (!inputController.isNullOrEmpty(rentalIDField.getText())) {
			JOptionPane.showMessageDialog(null, "Rental ID cannot be empty!", "Check Empty", 1);
			return;
		}

		// check digits
		else if (!inputController.isDigit(rentalIDField.getText())) {
			JOptionPane.showMessageDialog(null, "Rental ID must be digit!", "Check Digits", 1);
			rentalIDField.setText("");
			return;
		}

		Rental rental = rentalController.searchRentalFee(Integer.parseInt(rentalIDField.getText()));

		// no rental ID found
		if (rental == null) {
			JOptionPane.showMessageDialog(null, "This Rental ID cannot be found!", "Find Rental ID", 1);
			rentalIDField.setText("");
			nameField.setText("");
			currentDateField.setText("");
			expectedField.setText("");
			rentalFeeField.setText("");
			rentalIDField2.setText("");
			printButton.setEnabled(false);
			return;
		}
		rentalIDField.setText("");
		printButton.setEnabled(true);
		rentalIDField2.setText(Integer.toString(rental.getRentID()));
		nameField.setText(rental.getCustomerName());
		currentDateField.setText(rental.getRentDate());
		expectedField.setText(rental.getExpectedDate());
		rentalFeeField.setText(Double.toString(rental.getRentFee()));

		nameField.setEditable(false);
		currentDateField.setEditable(false);
		expectedField.setEditable(false);
		rentalFeeField.setEditable(false);

	}

}
