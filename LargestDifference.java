package exercises;

import java.util.Scanner;

public class LargestDifference {
	public static void main(String[] args) {
		// Exercise LargestDifference
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of integers followed by integers separated by spaces:");
		int numInts = 0;
		if (scanner.hasNextInt()) {
			numInts = scanner.nextInt();
		}
		String[] userInput = scanner.nextLine().trim().split(" ");

		int[] ldArr = new int[numInts];
		for (int i=0; i<numInts; i++) {
			ldArr[i] = Integer.parseInt(userInput[i]);
		}
		System.out.println(LargestDifference.findLargestDifference(ldArr));

		scanner.close();
	}
	
	public static int findLargestDifference(int[] numbers) {
		if (numbers == null || numbers.length == 0 || numbers.length == 1) {
			return -1;
		}
		
		int diff = 0;
		int currentLargerNum = numbers[0];
		int currentLargerNumIndex = 0;
		
		for (int i=0; i<(numbers.length - 1); i++) {
			int tempDiff = 0;
			int tempLargerNumIndex = i;
			
			if (numbers[i] < numbers[i+1]) {
				tempDiff = numbers[i+1] - numbers[i];
				tempLargerNumIndex = i+1;
			} else {
				tempDiff = numbers[i] - numbers[i+1];
			}
			
			if (tempDiff > diff) {
				diff = tempDiff;
				currentLargerNum = numbers[tempLargerNumIndex];
				currentLargerNumIndex = tempLargerNumIndex;
			}
			
			if (tempDiff == diff && currentLargerNum < numbers[tempLargerNumIndex]) {
				currentLargerNumIndex = tempLargerNumIndex;
				currentLargerNum = numbers[tempLargerNumIndex];
			}
		}
		
		return currentLargerNumIndex;
	}
}
