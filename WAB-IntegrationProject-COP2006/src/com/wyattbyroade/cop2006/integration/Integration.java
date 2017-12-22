package com.wyattbyroade.cop2006.integration;

import java.util.Arrays;
import java.util.Scanner;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SPI3 - December 16, 2017

/**
 * This is the main class of this project.
 * 
 * <p>Integration class contains the methods and fields needed to run this
 * application. It is not intended to be instantiated as object.
 *
 * @author Wyatt Byroade
 */
public class Integration {
  /**
   * Number of positions in the alphabet to shift a given letter while encoding.
   */
  public static int encodeOffset = 10;
  /**
   * Number of positions in the alphabet to shift a given letter while decoding.
   */
  public static int decodeOffset = 16;
  /**
   * Boolean value to act as sentinel for menu while-loop.
   */
  public static boolean exitCodeRecd = false;
  /**
   * Instantiation of new Scanner object to handle all user input throughout
   * all sections of the program.
   */
  public static Scanner scan = new Scanner(System.in);

  /**
   * The main method begins execution of the program.
   * 
   * @param args  Array of String objects can be passed as arguments to main
   *              method. Currently unused.
   */
  public static void main(String[] args) {

    while (exitCodeRecd == false) {
      
      int menuSelection = runMainMenu();

      switch (menuSelection) {
        case 1:
          //Instantiate a new WeakCrypt object
          WeakCrypt thisEncryptObj = new WeakCrypt();
          System.out
              .println("You selected to encode text.\nEnter text to encode:");
          String encodeInput = scan.nextLine().toUpperCase();
          // call encodeText() method with arguments encodeInput and
          // encodeOffset
          thisEncryptObj.encodeText(encodeInput, encodeOffset);
          System.out.println(thisEncryptObj.getEncodedText());
          break;
        case 2:
          //Instantiate a new WeakCrypt object
          WeakCrypt thisDecryptObj = new WeakCrypt();
          System.out
              .println("You selected to decode text.\nEnter text to decode:");
          String decodeInput = scan.nextLine().toUpperCase();
          // call decodeText() method with arguments decodeInput and
          // decodeOffset
          thisDecryptObj.decodeText(decodeInput, decodeOffset);
          System.out.println(thisDecryptObj.getDecodedText());
          break;
        case 3:
          mathematicsDemo();
          break;
        case 4:
          arrayDemo();
          break;
        case 5:
          dataTypeDemo();
          break;
        case 6:
          FunWithStrings myDemoString = new FunWithStrings(scan);
          myDemoString.runStringMenu();
          break;
        case 7:
          // Polymorphism demonstration. Instantiate an array of objects of the
          // Weapon class and its subclasses, then run the demonstrate method
          // for each object.
          Weapon[] weaponArray = new Weapon[3];
          weaponArray[0] = new Weapon(342.50,75,80);
          weaponArray[1] = new Sword(99.50,90,90,70,30);
          weaponArray[2] = new Cannon(1990.00,19000,70,300);
          for (Weapon thisWeapon : weaponArray) {
            thisWeapon.demonstrateWeapon();
          }
          break;
        default:
          exitCodeRecd = true;
          System.out.println("So long.");
      }
      System.out.println("\n");
      try {
        Thread.sleep(1400);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }


  /**
   * The runMainMenu displays a text based menu and checks user input for
   * any issues.
   * 
   * @return   int of item selected in menu to be receieved by switch statement
   */
  public static int runMainMenu() {
    int thisMenuSelection = -1;
    // display welcome message and initial prompt, then receive user input
    System.out.println("Welcome to my integration project.");
    boolean goodSelection = false;
    while (goodSelection == false) {
      System.out.println("What would you like to do?:\n"
          + "1-Encode Text\n"
          + "2-Decode Text\n"
          + "3-Display Mathematics Demo\n"
          + "4-Display Array Functions Demo\n"
          + "5-Display Primitive Data Types Demo\n"
          + "6-Run String Demo\n"
          + "7-Run Inheritance & Polymorphism Demo\n"
          + "8-nevermind all that, exit");
      try {
        String userInput = scan.nextLine();
        thisMenuSelection = Integer.parseInt(userInput);
        if ((thisMenuSelection > 0) && (thisMenuSelection < 9)) {
          goodSelection = true;
        } else {
          throw new Exception("Menu Selection out of range. Try again");
        }
      } catch (NumberFormatException ex) {
        System.out.println("Number must be entered for menu choice. Try again");
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
    }
    return thisMenuSelection;
  }

  /**
   * The dataTypeDemo displays the list of data types and variables that fit 
   * into the various types.   
   */
  public static void dataTypeDemo() {

    // declaring variables of Java built-in(primitive) data types
    // VARIABLES: essentially blocks of memory allocated to store certain values
    // the size and type of values dictate which variable type should be used

    // int - 32 bit signed integer, values range from -2^31 to 2^31 or unsigned
    // from 0 to (2^32)-1
    int unusedInt = 100;
    // byte - 8 bit signed integer, values range from -128 to 128
    byte unusedByte = 2;
    // short - 16 bit signed integer, values range from -32,768 to 32,767
    short unusedShort = 34;
    // long - 64 bit signed integer, values range from -2^63 to (2^63)-1 or
    // unsigned
    // from 0 to (2^64)-1
    long unusedLong = 3429482L;
    // float - 32 bit floating point number
    float unusedFloat = 0.1f;
    // double - 64 bit floating point number
    double unusedDouble = 0.1342;
    // char - 16-bit unicode character ranges from \u0000 to \uffff
    char unusedChar = 'F';
    // boolean - true or false - one bit
    boolean unusedBoolean = false;
    System.out.println("Here are some examples of data types and arbitrary "
        + "values for them.");
    System.out.println("byte: " + unusedByte);
    System.out.println("int: " + unusedInt);
    System.out.println("short: " + unusedShort);
    System.out.println("long: " + unusedLong);
    System.out.println("float: " + unusedFloat);
    System.out.println("double: " + unusedDouble);
    System.out.println("char: " + unusedChar);
    System.out.println("boolean: " + unusedBoolean);
  }
  
  /**
   * The mathematicsDemo displays various arithmetic functions.
   */
  public static void mathematicsDemo() {
    // MATHEMATICAL OPERATION: integer division
    System.out.println("First, here's an unsolicited mathematics demo:");
    int testDividend1 = 70;
    int testDivisor1 = 11;
    // integer division
    int testQuotient1 = testDividend1 / testDivisor1;
    // mod operation to see if integers divide evenly
    int testRemainder1 = testDividend1 % testDivisor1;
    if (testRemainder1 == 0) {
      System.out.println(
          testDividend1 + " / " + testDivisor1 + " = " + testQuotient1 + ".");
    } else {
      System.out.println(testDividend1 + " / " + testDivisor1 + " = "
          + testQuotient1 + " with remainder " + testRemainder1 + ".");
    }

    int testMultiplicand = 11;
    int testMultiplier = 5;
    int testProduct = testMultiplicand * testMultiplier;
    System.out.println(testMultiplicand + " multiplipied by " + testMultiplier
        + " equals " + testProduct + ".");
  }
  
  /**
   * The arrayDemo method displays various array operations.
   */
  public static void arrayDemo() {
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
        System.out.println("Index of value " + testValue + ": " + opIter);
      }
      arraySum += randomNumbers[opIter];
    }
    System.out.println("Smallest of array values: " + smallestValue);
    System.out.println("Sum of array values: " + arraySum);
    System.out.print("\n");
    
    System.out.println("Here is a demonstration of a two-dimensional array:");
    
    final int[][] matrix = new int[][] {
        {8,2,22,97,38,15,0,40,0,75,4,5,7,78,52,12,50,77,91,8},
        {49,49,99,40,17,81,18,57,60,87,17,40,98,43,69,48,4,56,62,0},
        {81,49,31,73,55,79,14,29,93,71,40,67,53,88,30,3,49,13,36,65},
        {52,70,95,23,4,60,11,42,69,24,68,56,1,32,56,71,37,2,36,91},
        {22,31,16,71,51,67,63,89,41,92,36,54,22,40,40,28,66,33,13,80},
        {24,47,32,60,99,3,45,2,44,75,33,53,78,36,84,20,35,17,12,50},
        {32,98,81,28,64,23,67,10,26,38,40,67,59,54,70,66,18,38,64,70},
        {67,26,20,68,2,62,12,20,95,63,94,39,63,8,40,91,66,49,94,21},
        {24,55,58,5,66,73,99,26,97,17,78,78,96,83,14,88,34,89,63,72},
        {21,36,23,9,75,0,76,44,20,45,35,14,0,61,33,97,34,31,33,95},
        {78,17,53,28,22,75,31,67,15,94,3,80,4,62,16,14,9,53,56,92},
        {16,39,5,42,96,35,31,47,55,58,88,24,0,17,54,24,36,29,85,57},
        {86,56,0,48,35,71,89,7,5,44,44,37,44,60,21,58,51,54,17,58},
        {19,80,81,68,5,94,47,69,28,73,92,13,86,52,17,77,4,89,55,40},
        {4,52,8,83,97,35,99,16,7,97,57,32,16,26,26,79,33,27,98,66},
        {88,36,68,87,57,62,20,72,3,46,33,67,46,55,12,32,63,93,53,69},
        {4,42,16,73,38,25,39,11,24,94,72,18,8,46,29,32,40,62,76,36},
        {20,69,36,41,72,30,23,88,34,62,99,69,82,67,59,85,74,4,36,16},
        {20,73,35,29,78,31,90,1,74,31,49,71,48,86,81,16,23,57,5,54},
        {1,70,54,71,83,51,54,69,16,92,33,48,61,43,52,1,89,19,67,48}
    };
    
    for (int[] row : matrix) {
      for (int i : row) {
        System.out.print(i);
        System.out.print("\t");
      }
      System.out.println();
    }
    
    System.out.println("Searching for 55:");
    System.out.print("Found at: ");
    Integer[] searchResults = search2DArray(matrix,55);
    System.out.print("(" + searchResults[0] + ", " + searchResults[1] + ") ");
  }

  /**
   * The search2DArray method iterates through 2 dimensional array to find
   * location of first sought value.
   * 
   * @param searchArray   Two dimensional array of int values.
   * @param searchFor     int value of number being sought from the array.
   * @return    Returns an Integer array of size 2 containing the row index and
   *            column index respectively for the value being searched for. 
   */
  // search for a given number in 2D array, return it and stop method execution
  // when the sought number is found.
  public static Integer[] search2DArray(int[][] searchArray, int searchFor) {
    Integer[] resultList = new Integer[2];
    Integer rowIterator = 0;
    Integer colIterator = 0;
    for (int[] arrLine : searchArray) {
      colIterator = 0;
      for (int thisCell : arrLine) { 
        if (thisCell == searchFor) {
          Integer[] cellCoord = {rowIterator,colIterator};
          return cellCoord;
        }
        colIterator++;
      }
      rowIterator++;
    }
    return resultList;
  }
}
