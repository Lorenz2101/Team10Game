import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class usable_items here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class usable_items extends Others
{
    private int id;
    private String name;
    
   
    /**
     * Constructor of usable_items
     */
    public usable_items(int id) {
       
        
        switch(id) {
        case 1:
        this.id = id;
        name = "Shotgun";
        setImage("Shotgun.png");
        break;
        
        case 2:
        this.id = id;
        name = "Laser Gun";
        setImage("Lasergun.png");
        break;
     
        /**  
        TODO: Add another picture for AK 47
        case 3:
        this.id = id;
        name = "AK 47";
        setImage("Ak.gif");
        break;
        */
        
        // Should never happen, but for good measure I do it anyway!
        default:
         this.id = 0;
        break;
        }
    }
    
    /**
     * Act - do whatever the usable_items wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scrollingMethods();
        
        if(!isTouching(grass_tile.class)) {
        setLocation(getX(), getY() + 3);
        }
    }    
    
    /**
     * Returns id of item.
     */
    public int getId() {
     return id;
    }
}
