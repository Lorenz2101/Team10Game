import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollController
{   
   // Life is what we use to handle damage taken.
   private int life;
   // Walk speed.
   private int speed;
   // Hearts is the players actual "life" to determine when the player is game over.
   private int heart;
   // Player coins
   private int currency; 
   // x- and ySpeed
   private int xSpeed;
   private int ySpeed;
   
   
   private int vSpeed = 0;
   private int accelleration = 2;
   private boolean jumping;
   // Jump height
   private int jumpStrength = 20;
   
   
   List<Actor> myItems;
 
   private GifImage runRight;
   private GifImage runLeft;
   
   private GifImage JumpRight;
   private GifImage JumpLeft;
   
   public Player() {
   // Construct images.
   JumpLeft = new GifImage("PlayerJumpLeft.gif");
   JumpRight = new GifImage("PlayerJumpRight.gif");
   
   runLeft = new GifImage("runLeft.gif");
   runRight = new GifImage("runRight.gif");
   
   life = 3;
   speed = 3;
   heart = 3;  
   currency = 0;
   
   myItems = new ArrayList();
   setImage(runRight.getCurrentImage());
   }
    
    public void act()
    {
        checkKeyPress(); //This should be included in the act() method so that the game is always checking for user input.
        //Methods such as shooting a gun go here.
        
        // Determines when the player should die.
        handleDeath();
        
        // Removes the coin and get +1 currency.
        pickUpCurrency();
        
        // Picks up any usable item.
        pickUpUsableItem();
        
        // Checks if the player is mid-air
        checkFall();
        
        
        
        // Checks if player is touching a block.
        //InteractingEnvironment();
        checkForCollision();
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
        
        if(Greenfoot.isKeyDown("space") && jumping == false) 
        {
            jump();
        }
        
        
      
    }
    
  
    /**
     * Makes the player fall
     */
    public void fall()
    {
       setLocation(getX(), getY() +vSpeed);
       if (vSpeed <= 9)
       {
           vSpeed = vSpeed + accelleration;
       }
       jumping = true;
    }
    
    
    /**
     * Checks if the player is on the ground 
     */
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int lookForGround = (int) (spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, lookForGround, grass_tile.class);
        
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
        
    
    }
    
    /**
     * Gravity
     */
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        
        setLocation(getX(), newY);
        jumping = false;
    }
    
    /**
     * Checks if the player is falling (mid-air)
     */
    public void checkFall()
    {
        if (onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }
    
    /**
     * Makes the player jump
     */
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    /**
     * Checks for collision.
     */
    public void checkForCollision() {
        // check below the actor
        while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, null)!=null)
        {
            setLocation(getX(), getY()-1); 
            ySpeed=0;
        }
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, null)!=null) 
        {
            setLocation(getX(), getY()+1);
            ySpeed = 0;
        }
        // check to right of actor
        while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, null)!=null)
        {
            setLocation(getX()-1, getY());
            xSpeed = 0;
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, null)!=null)
        {
            setLocation(getX()+1, getY());
            xSpeed = 0;
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
    
    public int getCurrency() {
    return currency;    
    }
    
    /**
     * Respawns the player on top of the map, so he can relocate himself.
     */
    private void handleDeath() {
    if(getY() >= getWorld().getHeight() && life > 0) {
    setLocation(300, 0);
    heart --;
    } else if (life == 0) {
    // Resets lifes.
    life = 3;
    heart --;
    }
    }

    private void pickUpUsableItem() {
        if(isTouching(usable_items.class)) {
        Actor item = getOneIntersectingObject(usable_items.class);
        myItems.add(item);
        removeTouching(usable_items.class);
        }
    }
    
    /**
     * Picks up the coin, if it is touching
     */
    private void pickUpCurrency() {
    if(isCurrency()) {
    removeTouching(Currency.class);
    currency ++;
    
    }
    }
    
    /**
     * Checks if Currency is on the spot.
     */
    private boolean isCurrency() {
   // Actor coin = getOneObjectAtOffset(15, 15, Currency.class);
   // return (coin != null);
   return isTouching(Currency.class);
   }
   
    public void changeWeapon() {
        // TODO: Add method to scroll between weapons.
    }
    
    private void InteractingEnvironment() {
        
        // TODO: Handle this differently, there are issues.
       while(getOneObjectAtOffset(0, getImage().getHeight()/2+1, null)!=null)
        {
            setLocation(getX(), getY()-1); 
        }
        
        // check above the actor
        while(getOneObjectAtOffset(0, -getImage().getHeight()/2-1, null)!=null) 
        {
            setLocation(getX(), getY()+1);
            
        }
        // check to right of actor
        while(getOneObjectAtOffset(getImage().getWidth()/2+1, 0, null)!=null)
        {
            setLocation(getX()-1, getY());
        }
        // check to left of actor
        while(getOneObjectAtOffset(-getImage().getWidth()/2-1, 0, null)!=null)
        {
            setLocation(getX()+1, getY());
        }
            
    }
    
    /**
     * Returns the player's speed.
     */
    public int getSpeed() {
    return speed;
    }
    
    
   
    

}
