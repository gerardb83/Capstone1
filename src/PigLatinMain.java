public class PigLatinMain {
	public static void main(String[] args) {

		String keepGoing = "y";
		System.out.println("Welcome to the Pig Latin Translator!");

		do {
			System.out.print("\nPlease enter a line to be translated: ");
			String userString = PigLatinMethods.getString();
			String stringCase = PigLatinMethods.getCase(userString);
			String pigString = PigLatinMethods.getSpaces(userString);
			System.out.println();
			System.out.println(PigLatinMethods.restoreCase(pigString, stringCase));
			keepGoing = PigLatinMethods.keepGoing();

		} while (keepGoing.equalsIgnoreCase("y"));
		System.out.println("\nOodgay-Eyebay!");
	}
}
