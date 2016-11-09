import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollController
{   
   private int life;
   private int speed;
   private int heart;
   
   private int currency; 
 
   private GifImage runRight = new GifImage("runRight.gif");
   private GifImage runLeft = new GifImage("runLeft.gif");
   
   
   public Player() {
   life = 3;
   speed = 3;
   heart = 3;  

   currency = 50;
   
   setImage(runRight.getCurrentImage());
   
   }
    
    public void act()
    {
        checkKeyPress(); //This should be included in the act() method so that the game is always checking for user input.
        //Methods such as shooting a gun go here.
        
        // Kills the player on fall.
        deathOnFall();
        
        // Removes the coin and get +1 currency.
        pickUpCoin();
        
        
        
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
            setLocation(getX() - speed, getY());
            setImage(runLeft.getCurrentImage());
        }
        else if(Greenfoot.isKeyDown("right") && theScroll.shouldScroll == false)
        {
           setLocation(getX() + speed, getY());       
           setImage(runRight.getCurrentImage());
        } else {
            setImage("standStill.png");
        }
        
        if(!isTouching(grass_tile.class)){
        
        for (int i = 0; i < 5; i++) {
        setLocation(getX(), getY() + i);
        }
        
        } 
        
       
    }
    
    /**
     * This returns the players life, player usually lose one life pr. hit.
     */
    public int getLife() {
    return life;
    }
    
    /**
     * This returns the hearts of the player, hearts are used to determine gameover.
     */
    public int getHearts() {
    return heart;
    }
    
    /**
     * Respawns the player on top of the map, so he can relocate himself.
     */
    private void deathOnFall() {
    if(getY() >= getWorld().getHeight()) {
    setLocation(300, 0);
    life --;
    }
}
    
    private void pickUpCoin() {
    
    if(isCoin()) {
    removeTouching(Currency.class);
    currency ++;
    }
    }
    
    private boolean isCoin() {
    Actor coin = getOneObjectAtOffset(15, 15, Currency.class);
    return (coin != null);
    }
   
    

}
