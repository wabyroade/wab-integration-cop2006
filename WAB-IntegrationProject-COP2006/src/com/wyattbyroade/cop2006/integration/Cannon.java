package com.wyattbyroade.cop2006.integration;

/**
 * This class is used for creating Cannon objects; it is a subclass of Weapon.
 * 
 * @author Wyatt Byroade
 */
public class Cannon extends Weapon {

  /**
   * Constructor for Cannon class; takes arguments for cost, weight, condition and hitPoints.
   * 
   * <p>Runs constructor of parent class(Weapon) then runs some Cannon-specific methods and sets
   * Cannon-specific fields.
   * 
   * @param cost  double  cost of weapon
   * @param weight  int  weight of weapon
   * @param condition int condition of weapon(1-100)
   * @param hitPoints int hitPoints of weapon
   */
  public Cannon(double cost, int weight, int condition, int hitPoints) {
    // TODO Auto-generated constructor stub
    super(cost, weight, condition);
    setHitPoints(hitPoints);
    inHand = false;
    needsAmmo = true;
  }

  /**
   * The attack method calculates and returns attack damage of the Sword object.
   * 
   * @return int  attack damage
   */
  public int attack() {
    int attackPoints = (int) (hitPoints + skillWithWeapon + (Math.random() * 100));
    System.out.println("Attacked with " + attackPoints + " points.");
    return attackPoints;
  }

  /**
   * holster method overridden as cannon cannot be holstered.
   */
  public void holster() {
    System.out.println("Weapon cannot be holstered. It's a cannon.");
  }

  /**
   * unholster method overridden as cannon cannot be unholstered.
   */
  public void unholster() {
    System.out.println("Weapon cannot be holstered or unholstered. It's a cannon.");
  }
}