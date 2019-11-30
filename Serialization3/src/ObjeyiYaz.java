
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjeyiYaz {

    public static void main(String[] args) {
        Ogrenci ogrenci = new Ogrenci("Ahmet Emin Saglik ", 1234, "Yazılım Mühendisliği");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Ogrenciler.bin"))) { //dosyamızın byte şeklinde oluştuğunu gösterir
            
            Ogrenci.setOgrenci_sayisi(100);
            out.writeObject(ogrenci);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya bulunamadı...");
        } catch (IOException ex) {
            Logger.getLogger(ObjeyiYaz.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Dosya açılırken IOException oluştu...");
        }
    }
}
