
/**
 * tausif.akram
 */

public class FinallyInJava {

	public static void main(String[] args) {

		System.out.println("Result: " + mymethod());

	}

	private static int mymethod() {
		try {

			System.out.println("In try");
			throw new Exception("abc");

		} catch (Exception e) {

			System.out.println("In Catch");
			return 2;

		} finally {

			return 3;

		}
	}

}
