package gui.menu.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.rental.admin.menu.ViewAdminRentalMenu;
import model.User;

//button to rental management menu
public class AdminRentalManagementButtonListener implements ActionListener
 {
    private JFrame frame;
    private User user;

    public AdminRentalManagementButtonListener (JFrame frame,User user)
    {
        this.frame=frame;
        this.user=user;
    }

	public void actionPerformed(ActionEvent action) 
    {
        ViewAdminRentalMenu menu = new ViewAdminRentalMenu (user);
        menu.setVisible(true);
        frame.dispose();
	}

}
