package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.User;

//button to return from rental menu to book return menu
public class RentalMenuBookReturnButtonListener implements ActionListener{

	private JFrame frame;
    private User user;


    public RentalMenuBookReturnButtonListener (JFrame frame, User user)
    {
            this.frame=frame;
            this.user=user;
    }
	public void actionPerformed(ActionEvent action) {
		
        ViewBookReturn menu = new ViewBookReturn(user);
        menu.setVisible(true);
		frame.dispose();
	}

}