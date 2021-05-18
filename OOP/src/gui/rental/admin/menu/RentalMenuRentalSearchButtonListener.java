package gui.rental.admin.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import gui.rental.admin.search.ViewSearchRental;
import model.User;

//button to go to search rental menu
public class RentalMenuRentalSearchButtonListener implements ActionListener{

	private JFrame frame;

    public RentalMenuRentalSearchButtonListener (JFrame frame,User user)
    {
            this.frame=frame;
    }
	public void actionPerformed(ActionEvent action) {
		
        ViewSearchRental menu = new ViewSearchRental();
        menu.setVisible(true);
		frame.dispose();
	}

}
