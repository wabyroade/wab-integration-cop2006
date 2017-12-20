package com.wyattbyroade.cop2006.integration;

public class Cannon extends Weapon {

  public Cannon(double cost, int weight, int condition, int hitPoints) {
    // TODO Auto-generated constructor stub
    super(cost, weight, condition);
    setHitPoints(hitPoints);
    inHand = false;
    needsAmmo = false;
  }

  public int attack() {
    int attackPoints = (int) (hitPoints + skillWithWeapon + (Math.random() * 100));
    System.out.println("Attacked with " + attackPoints + " points.");
    return attackPoints;
  }

  public void holster() {
    System.out.println("Weapon cannot be holstered. It's a cannon.");
  }

  public void unholster() {
    System.out.println("Weapon cannot be holstered or unholstered. It's a cannon.");
  }
}