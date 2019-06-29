import java.util.*;

public class PigLatinMethods {
	static Scanner scnr = new Scanner(System.in);
	
	public static String getString() {
		String userString = "";
		Boolean alpha = false;
		do {
			while (!scnr.hasNextLine())
					scnr.next();
			userString = scnr.nextLine().replaceAll("\\s+", " ").trim();
			alpha = alphaString(userString);
		} while (alpha == false);
		return userString;
	}

	public static Boolean alphaString(String str) {
		return ((str != null) && (!str.equals("")) && (!str.contains("^[0-9#$%^&*()@]*$"))
				&& (str.matches("^[a-zA-Z'.!?-_:;, ]*$")));
	}

	public static String getCase(String userString) {
		char firstChar = userString.charAt(0);
		char secondChar = userString.charAt(1);
		String stringCase = "";
		if (Character.isLowerCase(firstChar)) {
			stringCase = "lowercase";
		} else if (Character.isUpperCase(secondChar)) {
			stringCase = "uppercase";
		} else {
			stringCase = "capitalized";
		}
		return stringCase;
	}

	public static String getSpaces(String userString) {
		String pigString = "";
		if (userString.contains(" ")) {
			String[] output = userString.split(" ");
			for (String each : output) {
				String newString = getPunctuation(each);
				pigString += newString + " ";
			}
		} else {
			pigString = getPunctuation(userString);
		}
		return pigString;
	}
	
	public static String getPunctuation(String userString) {
		String punctuatedString = "";
		char lastChar = userString.charAt(userString.length() - 1);
		if (lastChar == '!' || lastChar == '.' || lastChar == '?' || 
				lastChar == ',' || lastChar == ';') {
			userString = userString.substring(0, userString.length() - 1);
			punctuatedString = convertString(userString);
			punctuatedString += lastChar; 
		} else {
			punctuatedString = convertString(userString);
		}
		return punctuatedString;
	}

	public static String convertString(String inputString) {
		String convertedString = "";
		String userString = inputString.toLowerCase();
		char firstChar = userString.charAt(0);
	
		if ((firstChar == 'a') || (firstChar == 'e') || (firstChar == 'i') || 
				(firstChar == 'o') || (firstChar == 'u') || (firstChar == 'y')) {
			convertedString = userString + "way";
		} else {
			for (int i = 1; i < userString.length(); i++) {
				char currentChar = userString.charAt(i);
				if ((currentChar == 'a') || (currentChar == 'e') || (currentChar == 'i') || 
						(currentChar == 'o') || (currentChar == 'u') || (currentChar == 'y')) {
					String firstHalfString = userString.substring(i, userString.length());
					String secondHalfString = userString.substring(0, i);
					convertedString = firstHalfString + secondHalfString + "ay";
					break;
				}
			}
		}
		return convertedString;
	}

	public static String restoreCase(String pigString, String stringCase) {
		if (stringCase.equals("capitalized")) {
			pigString = pigString.substring(0, 1).toUpperCase() + pigString.substring(1).toLowerCase();
		} else if (stringCase.equals("uppercase")) {
			pigString = pigString.toUpperCase();
		}
		return pigString;
	}

	public static String keepGoing() {
		System.out.print("\nTranslate another line? (y/n): ");
		String keepGoing = scnr.next();
		return keepGoing;
	}
}