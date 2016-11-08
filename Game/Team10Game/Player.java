import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollController
{

    public void act()
    {
        checkKeyPress(); //This should be included in the act() method so that the game is always checking for user input.
        //Methods such as shooting a gun go here.
        if(!isTouching(grass_tile.class)) {
        setLocation(getX(), getY() + 5);
        }
    }
    
    /**
     * This is used for responding to keyboard input by the user.
     * This will only happen when the player is far enough to the left or right of the screen for scrolling to be needed.
     */
    public void checkKeyPress()
    {
        MyWorld theWorld = (MyWorld) getWorld();
        ScrollController theScroll = (ScrollController) theWorld.getTheScroll();
        if(Greenfoot.isKeyDown("left") && theScroll.shouldScroll == false)
        {
            move(-3);
        }
        else if(Greenfoot.isKeyDown("right") && theScroll.shouldScroll == false)
        {
            move(3);
        }
        else if(Greenfoot.isKeyDown("space")) {
           setLocation(getX(), getY() - 5); 
        } 
    }
    
    /**
     * This method will make the player move right a certain amount.
     * Entering a negative amount will cause a movement towards the left.
     * @param The speed of the movement
     */
    public void move(int amount)
    {
        int x = getX() + amount;
        int y = getY();
        
        setLocation(x, y);
    }
}
