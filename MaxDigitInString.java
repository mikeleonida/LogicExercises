//**Given a String find the maximum digit within the String**
//
//**This exercise contains a class named MaxDigitInString with the following static method:**
//
//      getMaxDigit(String):int  
//  
//- The input String to the method should be scanned for digits and the maximum digit should be returned.
//- Input String can contain alphanumeric character, spaces and special characters
//- If the input string is empty/null or it does not contain any digits, -1 should be returned.

package exercises;

import java.util.Scanner;

public class MaxDigitInString {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string:");
		String userInput = scanner.nextLine().trim();
		
		int maxDigit = MaxDigitInString.getMaxDigit(userInput);

		if (maxDigit == -1) {
			System.out.println("No digits in string");
		} else {
			System.out.println("Max digit : " + maxDigit);
		}
		
		scanner.close();
	}

	public static int getMaxDigit(String input) {
		if (input == null || input.compareTo("")==0) {
			return -1;
		}
		int maxDigit = -1;
		for (int i=0; i<input.length(); i++) {
			if (Character.isDigit(input.charAt(i))) {
				int newDigit = Integer.parseInt(input.substring(i, i+1));
				if (newDigit > maxDigit) {
					maxDigit = newDigit;
				}
			}
		}
	
		return maxDigit;
	}
	
	
}
