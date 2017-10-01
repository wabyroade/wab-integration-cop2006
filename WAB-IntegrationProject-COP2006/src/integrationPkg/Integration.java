package integrationPkg;

import java.util.Scanner;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SP1 - September 30, 2017


//TODO: Work on more complex cipher method, reduce duplicate code

public class Integration {
	public static Scanner scan;
// declaring variables of Java built-in(primitive) data types
// byte, short, int, long, float, double, char and boolean
// also I shoehorned in some integer division in next two lines. My idea was to
// create some kind of basic cipher that would use division and multiplication
// but I couldn't get it working, so I'm using a basic offset substitution that
// only uses addition and modulus
	static int encodeOffset = 100 / 10;
	static int decodeOffset = 160 / 10;
	byte unusedByte = 0;
	short unusedShort = 0;
	long unusedLong = 0;
	float unusedFloat = 0.1f;
	double unusedDouble = 0.1;
	char unusedChar = 'A';
	boolean unusedBoolean = false;

	public static void main(String[] args) {
// instantiate a new Scanner object as well as a new WeakCrypt object
		Scanner scan = new Scanner(System.in);
		WeakCrypt thisCryptObj = new WeakCrypt();

// display welcome message and initial prompt, then receive user input
		System.out.println(
				"Welcome to my integration project.\nWould you like to encode" +
				"or decode text?:\n1-encode\n2-decode");
		int encodeDecodeChoice = scan.nextInt();
		scan.nextLine();

// if/else logical blocks here
		if (encodeDecodeChoice == 1) {
			System.out.println(
					"You selected to encode text.\nEnter text to encode:");
			String encodeInput = scan.nextLine().toUpperCase();
// call encodeText() method with arguments encodeInput and encodeOffset
			thisCryptObj.encodeText(encodeInput, encodeOffset);
			System.out.println(thisCryptObj.getEncodedText());
		} else if (encodeDecodeChoice == 2) {
			System.out.println(
					"You selected to decode text.\nEnter text to decode:");
			String decodeInput = scan.nextLine().toUpperCase();
// call decodeText() method with arguments decodeInput and decodeOffset
			thisCryptObj.decodeText(decodeInput, decodeOffset);
			System.out.println(thisCryptObj.getDecodedText());
		} else {
			System.out.println("You have selected an invalid option. Exiting.");
		}
		scan.close();

	}
}
