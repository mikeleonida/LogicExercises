package exercises;

import java.util.Scanner;

public class RepeatedCharacter {

	public static void main(String[] args) {
		// Exercise RepeatedCharacter
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter string to find repeated character:");
		String userInput = scanner.nextLine().trim();

		Character repeatedChar = RepeatedCharacter.findRepeatedCharacter(userInput);

		if (repeatedChar.compareTo('0') == 0) {
			System.out.println("No characters repeated");
		} else {
			System.out.println(repeatedChar);
		}

		scanner.close();
	}

	public static Character findRepeatedCharacter(String inputString) {
		String input = inputString.replace(" ", "");
		if (input == null || input.compareTo("") == 0) {
			return '0';
		}

		int numRepeated = 0;
		char charRepeated = '0';
		for (int i = 0; i < input.length() - 1; i++) {
			int tempNumRepeated = 1;
			for (int j = i + 1; j < input.length(); j++) {
				if (input.charAt(i) == input.charAt(j)) {
					tempNumRepeated++;
				}
			}

			if (tempNumRepeated > numRepeated && tempNumRepeated > 1) {
				numRepeated = tempNumRepeated;
				charRepeated = input.charAt(i);
			} else if (tempNumRepeated == numRepeated && (input.charAt(i) < charRepeated)) {
				charRepeated = input.charAt(i);
			}
		}

		return charRepeated;
	}

}
