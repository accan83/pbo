import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int width,height;
    String nama;
    public Button(int width, int height, int r, int g, int b, String nama){
        this.height=height;
        this.width=width;
        this.nama=nama;
        GreenfootImage bg=new GreenfootImage(width,height);
        bg.setColor(new Color(r,g,b,100));
        bg.fill();
        bg.setColor(Color.black);
        bg.setFont(new Font("Calibri",Font.BOLD,40));
        bg.drawString(nama, (bg.getWidth()/2)-15, (bg.getHeight()/2)+15);
        setImage(bg);
    }
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            World w=getWorld();
            if(!nama.equals("<") && !nama.equals("X")){
                if(((Kalkulator)w).getMonitor().getCount()==2){
                    String s= ((Kalkulator)w).getMonitor().getKata(1);
                    ((Kalkulator)w).getMonitor().reset();
                    ((Kalkulator)w).getMonitor().setKata("Masukkan Uang", 24);
                    ((Kalkulator)w).getMonitor().setKata("Rp"+s.substring(2, s.length()-3)+nama+",00", 50);
                }else{
                    ((Kalkulator)w).getMonitor().reset();
                    ((Kalkulator)w).getMonitor().setKata("Masukkan Uang", 24);
                    ((Kalkulator)w).getMonitor().setKata("Rp"+nama+",00", 50);
                }
            }else if(nama.equals("X")){
                    ((Kalkulator)w).getMonitor().reset();
                    ((Kalkulator)w).getMonitor().setKata("Masukkan Uang", 24);
            }else if(nama.equals("<")){
                if(((Kalkulator)w).getMonitor().getCount()==2){
                    String s= ((Kalkulator)w).getMonitor().getKata(1);
                    ((Kalkulator)w).getMonitor().reset();
                    ((Kalkulator)w).getMonitor().setKata("Masukkan Uang", 24);
                    if(s.length()!=6){
                        ((Kalkulator)w).getMonitor().setKata("Rp"+s.substring(2, s.length()-4)+",00", 50);
                    }
                }
            }
        }
    }    
}
