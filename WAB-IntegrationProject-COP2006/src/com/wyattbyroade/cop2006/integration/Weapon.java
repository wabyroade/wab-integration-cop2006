package com.wyattbyroade.cop2006.integration;

// Inheritance: Weapon class is parent class. All subclasses will have the
// same basic functionality, as well as some additional features.
// Polymorphism: Objects of the sub classes can be created with references to
// the parent class, allowing them to be used with all of the same methods
// and fields. Basically all subclasses will be treated exactly the same as
// the parent class. This includes the methods that are available. Methods that
// are defined for the subclass but not the parent class will not be accessible
// if the reference is 

/**
 * This class is used for creating Weapon objects and to set up the fields and
 * methods for use with its subclasses.
 * 
 * @author Wyatt Byroade
 */
class Weapon {
  /**
   * hitPoints int value to determine factor in attack strength.
   */
  protected int hitPoints;
  /**
   * weight int value to determine weight of weapon.
   */
  protected int weight;
  /**
   * condition int value to determine condition of weapon.
   */
  protected int condition;
  /**
   * skillWithWeapon int value used as a multiplier of attack strength.
   */
  protected int skillWithWeapon;
  /**
   * cost double, the cost to acquire weapon and influences the price received
   * when selling.
   */
  protected double cost;
  /**
   * needsAmmo boolean, to determine if the weapon has expendable resource
   * requirement.
   */
  protected boolean needsAmmo;
  /**
   * playerOwns boolean, to determine if the player owns the weapon.
   */
  protected boolean playerOwns;
  /**
   * inHand boolean, to determine if the weapon is currently in hand and
   * activated.
   */
  protected boolean inHand;

  // Constructor
  /**
   * Weapon constructor takes cost, weight and condition as arguments to
   * instantiate an object of weapon or its subclasses.
   * 
   * @param cost
   *          double value contains cost of weapon
   * @param weight
   *          int value contains weight of weapon
   * @param condition
   *          int value contains condition of weapon(percent)
   */
  public Weapon(double cost, int weight, int condition) {
    this.weight = weight;
    this.cost = cost;
    this.playerOwns = true;
    this.skillWithWeapon = 1;
  }

  /**
   * attack method displays error for object of weapon class, to be overridden in
   * subclasses.
   * 
   * @return int value of attack strength returned to calling method
   */
  public int attack() {
    System.out.println("Weapon details unknown, unable to attack.");
    return 0;
  }

  /**
   * sellWeapon method returns value of funds received and sets playerOwns field
   * to false.
   * 
   * @return double value of money received after selling returned to calling
   *         method
   */
  public double sellWeapon() {
    // return 80% of value, destroy object
    this.playerOwns = false;
    return cost * .8;
  }

  /**
   * holster method puts weapon into holster or other non-ready state for
   * transport.
   */
  public void holster() {
    inHand = false;
  }

  /**
   * unholster method returns weapon to hand and ready to attack state.
   */
  public void unholster() {
    inHand = true;
  }

  /**
   * setHitPoints method sets the hitPoints field to determine attack strength of
   * weapon.
   * 
   * @param hitPoints
   *          int value represents hitPoints of particular weapon
   */
  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  /**
   * increaseSkillLevel method multiplies current skillWithWeapon field by passed
   * factor.
   * 
   * @param factor
   *          double value represents factor by which to multiply skillWithWeapon
   *          field
   */
  public void increaseSkillLevel(double factor) {
    this.skillWithWeapon = (int) (factor * this.skillWithWeapon);
  }

  /**
   * demonstrateWeapon method identifies weapon, runs attack method and then
   * holsters weapon.
   */
  public void demonstrateWeapon() {
    String fullyQualName = this.getClass().toString();
    String bareClassName = fullyQualName.substring(fullyQualName.lastIndexOf('.') + 1);
    System.out.println("Demonstrate " + bareClassName + ":");
    this.attack();
    this.holster();
  }
}
