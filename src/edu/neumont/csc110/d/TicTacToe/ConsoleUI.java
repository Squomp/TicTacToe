
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUI {
	
	private static String getString(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return input;
	}

	/*private static boolean isNumber(String number){
		boolean isIt = false;
		if(!number.isEmpty());{
			if(number.charAt(0) == '-' || number.charAt(0) == '0' || number.charAt(0) == '1' 
					|| number.charAt(0) == '2' || number.charAt(0) == '3' || number.charAt(0) == '4' 
					|| number.charAt(0) == '5' || number.charAt(0) == '6' || number.charAt(0) == '7'
					|| number.charAt(0) == '8' || number.charAt(0) == '9' || number.charAt(0) == '.') {
				isIt = true;
			}
			if(number.length() > 1) { 
				if(number.charAt(1) == '0' || number.charAt(1) == '1' || number.charAt(1) == '2'
					|| number.charAt(1) == '3' || number.charAt(1) == '4' || number.charAt(1) == '5'
					|| number.charAt(1) == '6' || number.charAt(1) == '7' || number.charAt(1) == '8'
					|| number.charAt(1) == '9' || number.charAt(1) == '.') {
				isIt = true;
				}
				if(number.length() > 2){
					if(number.charAt(2) == '0' || number.charAt(2) == '1' || number.charAt(2) == '2'
							|| number.charAt(2) == '3' || number.charAt(2) == '4' || number.charAt(2) == '5'
							|| number.charAt(2) == '6' || number.charAt(2) == '7' || number.charAt(2) == '8'
							|| number.charAt(2) == '9' || number.charAt(2) == '.') {
						isIt = true;
					}
				}
			}
			for(int i = 3; i < number.length(); i++){
				if(number.charAt(i) == '0' || number.charAt(i) == '1' || number.charAt(i) == '2'
						|| number.charAt(i) == '3' || number.charAt(i) == '4' || number.charAt(i) == '5'
						|| number.charAt(i) == '6' || number.charAt(i) == '7' || number.charAt(i) == '8'
						|| number.charAt(i) == '9'){
					isIt = true;
				}
			}
		}
		return isIt;
	}*/
	
	/**
	 * Generates a console-based menu using the Strings in options as the menu items.
	 * Reserves the number 0 for the "quit" option when withQuit is true.
	 * @param options - Strings representing the menu options
	 * @param withQuit - adds option 0 for "quit" when true
	 * @return the int of the selection made by the user
	 */
	static int promptForMenuSelection(String[] options, boolean withQuit) {
		if(options == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		int something = -5;
		boolean run = true;
		String input = null;
		
		for(int a = 0; a < options.length; a++){
			if(withQuit == false){
				System.out.print("" + (a + 1) + ": ");
				System.out.println(options[a]);
			}
			else if(withQuit == true){
				if(a == 0) {
					System.out.println("\'0\': Exit"); 
				}
				System.out.println("" + (a + 1) + ": " + options[a]);
			}
		}
		
		do{
			System.out.print("Please enter the number of the option you would like to choose: ");
			input = getString();
			
				
			try {
				something = Integer.parseInt(input);
			} catch(NumberFormatException ex){
				something = -1;
			} finally{
				
			}
			if(withQuit){
				if(something >= 0 && something < options.length){
					run = false;
				} else if (withQuit == true && something == options.length){
					run = false;
				}
			} else {
				if(something > 0 && something <= options.length){
					run = false;
				} else {
					run = true;
				}
			}
			
		} while (run);
		
		return something;
	}
	
	/**
	 * Generates a prompt that expects the user to enter one of two responses that will equate
	 * to a boolean value. The trueString represents the case insensitive response that will equate to true. 
	 * The falseString acts similarly, but for a false boolean value.
	 * 		Example: Assume this method is called with a trueString argument of "yes" and a falseString argument of
	 * 		"no". If the enters "YES", the method returns true. If the user enters "no", the method returns false.
	 * 		All other inputs are considered invalid, the user will be informed, and the prompt will repeat.
	 * @param prompt - the prompt to be displayed to the user
	 * @param trueString - the case insensitive value that will evaluate to true
	 * @param falseString - the case insensitive value that will evaluate to false
	 * @return the boolean value
	 */
	static boolean promptForBool(String prompt, String trueString, String falseString){
		if(prompt == null || trueString == null || falseString == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		boolean num = false;
		String input = null;
		do{
			input = getString();
			if(!input.equalsIgnoreCase(trueString) && !input.equalsIgnoreCase(falseString)){
				System.out.print("Please enter either " + trueString + " or " + falseString);
			}
		} while (!input.equalsIgnoreCase(trueString) && !input.equalsIgnoreCase(falseString));
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a byte value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the byte value
	 */
	static byte promptForByte(String prompt, byte min, byte max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		byte num = 0;
		int store = 0;
		boolean run = false;
		String input = null;
		do{
			run = false;
			input = getString();
			
				
			try { 
				store = Integer.parseInt(input);
			} catch(NumberFormatException ex){
				store = min - 1;
			}
			
			if(store > 127 || store < -127){
				System.out.print("Please enter a valid input between " + min + " and " + max);
				run = true;
			}
			else num = Byte.parseByte(input);
			
			if(num < min || num > max){
				System.out.print("Please enter a valid input between " + min + " and " + max);
				run = true;
			}
			
			
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a short value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the short value
	 */
	static short promptForShort(String prompt, short min, short max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		short num = 0;
		boolean run = true;
		String input = null;
		long check;
		do{
			input = getString();
			
				
			try {
				check = Long.parseLong(input);
			} catch(NumberFormatException ex){
				check = min - 1;
			}
			
			if(check > -32768 && check < 32767){
				num = Short.parseShort(input);
				if(num < min || num > max){
					System.out.print("Please enter a valid input between " + min + " and " + max + " ");
				}
				else{
					run = false;
				}
			}
		
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing an int value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the int value
	 */
	static int promptForInt(String prompt, int min, int max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		int num = 0;
		String input;
		boolean isInt = true, run = true;
		do{
			input = getString();
			
			for(int i = 0; i < input.length(); i++){
				if(input.charAt(i) == '.'){
					isInt = false;
				}
			}
			if(isInt){
				
				try {
					num = Integer.parseInt(input);
				} catch(NumberFormatException ex){
					num = min - 1;
				}
				
				if(num >= -2147483648 && num <= 2147483647)
					if(num < min || num > max){
						System.out.print("Please enter a valid input between " + min + " and " + max);
					}
					else run = false;
			} else {
				System.out.println("Please enter a valid input: ");
			}
			
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a long value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the long value
	 */
	static long promptForLong(String prompt, long min, long max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		long num = 0;
		String input;
		boolean run = true;
		do{
			input = getString();
				
			try {
				num = Long.parseLong(input);
			} catch(NumberFormatException ex){
				num = min - 1;
			}
			
			if(num >= -922337203 && num <= 922330000){
				if(num < min || num > max){
					System.out.print("Please enter a valid input between " + min + " and " + max);
				} else run = false;
			}
		
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a float value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the float value
	 */
	static float promptForFloat(String prompt, float min, float max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		float num = 0;
		String input;
		boolean run = true;
		do{
			input = getString();
				
			try {
				num = Float.parseFloat(input);
			} catch(NumberFormatException ex){
				num = min - 1;
			}
			
		
			if(num < min || num > max){
				System.out.print("Please enter a valid input between " + min + " and " + max);
			} else run = false;
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that expects a numeric input representing a double value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the double value
	 */
	static double promptForDouble(String prompt, double min, double max){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		double num = 0;
		boolean run = true;
		String input;
		do{
			input = getString();
			
				
			try {
				num = Double.parseDouble(input);
			} catch (NumberFormatException ex){
				num = min - 1;
			}
			
			if(num < min || num > max){
				System.out.print("Please enter a valid input between " + min + " and " + max);
			} else run = false;
		} while (run);
		return num;
	}
	
	/**
	 * Generates a prompt that allows the user to enter any response and returns the String.
	 * When allowEmpty is true, empty responses are valid. When false, responses must contain
	 * at least one character (including whitespace).
	 * @param prompt - the prompt to be displayed to the user.
	 * @param allowEmpty - when true, makes empty responses valid
	 * @return the input from the user as a String
	 */
	static String promptForInput(String prompt, boolean allowEmpty){
		if(prompt == null){
			IllegalArgumentException myException = new IllegalArgumentException("Prompt cannot be null");
			throw myException;
		}
		
		System.out.print(prompt);
		String input = null;
		boolean run = false;
		do {
			run = false;
			input = getString();
			if(allowEmpty == false && input.isEmpty()){
				System.out.print("Please enter something: ");
				run = true;
			}
			else run = false;
		} while (run);
		return input;
	}
	
	/**
	 * Generates a prompt that expects a single character input representing a char value.
	 * This method loops until valid input is given.
	 * @param prompt - the prompt to be displayed to the user
	 * @param min - the inclusive minimum boundary
	 * @param max - the inclusive maximum boundary
	 * @return the char value
	 */
	static char promptForChar(String prompt, char min, char max){
		
		if(prompt == null){ 
			
			throw new IllegalArgumentException("Prompt cannot be null");
			//throw myException;
		}
		
		if(min == '\0' || max == '\0'){ 
			
			throw new IllegalArgumentException("Paramaters cannot be null");
			//throw myException;
		}
		
		System.out.print(prompt);
		char num = '\0';
		String input = null;
		do{
			input = getString();
			//check to see if the string is longer than one character
			if(input.length() > 1){
				System.out.println("Please enter a single character");
			}
			else{
				//put the first character of the string into the char variable 
				try{
					num = input.charAt(0);
				} catch(StringIndexOutOfBoundsException ex){
					//System.out.println("Please enter a valid input between " + min + " and " + max + ": ");
				}
			}
			if(num < min || num > max){
				System.out.println("Please enter a valid input between " + min + " and " + max + ": ");
			}
		} while (num < min || num > max);
		return num;
	}
}