package gui.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.login.ViewLogIn;
import model.User;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Font;

public class ViewMain extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User user = new User();
					ViewMain frame = new ViewMain(user);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ViewMain(User user) 
	{
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 574);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 240, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel MainIcon = new JLabel();
		MainIcon.setIcon(new ImageIcon(ViewMain.class.getResource("/png/bookshelf.png")));
		
		JLabel tittle = new JLabel("Welcome to Pisces Book World");
		tittle.setFont(new Font("Palatino Linotype", Font.BOLD, 24));
		JButton logInButton = new JButton("Log In");
		logInButton.setFont(new Font("FangSong", Font.BOLD, 20));
		logInButton.setMaximumSize(new Dimension(73, 23));
		logInButton.setMinimumSize(new Dimension(73, 23));
		
		JButton RegisterButton = new JButton("Register");
		RegisterButton.setFont(new Font("FangSong", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(340)
					.addComponent(MainIcon)
					.addContainerGap(335, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(tittle, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addGap(157))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(247)
					.addComponent(logInButton, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addGap(71)
					.addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(223, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(55)
					.addComponent(MainIcon, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tittle)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(RegisterButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(logInButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(196))
		);
		contentPane.setLayout(gl_contentPane);

		ActionListener actionListener = new RegisterMenuButtonListener(this);
		RegisterButton.addActionListener(actionListener);

		logInButton.addActionListener(new logInActionListener());
	}
	
	private class logInActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			ViewLogIn frame = new ViewLogIn(user);
			frame.setVisible(true);
			dispose();
		}
		
	}
}
