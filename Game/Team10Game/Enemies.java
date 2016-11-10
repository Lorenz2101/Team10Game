import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Others
{
    private GifImage Enemy;
    
    public Enemies(String EnemyImage) {
     Enemy = new GifImage(EnemyImage);
    }
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        scrollingMethods();
        
        if(!isTouching(grass_tile.class)) {
        setLocation(getX(), getY() + 3);
        }
        setImage(Enemy.getCurrentImage());
        
    }    
}
