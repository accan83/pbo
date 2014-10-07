import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Vector;
import java.awt.Font;
import java.awt.Color;
/**
 * Write a description of class List here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class List extends Actor
{
    private int width;
    private int height;
    private Vector<Item> barang=new Vector<Item>();
    private Vector<Integer> qty=new Vector<Integer>();
    private GreenfootImage bg;
    private int total;
    /**
     * Act - do whatever the List wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public List(int width, int height){
        this.width=width;
        this.height=height;
        bg=getImage();
        bg.scale(width, height);
        setImage(bg);
    }
        
    public void refresh(List lst){
        width=lst.getWidth();
        height=lst.getHeight();
        barang=lst.getBarang();
        qty=lst.getQty();
        total=lst.getTotal();
        bg=lst.getImage();
        setImage(bg);
    }

    public Vector getBarang(){
        return barang;
    }

    public Vector getQty(){
        return qty;
    }

    public void tambahBarang(Item brg){
        if(!barang.contains(brg)){
            barang.addElement(brg);
            qty.addElement(1);
        }else{
            int idx=barang.indexOf(brg);
            qty.setElementAt(qty.elementAt(idx)+1, idx);
        }
    }
    
    public int countList(){
        return barang.size();
    }
    
    public void refresh(){
        setImage("file.png");
        bg=getImage();
        bg.scale(width, height);
        setImage(bg);
        GreenfootImage sub=getImage();
        sub.setFont(new Font("Calibri",Font.BOLD,25));
        sub.drawString("DAFTAR", 30, 60);
        sub.drawLine(30, 80, 180, 80);
        int total=0;
        for(int i=0;i<barang.size();i++){
            sub.setColor(Color.black);
            sub.setFont(new Font("Calibri",Font.BOLD,12));
            sub.drawString(barang.elementAt(i).getNama()+" ("+String.valueOf(qty.elementAt(i))+")", 30, 80+((i+1)*20)+(i*20));
            sub.setColor(Color.blue);
            sub.drawString("     Rp"+String.valueOf(barang.elementAt(i).getHarga()*qty.elementAt(i))+",00", 30, 100+((i+1)*20)+(i*20));
            total+=barang.elementAt(i).getHarga()*qty.elementAt(i);
        }
        
        if(barang.size()!=0){
            int uk=barang.size();
            int y=70+((uk+1)*20)+(uk*20);
            sub.setColor(Color.black);
            sub.drawLine(30, y, 180, y);
            sub.setColor(Color.green);
            sub.drawString("TOTAL = Rp"+total+",00", 30, y+15);
        }
        setImage(sub);
        this.total=total;
    }
    
    public int getTotal(){
        return total;
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
