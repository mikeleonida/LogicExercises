package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// THIS FILE IS NOT NEEDED, JUST KEEPING IT FOR TESTING PURPOSES NOW AND LATER
		// Exercise StudentNameSort
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter names and scores:");
		
		String[] namesAndScoresArr = scanner.nextLine().trim().split(";");
		String[] names = new String[namesAndScoresArr.length];
		int[] scores = new int[namesAndScoresArr.length]; 
		
		for (int i=0; i<namesAndScoresArr.length; i++) {
			names[i] = namesAndScoresArr[i].split(":")[0];
			scores[i] = Integer.parseInt(namesAndScoresArr[i].split(":")[1]);
		}
		
		System.out.println(Arrays.toString(Exercise01StudentNameSort.sortStudents(names, scores)));
		
		scanner.close();
	}

}
