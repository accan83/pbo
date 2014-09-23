import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gelembung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gelembung extends Actor
{
    /**
     * Act - do whatever the Gelembung wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int xA;
    int yA;
    
    public Gelembung(int x, int y)
    {
        xA=x;
        yA=y;
    }

    public void act() 
    {
        // Add your action code here.
        if(!isAtEdge())
        {
            naik();
        }else{
            setLocation(xA, yA);
        }
    }
    
    private void naik()
    {
        int x=randomWithRange(-5, 5);
        int y=randomWithRange(-5, -3);
        setLocation(getX()+x, getY()+y);
    }
    
    private int randomWithRange(int min, int max)
    {
       int range = (max - min) + 1;     
       return (int)(Math.random() * range) + min;
    }
}