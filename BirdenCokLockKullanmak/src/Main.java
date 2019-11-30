
public class Main {

    public static void main(String[] args) {
        ListWorker worker = new ListWorker();
        worker.calistir();
        
        // 2 tane thread kullandık ve süreyi yarıya indirdik  -->  ama çalışmalarda hala eksik olabiliyor 
        // bunun yerine synchronized olduğu zaman atlama olmuyor ama çok zaman kaybı oluyor ama güvenli çalışıyor
        
        
        
        /* long baslangic = System.currentTimeMillis();
        worker.degerAta();
        long bitis = System.currentTimeMillis();
        System.out.println("Geçen Süre : " + (bitis - baslangic));*/

    }
}
