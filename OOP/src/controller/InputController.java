package controller;

public class InputController {

	// check input is null or empty, return true if input is not empty
	public boolean isNullOrEmpty(String input)
	{
	    if (input==null || input.length()==0)
			return false;
		else
			return true;
		
	}

	// check the input is digit or not, return true if input is digit
	public boolean isDigit(String input)
	{
		return input.matches("[0-9]+");
	}
	
	public boolean isOverLimit(String input, int limit)
	{
		if(input.length() <= limit)
			return true;
		else
			return false;
	}

	// check input IC is in valid format (only 12 digits)
	public boolean isValidIc(String input)
	{
		if(isDigit(input))
		{
			if(input.length() == 12)
				return true;
			else
				return false;
		}
		else
		return false;
	}
	
	// check input Phone is only 10 to 12 digits
	public boolean isValidPhoneNo(String input)
	{
		if(isDigit(input))
		{
			if(input.length() >=10 && input.length() <= 12)
				return true;
			else
				return false;
		}
		else
		return false;
	}
	
}	
