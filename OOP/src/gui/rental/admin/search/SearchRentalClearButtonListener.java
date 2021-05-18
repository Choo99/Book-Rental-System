package gui.rental.admin.search;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.RentalController;
import model.Rental;

//button to clear input of rental ID Field
public class SearchRentalClearButtonListener implements ActionListener{

	private JTextField rentalIDField;
    private DefaultTableModel model;

	public SearchRentalClearButtonListener (JTextField rentalIDField, DefaultTableModel model)
	{
		this.rentalIDField = rentalIDField;
        this.model = model;
	}
	
	public void actionPerformed(ActionEvent action) {
		
		RentalController rentalController = new RentalController();
		
		rentalIDField.setText("");		
		model.setRowCount(0);
		List<Rental> rentalList = rentalController.viewAllRentList();
		for(int index =0; index < rentalList.size();index++)
		{
			Rental rent = rentalList.get(index);
			Object object[] = {rent.getRentID(),rent.getCustomerName(),rent.getRentDate(),
			rent.getExpectedDate(),rent.getReturnDate(),rent.getRentFee(),rent.getStatus()};
			model.addRow(object);
		}
       
        
        
		
	}

}
