package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

//button to select add book
public class AddBookJRadioButtonListener implements ActionListener
{
    private JPanel addBookPanel;
    private JPanel addCopyPanel;
    private JRadioButton addBookRadio;

    AddBookJRadioButtonListener(JRadioButton addBookRadio, JPanel addBookPanel,JPanel addCopyPanel)
    {
        this.addBookRadio = addBookRadio;
        this.addBookPanel = addBookPanel;
        this.addCopyPanel = addCopyPanel;
    }


	public void actionPerformed(ActionEvent action) 
    {
        if(addBookRadio.isSelected())
        {
		    Component component[] = addBookPanel.getComponents();
		    for(int index = 0;index < component.length;index++)
            {
              component[index].setEnabled(true);
            }
             Component component2[] = addCopyPanel.getComponents();
		    for(int index = 0;index < component2.length;index++)
            {
              component2[index].setEnabled(false);
            }
        }
	}
}
