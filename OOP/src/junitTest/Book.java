package junitTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.book.admin.insert.ViewAdminAddBook;
import gui.book.admin.searchBook.ViewAdminViewBook;
import gui.book.customer.ViewCustomerSearchBook;
import model.User;

class Book {

	//@Test
	void b3 (){
		ViewAdminAddBook addBook = new ViewAdminAddBook (new User());
		addBook.setVisible(true);

	 	JTextField bookIDField = (JTextField)TestUtils.getChildNamed(addBook, "bookID");
		JTextField quantityField2= (JTextField)TestUtils.getChildNamed(addBook, "quantity2");
		JComboBox<String> bookTypeComboBox= (JComboBox<String>) TestUtils.getChildNamed(addBook, "bookType");
		JTextField titleField= (JTextField)TestUtils.getChildNamed(addBook, "title");
	 	JTextField authorField= (JTextField)TestUtils.getChildNamed(addBook, "author");
	 	JTextField quantityField= (JTextField)TestUtils.getChildNamed(addBook, "quantity");
	 
		JRadioButton addNewBookRadioButton= (JRadioButton)TestUtils.getChildNamed(addBook, "addBookRbtn");
 		JButton addNewBookButton= (JButton)TestUtils.getChildNamed(addBook, "addBookBtn");;
		JRadioButton addCopyRadioButton= (JRadioButton)TestUtils.getChildNamed(addBook, "addCopyRbtn");;
	 	JButton searchIDButton= (JButton)TestUtils.getChildNamed(addBook, "searchIDBtn");
	 	JButton addCopyButton= (JButton)TestUtils.getChildNamed(addBook, "addCopyBtn");
	 	

		assertNotNull("Can't access the JTextField component", bookIDField);
		assertNotNull("Can't access the JTextField component", quantityField2);
		assertNotNull("Can't access the JComboBox component", bookTypeComboBox);
		assertNotNull("Can't access the JTextField component", titleField);
		assertNotNull("Can't access the JTextField component", authorField);
		assertNotNull("Can't access the JTextField component", quantityField);

		assertNotNull("Can't access the JRadioButton component", addNewBookRadioButton);
		assertNotNull("Can't access the JButton component", addNewBookButton);
		assertNotNull("Can't access the JRadioButton component", addCopyRadioButton);
		assertNotNull("Can't access the JButton component", searchIDButton);
		assertNotNull("Can't access the JButton component", addCopyButton);
			
		addNewBookRadioButton.doClick();

		titleField.setText("Where Are You");
		authorField.setText("Meilin");
		bookTypeComboBox.setSelectedIndex(0);
		quantityField.setText("3");

		addNewBookButton.doClick();
		String expectedResult="Add the Book successfully !";
		assertEquals(expectedResult, addBook.getMessage());

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		addCopyRadioButton.doClick();

		bookIDField.setText("21");
		searchIDButton.doClick();

		quantityField2.setText("2");
		addCopyButton.doClick();
		expectedResult = "Add the copy successfully !";
		assertEquals(expectedResult, addBook.getMessage());

	}

	
	@Test
	void b4 () throws InterruptedException {
		
		ViewAdminViewBook viewBook = new ViewAdminViewBook (new User());
		viewBook.setVisible(true);
		
		JTextField bookId = (JTextField)TestUtils.getChildNamed(viewBook, "bookID");
		JTable table = (JTable)TestUtils.getChildNamed(viewBook, "table");

		assertNotNull("Can't access the JTextField component", bookId);
		
		Thread.sleep(5000);
		
		assertNotNull("Can't access the JTable component", table);
		 
	}
	
	@Test
	void b8 () throws InterruptedException {
		
		ViewCustomerSearchBook viewCustomerSearchBook = new ViewCustomerSearchBook (new User());
		viewCustomerSearchBook.setVisible(true);
		
		JTable table = (JTable)TestUtils.getChildNamed(viewCustomerSearchBook, "table");

		Thread.sleep(5000);
		
		assertNotNull("Can't access the JTable component", table);
		
	}

}
