package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.InputController;
import controller.RentalController;
import model.Rental;

//button to search rental information by rental ID
public class BookReturnSearchButtonListener implements ActionListener{

    private JTextField rentalIDField;
	private JTextField customerNameField;
	private JTextField expectedDateField;
	private JTextField returnDateField;
	private JTextField rentalIDField2;

    public BookReturnSearchButtonListener (JTextField rentalIDField, JTextField customerNameField, JTextField expectedDateField,JTextField returnDateField, JTextField rentalIDField2)
    {
        this.rentalIDField=rentalIDField;
        this.customerNameField=customerNameField;
        this.expectedDateField=expectedDateField;
        this.returnDateField=returnDateField;
		this.rentalIDField2= rentalIDField2;
    }

	public void actionPerformed(ActionEvent action) 
    {
		returnDateField.setForeground(Color.BLACK);
		
		RentalController rentalController = new RentalController();
	    InputController inputController = new InputController ();

		//check empty input
        if(!inputController.isNullOrEmpty(rentalIDField.getText()))
		{
			JOptionPane.showMessageDialog(null,"Rental ID cannot be empty!","Check Empty",1);
        	return;
		}

		//check digits
		else if (!inputController.isDigit(rentalIDField.getText()))
		{
			JOptionPane.showMessageDialog(null,"Rental ID must be digit!","Check Digits",1);
			rentalIDField.setText("");
			customerNameField.setText("");
			expectedDateField.setText("");
			returnDateField.setText("");
			rentalIDField2.setText("");
			return;
		}

		Rental rental = rentalController.searchReturnBook(Integer.parseInt(rentalIDField.getText()));

		//rental ID not found
        if(rental==null)
        {
            JOptionPane.showMessageDialog(null,"This Rental ID cannot be found!","Find Rental ID",1);
			rentalIDField.setText("No result found");
			customerNameField.setText("");
			expectedDateField.setText("");
			returnDateField.setText("");
			rentalIDField2.setText("");
			return;
        }

        customerNameField.setText(rental.getCustomerName());
		int dateDiff = 0;
		dateDiff = rentalController.differentDate(rental.getExpectedDate(), rentalController.currentDate());
		if(dateDiff > 0)
		{
			returnDateField.setForeground(Color.RED);
		}
		rentalIDField.setText("");
		rentalIDField2.setText(Integer.toString(rental.getRentID()));
		expectedDateField.setText(rental.getExpectedDate());
		returnDateField.setText(rentalController.currentDate());

        customerNameField.setEditable(false);
        expectedDateField.setEditable(false);
		returnDateField.setEditable(false);
        


	}
}
