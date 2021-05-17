package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;

import gui.book.admin.update.ViewAdminUpdateBook;
import gui.login.ViewLogIn;
import gui.menu.admin.ViewAdminMenu;
import gui.register.ViewRegister;
import gui.rental.admin.returnBook.ViewBookReturn;
import model.User;

class test {

	@Test
	public void L7test() throws InterruptedException {
		User user = new User();
		ViewLogIn login = new ViewLogIn(user);
		login.setVisible(true);

		JTextField userID = (JTextField) TestUtils.getChildNamed(login, "userID");
		JTextField password = (JTextField) TestUtils.getChildNamed(login, "password");
		JButton loginBtn = (JButton) TestUtils.getChildNamed(login, "login");

		assertNotNull("Can't access the JTextField component", userID);
		assertNotNull("Can't access the JTextField component", password);

		userID.setText("1");
		password.setText("abc123");

		loginBtn.doClick();

		ViewAdminMenu adminMenu = new ViewAdminMenu(user);
		adminMenu.setVisible(true);

		String expResult = "Successfully login";
		assertEquals(expResult, login.getMessage());
	}

	// @Test
	public void Reg4Test() {
		ViewRegister register = new ViewRegister();
		register.setVisible(true);

		JTextField name = (JTextField) TestUtils.getChildNamed(register, "name");
		JTextField ic = (JTextField) TestUtils.getChildNamed(register, "ic");
		JTextField phone = (JTextField) TestUtils.getChildNamed(register, "phone");
		JTextField password = (JTextField) TestUtils.getChildNamed(register, "password");
		JTextField password2 = (JTextField) TestUtils.getChildNamed(register, "password2");
		JButton registerBtn = (JButton) TestUtils.getChildNamed(register, "registerBtn");

		assertNotNull("Can't access the JTextField component1", name);
		assertNotNull("Can't access the JTextField component2", ic);
		assertNotNull("Can't access the JTextField component3", phone);
		assertNotNull("Can't access the JTextField component4", password);
		assertNotNull("Can't access the JTextField component5", password2);

		name.setText("ali");
		ic.setText("990705106635");
		phone.setText("01463423");
		password.setText("abc123");
		password2.setText("abc123");

		registerBtn.doClick();

		String expResult = "666";
		assertEquals(expResult, phone.getText());
	}

	// @Test
	public void B6Test() {
		User user = new User();
		ViewAdminUpdateBook frame = new ViewAdminUpdateBook(user);
		frame.setVisible(true);

		JTextField bookID = (JTextField) TestUtils.getChildNamed(frame, "bookID");
		JTextField title = (JTextField) TestUtils.getChildNamed(frame, "title");
		JTextField author = (JTextField) TestUtils.getChildNamed(frame, "author");
		JButton searchBtn = (JButton) TestUtils.getChildNamed(frame, "search");
		JButton renewBtn = (JButton) TestUtils.getChildNamed(frame, "renew");

		assertNotNull("Can't access the JTextField1 component1", bookID);
		assertNotNull("Can't access the JTextField2 component1", title);
		assertNotNull("Can't access the JTextField3 component1", author);
		assertNotNull("Can't access the JButton component1", searchBtn);
		assertNotNull("Can't access the JButton component1", renewBtn);

		bookID.setText("1");
		searchBtn.doClick();

		String text = "(new)";
		title.setText(title.getText() + text);

		renewBtn.doClick();

		String expResult = "Success";
		assertEquals(expResult, title.getText());
	}

	// @Test
	public void Ren15() {
		User user = new User();
		ViewBookReturn frame = new ViewBookReturn(user);
		frame.setVisible(true);

		JTextField rentalID = (JTextField) TestUtils.getChildNamed(frame, "rentalID");
		JButton searchBtn = (JButton) TestUtils.getChildNamed(frame, "search");

		assertNotNull("Can't access the JTextField component", rentalID);
		assertNotNull("Can't access the JButton component", searchBtn);

		rentalID.setText("55");
		searchBtn.doClick();

		String expResult = "No result found";
		assertEquals(expResult, rentalID.getText());
	}

}
