import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Currency here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Currency extends Others
{
    /**
     * Act - do whatever the Currency wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GifImage coin = new GifImage("coin.gif");
    public void act() 
    {
       scrollingMethods();
       setImage(coin.getCurrentImage());
    }    
}
