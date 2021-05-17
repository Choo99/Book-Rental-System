package junitTest;

import javax.swing.JOptionPane;

public class OptionPane {

	public static void main(String arg[]) {
		OptionPane option = new OptionPane();

		System.out.print(option.option.getMessage());
	}
	
	public JOptionPane option;
	
	@SuppressWarnings("static-access")
	public OptionPane(){
		option = new JOptionPane("hi");
		option.showMessageDialog(option, "haha");
	}
	
}
