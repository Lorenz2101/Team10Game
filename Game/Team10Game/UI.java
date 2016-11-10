import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI extends MyWorld
{
    GreenfootImage draw;
    /**
     * Constructor for objects of class UI.
     * 
     */
    public UI()
    {
        draw = getBackground();
        draw.setColor(Color.WHITE);
        prepare();
    }

    public void act() {
        // TODO: Use drawstring instead.
        createHUD();
        if(getPlayer().getHearts() < 1) {
        Greenfoot.setWorld(new GameOver());
        }
    }

    /**
     * Spawns the HUD on act.
     */
    public void createHUD() {
        showText("Currency: " + getPlayer().getCurrency(), 500, 30);
        showText("Hearts: " + getPlayer().getHearts(), 250, 30);
        showText("Life: " + getPlayer().getLife(), 50, 30);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crate crate = new Crate();
        addObject(crate,111,361);
        Crate crate2 = new Crate();
        addObject(crate2,69,362);
        Crate crate3 = new Crate();
        addObject(crate3,31,362);
        removeObject(crate);
        removeObject(crate3);
        removeObject(crate2);
        Crate crate4 = new Crate();
        addObject(crate4,72,213);
        Crate crate5 = new Crate();
        addObject(crate5,137,202);
        Crate crate6 = new Crate();
        addObject(crate6,185,211);
        Crate crate7 = new Crate();
        addObject(crate7,245,211);
        Crate crate8 = new Crate();
        addObject(crate8,410,224);
        Crate crate9 = new Crate();
        addObject(crate9,479,224);
        Crate crate10 = new Crate();
        addObject(crate10,517,219);
        Crate crate11 = new Crate();
        addObject(crate11,444,217);
    }
}
