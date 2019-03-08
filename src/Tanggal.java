import java.util.Calendar;

public class Tanggal {
    private Keypad keypad;
    public static Calendar now = Calendar.getInstance();
    
    public void tanggalSekarang(){
//        this.now = Calendar.getInstance();
        System.out.println("Tanggal Sekarang: "
                + now.get(Calendar.DATE)
                + " - " + (now.get(Calendar.MONTH)+1)
                + " - " + now.get(Calendar.YEAR));
    }
    
    public void addHari(int tambahkanJumlahHari){
        now.add(Calendar.DATE, tambahkanJumlahHari);
        System.out.println("Tanggal Setelah ditambah " + tambahkanJumlahHari
                + " hari: "
                + now.get(Calendar.DATE)
                + " - " + (now.get(Calendar.MONTH)+1)
                + " - " + now.get(Calendar.YEAR));
    }
    
    public void menuTanggal(){
        int jumlahHari;
        tanggalSekarang();
        do{
             System.out.print("Masukkan jumlah hari: ");
             jumlahHari = keypad.getInput();
        }while (jumlahHari < 0);
        addHari(jumlahHari);
    }
    
    public Calendar getTanggal(){
        return now;
    }
}