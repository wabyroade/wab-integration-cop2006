package com.wyattbyroade.cop2006.integration;

class Sword extends Weapon {
  private int bladeLength;
  private int sharpness;
  
  public Sword(double cost, int bladeLength, int weight,
      int condition, int hitPoints) {
    super(cost, weight, condition);
    setHitPoints(hitPoints);
    setSharpness(60);
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
