import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollController extends Actor
{

    public boolean shouldScroll; //A boolean to determine if scrolling is needed, according to how far left/right across the screen the player is.
    public int playerX; //The player's x value
    
    public void act() 
    {
        updateShouldScroll(200, 400); //This should be in the act method so that the shouldScroll boolean is constantly updated.

    }
    
    /**
     * This method checks the players x position and sets the shouldScroll boolean accordingly.
     * @param The x value limits within which scrolling is not required for left/right movement.
     */
    public void updateShouldScroll(int minX, int maxX)
    {
        MyWorld theWorld = (MyWorld) getWorld();
        Player player = (Player) theWorld.getPlayer();
        playerX = player.getX();
        if(playerX <= minX || playerX >= maxX)
        {
            shouldScroll = true;
        }
        else
        {
            shouldScroll = false;
        }
        if(shouldScroll == true && (playerX >= 400 && Greenfoot.isKeyDown("left")) || (playerX <= 200 && Greenfoot.isKeyDown("right")))
        {
            shouldScroll = false;
        }
    }
}
