import gui.ViewMain;
import model.User;

/**
 * 
 * @author Choo Dik Pong, Gui Qi Fang, Khaw Ming Jie 
 *	This is a book rental system
 */

public class PiscesRentalShop 
{
	// main entrance of the whole system
	
	public static void main(String[] args) 
	{
		User user = new User();
		ViewMain mainScreen = new ViewMain(user);
		mainScreen.setVisible(true);
	}
	// admin account 
	// acc number    : 1
	// password      : abc123
	
	// customer account 
	// acc number    : 2
	// password      : abc123


}
