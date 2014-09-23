import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Iwak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Iwak extends Actor
{
    /**
     * Act - do whatever the Iwak wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(!isAtEdge())
        {
            if(getRotation()==0)
            {
                kanan();
            }else{
                kiri();
            }
        }else{
            turn(180);
            if(getRotation()==180)
            {
                kiri();
            }else{
                kanan();
            }
        }
    }
    
        private void kanan()
    {
        setLocation(getX()+5, getY());
    }

    private void kiri()
    {
        setLocation(getX()-5, getY());
    }
}
