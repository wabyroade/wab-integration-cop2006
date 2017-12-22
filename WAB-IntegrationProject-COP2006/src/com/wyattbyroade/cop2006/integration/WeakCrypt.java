package com.wyattbyroade.cop2006.integration;

import java.util.HashMap;
import java.util.Map;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SP1 - September 30, 2017

/**
 * This is the class used to create objects for encoding and decoding text.
 * 
 * @author Wyatt Byroade
 */
public class WeakCrypt {

  // Creation of static MAP to hold characters as values and position in
  // alphabet as keys
  /**
   * alphaMap is a hashmap that stores a Character with an Integer key for each
   * element.
   */
  private static final Map<Integer, Character> alphaMap = new HashMap<Integer, Character>();

  static {
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
  /**
   * The encodeText method encodes a String when passed that String as well as
   * the offset used for encoding.
   * 
   * @param inputText   String to be encoded
   * @param offset      Number of characters to offset by
   */
  public void encodeText(String inputText, int offset) {
    char[] tempArray = new char[inputText.length()];
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
  /**
   * The decodeText method decodes a String when passed that String as well as
   * the offset used for decoding.
   * 
   * @param inputText   String to be decoded
   * @param offset      Number of characters to offset by
   */
  public void decodeText(String inputText, int offset) {
    char[] tempArray = new char[inputText.length()];
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
  /**
   * The getEncodedText method returns the String that holds the encoded text.
   * 
   * @return  Returns String object containing encoded text.
   */
  public String getEncodedText() {
    return textEncoded;
  }

  // public getter method for the private decodedText field
  /**
   * The getDecodedText method returns the String that holds the decoded text.
   * 
   * @return  Returns String object containing decoded text.
   */
  public String getDecodedText() {
    return textDecoded;
  }

}
