import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Tombol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pindah extends Actor
{
    private int width,height;
    private int r,g,b;
    private GreenfootImage bg;
    private int tujuan;
    private String caption;
    /**
     * Act - do whatever the Tombol wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pindah(int width, int height, int r, int g, int b, String caption,int tujuan){
        this.width=width;
        this.height=height;
        this.r=r;
        this.g=g;
        this.b=b;
        this.tujuan=tujuan;
        this.caption=caption;
        bg=new GreenfootImage(width, height);
        bg.setColor(new Color(r,g,b,100));
        bg.fill();
        bg.setColor(Color.black);
        bg.setFont(new Font("Calibri",Font.BOLD,25));
        bg.drawString(caption, width/4, height-10);
        setImage(bg);
    }
    
    private void setCaption(String a){
        bg=new GreenfootImage(width, height);
        bg.setColor(new Color(r,g,b,100));
        bg.fill();
        bg.setColor(Color.black);
        bg.setFont(new Font("Calibri",Font.BOLD,25));
        bg.drawString(a, width/4, height-10);
        setImage(bg);
    }

    public void act() 
    {
        // Add your action code here.
        World w=getWorld();
        if(Greenfoot.mouseClicked(this)){
            if(tujuan==0 && ((Menu)w).getDaftar().countList()!=0){
                Kalkulator k=new Kalkulator(((Menu)w).getBackground(),((Menu)w).getDaftar());
                Greenfoot.setWorld(k);
                k.repaint();
            }else if(tujuan==1 &&
                (!((Kalkulator)w).getMonitor().getKata(0).equalsIgnoreCase("masukkan uang") && !((Kalkulator)w).getMonitor().getKata(0).equalsIgnoreCase("uang kurang"))){
                Greenfoot.setWorld(new Menu());
            }else if(tujuan==1 && ((Kalkulator)w).getMonitor().getKata(0).equalsIgnoreCase("masukkan uang") && ((Kalkulator)w).getMonitor().getCount()==2){
                String s=((Kalkulator)w).getMonitor().getKata(1);
                int uang=Integer.parseInt(s.substring(2, s.length()-3));
                int jml=((Kalkulator)w).getList().getTotal();
                ((Kalkulator)w).getMonitor().reset();
                if((uang-jml)>=0){
                    ((Kalkulator)w).getMonitor().setKata("Uang Kembalian", 24);
                    ((Kalkulator)w).getMonitor().setKata("Rp"+String.valueOf(uang-jml)+",00", 50);
                    setCaption("Menu");
                }else{
                    ((Kalkulator)w).getMonitor().setKata("Uang Kurang", 24);
                    ((Kalkulator)w).getMonitor().setKata("Rp"+String.valueOf(jml-uang)+",00", 50);
                }
            }
        }
   }    
}
