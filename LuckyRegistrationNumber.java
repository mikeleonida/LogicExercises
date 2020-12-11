package exercises;

import java.util.Scanner;

public class LuckyRegistrationNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter registration number:");
		String userInput = scanner.nextLine().trim();
		
		int code = LuckyRegistrationNumber.checkRegistrationNumber(userInput);

		switch (code) {
		case -1:
			System.out.println("Invalid Registration Number");
			break;
		case 0:
			System.out.println("Valid Registration Number");
			break;
		case 1:
			System.out.println("Lucky Registration Number");
			break;
		default:
			System.out.println("Invalid Registration Number");
		}
		
		scanner.close();
	}

	public static int checkRegistrationNumber(String regNumber) {
		if (regNumber == null || regNumber.compareTo("")==0 
				|| (regNumber.length() != 9 && (regNumber.length() != 10)) ) {
			return -1;
		}
		
		String pp = regNumber.substring(0, 2);
		if (pp.compareToIgnoreCase("KA")!=0 && (pp.compareToIgnoreCase("DL")!=0)) {
			return -1;
		}
		
		String xx = regNumber.substring(2, 4);
		if ( (xx.compareTo("10")!= 0) && (xx.charAt(0) != '0') ) {
			return -1;
		} else if ( (xx.compareTo("10")!=0) && (!(xx.charAt(1) >= '1' && xx.charAt(1) <= '9')) ) {
			return -1;
		}
		
		char char4 = regNumber.charAt(4);
		if ( (!(Character.isLetter(char4))) || (!(Character.isUpperCase(char4))) ) {
			return -1;
		}
		char char5 = regNumber.charAt(5);
		if ( (regNumber.length()==10) &&
				( (!(Character.isLetter(char5))) || (!(Character.isUpperCase(char5))) ) ) {
			return -1;
		}
		
		int yyyy = 0;
		try {
			yyyy = Integer.parseInt(regNumber.substring(regNumber.length()-4, regNumber.length()));
			if (yyyy < 1000) {
				return -1;
			}
		} catch (NumberFormatException e) {
			return -1;
		}
		
		if (!isLuckyNumber(yyyy)) {
			return 0;
		}
		
		return 1;
	}
	
	public static boolean isLuckyNumber(int yyyy) {
		if (yyyy<10) {
			return (yyyy == 6);
		}
		
		int newNumber = yyyy;
		while (newNumber > 9) {
			newNumber = (newNumber%10) + 
					(((int)newNumber/10 )%10) +
					(((int)newNumber/100)%10) +
					((int)newNumber/1000) ;
		}
		
		return (newNumber == 6);
	}
	
	
	
}
