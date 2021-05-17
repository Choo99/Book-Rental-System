package gui.rental.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//button to delete book from rent list
public class CustomerDeleteRentalButtonListener implements ActionListener{

	private DefaultTableModel model;
	private JTable table;
	
	public CustomerDeleteRentalButtonListener(JTable table, DefaultTableModel model)
	{
		this.model = model;
		this.table = table;
	}
	public void actionPerformed(ActionEvent action) 
	{
		int rows[] = table.getSelectedRows();
		if(rows.length != 0)
		{
			model.removeRow(rows[0]);
		}
	}

}
