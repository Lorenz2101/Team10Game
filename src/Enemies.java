import greenfoot.*; // Imports the greenfoot library

public class Enemies extends Actor {
    
    private int speed;
    private int health;
    private int damage;
    
    /**
     * Returns health
     */
    public int getHealth() {
        return health;
    }
    
    
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
    public Enemies(int speed, int health, int damage) {
        // Set the speed, health and damage
        this.speed = speed;
        this.health = health;
        this.damage = damage;
    }
    
}
