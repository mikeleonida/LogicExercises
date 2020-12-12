//**Given a vehicle registration number, find whether it is valid, invalid or lucky registration number**
//
//**This exercise contains a class named LuckyRegistrationNumber with the following static method:**
//
//     checkRegistrationNumber(String):int
//- The input parameter is a vehicle registration number and the output is -1, 0 or 1 based on below given rules.
//- If the Vehicle registration number is valid as per the below format the method should return 0, else -1 
//
//    PPXXQQYYYY
//    PP - Should be either KA or DL
//    XX - Number from 01 to 10
//    QQ - 1 or 2 alphabets from A-Z(uppercase)
//    YYYY - Number from 1000 to 9999 
//    Ex: KA01MG2323, DL10G5454

package exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		/************New code with regular expressions**************/
		
		if(isValidRegistrationNumber(regNumber)) {
			if(hasLuckyNumber(regNumber)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return -1;
		}
		
		/************Old code with what we learned already**************/
		
//		if (regNumber == null || regNumber.compareTo("")==0 
//				|| (regNumber.length() != 9 && (regNumber.length() != 10)) ) {
//			return -1;
//		}
//		
//		String pp = regNumber.substring(0, 2);
//		if (pp.compareToIgnoreCase("KA")!=0 && (pp.compareToIgnoreCase("DL")!=0)) {
//			return -1;
//		}
//		
//		String xx = regNumber.substring(2, 4);
//		if ( (xx.compareTo("10")!= 0) && (xx.charAt(0) != '0') ) {
//			return -1;
//		} else if ( (xx.compareTo("10")!=0) && (!(xx.charAt(1) >= '1' && xx.charAt(1) <= '9')) ) {
//			return -1;
//		}
//		
//		char char4 = regNumber.charAt(4);
//		if ( (!(Character.isLetter(char4))) || (!(Character.isUpperCase(char4))) ) {
//			return -1;
//		}
//		char char5 = regNumber.charAt(5);
//		if ( (regNumber.length()==10) &&
//				( (!(Character.isLetter(char5))) || (!(Character.isUpperCase(char5))) ) ) {
//			return -1;
//		}
//		
//		int yyyy = 0;
//		try {
//			yyyy = Integer.parseInt(regNumber.substring(regNumber.length()-4, regNumber.length()));
//			if (yyyy < 1000) {
//				return -1;
//			}
//		} catch (NumberFormatException e) {
//			return -1;
//		}
//		
//		if (!isLuckyNumber(yyyy)) {
//			return 0;
//		}
//		
//		return 1;
	}
	
	public static boolean hasLuckyNumber(String regNumber) {
		/* old code without regex */
//		int yyyy = Integer.parseInt(regNumber.substring(regNumber.length()-4, regNumber.length()));
//		return isLuckyNumber(yyyy);
		
		/* new code with regex */
		String luckyStr = regNumber.replaceAll("^(DL|KA)(10|0[1-9])[A-Z]{1,2}", "");
		return isLuckyNumber(Integer.parseInt(luckyStr));
	}
	
	public static boolean isLuckyNumber(int yyyy) {
		int newNumber = yyyy;
		while (newNumber > 9) {
			newNumber = (newNumber%10) + 
					(((int)newNumber/10 )%10) +
					(((int)newNumber/100)%10) +
					((int)newNumber/1000) ;
		}
		
		return (newNumber == 6);
	}
	
	public static boolean isValidRegistrationNumber (String regNumber) {
		Pattern pattern = Pattern.compile("^(DL|KA)(10|0[1-9])[A-Z]{1,2}[1-9]\\d{3}$");
		Matcher matcher = pattern.matcher(regNumber);
		return matcher.matches();
	}
	
}
