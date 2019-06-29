
public class Capstone1PigLatin {
	public static void main(String[] args) {

		PigLatinMethods pig = new PigLatinMethods();
		String keepGoing = "y";
		System.out.println("Welcome to the Pig Latin Translator!");

		do {

			System.out.print("\nPlease enter a line to be translated: ");
			String userString = pig.getString();
			String stringCase = pig.getCase(userString);
			String pigString = pig.getSpaces(userString);
			System.out.println();
			System.out.println(pig.restoreCase(pigString, stringCase));
			keepGoing = pig.keepGoing();

		} while (keepGoing.equalsIgnoreCase("y"));
		System.out.println("\nOodgay-Eyebay!");
	}
}
