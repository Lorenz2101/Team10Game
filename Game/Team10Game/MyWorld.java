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
        super(3000, 400, 1, false); //The extra 'false' parameter means that the world is unbounded.
        
        addTiles();
        addEnemies();
        setBackground("o.jpg");
        thePlayer = new Player();
        addObject(thePlayer, 300, 100); //Creates the player.
        theScroll = new ScrollController();
        addObject(theScroll, 0, -10);
    }
    
    /**
     * Creates the world.
     */
    public void addTiles()
    {   
        for(int i=1;i<20;i++)
        {
            addObject(new grass_tile(), i*30-15, 415);
        }
        
        for(int i=0;i<3;i++)
        {
            addObject(new grass_tile(), 560+(i*30), 375);
        }
        
        for(int i=0;i<6;i++)
        {
            addObject(new grass_tile(), 650+(i*30), 335);
        }
       
        for(int i=0;i<5;i++)
        {
            addObject(new grass_tile(), 830+(i*30), 375);
        }
        
        for(int i=1;i<10;i++)
        {
            addObject(new grass_tile(), 950+(i*30), 415);
        }
        
        for(int i=1;i<3;i++)
        {
            addObject(new grass_tile(), 1220+(i*30), 375);
        }
           
        addObject(new grass_tile(), 1310, 335);
        addObject(new grass_tile(), 1340, 335);
        
        addObject(new grass_tile(), 1370, 295);
        addObject(new grass_tile(), 1400, 295);
        
        addObject(new grass_tile(), 1430, 415);
        addObject(new grass_tile(), 1460, 415);
        
        for(int i=1;i<15;i++)
        {   
            addObject(new grass_tile(), 1430+(i*30), 415);
        }
        
        for(int i=1;i<12;i++)
        {
            addObject(new grass_tile(), 1850+(i*30), 375);
        }
        
        for(int i=1;i<8;i++)
        {
            addObject(new grass_tile(), 2180+(i*30), 415);
        }
        
        for(int i=1;i<5;i++)
        {
            addObject(new grass_tile(), 2390+(i*30), 375);
        }
        
        for(int i=1;i<5;i++)
        {
            addObject(new grass_tile(), 2510+(i*30), 335);
        }
    
         for(int i=1;i<13;i++)
        {
            addObject(new grass_tile(), 2630+(i*30), 375);
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
