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
