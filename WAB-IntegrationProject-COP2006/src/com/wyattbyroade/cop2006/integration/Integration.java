package com.wyattbyroade.cop2006.integration;

import java.util.Arrays;
import java.util.Scanner;

//Wyatt Byroade
//Integration Project - COP 2006
//Fall 2017
//SPI3 - December 16, 2017

//TODO: Work on more complex cipher method, reduce duplicate code
//TODO: Create inputCheckerMethod(Scanner scanner, String type) to take input
//    and catch exceptions
//TODO: use Generics? for data type demo? probably not
//TODO: Javadocs for every class field, method, constructor

public class Integration {
  public static int encodeOffset = 10;
  public static int decodeOffset = 16;
  public static int encodeDecodeChoice;
  public static boolean exitCodeRecd = false;
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {

    while (exitCodeRecd == false) {
      
      int menuSelection = runMainMenu();

      switch (menuSelection) {
        case 1:
          //Instantiate a new WeakCrypt object
          WeakCrypt thisEncryptObj = new WeakCrypt();
          Scanner encTextScanner = new Scanner(System.in);
          System.out
              .println("You selected to encode text.\nEnter text to encode:");
          String encodeInput = encTextScanner.nextLine().toUpperCase();
          // call encodeText() method with arguments encodeInput and
          // encodeOffset
          thisEncryptObj.encodeText(encodeInput, encodeOffset);
          System.out.println(thisEncryptObj.getEncodedText());
          break;
        case 2:
          //Instantiate a new WeakCrypt object
          WeakCrypt thisDecryptObj = new WeakCrypt();
          Scanner decTextScanner = new Scanner(System.in);
          System.out
              .println("You selected to decode text.\nEnter text to decode:");
          String decodeInput = decTextScanner.nextLine().toUpperCase();
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
          System.out.println("test weapon");
          Weapon testWeapon = new Weapon("Steel",342.50,75,80);
          testWeapon.demonstrateWeapon();
          Weapon testSword = new Sword("Steel",99.50,90,90,70,30);
          testSword.demonstrateWeapon();
          break;
        default:
          exitCodeRecd = true;
          System.out.println("So long.");
      }
      System.out.println("\n");
      try        
      {
          Thread.sleep(1400);
      } 
      catch(InterruptedException ex) 
      {
          Thread.currentThread().interrupt();
      }
    }
  }

  public static int runMainMenu() {
    int thisMenuSelection = -1;
    // display welcome message and initial prompt, then receive user input
    System.out.println("Welcome to my integration project.");
    boolean goodSelection = false;
    while(goodSelection == false) {
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
//        scan.nextLine();
        thisMenuSelection = Integer.parseInt(userInput);
        if ((thisMenuSelection > 0) && (thisMenuSelection < 9)) {
          goodSelection = true;
        }
        else {
//          scan.nextLine();
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
    
    final String matrixString = 
        "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n" +
        "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n" +
        "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n" +
        "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n" +
        "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n" +
        "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n" +
        "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n" +
        "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n" +
        "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n" +
        "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n" +
        "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n" +
        "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n" +
        "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n" +
        "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n" +
        "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n" +
        "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n" +
        "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n" +
        "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n" +
        "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n" +
        "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
    
    
    String [] sOuter = matrixString.split ("[" + "\n" + "]"); 
    int size = sOuter.length;
    String [][] result = new String [size][]; 
    int count = 0;
    for (String line : sOuter)
    {
        result [count] = line.split (innerdelim);
        ++count;
    }
    return result;
  }
    
  }
}

// Inheritance and Polymorphism. Weapon class is parent class. All subclasses
// will have the same basic functionality, as well as some additional features.
class Weapon {
   protected String material;
   protected int hitPoints;
   protected int weight;
   protected int condition;
   protected int skillWithWeapon;
   protected double cost;
   protected boolean needsAmmo;
   protected boolean playerOwns;
   protected boolean inHand;
   
   // Constructor
   public Weapon (String material, double cost, int weight, int condition) {
      this.material = material;
      this.weight = weight;
      this.cost = cost;
      this.playerOwns = true;
      this.skillWithWeapon = 1;
   }
   
   public int attack() {
      System.out.println("Weapon details unknown, unable to attack.");
      return 0;
   }
   
   public double sellWeapon() {
     //return 80% of value, destroy object
     this.playerOwns = false;
     return cost * .8;
   }

   public void holster() {
     inHand = false;
   }
   
   public void unholster() {
     inHand = true;
   }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public void increaseSkillLevel(double factor) {
    this.skillWithWeapon =  (int) (factor * this.skillWithWeapon);
  }
  public void demonstrateWeapon() {
    String fullyQualName = this.getClass().toString();
    String bareClassName = fullyQualName.substring(fullyQualName.lastIndexOf('.')+1);
    System.out.println("Demonstrate " + bareClassName + ":");
    this.attack();
  }
}

class Sword extends Weapon {
  private int bladeLength;
  private int sharpness = 60;
  
  public Sword(String material, double cost, int bladeLength, int weight,
      int condition, int hitPoints) {
    super(material, cost, weight, condition);
    setHitPoints(hitPoints);
    this.bladeLength = bladeLength;
    needsAmmo = false;
  }
  
  public void setSharpness(int sharpness) {
    this.sharpness = sharpness;
  }
  
  public int attack() {
    int attackPoints = (int) (hitPoints + skillWithWeapon + (Math.random() * 10));
    if (sharpness > 50) {
      attackPoints += 5;
    }
    sharpness -= 2;
    System.out.println("Attacked with " + attackPoints + " points.");
    return attackPoints;
  }
  
  public void sharpen() {
    sharpness += 10;
  }
}