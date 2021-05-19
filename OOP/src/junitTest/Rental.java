package junitTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.rental.admin.bill.payment.ViewBilling;
import gui.rental.admin.returnBook.ViewBookReturn;
import gui.rental.admin.search.ViewSearchRental;
import gui.rental.customer.ViewCustomerRental;
import model.User;

class Rental {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	} 

	//@Test
	void ren1() {
		ViewBilling frame = new ViewBilling(new User());
		frame.setVisible(true);
		
		JTextField rentalID = (JTextField)TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "searchBtn");
		JButton updateBtn = (JButton)TestUtils.getChildNamed(frame, "updateBtn");
		
		assertNotNull("Cannot access JTextField Component",rentalID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",updateBtn);
		
		rentalID.setText("53");
		searchBtn.doClick();
		updateBtn.doClick();
		
		String expectedResult = "Renting";
		assertEquals(expectedResult,frame.getMessage());
	}
	
	//@Test
	void ren2() {
		ViewBookReturn frame = new ViewBookReturn(new User());
		frame.setVisible(true);
		
		JTextField rentalID = (JTextField)TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "search");
		JButton updateBtn = (JButton)TestUtils.getChildNamed(frame, "updateBtn");
		
		assertNotNull("Cannot access JTextField Component",rentalID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",updateBtn);
		
		rentalID.setText("56");
		searchBtn.doClick();
		updateBtn.doClick();
		
		String expectedResult = "Completed";
		assertEquals(expectedResult,frame.getMessage());
	}
	
	//@Test
	void ren4() {
		ViewSearchRental frame = new ViewSearchRental();
		frame.setVisible(true);
		
		JTable table = (JTable)TestUtils.getChildNamed(frame, "table");
		
		assertNotNull("Cannot access JTextField Component",table);
		
		
		String expectedColumnName[] = {"Rental ID", "Customer Name", "Rent Date", 
				"Expected Return Date", "Return Date", "Price", "Status"};
		
		for(int index = 0; index < expectedColumnName.length ;index++) {
			assertEquals(expectedColumnName[index],table.getModel().getColumnName(index));
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//expect table is not null means table got display information
		assertTrue(table.getModel().getRowCount()!=0);
	}
	
	//@Test
	void ren5() {
		User user = new User();
		user.setUserID(1);
		ViewCustomerRental frame = new ViewCustomerRental(user);
		frame.setVisible(true);
		
		JTextField bookID = (JTextField)TestUtils.getChildNamed(frame, "bookID");
		JTextField copyID = (JTextField)TestUtils.getChildNamed(frame, "copyID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "addBookBtn");
		JButton rentBtn = (JButton)TestUtils.getChildNamed(frame, "rentBookBtn");
		
		assertNotNull("Cannot access JTextField Component",bookID);
		assertNotNull("Cannot access JTextField Component",copyID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",rentBtn);
		
		bookID.setText("1");
		copyID.setText("7");
		
		searchBtn.doClick();
		
		bookID.setText("1");
		copyID.setText("4");
		
		searchBtn.doClick();
		rentBtn.doClick();
		
		//expert every field got display information means not null
		assertNotNull(frame.getSlip().getRentIDField().getText());
		assertNotNull(frame.getSlip().getNameField().getText());
		assertNotNull(frame.getSlip().getCurrentDateField().getText());
		assertNotNull(frame.getSlip().getReturnDateField().getText());
		
		//check expected column
		JTable rentList = frame.getSlip().getRentListTable();
		String expectedColumn[] ={"Book ID","Copy ID","Title", "Book Type", "Author", "Price"};
		for(int index = 0 ; index < expectedColumn.length ; index++) {
			assertEquals(expectedColumn[index],rentList.getColumnName(index));
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//check table content is not null
		assertTrue(rentList.getRowCount()!=0);
	}
	
	//@Test
	void ren7() {
		User user = new User();
		ViewCustomerRental frame = new ViewCustomerRental(user);
		frame.setVisible(true);
		
		JTextField bookID = (JTextField)TestUtils.getChildNamed(frame, "bookID");
		JTextField copyID = (JTextField)TestUtils.getChildNamed(frame, "copyID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "addBookBtn");
		
		assertNotNull("Cannot access JTextField Component",bookID);
		assertNotNull("Cannot access JTextField Component",copyID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		
		bookID.setText("1");
		copyID.setText("1");
		
		searchBtn.doClick();
		
		String expectedReult = "This book is broken/rented! Please find other book";
		assertEquals(expectedReult,frame.getMessage());
	}
	
	//@Test
	void ren8() {
		User user = new User();
		ViewBilling frame = new ViewBilling(user);
		frame.setVisible(true);
		
		JTextField rentalID = (JTextField)TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "searchBtn");
		JButton updateBtn = (JButton)TestUtils.getChildNamed(frame, "updateBtn");
		
		assertNotNull("Cannot access JTextField Component",rentalID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",updateBtn);
		
		rentalID.setText("58");
		
		searchBtn.doClick();
		updateBtn.doClick();
		
		//check expected column name
		JTable receiptTable = frame.getReceipt().getReceiptTable();
		String expectedColumn[] = {"Book ID", "Copy ID", "Title", "Price"};
		for(int index = 0 ; index < expectedColumn.length ; index++) {
			assertEquals(expectedColumn[index],receiptTable.getColumnName(index));
		}
		
		//check table is not null
		assertTrue(receiptTable.getModel().getRowCount() != 0);
		
		//check every field is not null
		assertNotNull(frame.getReceipt().getRentalIDField().getText());
		assertNotNull(frame.getReceipt().getDateField().getText());
		assertNotNull(frame.getReceipt().getAmountField().getText());
	}
	
	//@Test
	void ren9() {
		User user =  new User();
		user.setUserID(1);
		ViewCustomerRental frame = new ViewCustomerRental(user);
		frame.setVisible(true);
		
		JTextField bookID = (JTextField)TestUtils.getChildNamed(frame, "bookID");
		JTextField copyID = (JTextField)TestUtils.getChildNamed(frame, "copyID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "addBookBtn");
		JButton rentBtn = (JButton)TestUtils.getChildNamed(frame, "rentBookBtn");
		
		assertNotNull("Cannot access JTextField Component",bookID);
		assertNotNull("Cannot access JTextField Component",copyID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",rentBtn);
		
		bookID.setText("2");
		copyID.setText("6");
		
		searchBtn.doClick();
		
		bookID.setText("2");
		copyID.setText("3");
		
		searchBtn.doClick();
		rentBtn.doClick();
		
		//calculate expected date and compare with answer in system
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 7);
		
		String expectedDate = format.format(calendar.getTime());
		assertEquals(expectedDate,frame.getSlip().getReturnDateField().getText());
	}
	
	//@Test
	void ren10() {
		User user =  new User();
		ViewBilling frame = new ViewBilling(user);
		frame.setVisible(true);
		
		JTextField rentalID = (JTextField)TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "searchBtn");
		JButton updateBtn = (JButton)TestUtils.getChildNamed(frame, "updateBtn");
		
		assertNotNull("Cannot access JTextField Component",rentalID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",updateBtn);
		
		rentalID.setText("55");
		searchBtn.doClick();
		updateBtn.doClick();
		
		JTable table = frame.getReceipt().getReceiptTable();
		double expectedAmount = 0;
		for(int index = 0; index < table.getRowCount(); index++) {
			expectedAmount += (double)table.getValueAt(index, 3);
		}
		
		assertEquals(expectedAmount,Double.parseDouble(frame.getReceipt().getAmountField().getText()));
	}
	
	@Test
	void ren12() {
		User user = new User();
		ViewBookReturn frame = new ViewBookReturn(user);
		frame.setVisible(true);
		
		JTextField rentalID = (JTextField)TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton)TestUtils.getChildNamed(frame, "search");
		JButton updateBtn = (JButton)TestUtils.getChildNamed(frame, "updateBtn");
		
		assertNotNull("Cannot access JTextField Component",rentalID);
		assertNotNull("Cannot access JButton Component",searchBtn);
		assertNotNull("Cannot access JButton Component",updateBtn);
		
		rentalID.setText("58");
		
		searchBtn.doClick();
		String expectedDate = frame.getExpectedDateField().getText();
		updateBtn.doClick();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		int duration = Integer.parseInt(frame.getOverdue().getDurationField().getText());
		calendar.add(Calendar.DAY_OF_MONTH, -duration );
		String expectedReturnDate = format.format(calendar.getTime());
		
		assertEquals(expectedReturnDate,expectedDate);
		assertNotNull(frame.getOverdue().getAmountField().getText());
	}
	
}
