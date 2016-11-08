import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World {
    public Player thePlayer;
    public ScrollController theScroll;
    
    public MyWorld()
    {    
        super(600, 400, 1, false); //The extra 'false' parameter means that the world is unbounded.
       // GreenfootImage bg = new GreenfootImage("o.jpg");
       // bg.scale(getWidth(), getHeight());
       // setBackground(bg);
        
        addTiles();
        addEnemies();
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
        for(int i=1;i<100;i++)
        {
            addObject(new grass_tile(), i*30-15, 370);
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
