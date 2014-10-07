import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    private Label monitor;
    private List daftar;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        warnaBack();
        Item item1 = new Item("kebab.png","Kebab",10000);
        addObject(item1, 70, 200);
        Item item2 = new Item("burger.png","Burger",8000);
        addObject(item2, item1.getX()+140, 200);
        Item item3 = new Item("kentang.png","Kentang Goreng", 15000);
        addObject(item3, item2.getX()+140, 200);

        Item item4 = new Item("lemon.png","Es Lemon", 7000);
        addObject(item4, item1.getX(), 330);
        Item item5 = new Item("es.png","Es Krim", 6000);
        addObject(item5, item2.getX(), 330);
        Item item6 = new Item("soft.png","Softdrink", 5000);
        addObject(item6, item3.getX(), 330);
        
        monitor = new Label(400,120,255,0,0);
        addObject(monitor, (monitor.getWidth()/2)+10, (monitor.getHeight()/2)+10);

        daftar = new List(getWidth()-monitor.getWidth()+10,getHeight()-30);
        addObject(daftar, monitor.getWidth()+daftar.getWidth()/2, daftar.getHeight()/2);
        daftar.refresh();

        Pindah byr = new Pindah(daftar.getWidth()-55,30,0,255,0,"Bayar",0);
        addObject(byr, daftar.getX(), daftar.getHeight()+10);
        
        monitor.setKata("Point of Sale", 24);
        monitor.setKata("KEBAB PBO STIKOM", 34);
    }
    
    public Label getMonitor(){
        return monitor;
    }
    
    public List getDaftar(){
        return daftar;
    }

    private void warnaBack(){
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());  
        Color leftColor = Color.blue;
        Color rightColor = Color.green;
        Color topColor = Color.gray;
        Color bottomColor = Color.cyan;
        for (int x = 0; x < getWidth(); x++)  
        {  
            int alphaLeft = x * 255 / getWidth();
            int alphaRight = (getWidth() - 1 - x) * 255 / getWidth();  
            GreenfootImage left = new GreenfootImage(1, getHeight());  
            left.setColor(leftColor);  
            left.fill();  
            left.setTransparency(alphaLeft);  
            GreenfootImage right = new GreenfootImage(1, getHeight());  
            right.setColor(rightColor);  
            right.fill();  
            right.setTransparency(alphaRight);  
            bg.drawImage(left, x, 0);
            bg.drawImage(right, x, 0);
        }

        for (int y = 0; y < getHeight(); y++)
        {  
            int alphaTop = y * 255 / getHeight();
            int alphaBottom = (getHeight() - 1 - y) * 255 / getHeight();  
            GreenfootImage top = new GreenfootImage(getWidth(), 1);
            top.setColor(topColor);  
            top.fill();
            top.setTransparency(alphaTop);
            GreenfootImage bottom = new GreenfootImage(getWidth(), 1);  
            bottom.setColor(bottomColor);  
            bottom.fill();
            bottom.setTransparency(alphaBottom);
            bg.drawImage(top, 0, y);
            bg.drawImage(bottom, 0, y);
        }  
        setBackground(bg);
    }

}
