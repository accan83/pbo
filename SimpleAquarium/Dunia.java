import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dunia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dunia extends World
{

    /**
     * Constructor for objects of class Dunia.
     * 
     */
    public Dunia()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        Iwak i1=new Iwak();
        Iwak i2=new Iwak();
        addObject(i1, 500, 275);
        addObject(i2, 100, 350);

        Gelembung g1=new Gelembung(400,200);
        Gelembung g2=new Gelembung(300,100);
        Gelembung g3=new Gelembung(200,350);
        Gelembung g4=new Gelembung(100,250);
        Gelembung g5=new Gelembung(500,250);
        addObject(g1, 400, 200);
        addObject(g2, 300, 100);
        addObject(g3, 200, 350);
        addObject(g4, 100, 250);
        addObject(g5, 500, 250);
    }
}
