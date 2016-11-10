import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Crate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Crate extends Others
{
    List<Actor> items;
    
    GifImage image;
    public Crate() {
    image = new GifImage("Crate2.gif");
    items = new ArrayList();
    setImage(image.getCurrentImage());
    
    items.add(new Currency());
    items.add(new usable_items(1));
    items.add(new usable_items(2));
 
    }
    
    /**
     * Act - do whatever the Crate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

      scrollingMethods();
      setImage(image.getCurrentImage());
      
             if(!isTouching(grass_tile.class)) {
       setLocation(getX(), getY() + 3);
       }
      
       if(isTouching(Player.class)) {
        dropCoins();
       }
       
    }
    
    public void dropCoins() {
    
        getWorld().addObject(items.get(Greenfoot.getRandomNumber(items.size())), Greenfoot.getRandomNumber(600), 0);
    
        getWorld().removeObject(this);
    }
}
