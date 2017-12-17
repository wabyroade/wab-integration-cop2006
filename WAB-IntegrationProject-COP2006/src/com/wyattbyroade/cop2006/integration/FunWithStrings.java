package com.wyattbyroade.cop2006.integration;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Wyatt Byroade
 *
 */
public class FunWithStrings {
  private String inputString;

  /**
   * 
   */
  public FunWithStrings(String inputString) {
    this.inputString = inputString;
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
}
