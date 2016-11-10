import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInf
import java.awt.Color;

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.drawString("PRESS ENTER TO START!", getWidth()/2 - 30, getHeight()/2);
        
    }
    
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new UI());
        }
      
    
        
        
    }
}
