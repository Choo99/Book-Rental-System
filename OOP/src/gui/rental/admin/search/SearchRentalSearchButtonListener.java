package gui.rental.admin.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.InputController;
import controller.RentalController;
import model.Rental;

//button to search rental ID
public class SearchRentalSearchButtonListener implements ActionListener
{
    private JTextField rentalIDField;
    private JTable bookRentalTable;
    private DefaultTableModel model; 

    public SearchRentalSearchButtonListener(JTextField rentalIDField,JTable bookRentalTable,DefaultTableModel model)
    {
        this.rentalIDField = rentalIDField;
        this.bookRentalTable = bookRentalTable;
        this.model = model;
    }
	
	public void actionPerformed(ActionEvent arg0) 
    {
        RentalController rentalController = new RentalController();
        InputController inputController = new InputController ();
        Rental rental;

        //check digits
        if(!inputController.isDigit(rentalIDField.getText()))
        {
            JOptionPane.showMessageDialog(null,"Rental ID must be digit!","Check Digits",1);
            rentalIDField.setText("");
            return;
        }

      
        rental =  rentalController.searchAllRental(Integer.parseInt(rentalIDField.getText()));
         //no rental ID found
        if(rental == null)
        {
            JOptionPane.showMessageDialog(null,"This Rental ID cannot be found!","Find Rental ID",1);
            rentalIDField.setText("");
            return;
        }
      
        model.setRowCount(0); 
        Object object[] = {rental.getRentID(),rental.getCustomerName(),rental.getRentDate(),rental.getExpectedDate(),
        rental.getReturnDate(),rental.getRentFee(),rental.getStatus()};
        model.addRow(object);
        bookRentalTable.setModel(model);
	}
}
