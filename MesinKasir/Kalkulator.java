import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Kalkulator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kalkulator extends World
{
    private Label monitor;
    private List daftar;
    private List lst;
    /**
     * Constructor for objects of class Kalkulator.
     * 
     */
    public Kalkulator(GreenfootImage bg, List lst)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(bg);
        this.lst=lst;
        prepare();
    }
    
    public Label getMonitor(){
        return monitor;
    }

    public List getList(){
        return daftar;
    }

    private void prepare()
    {
        for(int i=0;i<3;i++){
            addObject(new Button(70,70,0,0,255,String.valueOf(i+7)), 50+(i*107), 180);
        }
        
        addObject(new Button(70,70,255,0,15,"<"), 50+(3*107), 180);

        for(int i=0;i<3;i++){
            addObject(new Button(70,70,0,0,255,String.valueOf(i+4)), 50+(i*107), 270);
        }
        
        addObject(new Button(70,70,255,0,15,"X"), 50+(3*107), 270);

        for(int i=0;i<3;i++){
            addObject(new Button(70,70,0,0,255,String.valueOf(i+1)), 50+(i*107), 360);
        }
        addObject(new Button(70,70,0,0,255,"0"), 50+(3*107), 360);
        
        monitor = new Label(400,120,255,0,0);
        addObject(monitor, (monitor.getWidth()/2)+10, (monitor.getHeight()/2)+10);

        daftar = new List(getWidth()-monitor.getWidth()+10,getHeight()-30);
        addObject(daftar, monitor.getWidth()+daftar.getWidth()/2, daftar.getHeight()/2);
        daftar.refresh();
        
        Pindah byr = new Pindah(daftar.getWidth()-55,30,0,255,0,"Bayar",1);
        addObject(byr, daftar.getX(), daftar.getHeight()+10);
    }
    
    public void repaint(){
        daftar.refresh(lst);
        monitor.setKata("Masukkan Uang", 24);
    }
}
