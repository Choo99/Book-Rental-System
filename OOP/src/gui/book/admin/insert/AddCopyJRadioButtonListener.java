package gui.book.admin.insert;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

//button to add copy 
public class AddCopyJRadioButtonListener implements ActionListener
{
    private JPanel addBookPanel;
    private JPanel addCopyPanel;
    private JRadioButton addCopyRadio;

    AddCopyJRadioButtonListener(JRadioButton addCopyRadio, JPanel addBookPanel,JPanel addCopyPanel)
    {
        this.addCopyRadio = addCopyRadio;
        this.addBookPanel = addBookPanel;
        this.addCopyPanel = addCopyPanel;
    }

	public void actionPerformed(ActionEvent action) 
    {
        if(addCopyRadio.isSelected())
        {
		    Component component[] = addCopyPanel.getComponents();
		    for(int index = 0;index < component.length;index++)
            {
              component[index].setEnabled(true);
            }
             Component component2[] = addBookPanel.getComponents();
		    for(int index = 0;index < component2.length;index++)
            {
              component2[index].setEnabled(false);
            }
        }
	}
}
