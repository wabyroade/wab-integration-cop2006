package integrationPkg;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SP1 - September 30, 2017

public class WeakCrypt {
	
// private fields declared here
	private String textEncoded = new String();
	private String textDecoded = new String();
	private String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

// method declaration with multiple parameters - technically this serves
// as setter for the private field textEncoded
	public void encodeText(String inputText, int offset) {
		char tempArray[] = new char[inputText.length()];
		for (int i = 0; i < inputText.length(); i++) {
			char thisChar = inputText.charAt(i);
			int alphaIndex = alphabetString.indexOf(thisChar);
// logical blocks within method
			if(alphaIndex > 0) {
// mathematical operations
				alphaIndex = (alphaIndex + offset)%26;
				tempArray[i] = alphabetString.charAt(alphaIndex);
			}
			else {
				tempArray[i] = thisChar;
			}
		}
		textEncoded = new String(tempArray);
	}
	
// method declaration with multiple parameters - technically this serves
// as setter for the private field textDecoded
	public void decodeText(String inputText, int offset) {
		char tempArray[] = new char[inputText.length()];
		for (int i = 0; i < inputText.length(); i++) {
			char thisChar = inputText.charAt(i);
			int alphaIndex = alphabetString.indexOf(thisChar);
// logical blocks within method
			if(alphaIndex > 0) {
// mathematical operations
				alphaIndex = (alphaIndex + offset)%26;
				tempArray[i] = alphabetString.charAt(alphaIndex);
			}
			else {
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
