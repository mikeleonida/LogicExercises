package exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise01StudentNameSort {

	public static void main(String[] args) {
		// Exercise StudentNameSort
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter names and scores:");

		String[] namesAndScoresArr = scanner.nextLine().trim().split(";");
		String[] names = new String[namesAndScoresArr.length];
		int[] scores = new int[namesAndScoresArr.length];

		for (int i = 0; i < namesAndScoresArr.length; i++) {
			names[i] = namesAndScoresArr[i].split(":")[0];
			scores[i] = Integer.parseInt(namesAndScoresArr[i].split(":")[1]);
		}

		System.out.println(Arrays.toString(Exercise01StudentNameSort.sortStudents(names, scores)));

		scanner.close();
	}

	public static String[] sortStudents(String[] names, int[] scores) {
		String[] scoreOrderNames = new String[names.length];
		int[] sortedScores = new int[scores.length];
		for (int i = 0; i < names.length; i++) {
			scoreOrderNames[i] = names[i];
			sortedScores[i] = scores[i];
		}

		int tempScore;
		String tempName;
		for (int i = 0; i < scoreOrderNames.length - 1; i++) {
			for (int j = i + 1; j < scoreOrderNames.length; j++) {
				if (sortedScores[j] < sortedScores[i]) {
					// switch data
					tempScore = sortedScores[i];
					sortedScores[i] = sortedScores[j];
					sortedScores[j] = tempScore;

					// now switch names
					tempName = scoreOrderNames[i];
					scoreOrderNames[i] = scoreOrderNames[j];
					scoreOrderNames[j] = tempName;
				}
			}
		}

		return scoreOrderNames;
	}

}
