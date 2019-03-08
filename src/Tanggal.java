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
}
