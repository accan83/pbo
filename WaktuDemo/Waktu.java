
/**
 * Write a description of class Waktu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waktu
{
    // instance variables - replace the example below with your own
    private static final int MAX_JAM=23;
    private static final int MAX_MENIT_DETIK=59;
    private int jam;
    private int menit;
    private int detik;

    /**
     * Constructor for objects of class Waktu
     */
    public Waktu()
    {
        // initialise instance variables
        jam=0;
        menit=0;
        detik=0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Waktu(int jam, int menit, int detik)
    {
        // put your code here
        setWaktu(jam, menit, detik);
    }
    
    public void setWaktu(int jam, int menit, int detik)
    {
        setJam(jam);
        setMenit(menit);
        setDetik(detik);
    }
    
    private boolean cekMax(int isi, int max)
    {
        if(isi>=0 && isi<=max)
        {
            return true;
        }else{
            return false;
        }
    }
    
    private void setJam(int jam)
    {
        if(cekMax(jam, MAX_JAM))
        {
            this.jam=jam;
        }else{
            System.out.print("JAM tidak boleh > "+MAX_JAM+" atau < 0");
            this.jam=0;
        }
    }

    private void setMenit(int menit)
    {
        if(cekMax(menit, MAX_MENIT_DETIK))
        {
            this.menit=menit;
        }else{
            System.out.print("Menit tidak boleh > "+MAX_MENIT_DETIK+" atau < 0");
            this.menit=0;
        }
    }

    private void setDetik(int detik)
    {
        if(cekMax(detik, MAX_MENIT_DETIK))
        {
            this.detik=detik;
        }else{
            System.out.print("Detik tidak boleh > "+MAX_MENIT_DETIK+" atau < 0");
            this.detik=0;
        }
    }
    
    public void jamUp()
    {
        if(cekMax(jam+1, MAX_JAM))
        {
            jam++;
        }else{
            jam=0;
        }
    }

    public void jamDown()
    {
        if(jam-1!=-1)
        {
            jam--;
        }else{
            jam=MAX_JAM;
        }
    }

    public void menitUp()
    {
        if(cekMax(menit+1, MAX_MENIT_DETIK))
        {
            menit++;
        }else{
            jamUp();
            menit=0;
        }
    }

    public void menitDown()
    {
        if(menit-1!=-1)
        {
            menit--;
        }else{
            jamDown();
            menit=MAX_MENIT_DETIK;
        }
    }

    public void detikUp()
    {
        if(cekMax(detik+1, MAX_MENIT_DETIK))
        {
            detik++;
        }else{
            menitUp();
            detik=0;
        }
    }

    public void detikDown()
    {
        if(detik-1!=-1)
        {
            detik--;
        }else{
            menitDown();
            detik=MAX_MENIT_DETIK;
        }
    }
    
    public String toString()
    {
        return jam+":"+menit+":"+detik;
    }
    
    public Waktu selisih(Waktu w)
    {
        return toWaktu(toDetik()-w.toDetik());
    }
    
    public long toDetik()
    {
        return detik+(60*menit)+(3600*jam);
    }
    
    public Waktu toWaktu(long detik)
    {
        int j=(int)detik/3600;
        int m=(int)detik%3600/60;
        int d=(int)detik%60;
        return new Waktu(j,m,d);
    }
}
