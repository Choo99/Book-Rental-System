package gui.menu.customer;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.User;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewCustomerMenu extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton SearchButton;
	private JButton RentalButton;
	private JButton QuitButton;
	private JLabel tittle;
	private JLabel customerLogo;

	public ViewCustomerMenu(User user) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		SearchButton = new JButton("Search Book");
		SearchButton.setBounds(296, 224, 243, 55);
		SearchButton.setIcon(new ImageIcon(ViewCustomerMenu.class.getResource("/png/search_3.png")));
		SearchButton.setFont(new Font("FangSong", Font.BOLD, 20));
		
		RentalButton = new JButton("Rental Book");
		RentalButton.setBounds(296, 316, 243, 59);
		RentalButton.setIcon(new ImageIcon(ViewCustomerMenu.class.getResource("/png/real-estate_2.png")));
		RentalButton.setFont(new Font("FangSong", Font.BOLD, 20));
		
		QuitButton = new JButton("  Quit");
		QuitButton.setBounds(296, 423, 243, 49);
		QuitButton.setIcon(new ImageIcon(ViewCustomerMenu.class.getResource("/png/exit_1.png")));
		QuitButton.setFont(new Font("FangSong", Font.BOLD, 20));
		
		tittle = new JLabel("Customer  Menu");
		tittle.setBounds(319, 150, 261, 57);
		tittle.setInheritsPopupMenu(false);
		tittle.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		
		customerLogo = new JLabel("");
		customerLogo.setIcon(new ImageIcon(ViewCustomerMenu.class.getResource("/png/stars.png")));
		customerLogo.setBounds(350, 19, 134, 120);
		contentPane.setLayout(null);
		contentPane.add(RentalButton);
		contentPane.add(QuitButton);
		contentPane.add(SearchButton);
		contentPane.add(tittle);
		contentPane.add(customerLogo);
		
		ActionListener actionListenerSearch=new CustomerSearchBookListener(this,user);
		SearchButton.addActionListener(actionListenerSearch);
		
		ActionListener actionListenerRental=new CustomerRentalBookButtonListener(this,user);
		RentalButton.addActionListener(actionListenerRental);
		
		ActionListener actionListenerQuit=new CustomerQuitButtonListener(this,user);
		QuitButton.addActionListener(actionListenerQuit);
	}
}
