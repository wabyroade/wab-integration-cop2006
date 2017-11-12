package integrationPkg;

import java.util.HashMap;
import java.util.Map;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SP1 - September 30, 2017

public class WeakCrypt {

	// Creation of static MAP to hold characters as values and position in
	// alphabet as keys
	private static final Map<Integer, Character> alphaMap =
			new HashMap<Integer, Character>();
	{
		alphaMap.put(0, 'A');
		alphaMap.put(1, 'B');
		alphaMap.put(2, 'C');
		alphaMap.put(3, 'D');
		alphaMap.put(4, 'E');
		alphaMap.put(5, 'F');
		alphaMap.put(6, 'G');
		alphaMap.put(7, 'H');
		alphaMap.put(8, 'I');
		alphaMap.put(9, 'J');
		alphaMap.put(10, 'K');
		alphaMap.put(11, 'L');
		alphaMap.put(12, 'M');
		alphaMap.put(13, 'N');
		alphaMap.put(14, 'O');
		alphaMap.put(15, 'P');
		alphaMap.put(16, 'Q');
		alphaMap.put(17, 'R');
		alphaMap.put(18, 'S');
		alphaMap.put(19, 'T');
		alphaMap.put(20, 'U');
		alphaMap.put(21, 'V');
		alphaMap.put(22, 'W');
		alphaMap.put(23, 'X');
		alphaMap.put(24, 'Y');
		alphaMap.put(25, 'Z');
	}

	// private fields declared here
	private String textEncoded = new String();
	private String textDecoded = new String();
	private String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// method declaration HEADER with inputText(String) and offset(int)
	// PARAMETERS
	// - technically this serves as setter for the private field textEncoded
	public void encodeText(String inputText, int offset) {
		char tempArray[] = new char[inputText.length()];
		// MATHEMATICAL OPERATION: unary addition in FOR LOOP
		for (int i = 0; i < inputText.length(); i++) {
			char thisChar = inputText.charAt(i);
			int alphaIndex = alphabetString.indexOf(thisChar);
			// int alphaIndex = alphaMap.
			// logical if blocks within method
			if (alphaIndex > 0) {
				// MATHEMATICAL OPERATIONS: addition as well as
				// modulus(remainder) used to
				// offset character without going out of bounds of alphabet
				alphaIndex = (alphaIndex + offset) % 26;
				tempArray[i] = alphaMap.get(alphaIndex);
			} else {
				tempArray[i] = thisChar;
			}
		}
		textEncoded = new String(tempArray);
	}

	// method declaration HEADER with inputText(String) and offset(int)
	// PARAMETERS
	// - technically this serves as setter for the private field textDecoded
	public void decodeText(String inputText, int offset) {
		char tempArray[] = new char[inputText.length()];
		// MATHEMATICAL OPERATION: unary addition in FOR LOOP
		for (int i = 0; i < inputText.length(); i++) {
			char thisChar = inputText.charAt(i);
			int alphaIndex = alphabetString.indexOf(thisChar);
			// logical if blocks within method
			if (alphaIndex > 0) {
				// MATHEMATICAL OPERATIONS: addition as well as
				// modulus(remainder) used to
				// offset character without going out of bounds of alphabet
				alphaIndex = (alphaIndex + offset) % 26;
				tempArray[i] = alphaMap.get(alphaIndex);
			} else {
				tempArray[i] = thisChar;
			}
		}
		textDecoded = new String(tempArray);
	}

	// public getter method for the private encodedText field
	public String getEncodedText() {
		return textEncoded;
	}

	// public getter method for the private decodedText field
	public String getDecodedText() {
		return textDecoded;
	}

}
