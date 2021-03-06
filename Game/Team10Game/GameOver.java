import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    GreenfootImage image;
    
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        image = new GreenfootImage("GameOver.jpg");
        image.scale(getWidth(), getHeight());
        setBackground(image);
    }
    
    public void act() {
    if(Greenfoot.isKeyDown("enter")) {
        Greenfoot.setWorld(new UI());
    }
    }
}
