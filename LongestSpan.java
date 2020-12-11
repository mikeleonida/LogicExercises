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
