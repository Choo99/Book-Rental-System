package gui.rental.admin.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.rental.admin.bill.payment.ViewBilling;
import model.User;

//button to go to billing menu
public class  RentalMenuPaymentButtonListener implements ActionListener {

    private JFrame frame;
    private User  user;

	public RentalMenuPaymentButtonListener (JFrame frame,User user)
    {
        this.frame=frame;
        this.user = user;
    }

	public void actionPerformed(ActionEvent arg0) {
		
        ViewBilling menu = new ViewBilling (user);
        menu.setVisible(true);
        frame.dispose();
		
	}

}
