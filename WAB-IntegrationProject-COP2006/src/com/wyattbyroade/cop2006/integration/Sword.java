package com.wyattbyroade.cop2006.integration;

/**
 * This class is used for creating Sword objects; it is a subclass of Weapon.
 * 
 * @author Wyatt Byroade
 */
class Sword extends Weapon {
  /**
   * The bladeLength int field represents the length of blade of the sword object.
   */
  private int bladeLength;
  /**
   * The sharpness int field sharpness factor of the sword, which affects attack damage.
   */
  private int sharpness;
  
  /**
   * Constructor for Sword class; takes arguments for cost, bladeLength, weight, condition
   * and hitPoints.
   * 
   * <p>Runs constructor of parent class(Weapon) then runs some Sword-specific methods and sets
   * Sword-specific fields.
   * 
   * @param cost  double  cost of weapon
   * @param bladeLength  int  length of blade
   * @param weight  int  weight of weapon
   * @param condition int condition of weapon(1-100)
   * @param hitPoints int hitPoints of weapon
   */
  public Sword(double cost, int bladeLength, int weight,
      int condition, int hitPoints) {
    super(cost, weight, condition);
    setHitPoints(hitPoints);
    setSharpness(60);
    this.bladeLength = bladeLength;
    needsAmmo = false;
  }
  
  /**
   * The setSharpness method sets sharpness to the value of passed argument.
   * 
   * @param sharpness  int  sharpness of weapon to be set
   */
  public void setSharpness(int sharpness) {
    this.sharpness = sharpness;
  }
  
  /**
   * The attack method calculates and returns attack damage as well as decreasing the sharpness
   * of the Sword object.
   * 
   * @return int  attack damage
   */
  public int attack() {
    int attackPoints = (int) (hitPoints + skillWithWeapon + bladeLength / 10 
        + (Math.random() * 10));
    if (sharpness > 50) {
      attackPoints += 5;
    }
    sharpness -= 2;
    System.out.println("Sword swung for attack of " + attackPoints + " points.");
    return attackPoints;
  }
  
  /**
   * The sharpen method increases the sharpness field by 10.
   */
  public void sharpen() {
    sharpness += 10;
  }
}
