import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;
import java.awt.Color;
import java.awt.Font;
/**
 * Write a description of class Label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    private int width,height;
    private int r,g,b;
    private GreenfootImage bg;
    private Vector<String> kata=new Vector<String>();
    /**
     * Act - do whatever the Label wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Label(int width, int height, int r, int g, int b){
        this.width=width;
        this.height=height;
        this.r=r;
        this.g=g;
        this.b=b;
        bg=new GreenfootImage(width, height);
        bg.setColor(new Color(r,g,b,100));
        bg.fill();
        setImage(bg);
    }
    
    public void reset(){
        kata.removeAllElements();
        bg=new GreenfootImage(width, height);
        bg.setColor(new Color(r,g,b,100));
        bg.fill();
        setImage(bg);
    }
    
    public void setKata(String isi,int size){
        kata.addElement(isi);
        bg.setColor(Color.black);
        bg.setFont(new Font("Calibri",Font.BOLD,size));
        bg.drawString(isi, 10, (kata.indexOf(isi)*25)+(kata.indexOf(isi)+1*size)+4);
        setImage(bg);
    }

    public void setKata(int isi, int size){
        kata.addElement(String.valueOf(isi));
        bg.setColor(Color.black);
        bg.setFont(new Font("Calibri",Font.BOLD,size));
        bg.drawString(String.valueOf(isi), 10, (kata.indexOf(String.valueOf(isi))*25)+(kata.indexOf(String.valueOf(isi))+1*size)+4);
        setImage(bg);
    }

    public String getKata(int idx){
        return kata.elementAt(idx);
    }
    
    public int getCount(){
        return kata.size();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
