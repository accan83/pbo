import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class List here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item extends Actor
{
    /**
     * Act - do whatever the List wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private String nama;
    private int harga;
    public Item(String gambar, String nama, int harga){
        GreenfootImage bg = getImage();
        GreenfootImage image = new GreenfootImage(gambar);
        image.scale(80, 80);
        bg.scale(bg.getWidth() - 120, bg.getHeight() - 150);
        bg.drawImage(image, (bg.getWidth()/2)-40, (bg.getHeight()/2)-40);
        setImage(bg);
        this.nama=nama;
        this.harga=harga;
    }
    
    public String getNama(){
        return nama;
    }
    
    public int getHarga(){
        return harga;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            World w=getWorld();
            ((Menu)w).getMonitor().reset();
            ((Menu)w).getMonitor().setKata(nama, 24);
            ((Menu)w).getMonitor().setKata("Rp"+String.valueOf(harga)+",00", 50);
            ((Menu)w).getDaftar().tambahBarang(this);
            ((Menu)w).getDaftar().refresh();
        }
    }    
}
