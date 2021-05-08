package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.UserController;
import model.User;

//button to update account information
public class UpdateAccountRenewButtonListener implements ActionListener
{
    private JTextField userIDField2;
    private JTextField nameField;
    private JTextField phoneNumberField;

    public UpdateAccountRenewButtonListener(JTextField userIDField2,JTextField nameField,JTextField phoneNumberField)
    {
        this.userIDField2 = userIDField2;
        this.nameField = nameField;
        this.phoneNumberField = phoneNumberField;
    }

	public void actionPerformed(ActionEvent arg0) 
    {
        int result = JOptionPane.showConfirmDialog(null,"Do you confirm your data?", "Update", 
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        //confirm renew
        if(result == 0)
        {
		    User user = new User();
            user.setUserID(Integer.parseInt(userIDField2.getText()));
            user.setName(nameField.getText());
            user.setPhone(phoneNumberField.getText());		

             UserController userController = new UserController();
            int status = userController.updateAccount(user);

            //successfully update
            if(status!= 0)
            {
             JOptionPane.showMessageDialog(null,"Update Successfully!","Update",1);
            }
        }
        userIDField2.setText("");
        nameField.setText("");
        phoneNumberField.setText("");
	}    
}
