package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to go to search rental menu
public class RentalMenuRentalSearchButtonListener implements ActionListener{

	private JFrame frame;
    private User user;

    public RentalMenuRentalSearchButtonListener (JFrame frame,User user)
    {
            this.frame=frame;
            this.user = user;
    }
	public void actionPerformed(ActionEvent action) {
		
        ViewSearchRental menu = new ViewSearchRental();
        menu.setVisible(true);
		frame.dispose();
	}

}
