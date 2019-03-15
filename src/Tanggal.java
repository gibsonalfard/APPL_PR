import java.util.Calendar;

public class Tanggal {
    public static Calendar now = Calendar.getInstance();
    
    public void tanggalSekarang(){
//        this.now = Calendar.getInstance();
        System.out.println("Tanggal: "
                + now.get(Calendar.DATE)
                + " - " + (now.get(Calendar.MONTH)+1)
                + " - " + now.get(Calendar.YEAR));
    }
    
    public void addTanggal(int tambahkanJumlahHari){
        now.add(Calendar.DATE, tambahkanJumlahHari);
        System.out.println("Tanggal: "
                + now.get(Calendar.DATE)
                + " - " + (now.get(Calendar.MONTH)+1)
                + " - " + now.get(Calendar.YEAR));
    }
    
    public int getTanggal(){
        return Tanggal.now.get(Calendar.DATE);
    }
    
    public void menuTanggal(){
        
    }
    
    public String dateNow(){
        int day = now.get(Calendar.DATE);
        int month = now.get(Calendar.MONTH)+1;
        int year = now.get(Calendar.YEAR);
        
        return (day < 9 ? "0" : "")+day +"-"+ (month < 9 ? "0" : "")+month+"-"+year;
    }
}
