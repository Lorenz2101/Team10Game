import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class grass_tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class grass_tile extends Others
{
    
    public grass_tile() {
        setSize(30, 75);
    }
    
    /**
     * Act - do whatever the grass_tile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scrollingMethods();
    }
    
    public void setSize(int width, int height)
    {
        GreenfootImage grass = new GreenfootImage("grass_tile.jpg");
        grass.scale(width, height);
        setImage(grass);
    }
}
