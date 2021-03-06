//**Write a program to read an integer array and find the index of larger number of the 
//two adjacent numbers with largest difference.
//Print the index of the larger number.**
//
//**This exercise contains a class LargestDifference with the following static method**
//
//    public static int findLargestDifference(int[] numbers)
//        
//    - Method should take integer array as input and return an integer with the index of 
//      the larger number with the largest difference.
//
//    - Rules: 
//        - Difference is obtained by subtracting smaller number from larger number
//        - If the largest difference is same for multiple adjacent numbers, then the 
//          index of the largest numbers of the larger number should be returned. See 
//          Sample for example
//        - If the largest difference is same for multiple adjacent numbers, and the 
//          larger numbers are also same, then the index of the first larger number should 
//          be returned
//    
//    *Note: If the input array is null or empty, method should return -1*

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
		String[] userInput = scanner.nextLine().trim().split("\\s+");
		
		if (numInts <= 1 || (userInput.length == 1) || (userInput.length<numInts)) {
			System.out.println(-1);
			scanner.close();
			return;
		}
		
		int[] ldArr = new int[numInts];
		for (int i=0; i<numInts; i++) {
			ldArr[i] = Integer.parseInt(userInput[i].trim());
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
