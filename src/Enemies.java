import greenfoot.*; // Imports the greenfoot library

public class Enemies extends Actor {
    
    private int speed;
    private int damage;
       
    
    /**
     * Sets the health
     * @param Health
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    
    /**
     * Enemies constructor
     * @param speed, health, damage
     */
    public Enemies() {
        // Set the speed, health and damage
        speed = 3
        damage = 1;
    }
    
}
