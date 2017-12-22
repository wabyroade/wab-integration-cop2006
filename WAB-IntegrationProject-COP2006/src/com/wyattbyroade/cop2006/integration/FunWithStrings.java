package com.wyattbyroade.cop2006.integration;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class is used for creating objects to be used for String demonstration.
 * 
 * @author Wyatt Byroade
 */
public class FunWithStrings {
  /**
   * The inputString field holds the user entered String to be used for String demonstrations.
   */
  private String inputString;
  /**
   * The scan Scanner object references the object passed to the constructor for user input.
   */
  public Scanner scan;

  /**
   * Constructor for FunWithStrings objects; takes Scanner object as argument.
   * 
   * @param scan   Scanner object used for text input by user
   */
  public FunWithStrings(Scanner scan) {
    this.scan = scan;
    inputString();
  }
  
  
  /**
   * The inputString method prompts the user for a String and checks the input for validity.
   */
  public void inputString() {
    boolean goodInput = false;
    while (goodInput == false) {
      // display prompt to have user enter string.
      System.out.println("Please enter a String:\n");
      try {
        inputString = scan.nextLine();
        if (inputString.length() < 1) {
          throw new Exception("Too few characters. Try again.");
        }
        if (inputString.matches("[0-9]+")) {
          throw new Exception("This is only numeric. Need letters. Try again.");
        }
        goodInput = true;
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }
  
  
  /**
   * The runStringMenu method displays a menu of String demonstration options, then receives and
   * validates user input and runs appropriate demonstration method.
   */
  public void runStringMenu() {
    boolean exitCodeRecd = false;
    while (exitCodeRecd == false) {
      boolean goodSelection = false;
      int menuSelection = -1;
      while (goodSelection == false) {
        // display prompt to determine what type of String demo to run
        System.out.println("What kind of string demo would you like?:\n"
            + "1-Convert name to proper case\n"
            + "2-Count vowels\n"
            + "3-Check for palindrome\n"
            + "4-return to main menu");
        try {
          String userInput = scan.next();
          scan.nextLine();
          menuSelection = Integer.parseInt(userInput);
          if ((menuSelection > 0) && (menuSelection < 5)) {
            goodSelection = true;
          } else {
            throw new Exception("Menu Selection out of range. Try again.");
          }
        } catch (NumberFormatException ex) {
          System.out.println("A Number must be entered for menu selection. Try again.");
        } catch (Exception ex) {
          System.out.println(ex.getMessage());
        }
        
        switch (menuSelection) {
          case 1:
            convertToProperCase();
            System.out.println(inputString);
            break;
          case 2:
            System.out.println(this.inputString + " has " + this.countVowels() + " vowels.");
            break;
          case 3:
            if (this.checkPalindrome() == true) {
              System.out.println("It is a palindrome.");
            } else {
              System.out.println("It's not a palindrome.");
            }
            break;
          default:
            exitCodeRecd = true;
            System.out.println("Returning to main menu.");
        }
        try {
          Thread.sleep(1400);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
        //TODO: catch Exception
      }
    }
  }
  
  /**
   * The checkPalindrome method creates a temporary Stack and Queue, puts each character
   * of the inputString field into both. Then removes/pops elements one at a time and compares
   * them.
   * 
   * @return  boolean value returns to the calling function to determine if valid palindrome
   */
  public boolean checkPalindrome() {
    
    // Use of a stack as part of checkPalindrome method
    Stack<Character> charStack = new Stack<Character>();
    // Use of a queue as part of checkPalindrome method
    Queue<Character> charQueue = new LinkedList<Character>();

    char[] stringAsCharArray = inputString.toCharArray();

    // add/push all chars to their respective data structures:
    for (char thisLetter : stringAsCharArray) {
      charStack.push(thisLetter);
      charQueue.add(thisLetter);
    }
    
    for (int i = 0; i < stringAsCharArray.length / 2; i++) {
      if (charStack.pop() != charQueue.remove()) {
        return false;                
      }
    }   
    return true;
  }

  /**
   * The convertToProperCase method creates a temporary char array then iterates through it
   * replacing each character after a space with the its uppercase counterpart.
   */
  public void convertToProperCase() {
    char[] tempCharArray = inputString.toCharArray();
    boolean nextLetterUp = true;
    for (int iterator = 0; iterator < tempCharArray.length; iterator++) {
      if (nextLetterUp) {
        tempCharArray[iterator] = Character.toUpperCase(tempCharArray[iterator]);
        nextLetterUp = false;
      }
      if (tempCharArray[iterator] == ' ') {
        nextLetterUp = true;
      }
    }
    inputString = new String(tempCharArray);
  }

  /**
   * The countVowels loops through each character of inputString field and increments
   * a count variable each time a vowel is found, then returns that count.
   * 
   * @return  int value containing the number of vowels in inputString
   */
  public int countVowels() {
    String compareString = inputString.toLowerCase();
    int count = 0;
    for (int iterator = 0; iterator < compareString.length(); iterator++) {
      switch (compareString.charAt(iterator)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          count++;
          break;
        default:
          //don't increment count
      }
    }
    return count;
  }
}
