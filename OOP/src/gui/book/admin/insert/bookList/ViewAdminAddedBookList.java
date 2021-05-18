package gui.book.admin.insert.bookList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Book;
import model.User;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ViewAdminAddedBookList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable addedBookList;
	private JLabel lblNewLabel;
	private JButton okButton;

	public ViewAdminAddedBookList(List<Book> bookList, User user) {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 45, 367, 177);
		contentPane.add(scrollPane);
		
		addedBookList = new JTable();
		addedBookList.setPreferredScrollableViewportSize(addedBookList.getPreferredSize());
		scrollPane.setViewportView(addedBookList);

		String column[] ={"BookID","CopyID"};
		DefaultTableModel model = new DefaultTableModel(column,0);
		for(int index = 0; index < bookList.size();index++)
		{
			Object row[] ={bookList.get(index).getBookID(),bookList.get(index).getCopyID()};
			model.addRow(row);
		}
		addedBookList.setModel(model);
		
		lblNewLabel = new JLabel("New inserted book ID and CopyID");
		lblNewLabel.setBounds(129, 20, 193, 14);
		contentPane.add(lblNewLabel);
		
		okButton = new JButton("OK");
		okButton.setBounds(140, 225, 143, 31);
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		contentPane.add(okButton);
	}

}
