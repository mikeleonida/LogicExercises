//**You  are  given  a  string  of  length  N.  Find  the  most  repeated  character  in  the  string.  If  many  characters  appear
//same  number  of  times  find  the  smallest  one**
//
//**This exercise contains a class named RepeatedCharacter with the following static method:**
//
//      findRepeatedCharacter(String):Character  
//  
//- The input String to the method should be scanned for repeated characters and the most 
//  repeated character should be returned.
//- String will not contain digits
//- If the input string is empty/null or it does not contain any repeated character, character 0 should be returned.
//- characters will be in lowercase only

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
		String input = inputString.replaceAll(" ", "").replaceAll("\t", "");
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
