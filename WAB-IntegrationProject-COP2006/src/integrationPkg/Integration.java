package integrationPkg;

import java.util.Arrays;
import java.util.Scanner;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SP2 - November 11, 2017

//TODO: Work on more complex cipher method, reduce duplicate code

public class Integration {
	public static Scanner scan;

	// declaring variables of Java built-in(primitive) data types
	// VARIABLES: essentially blocks of memory allocated to store certain values
	// the size and type of values dictate which variable type should be used

	// int - 32 bit signed integer, values range from -2^31 to 2^31 or unsigned
	// from 0 to (2^32)-1
	static int encodeOffset = 10;
	static int decodeOffset = 16;
	static int encodeDecodeChoice;

	// byte - 8 bit signed integer, values range from -128 to 128
	byte unusedByte = 0;
	// short - 16 bit signed integer, values range from -32,768 to 32,767
	short unusedShort = 0;
	// long - 64 bit signed integer, values range from -2^63 to (2^63)-1 or
	// unsigned
	// from 0 to (2^64)-1
	long unusedLong = 0;
	// float - 32 bit floating point number
	float unusedFloat = 0.1f;
	// double - 64 bit floating point number
	double unusedDouble = 0.1;
	// char - 16-bit unicode character ranges from \u0000 to \uffff
	char unusedChar = 'A';
	// boolean - true or false - one bit
	boolean unusedBoolean = false;

	public static void main(String[] args) {
		// instantiate a new Scanner object as well as a new WeakCrypt object
		Scanner scan = new Scanner(System.in);
		WeakCrypt thisCryptObj = new WeakCrypt();

		// display welcome message and initial prompt, then receive user input
		System.out.println("Welcome to my integration project.");

		// MATHEMATICAL OPERATION: integer division
		System.out.println("First, here's an unsolicited mathematics demo:");
		int testDividend1 = 70;
		int testDivisor1 = 11;
		// integer division
		int testQuotient1 = testDividend1 / testDivisor1;
		// mod operation to see if integers divide evenly
		int testRemainder1 = testDividend1 % testDivisor1;
		if (testRemainder1 == 0) {
			System.out.println(testDividend1 + " / " + testDivisor1 + " = "
					+ testQuotient1 + ".");
		} else {
			System.out.println(
					testDividend1 + " / " + testDivisor1 + " = " + testQuotient1
							+ " with remainder " + testRemainder1 + ".");
		}

		int testMultiplicand = 11;
		int testMultiplier = 5;
		int testProduct = testMultiplicand * testMultiplier;
		System.out.println(testMultiplicand + " multiplipied by "
				+ testMultiplier + " equals " + testProduct + ".");

		System.out.println("Here are some array operations.");
		// Create an ARRAY of random numbers in order to perform various
		// operations on the ARRAY.
		int[] randomNumbers = new int[10];
		int testValue = 999; // won't compile unless initialized
		boolean testValueAssigned = false;
		int smallestValue = 99;
		int arraySum = 0;
		for (int randIter = 0; randIter < randomNumbers.length; randIter++) {
			randomNumbers[randIter] = (int) (Math.random() * 10 + 1);
			// to hopefully get a value to check the index of, and to use
			// CONDITIONAL OPERATORS and RELATIONAL OPERATORS, I have criteria
			// to assign the test value first time random number falls within
			// a certain range
			if ((!testValueAssigned) && (randomNumbers[randIter] <= 7)
					&& (randomNumbers[randIter] >= 5)) {
				testValue = randomNumbers[randIter];
				testValueAssigned = true;
			}
		}
		System.out.println("Array contents: " + Arrays.toString(randomNumbers));

		for (int opIter = 0; opIter < randomNumbers.length; opIter++) {
			if (randomNumbers[opIter] < smallestValue) {
				smallestValue = randomNumbers[opIter];
			}
			if (randomNumbers[opIter] == testValue) {
				System.out
						.println("Index of value " + testValue + ": " + opIter);
			}
			arraySum += randomNumbers[opIter];
		}
		System.out.println("Smallest of array values: " + smallestValue);
		System.out.println("Sum of array values: " + arraySum);
		System.out.print("\n");

		System.out.println("Would you like to encode or decode text?:\n"
				+ "1-encode\n2-decode\n3-nevermind that");
		encodeDecodeChoice = scan.nextInt();
		scan.nextLine();
		// While loop to validate menu input from user
		while ((encodeDecodeChoice < 1) || (encodeDecodeChoice > 3)) {
			System.out.println("You have selected an invalid option."
					+ "Try again:\n1-encode\n2-decode\n3-nevermind that");
			encodeDecodeChoice = scan.nextInt();
			scan.nextLine();
		}

		switch (encodeDecodeChoice) {
		case 1:
			System.out.println(
					"You selected to encode text.\nEnter text to encode:");
			String encodeInput = scan.nextLine().toUpperCase();
			// call encodeText() method with arguments encodeInput and
			// encodeOffset
			thisCryptObj.encodeText(encodeInput, encodeOffset);
			System.out.println(thisCryptObj.getEncodedText());
			break;
		case 2:
			System.out.println(
					"You selected to decode text.\nEnter text to decode:");
			String decodeInput = scan.nextLine().toUpperCase();
			// call decodeText() method with arguments decodeInput and
			// decodeOffset
			thisCryptObj.decodeText(decodeInput, decodeOffset);
			System.out.println(thisCryptObj.getDecodedText());
			break;
		default:
			System.out.println("So long.");
		}
		scan.close();
	}
}
