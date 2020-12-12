//**Given an integer array, the longest span of number needs to be found. If 
//a number is repeated multiple times in an array, span is the number of elements between 
//the first occurrence and the last occurrence of the number, inclusive of the numbers. 
//
//**This exercise contains a class named LongestSpan with the following static method:**
//
//      findLongestSpan(int[]):String  
//  
//     - Method should take integer array as input and return a String with the number and longest span 
//		of a number separated by colon(:).
//     - If two numbers have the same longest span, the larger number and its span should be returned
//     - A single value has a span of 1.
//     
//    *Note: If the input array is null or empty, method should return "-1"* 
    		
package exercises;

import java.util.Scanner;

public class LongestSpan {

	public static void main(String[] args) {
		// Exercise Longest Span
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers followed by integers separated by spaces:");
		int numInts = 0;
		if (scanner.hasNextInt()) {
			numInts = scanner.nextInt();
		} 
		String[] userInput = scanner.nextLine().trim().split(" ");
		
		if (numInts <= 0 || (userInput.length<numInts) 
				|| (userInput.length == 1 && numInts == 1 && (userInput[0].compareTo("")==0) ) ) {
			System.out.println(-1);
			scanner.close();
			return;
		}
		
		int[] lsArr = new int[numInts];
		for (int i = 0; i < numInts; i++) {
			lsArr[i] = Integer.parseInt(userInput[i]);
		}
		System.out.println(LongestSpan.findLongestSpan(lsArr));

		scanner.close();
	}

	public static String findLongestSpan(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return "-1";
		}
		if (numbers.length == 1) {
			return numbers[0] + ":1";
		}
		int currentLongestSpan = 1;
		int currentLongSpanIndex = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			int currentSpan = 1;
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					currentSpan = j - i + 1;
				}
			}
			if (currentSpan > currentLongestSpan
					|| (currentSpan == currentLongestSpan && numbers[currentLongSpanIndex] < numbers[i])) {
				currentLongestSpan = currentSpan;
				currentLongSpanIndex = i;
			}
			if ((numbers.length - i) < currentLongestSpan) {
				break;
			}
		}

		return numbers[currentLongSpanIndex] + ":" + currentLongestSpan;
	}

}
