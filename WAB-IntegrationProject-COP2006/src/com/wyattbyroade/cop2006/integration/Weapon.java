package com.wyattbyroade.cop2006.integration;

// Inheritance: Weapon class is parent class. All subclasses will have the
// same basic functionality, as well as some additional features.
// Polymorphism: Objects of the sub classes can be created with references to
// the parent class, allowing them to be used with all of the same methods
// and fields. Basically all subclasses will be treated exactly the same as
// the parent class. This includes the methods that are available. Methods that
// are defined for the subclass but not the parent class will not be accessible
// if the reference is 

class Weapon {
   protected int hitPoints;
   protected int weight;
   protected int condition;
   protected int skillWithWeapon;
   protected double cost;
   protected boolean needsAmmo;
   protected boolean playerOwns;
   protected boolean inHand;
   
   // Constructor
   public Weapon (double cost, int weight, int condition) {
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
    this.holster();
  }
}
