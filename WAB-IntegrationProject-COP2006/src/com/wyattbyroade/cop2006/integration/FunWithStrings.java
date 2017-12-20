package com.wyattbyroade.cop2006.integration;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

/**
 * @author Wyatt Byroade
 *
 */
public class FunWithStrings {
  private String inputString;
  public Scanner scan;

  public FunWithStrings(Scanner scan) {
    this.scan = scan;
    inputString();
  }
  
  
  public void inputString() {
    boolean goodInput = false;
    while(goodInput == false) {
      // display prompt to have user enter string.
      System.out.println("Please enter a String:\n");
      try {
        inputString = scan.nextLine();
        if (inputString.length() < 1) {
          throw new Exception("Too few characters. Try again.");
        }
        if(inputString.matches("[0-9]+")) {
          throw new Exception("This is only numeric. Need letters. Try again.");
        }
        goodInput = true;
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
  }
  
  
  public void runStringMenu() {
    boolean exitCodeRecd = false;
    while (exitCodeRecd == false) {
      boolean goodSelection = false;
      int menuSelection = -1;
      while(goodSelection == false) {
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
          }
          else {
  //          scan.nextLine();
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
            }
            else {
              System.out.println("It's not a palindrome.");
            }
            break;
          default:
            exitCodeRecd = true;
            System.out.println("Returning to main menu.");
        }
      
        try        
        {
            Thread.sleep(1400);
        } 
        catch(InterruptedException ex) 
        {
            Thread.currentThread().interrupt();
        }
        //TODO: catch Exception
      }
    }
  }
  
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

  public void convertToProperCase() {
    char[] tempCharArray = inputString.toCharArray();
    boolean nextLetterUp = true;
    for (int iterator = 0; iterator < tempCharArray.length; iterator++) {
      if(nextLetterUp) {
        tempCharArray[iterator] = Character.toUpperCase(tempCharArray[iterator]);
        nextLetterUp = false;
      }
      if(tempCharArray[iterator] == ' ') {
        nextLetterUp = true;
      }
    }
    inputString = new String(tempCharArray);
  }
  public int countVowels() {
    String compareString = inputString.toLowerCase();
    int count = 0;
    for(int iterator = 0; iterator < compareString.length(); iterator++) {
      switch (compareString.charAt(iterator)) {
        case 'a':
        case 'e':
        case 'i':
        case 'o':
        case 'u':
          count++;
        default:
          //don't increment count
      }
    }
    return count;
  }
}
