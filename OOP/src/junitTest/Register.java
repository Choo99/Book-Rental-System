package junitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gui.register.ViewRegister;

class Register {

	private static ViewRegister register;
	private JTextField name;
	private JTextField ic;
	private JTextField phone;
	private JTextField password;
	private JTextField password2;
	private JButton registerBtn;
	private static Scanner any;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		register = new ViewRegister();
		any = new Scanner(System.in);
	}

	@BeforeEach
	void setUp() throws Exception {
		register.setVisible(true);

		name = (JTextField) TestUtils.getChildNamed(register, "name");
		ic = (JTextField) TestUtils.getChildNamed(register, "ic");
		phone = (JTextField) TestUtils.getChildNamed(register, "phone");
		password = (JTextField) TestUtils.getChildNamed(register, "password");
		password2 = (JTextField) TestUtils.getChildNamed(register, "password2");
		registerBtn = (JButton) TestUtils.getChildNamed(register, "registerBtn");

		assertNotNull("Can't access the JTextField component1", name);
		assertNotNull("Can't access the JTextField component2", ic);
		assertNotNull("Can't access the JTextField component3", phone);
		assertNotNull("Can't access the JTextField component4", password);
		assertNotNull("Can't access the JTextField component5", password2);
	}

	@Test
	void reg1() throws InterruptedException {

		System.out.println("This is test case Reg1");
		System.out.println("This test case should Verify the system shall allow ");
		System.out.println("new users to register with personal information such as name, ");
		System.out.println("IC, phone number, role(admin/customer), password and confirmed password.");

		name.setText("ali");
		ic.setText("990705106635");
		phone.setText("01463423");
		password.setText("abc123");
		password2.setText("abc123");

		assertNotNull(name.getText());
		assertNotNull(ic.getText());
		assertNotNull(phone.getText());
		assertNotNull(password.getText());
		assertNotNull(password2.getText());

		Thread.sleep(1000);
	}

	@Test
	void reg2() {

		System.out.println("This is test case Reg2");
		System.out.println("Verify the system shall pop out an error message ");
		System.out.println("if the password is not matched with the re-enter password.");

		name.setText("ali");
		ic.setText("990705106635");
		phone.setText("0146342390");
		password.setText("abc123");
		password2.setText("abc124");

		registerBtn.doClick();

		String expectedResult = "Password and confirm password must be same!";
		assertEquals(expectedResult, register.getMessage());
	}

	@Test
	void reg3() {

		System.out.println("This is test case Reg3");
		System.out.println("Verify the system shall pop out an error message ");
		System.out.println("if the password is not matched with the re-enter password.");

		name.setText("");
		ic.setText("");
		phone.setText("");
		password.setText("");
		password2.setText("");

		registerBtn.doClick();

		String expectedResult = "Empty inputs are not available!";
		assertEquals(expectedResult, register.getMessage());
	}

	@Test
	void reg4() {

		System.out.println("This is test case Reg4");
		System.out.println("Verify the system shall pop out an error message ");
		System.out.println("if IC and phone number does not match its format.");

		name.setText("ali");
		ic.setText("990705106635");
		phone.setText("0146342");
		password.setText("abc123");
		password2.setText("abc123");

		registerBtn.doClick();

		String expectedResult = "Phone number must be 10 to 12 digits!";
		assertEquals(expectedResult, register.getMessage());
	}

	@Test
	void reg5() {

		System.out.println("This is test case Reg5");
		System.out.println("Test the system shall generate a user ID for users to log in after register successfully.");

		String icNumber = randomNumber(12);

		name.setText("ali");
		ic.setText(icNumber);
		phone.setText("0146342087");
		password.setText("abc123");
		password2.setText("abc123");

		registerBtn.doClick();

		String expectedResult = "Register Successfully! Please Login With This ID : ";
		assertEquals(expectedResult, register.getMessage());
	}

	@AfterEach
	void tearDown() throws IOException {
		register.dispose();

		System.out.println("Please press any key to continue");
		System.in.read();
		any.nextLine();
	}

	@AfterAll
	static void tearDownClass() {
		any.close();
		System.out.println("Test case end");
	}

	String randomNumber(int digit) {
		String number = "";
		for (int counter = 0; counter < digit; counter++) {
			number += ThreadLocalRandom.current().nextInt(0, 9 + 1);
		}
		return number;
	}

}
