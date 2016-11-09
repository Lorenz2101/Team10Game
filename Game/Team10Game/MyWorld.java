import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
public Player thePlayer;
    
public ScrollController theScroll;

private int imageCount = 0;
 
private GreenfootImage bgImage = new GreenfootImage("o.jpg");

 
   public void act() {
   if (theScroll.getScrolll()) {
    imageCount -= 5; //(or any other value; small -> slow moving, big -> fast movement)
    drawBackgroundImage();
   }
   }
 
    public void drawBackgroundImage() {
    if (imageCount > bgImage.getWidth()) {
        imageCount += bgImage.getWidth();
    }
    int temp = imageCount;
    getBackground().drawImage(bgImage, temp, 0);
    getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
   }
    
    public MyWorld()
    {    
        super(600, 400, 1, false); //The extra 'false' parameter means that the world is unbounded.
        
        addTiles();
        addEnemies();
        setBackground("o.jpg");
        thePlayer = new Player();
        addObject(thePlayer, 300, 100); //Creates the player.
        theScroll = new ScrollController();
        addObject(theScroll, 0, -10);
    }
    
    /**
     * Creates tiles for building your world.
     */
    public void addTiles()
    {
   
        for(int i=0;i<20;i++)
        {
            addObject(new grass_tile(), i*30-15, 415);
            addObject(new grass_tile(), 675, 200); // This was just to clarify it's possible to create a world.
            addObject(new grass_tile(), 5000, 200); // Same with this.
        }
    }
    
    /**
     * Creates enemies.
     */
    public void addEnemies()
    {
        
    }
    
    public Player getPlayer()
    {
        return thePlayer;
    }
    
    
    public ScrollController getTheScroll()
    {
        return theScroll;
    }
}
